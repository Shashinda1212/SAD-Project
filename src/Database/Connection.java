
package Database;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Connection {
    
    private static final String DATABASE = "smarttrade";
    private static java.sql.Connection connection;
    
    private static java.sql.Connection createConnection(){
   
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            if(connection == null){
            
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DATABASE,"root","1111");
            }
      
        } catch (ClassNotFoundException | SQLException e) {
            
            e.printStackTrace();
        }
        
        return connection;
    }
    
    public void iud(String query) throws SQLException{
    
            Statement stmt =  createConnection().createStatement();
            stmt.executeUpdate(query);

    }
    
    public static ResultSet search(String query) throws SQLException{
            
        Statement stmt = createConnection().createStatement();
        ResultSet rs = stmt.executeQuery(query);
           
        return rs;
    }
}
