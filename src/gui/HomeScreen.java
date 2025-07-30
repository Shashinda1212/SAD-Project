package gui;

import com.formdev.flatlaf.FlatLightLaf;
import contentpanels.BrandsPanel;
import contentpanels.DashboardPanel;
import contentpanels.GenerateReport;
import contentpanels.ManageSuppliers;
import contentpanels.ProductsPanel;
import java.awt.CardLayout;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import raven.toast.Notifications;



public class HomeScreen extends javax.swing.JFrame {

    private CardLayout contentPanelLayout;
    private DashboardPanel dashboardPanel;
    private BrandsPanel brandsPanel;
    private GenerateReport generateReportPanel;
    private ManageSuppliers manageSuppliersPanel;
    private ProductsPanel productPanel;
    
    public HomeScreen() {
        initComponents();
        loadPanels();
        init();
    }
    
    private void init(){
    
        FlatLightLaf.setup();
        Notifications.getInstance().setJFrame(this);
        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, "Login Successfull.");
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(10);
        
    }
    
    private void maximizeWindow(WindowEvent e){
    
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void loadPanels(){
    
        if(contentPanelLayout == null && contentPanel.getLayout() instanceof CardLayout){
        
            this.contentPanelLayout = (CardLayout)contentPanel.getLayout();
            
            this.brandsPanel = new BrandsPanel();
            this.dashboardPanel = new DashboardPanel();
            this.generateReportPanel = new GenerateReport();
            this.manageSuppliersPanel = new ManageSuppliers();
            this.productPanel = new ProductsPanel();
            
            this.contentPanel.add(dashboardPanel,"dashboard_panel");
            this.contentPanel.add(brandsPanel,"brand_panel");
            this.contentPanel.add(generateReportPanel,"generate_report_panel");
            this.contentPanel.add(manageSuppliersPanel,"manage_suppliers_panel");
            this.contentPanel.add(productPanel,"product_panel");
            SwingUtilities.updateComponentTreeUI(contentPanel);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menubarPanel = new javax.swing.JPanel();
        dashboardBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        brandsBtn = new javax.swing.JButton();
        productsBtn = new javax.swing.JButton();
        manageSuppliersBtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        sendNewsLetterBtn = new javax.swing.JButton();
        generateReportBtn = new javax.swing.JButton();
        LogoutBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        headerPanel.setBackground(new java.awt.Color(16, 92, 92));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WELCOME TO FURSTORE ADMIN PANEL");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1123, Short.MAX_VALUE)
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addContainerGap())
        );

        menubarPanel.setBackground(new java.awt.Color(16, 68, 68));

        dashboardBtn.setBackground(new java.awt.Color(16, 92, 92));
        dashboardBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dashboardBtn.setForeground(new java.awt.Color(255, 255, 255));
        dashboardBtn.setText("Dashboard");
        dashboardBtn.setBorderPainted(false);
        dashboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnActionPerformed(evt);
            }
        });

        brandsBtn.setBackground(new java.awt.Color(16, 92, 92));
        brandsBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        brandsBtn.setForeground(new java.awt.Color(255, 255, 255));
        brandsBtn.setText("Brands");
        brandsBtn.setBorderPainted(false);
        brandsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandsBtnActionPerformed(evt);
            }
        });

        productsBtn.setBackground(new java.awt.Color(16, 92, 92));
        productsBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        productsBtn.setForeground(new java.awt.Color(255, 255, 255));
        productsBtn.setText("Products");
        productsBtn.setBorderPainted(false);
        productsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsBtnActionPerformed(evt);
            }
        });

        manageSuppliersBtn.setBackground(new java.awt.Color(16, 92, 92));
        manageSuppliersBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        manageSuppliersBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageSuppliersBtn.setText("Manage Suppliers");
        manageSuppliersBtn.setBorderPainted(false);
        manageSuppliersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageSuppliersBtnActionPerformed(evt);
            }
        });

        sendNewsLetterBtn.setBackground(new java.awt.Color(16, 92, 92));
        sendNewsLetterBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sendNewsLetterBtn.setForeground(new java.awt.Color(255, 255, 255));
        sendNewsLetterBtn.setText("Send Newsletter");
        sendNewsLetterBtn.setBorderPainted(false);

        generateReportBtn.setBackground(new java.awt.Color(16, 92, 92));
        generateReportBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        generateReportBtn.setForeground(new java.awt.Color(255, 255, 255));
        generateReportBtn.setText("Generate a report");
        generateReportBtn.setBorderPainted(false);
        generateReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateReportBtnActionPerformed(evt);
            }
        });

        LogoutBtn.setBackground(new java.awt.Color(16, 92, 92));
        LogoutBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LogoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        LogoutBtn.setText("Logout");
        LogoutBtn.setBorderPainted(false);
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menubarPanelLayout = new javax.swing.GroupLayout(menubarPanel);
        menubarPanel.setLayout(menubarPanelLayout);
        menubarPanelLayout.setHorizontalGroup(
            menubarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menubarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menubarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageSuppliersBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dashboardBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(brandsBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productsBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(sendNewsLetterBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(generateReportBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(LogoutBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        menubarPanelLayout.setVerticalGroup(
            menubarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menubarPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(dashboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brandsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(productsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageSuppliersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendNewsLetterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(generateReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        contentPanel.setLayout(new java.awt.CardLayout());
        jScrollPane1.setViewportView(contentPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menubarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menubarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened

    private void dashboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "dashboard_panel");
    }//GEN-LAST:event_dashboardBtnActionPerformed

    private void brandsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandsBtnActionPerformed
       this.contentPanelLayout.show(contentPanel, "brand_panel");
    }//GEN-LAST:event_brandsBtnActionPerformed

    private void productsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsBtnActionPerformed
       this.contentPanelLayout.show(contentPanel, "product_panel");
    }//GEN-LAST:event_productsBtnActionPerformed

    private void manageSuppliersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageSuppliersBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "manage_suppliers_panel");
    }//GEN-LAST:event_manageSuppliersBtnActionPerformed

    private void generateReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateReportBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "generate_report_panel");
    }//GEN-LAST:event_generateReportBtnActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        this.dispose();
        new LoginScreen().setVisible(true);
    }//GEN-LAST:event_LogoutBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        new Thread(new Runnable(){
            @Override
            public void run() {
                new HomeScreen().setVisible(true);
            }
        }).start();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JButton brandsBtn;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton dashboardBtn;
    private javax.swing.JButton generateReportBtn;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton manageSuppliersBtn;
    private javax.swing.JPanel menubarPanel;
    private javax.swing.JButton productsBtn;
    private javax.swing.JButton sendNewsLetterBtn;
    // End of variables declaration//GEN-END:variables
}
