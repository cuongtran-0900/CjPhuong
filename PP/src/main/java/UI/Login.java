/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import UX.LeVanAn;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author levan
 */
public class Login extends javax.swing.JFrame {
    public String userName = "";
    public String userPassword = "";
    private final LeVanAn levanan = new LeVanAn();
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        LoginForm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_Login_ = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_UserName_ = new javax.swing.JTextField();
        txt_UserPassword_ = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(800, 345));
        setMinimumSize(new java.awt.Dimension(800, 345));
        setPreferredSize(new java.awt.Dimension(800, 345));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        LoginForm.setMaximumSize(new java.awt.Dimension(694, 315));
        LoginForm.setMinimumSize(new java.awt.Dimension(694, 315));
        LoginForm.setPreferredSize(new java.awt.Dimension(694, 315));
        LoginForm.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo_PP.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        LoginForm.add(jLabel1, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(255, 192, 57));
        jPanel1.setMaximumSize(new java.awt.Dimension(379, 315));
        jPanel1.setMinimumSize(new java.awt.Dimension(379, 315));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Đăng nhập");
        jLabel5.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 13, 0, 0);
        jPanel1.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Chi nhánh số :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 0);
        jPanel1.add(jLabel6, gridBagConstraints);

        btn_Login_.setBackground(new java.awt.Color(28, 61, 90));
        btn_Login_.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        btn_Login_.setForeground(new java.awt.Color(255, 255, 255));
        btn_Login_.setText("Đăng nhập");
        btn_Login_.setToolTipText("Vào trang chủ");
        btn_Login_.setMargin(new java.awt.Insets(5, 14, 5, 14));
        btn_Login_.setMaximumSize(new java.awt.Dimension(186, 60));
        btn_Login_.setMinimumSize(new java.awt.Dimension(186, 60));
        btn_Login_.setName(""); // NOI18N
        btn_Login_.setPreferredSize(new java.awt.Dimension(186, 60));
        btn_Login_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Login_ActionPerformed(evt);
            }
        });
        btn_Login_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_Login_KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 13);
        jPanel1.add(btn_Login_, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Cần hổ trợ ? Liên hệ 0911295205");
        jLabel7.setToolTipText("");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.insets = new java.awt.Insets(5, 13, 5, 13);
        jPanel1.add(jLabel7, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mật khẩu :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        txt_UserName_.setBackground(new java.awt.Color(28, 61, 90));
        txt_UserName_.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_UserName_.setForeground(new java.awt.Color(255, 255, 255));
        txt_UserName_.setToolTipText("Nhập tên chi nhánh");
        txt_UserName_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_UserName_KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 13);
        jPanel1.add(txt_UserName_, gridBagConstraints);

        txt_UserPassword_.setBackground(new java.awt.Color(28, 61, 90));
        txt_UserPassword_.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_UserPassword_.setForeground(new java.awt.Color(255, 255, 255));
        txt_UserPassword_.setToolTipText("Nhập mật khẩu chi nhánh");
        txt_UserPassword_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_UserPassword_KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 13);
        jPanel1.add(txt_UserPassword_, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        LoginForm.add(jPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(LoginForm, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(28, 61, 90));
        jPanel2.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Login_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Login_ActionPerformed
          checkBranch();
    }//GEN-LAST:event_btn_Login_ActionPerformed

    private void txt_UserName_KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_UserName_KeyPressed
        levanan.moreSmooth(txt_UserName_, txt_UserName_, txt_UserPassword_, evt);
    }//GEN-LAST:event_txt_UserName_KeyPressed

    private void txt_UserPassword_KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_UserPassword_KeyPressed
        levanan.moreSmooth(txt_UserName_, txt_UserPassword_, btn_Login_, evt);
    }//GEN-LAST:event_txt_UserPassword_KeyPressed

    private void btn_Login_KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_Login_KeyPressed
        levanan.moreSmooth(txt_UserPassword_, txt_UserPassword_, btn_Login_, evt);
    }//GEN-LAST:event_btn_Login_KeyPressed

    private void checkBranch(){
        // Lấy thông tin người dùng từ các ô nhập liệu
        userName = txt_UserName_.getText().trim();
        userPassword = txt_UserPassword_.getText().trim();

        // Kiểm tra nếu các trường nhập liệu đều trống
        if(userName.isEmpty() && userPassword.isEmpty()){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập gì cả! \nYêu cầu nhập vào", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra nếu trường tên đăng nhập trống
        if(userName.isEmpty()){
            JOptionPane.showMessageDialog(this, "Sai tên chi nhánh! \nYêu cầu nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra nếu trường mật khẩu trống
        if(userPassword.isEmpty()){
            JOptionPane.showMessageDialog(this, "Sai mật khẩu! \nYêu cầu nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra tên đăng nhập và mật khẩu
        if(userName.equalsIgnoreCase("a") && userPassword.equalsIgnoreCase("a")){
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            this.dispose(); // Đóng cửa sổ hiện tại
            new Home(userName).setVisible(true); // Mở cửa sổ chính
        } else {
            JOptionPane.showMessageDialog(this, "Sai tên chi nhánh hoặc mật khẩu \nYêu cầu nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            // Đặt Look and Feel thành FlatDarkLaf
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LoginForm;
    private javax.swing.JButton btn_Login_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_UserName_;
    private javax.swing.JPasswordField txt_UserPassword_;
    // End of variables declaration//GEN-END:variables
}
