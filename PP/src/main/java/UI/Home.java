/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import UI.Main_Functional_Requirements.*;
import UI.Extention_Functional.*;
import UX.LeVanAn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author levan
 */
public class Home extends javax.swing.JFrame {
    private final Main_Dashboard home_Dashboard = new Main_Dashboard();
    private final Main_Report home_Report = new Main_Report();
    private final Main_History home_History = new Main_History();
    private final Main_Sale home_Sale = new Main_Sale();
    
    private final Nav_Help nav_Help = new Nav_Help(this, true);
    private final Nav_Notification nav_Notification = new Nav_Notification(this, true);
    
    public LeVanAn levanan = new LeVanAn();
    private Timer timer;
    public Home(String userName) {
        initComponents();
        setUpHome(userName);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        Header = new javax.swing.JPanel();
        SupNav = new javax.swing.JPanel();
        lbl_Out_ = new javax.swing.JLabel();
        lbl_Help_ = new javax.swing.JLabel();
        lbl_Notification_ = new javax.swing.JLabel();
        MainNav = new javax.swing.JPanel();
        Dashboard_ = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        Report_ = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        History_ = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Orther = new javax.swing.JPanel();
        lbl_ShowBranch = new javax.swing.JLabel();
        lbl_ShowTime = new javax.swing.JLabel();
        lbl_ShowDate = new javax.swing.JLabel();
        Sale_ = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Main = new javax.swing.JPanel();
        Footter = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang chủ");

        Header.setBackground(new java.awt.Color(255, 192, 57));
        Header.setLayout(new javax.swing.BoxLayout(Header, javax.swing.BoxLayout.Y_AXIS));

        SupNav.setBackground(new java.awt.Color(229, 237, 239));
        SupNav.setPreferredSize(new java.awt.Dimension(755, 31));

        lbl_Out_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Nav_Out.png"))); // NOI18N
        lbl_Out_.setText("Đăng xuất");
        lbl_Out_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Out_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_Out_MouseClicked(evt);
            }
        });

        lbl_Help_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Nav_Help.png"))); // NOI18N
        lbl_Help_.setText("Trợ giúp");
        lbl_Help_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Help_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_Help_MouseClicked(evt);
            }
        });

        lbl_Notification_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Nav_Notification.png"))); // NOI18N
        lbl_Notification_.setText("Thông báo");
        lbl_Notification_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Notification_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_Notification_MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout SupNavLayout = new javax.swing.GroupLayout(SupNav);
        SupNav.setLayout(SupNavLayout);
        SupNavLayout.setHorizontalGroup(
            SupNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SupNavLayout.createSequentialGroup()
                .addContainerGap(551, Short.MAX_VALUE)
                .addComponent(lbl_Notification_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Help_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Out_)
                .addGap(10, 10, 10))
        );
        SupNavLayout.setVerticalGroup(
            SupNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Out_, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
            .addComponent(lbl_Notification_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_Help_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Header.add(SupNav);

        MainNav.setPreferredSize(new java.awt.Dimension(755, 69));
        MainNav.setLayout(new javax.swing.BoxLayout(MainNav, javax.swing.BoxLayout.LINE_AXIS));

        Dashboard_.setBackground(new java.awt.Color(255, 178, 10));
        Dashboard_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Dashboard_.setMaximumSize(new java.awt.Dimension(165, 75));
        Dashboard_.setMinimumSize(new java.awt.Dimension(165, 75));
        Dashboard_.setPreferredSize(new java.awt.Dimension(165, 75));
        Dashboard_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Dashboard_MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Home_Dashboard.png"))); // NOI18N
        jLabel12.setText("Tổng Quan");

        javax.swing.GroupLayout Dashboard_Layout = new javax.swing.GroupLayout(Dashboard_);
        Dashboard_.setLayout(Dashboard_Layout);
        Dashboard_Layout.setHorizontalGroup(
            Dashboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );
        Dashboard_Layout.setVerticalGroup(
            Dashboard_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        MainNav.add(Dashboard_);

        Report_.setBackground(new java.awt.Color(255, 178, 10));
        Report_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Report_.setMaximumSize(new java.awt.Dimension(165, 75));
        Report_.setMinimumSize(new java.awt.Dimension(165, 75));
        Report_.setPreferredSize(new java.awt.Dimension(165, 75));
        Report_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Report_MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Home_Report.png"))); // NOI18N
        jLabel5.setText("Báo Cáo");

        javax.swing.GroupLayout Report_Layout = new javax.swing.GroupLayout(Report_);
        Report_.setLayout(Report_Layout);
        Report_Layout.setHorizontalGroup(
            Report_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );
        Report_Layout.setVerticalGroup(
            Report_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        MainNav.add(Report_);

        History_.setBackground(new java.awt.Color(255, 178, 10));
        History_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        History_.setMaximumSize(new java.awt.Dimension(165, 75));
        History_.setMinimumSize(new java.awt.Dimension(165, 75));
        History_.setPreferredSize(new java.awt.Dimension(165, 75));
        History_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                History_MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Home_History.png"))); // NOI18N
        jLabel6.setText("Lịch Sử");

        javax.swing.GroupLayout History_Layout = new javax.swing.GroupLayout(History_);
        History_.setLayout(History_Layout);
        History_Layout.setHorizontalGroup(
            History_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );
        History_Layout.setVerticalGroup(
            History_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        MainNav.add(History_);

        Orther.setBackground(new java.awt.Color(255, 178, 10));
        Orther.setMaximumSize(new java.awt.Dimension(9999, 69));
        Orther.setMinimumSize(new java.awt.Dimension(122, 69));
        Orther.setPreferredSize(new java.awt.Dimension(99, 99));
        Orther.setLayout(new java.awt.GridBagLayout());

        lbl_ShowBranch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_ShowBranch.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ShowBranch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ShowBranch.setText("Hiển thị chi nhánh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        Orther.add(lbl_ShowBranch, gridBagConstraints);

        lbl_ShowTime.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lbl_ShowTime.setForeground(new java.awt.Color(51, 51, 51));
        lbl_ShowTime.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_ShowTime.setText("(Thời gian)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Orther.add(lbl_ShowTime, gridBagConstraints);

        lbl_ShowDate.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lbl_ShowDate.setForeground(new java.awt.Color(51, 51, 51));
        lbl_ShowDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_ShowDate.setText("(Ngày tháng)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        Orther.add(lbl_ShowDate, gridBagConstraints);

        MainNav.add(Orther);

        Sale_.setBackground(new java.awt.Color(255, 178, 10));
        Sale_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Sale_.setMaximumSize(new java.awt.Dimension(165, 75));
        Sale_.setMinimumSize(new java.awt.Dimension(165, 75));
        Sale_.setPreferredSize(new java.awt.Dimension(165, 75));
        Sale_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Sale_MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Home_Sale.png"))); // NOI18N
        jLabel7.setText("Bán Hàng");

        javax.swing.GroupLayout Sale_Layout = new javax.swing.GroupLayout(Sale_);
        Sale_.setLayout(Sale_Layout);
        Sale_Layout.setHorizontalGroup(
            Sale_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );
        Sale_Layout.setVerticalGroup(
            Sale_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        MainNav.add(Sale_);

        Header.add(MainNav);

        getContentPane().add(Header, java.awt.BorderLayout.PAGE_START);

        Main.setBackground(new java.awt.Color(229, 237, 239));
        Main.setLayout(new java.awt.BorderLayout());
        getContentPane().add(Main, java.awt.BorderLayout.CENTER);

        Footter.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create by TranQuocCuong - LeVanAn - HoNgocCamTien ");

        javax.swing.GroupLayout FootterLayout = new javax.swing.GroupLayout(Footter);
        Footter.setLayout(FootterLayout);
        FootterLayout.setHorizontalGroup(
            FootterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        );
        FootterLayout.setVerticalGroup(
            FootterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        getContentPane().add(Footter, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Dashboard_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Dashboard_MouseClicked
        levanan.changePanel(Main, home_Dashboard);
    }//GEN-LAST:event_Dashboard_MouseClicked

    private void Report_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Report_MouseClicked
        levanan.changePanel(Main, home_Report);
    }//GEN-LAST:event_Report_MouseClicked

    private void History_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_History_MouseClicked
        levanan.changePanel(Main, home_History);
    }//GEN-LAST:event_History_MouseClicked

    private void Sale_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sale_MouseClicked
        levanan.changePanel(Main, home_Sale);
    }//GEN-LAST:event_Sale_MouseClicked

    private void lbl_Out_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Out_MouseClicked
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_lbl_Out_MouseClicked

    private void lbl_Help_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Help_MouseClicked
        nav_Help.setVisible(true);
    }//GEN-LAST:event_lbl_Help_MouseClicked

    private void lbl_Notification_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Notification_MouseClicked
        nav_Notification.setVisible(true);
    }//GEN-LAST:event_lbl_Notification_MouseClicked

    
    private void setUpHome(String userName) {
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

        // Thiết lập tên chi nhánh
        char branchName = userName.charAt(userName.length() - 1);
        lbl_ShowBranch.setText("CHI NHÁNH SỐ " + branchName);
        setTitle("Trang chủ - Chi nhánh số " + branchName);

        // Thiết lập ngày hôm nay
        lbl_ShowDate.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        // Thiết lập đồng hồ
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl_ShowTime.setText(new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        });
        timer.start();

        levanan.changePanel(Main, home_Dashboard);
        levanan.setPanelEvents(Dashboard_, Report_, History_, Sale_);
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Dashboard_;
    private javax.swing.JPanel Footter;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel History_;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel MainNav;
    private javax.swing.JPanel Orther;
    private javax.swing.JPanel Report_;
    private javax.swing.JPanel Sale_;
    private javax.swing.JPanel SupNav;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Help_;
    private javax.swing.JLabel lbl_Notification_;
    private javax.swing.JLabel lbl_Out_;
    private javax.swing.JLabel lbl_ShowBranch;
    private javax.swing.JLabel lbl_ShowDate;
    private javax.swing.JLabel lbl_ShowTime;
    // End of variables declaration//GEN-END:variables
}
