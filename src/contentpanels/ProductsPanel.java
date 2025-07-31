package contentpanels;

import dialogs.AddProductDialog;
import java.sql.SQLException;
import Database.Connection;
import dialogs.ProductUpdateDialog;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class ProductsPanel extends javax.swing.JPanel {

    public ProductsPanel() {
        initComponents();
        loadProducts();
    }

    public void loadProducts() {

        try {

            ResultSet rs = Connection.search("SELECT * FROM `product`"
                    + " INNER JOIN `brand` ON `product`.`brand_brand_id` = `brand`.`brand_id`"
                    + " INNER JOIN `category` ON `product`.`category_cat_id` = `category`.`cat_id`"
                    + " INNER JOIN `status` ON `product`.`Status_status_id` = `status`.`status_id`");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                Vector<String> v = new Vector<>();
                v.add(rs.getString("name"));
                v.add(rs.getString("product_SKU"));
                v.add(rs.getString("brand_name"));
                v.add(rs.getString("cat_name"));
                v.add(rs.getString("date_aded"));
                v.add(rs.getString("status"));
                v.add("Edit");
                if(rs.getInt("Status_status_id") == 1){
                
                    v.add("Desable");
                }else{
                
                    v.add("Enable");
                }

                dtm.addRow(v);

            }

            TableColumn buttonColumn = jTable1.getColumnModel().getColumn(6);
            buttonColumn.setCellRenderer(new ButtonRenderer(new Color(0, 153, 155)));
            buttonColumn.setCellEditor(new ButtonEditor(new JCheckBox(),jTable1));
            
            TableColumn buttonColumn2 = jTable1.getColumnModel().getColumn(7);
            buttonColumn2.setCellRenderer(new ButtonRenderer(new Color(0, 153, 255)));
            buttonColumn2.setCellEditor(new ButtonEditor(new JCheckBox(),jTable1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(922, 420));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Product Details");

        jButton1.setBackground(new java.awt.Color(16, 92, 92));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add Product");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Product SKU", "Brand", "Category", "Date Added", "Status", "Edit Product", "Deactive Product"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new AddProductDialog(null, true, this).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

// Button Renderer
class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer(Color c) {
        setOpaque(true);
        setBackground(c); 
        setForeground(Color.WHITE);          
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        setText((value == null) ? "Edit" : value.toString());

        return this;
    }
}

// Button Editor
class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private String label;
    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox, JTable table) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.setBackground(new Color(0, 153, 255)); 
        button.setForeground(Color.WHITE);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                int row = table.getSelectedRow();
                String prSKU = (String)table.getValueAt(row, 1);
                if(button.getText() == "Edit"){
                    
                    try{
                    
                        ResultSet rs = Connection.search("SELECT * FROM `product`"
                                + " INNER JOIN `brand` ON `product`.`brand_brand_id` = `brand`.`brand_id`"
                                + " INNER JOIN `category` ON `product`.`category_cat_id` = `category`.`cat_id`"
                                + " WHERE `product`.`product_SKU` = '"+prSKU+"'");
                        ProductUpdateDialog dialog = new ProductUpdateDialog(null,true);
                        if(rs.next()){
                        
                            dialog.setName(rs.getString("name"));
                            dialog.setDescription(rs.getString("description"));
                            dialog.setBrand(rs.getString("brand_name"));
                            dialog.setCategory(rs.getString("cat_name"));
                            dialog.setSku(prSKU);
                        }
                        dialog.setVisible(true);
                        
                    }catch(SQLException ex){
                        JOptionPane.showMessageDialog(null, "An error occured. Please try again.");
                    }
                }else if(button.getText() == "Desable"){
                
                    try{
                    
                        Connection.iud("UPDATE `product` SET `Status_status_id` = 2 WHERE `product_SKU` = '"+prSKU+"'");
                        JOptionPane.showMessageDialog(null, "Product desabled successfully.");
                        
                    }catch(SQLException ex){
                     
                        JOptionPane.showMessageDialog(null, "An error occured. Product desable failed.");
                    }
                }else{
                
                    try{
                    
                        Connection.iud("UPDATE `product` SET `Status_status_id` = 1 WHERE `product_SKU` = '"+prSKU+"'");
                        JOptionPane.showMessageDialog(null, "Product enabled successfully.");
                        
                    }catch(SQLException ex){
                     
                        JOptionPane.showMessageDialog(null, "An error occured. Product desable failed.");
                    }
                }
                
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {

        label = (value == null) ? "Edit" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        isPushed = false;
        return label;
    }
}
