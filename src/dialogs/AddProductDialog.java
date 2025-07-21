package dialogs;

import Database.Connection;
import dialogs.addProductPanels.BasicProductPanel;
import dialogs.addProductPanels.ImagePanel;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.sql.ResultSet;

/**
 *
 * @author shash
 */
public class AddProductDialog extends javax.swing.JDialog {

    public AddProductDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadAddProductDialogPanels();
    }

    private BasicProductPanel basicProductPanel;
    private ImagePanel imagePanel;
    private CardLayout addProductDialogPanelLayout;
    private String prName;
    private String prDescription;
    private String sku;
    private String brand;
    private String category;
    private int brandId;
    private int categoryId;
    private HashMap brandMap;
    private HashMap categoryMap;

    private void loadAddProductDialogPanels() {

        if (addProductDialogPanelLayout == null && addProductDialogPanel.getLayout() instanceof CardLayout) {

            this.addProductDialogPanelLayout = (CardLayout) addProductDialogPanel.getLayout();
        }

        this.basicProductPanel = new BasicProductPanel();
        this.imagePanel = new ImagePanel();

        addProductDialogPanel.add(basicProductPanel, "basic_product_panel");
        addProductDialogPanel.add(imagePanel, "image_panel");
        SwingUtilities.updateComponentTreeUI(addProductDialogPanel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        addProductDialogPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Product");

        addProductDialogPanel.setLayout(new java.awt.CardLayout());

        jButton1.setBackground(new java.awt.Color(16, 92, 92));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.setEnabled(false);
        jButton2.setPreferredSize(new java.awt.Dimension(72, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addProductDialogPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addProductDialogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        submitData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.addProductDialogPanelLayout.show(addProductDialogPanel, "basic_product_panel");
        jButton1.setText("Next");
        jButton2.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void submitData() {

        if (jButton1.getText().equals("Submit")) {

            String fileName = imagePanel.getFileName();

            if (fileName == null) {

                JOptionPane.showMessageDialog(null, "Product image cannot be empty.", "Empty", JOptionPane.WARNING_MESSAGE);
            } else {

                LocalDate date = LocalDate.now();
                brandMap = basicProductPanel.getBrandMap();
                categoryMap = basicProductPanel.getCategoryMap();

                for (Object obj : brandMap.entrySet()){
                
                    Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) obj;
                    if(entry.getKey() == brand){
                    
                        brandId = entry.getValue();
                        break;
                    }
                }
                
                for(Object obj : categoryMap.entrySet()){
                
                    Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) obj;
                    if(entry.getKey().equals(category)){
                        
                        categoryId = entry.getValue();
                        break;
                    }
                }

                try {
                    int insertId =  Database.Connection.iudWithReturn("INSERT INTO `product` (`name`,`Description`,`product_SKU`,`date_aded`,`brand_brand_id`,`category_cat_id`,`Status_status_id`) "
                            + "VALUES ('" + prName + "','" + prDescription + "','" + sku + "','" + date + "','"+brandId+"','"+categoryId+"','1')");
                    
                    Connection.iud("INSERT INTO `image` (`path`,`product_product_id`) VALUES ('"+imagePanel.getFileName()+"','"+insertId+"')");
                    
                    JOptionPane.showMessageDialog(null, "Product inserted succesfully", "Success", JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException e) {

                    JOptionPane.showMessageDialog(null, "Something went wrong.Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else {

            prName = basicProductPanel.getPrName().getText();
            prDescription = basicProductPanel.getPrDescription().getText();
            sku = basicProductPanel.getPrSKU().getText();
            brand = (String) basicProductPanel.getBrandCombo().getSelectedItem();
            category = (String) basicProductPanel.getCategoryCombo().getSelectedItem();

            if (prName.equals("")) {

                JOptionPane.showMessageDialog(null, "Product name cannot be empty.", "Empty", JOptionPane.WARNING_MESSAGE);
            } else if (prDescription.equals("")) {

                JOptionPane.showMessageDialog(null, "Product description cannot be empty.", "Empty", JOptionPane.WARNING_MESSAGE);
            } else if (brand == null) {

                JOptionPane.showMessageDialog(null, "Please select a brand.", "Empty", JOptionPane.WARNING_MESSAGE);
            } else if (category == null) {

                JOptionPane.showMessageDialog(null, "Please select a category.", "Empty", JOptionPane.WARNING_MESSAGE);
            } else {

                this.addProductDialogPanelLayout.show(addProductDialogPanel, "image_panel");
                jButton1.setText("Submit");
                jButton2.setEnabled(true);
            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddProductDialog dialog = new AddProductDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addProductDialogPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
