package buttonRenders;

import Database.Connection;
import contentpanels.ManageSuppliers;
import contentpanels.ProductsPanel;
import dialogs.ProductUpdateDialog;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.*;

public class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private String label;
    private boolean isPushed;
    private JTable table;
    private JPanel panel;

    public ButtonEditor(JCheckBox checkBox, JTable table, ManageSuppliers panel) {
        super(checkBox);
        this.table = table;
        this.panel = panel;

        button = new JButton();
        button.setOpaque(true);
        button.setBackground(new Color(0, 153, 255));
        button.setForeground(Color.WHITE);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                int row = table.getSelectedRow();
                String email = (String) table.getValueAt(row, 1);
                try {
                    if (button.getText().equals("ACTIVE")) {

                        Connection.iud("UPDATE `suppliers` SET `status_status_id` = '2' WHERE `email` = '" + email + "'");
                        JOptionPane.showMessageDialog(null, "Supplier Desabled.");
                        
                    }else{
                        Connection.iud("UPDATE `suppliers` SET `status_status_id` = '1' WHERE `email` = '" + email + "'");
                        JOptionPane.showMessageDialog(null, "Supplier Enabled.");
                        
                    }
                    panel.loadSuppliers();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "An error occurred.");
                }
            }
        });
    }

    public ButtonEditor(JCheckBox checkBox, JTable table, ProductsPanel panel) {
        super(checkBox);
        this.table = table;
        this.panel = panel;

        button = new JButton();
        button.setOpaque(true);
        button.setBackground(new Color(0, 153, 255));
        button.setForeground(Color.WHITE);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                int row = table.getSelectedRow();
                String prSKU = (String) table.getValueAt(row, 1);
                if ("Edit".equals(button.getText())) {

                    try {

                        ResultSet rs = Connection.search("SELECT * FROM `product`"
                                + " INNER JOIN `brand` ON `product`.`brand_brand_id` = `brand`.`brand_id`"
                                + " INNER JOIN `category` ON `product`.`category_cat_id` = `category`.`cat_id`"
                                + " WHERE `product`.`product_SKU` = '" + prSKU + "'");
                        ProductUpdateDialog dialog = new ProductUpdateDialog(null, true, panel);
                        if (rs.next()) {

                            dialog.setName(rs.getString("name"));
                            dialog.setDescription(rs.getString("description"));
                            dialog.setBrand(rs.getString("brand_name"));
                            dialog.setCategory(rs.getString("cat_name"));
                            dialog.setPrice(rs.getString("price"));
                            dialog.setQty(rs.getString("qty"));
                            dialog.setSku(prSKU);
                        }
                        dialog.setVisible(true);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "An error occured. Please try again.");
                    }
                } else if ("Desable".equals(button.getText())) {

                    try {

                        Connection.iud("UPDATE `product` SET `Status_status_id` = 2 WHERE `product_SKU` = '" + prSKU + "'");
                        JOptionPane.showMessageDialog(null, "Product desabled successfully.");
                        panel.loadProducts();

                    } catch (SQLException ex) {

                        JOptionPane.showMessageDialog(null, "An error occured. Product desable failed.");
                    }
                } else if (button.getText() == "Enable") {

                    try {

                        Connection.iud("UPDATE `product` SET `Status_status_id` = 1 WHERE `product_SKU` = '" + prSKU + "'");
                        JOptionPane.showMessageDialog(null, "Product enabled successfully.");
                        panel.loadProducts();

                    } catch (SQLException ex) {

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
