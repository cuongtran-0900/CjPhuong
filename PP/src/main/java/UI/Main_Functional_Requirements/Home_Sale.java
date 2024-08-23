/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Main_Functional_Requirements;

import DAO.*;
import javax.swing.table.DefaultTableModel;
import MODEL.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
/**
 *
 * @author levan
 */
public class Home_Sale extends javax.swing.JPanel {

    /**
     * Creates new form Dashboard
     */
    public Home_Sale() {
        initComponents();
        filltoProductTBL();
        tableEvent();
        clearCart();

    }
    BillDAO billdao = new BillDAO();
    List<Bill> billList = billdao.loadAllBillData();
    ProductDAO productdao = new ProductDAO();
    List<Product> ProductList = productdao.loadAllProductData();
    
    private boolean isUpdatingTable = false;
    
    private void clearCart(){
        DefaultTableModel model = (DefaultTableModel) tbl_Cart.getModel();
        model.setRowCount(0);
    }
    
    private void filltoProductTBL(){
        DefaultTableModel model = (DefaultTableModel) tbl_Product.getModel();
        model.setRowCount(0);
        for(Product pr:ProductList){
            model.addRow(new Object[] {
                pr.getProductID(),
                pr.getProductName(),
                pr.getProductPrice()
            });
        }
    }
    
    private void tableEvent() {
        // add sự kiện nếu thay đổi số lượng thì cập nhật thành tiền
        tbl_Cart.getModel().addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                // Kiểm tra nếu cột thay đổi là cột số lượng
                if (column == 2) {
                    int quantity = (int) tbl_Cart.getValueAt(row, column);
                    // Nếu số lượng hợp lệ, cập nhật thành tiền
                    int price = (int) tbl_Cart.getValueAt(row, 1);
                    int totalprice = quantity * price;
                    tbl_Cart.setValueAt(totalprice, row, 3); // Cập nhật thành tiền
                    updateTotalAmount(); // Cập nhật tổng tiền
                }
            }
        });
        // add sự kiện double click thì add sản phẩm vào tbl_Cart
        tbl_Product.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Kiểm tra click đôi
                    int selectedRow = tbl_Product.rowAtPoint(e.getPoint()); // Lấy hàng tại vị trí chuột
                    if (selectedRow != -1) {
                        addProductToCart(selectedRow);
                    }
                }
            }
        });
    }
    
    private void updateTotalAmount() {
        DefaultTableModel cartmodel = (DefaultTableModel) tbl_Cart.getModel();
        int totalAmount = 0;
        for (int i = 0; i < cartmodel.getRowCount(); i++) {
            int thanhTien = 0;
            thanhTien = (int) cartmodel.getValueAt(i, 4);
            totalAmount += thanhTien;
        }
        txt_TotalAmount.setText(String.valueOf(totalAmount));
    }
    
    private void addProductToCart(int selectedRow) {
        DefaultTableModel cartmodel = (DefaultTableModel) tbl_Cart.getModel();
        String IDProduct = String.valueOf(tbl_Product.getValueAt(selectedRow, 0));
        String nameproduct = String.valueOf(tbl_Product.getValueAt(selectedRow, 1));
        int productprice = (int) (tbl_Product.getValueAt(selectedRow, 2));
        int quantity = 1;
        int totalprice = quantity * productprice;
        boolean productExists = false;

        for (int i = 0; i < tbl_Cart.getRowCount(); i++) {
            String IDProductInCart = String.valueOf(tbl_Cart.getValueAt(i, 0));
            if (IDProduct.equalsIgnoreCase(IDProductInCart)) {
                int currentQuantity = (int) tbl_Cart.getValueAt(i, 3);
                int newQuantity = currentQuantity + quantity;
                totalprice = newQuantity * productprice;

                isUpdatingTable = true;
                tbl_Cart.setValueAt(newQuantity, i, 3); // Cập nhật số lượng
                tbl_Cart.setValueAt(totalprice, i, 4); // Cập nhật thành tiền
                isUpdatingTable = false;
                productExists = true; // Đánh dấu sản phẩm đã tồn tại
                break;
            }
        }

        if (!productExists) {
            // Thêm sản phẩm mới vào bảng nếu không tìm thấy
            Object[] rowData = new Object[]{IDProduct,nameproduct, productprice, quantity, totalprice};
            cartmodel.addRow(rowData);
        }

        // Cập nhật tổng tiền
        updateTotalAmount();
    }
    
    private String TimeNow(){
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(System.currentTimeMillis());
        String newTime = String.valueOf(currentTimestamp);
        return newTime;
    }
    
    public void payment() {
        Bill bill = new Bill();
        bill.setBillID(billdao.NewBillID());
        bill.setAccountID("CN01");
        bill.setBillNote((String) cbo_TextNote.getSelectedItem());
        bill.setCreateDate(Timestamp.valueOf(TimeNow()));
        try {
            bill.setBillTotalAmount(Integer.parseInt(txt_TotalAmount.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tổng tiền không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<BillDetail> billdetailList = new ArrayList<>();

        for (int i = 0; i < tbl_Cart.getRowCount(); i++) {
            BillDetail billdetail = new BillDetail();
            
            billdetail.setProductID((String) tbl_Cart.getValueAt(i, 0)); // Thành tiền
            billdetail.setProductPrice((int) tbl_Cart.getValueAt(i, 2)); // Tên thuốc
            billdetail.setQuantity((int) tbl_Cart.getValueAt(i, 3)); // Số lượng
            billdetail.setTotalPrice((int) tbl_Cart.getValueAt(i, 4)); // Giá nhập

            billdetailList.add(billdetail);
        }
        bill.setBillDetailList(billdetailList);
        int result = billdao.save(bill);
        if (result>0) {
            JOptionPane.showMessageDialog(null, "Thanh toán thành công");
            ((DefaultTableModel) tbl_Cart.getModel()).setRowCount(0); // Làm rỗng giỏ hàng
        } else {
            JOptionPane.showMessageDialog(this, "Thanh Toán thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Product = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Cart = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_Reset = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_TotalAmount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_CustomerCash = new javax.swing.JTextField();
        txt_CashChange = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_Save = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbo_TextNote = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 192, 57));
        setLayout(new java.awt.GridBagLayout());

        tbl_Product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Món Ăn", "Tên Món Ăn", "Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_Product);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 508;
        gridBagConstraints.ipady = 495;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 12.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 10, 10, 0);
        add(jScrollPane1, gridBagConstraints);

        tbl_Cart.setAutoCreateRowSorter(true);
        tbl_Cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Món Ăn", "Tên Món Ăn", "Đơn Giá", "Số Lượng", "Thành Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_Cart);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 686;
        gridBagConstraints.ipady = 227;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 100, 0, 10);
        add(jScrollPane2, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BÁN HÀNG");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 1217;
        gridBagConstraints.ipady = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabel1, gridBagConstraints);

        btn_Reset.setText("Làm Mới");
        btn_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ResetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 135, 10, 0);
        add(btn_Reset, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tổng Tiền");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 135, 0, 0);
        add(jLabel2, gridBagConstraints);

        txt_TotalAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TotalAmountActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 485;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 0);
        add(txt_TotalAmount, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Khách Đưa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 135, 0, 0);
        add(jLabel3, gridBagConstraints);

        txt_CustomerCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CustomerCashActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 485;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 18, 0, 0);
        add(txt_CustomerCash, gridBagConstraints);

        txt_CashChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CashChangeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 485;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 18, 0, 0);
        add(txt_CashChange, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tiền Thừa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 135, 0, 0);
        add(jLabel4, gridBagConstraints);

        btn_Save.setText("Lưu In");
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.ipady = 27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(50, 467, 10, 0);
        add(btn_Save, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ghi Chú");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 135, 0, 0);
        add(jLabel5, gridBagConstraints);

        cbo_TextNote.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none", "Bấm Nhầm" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 456;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 18, 0, 0);
        add(cbo_TextNote, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_TotalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TotalAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TotalAmountActionPerformed

    private void txt_CustomerCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CustomerCashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CustomerCashActionPerformed

    private void txt_CashChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CashChangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CashChangeActionPerformed

    private void btn_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ResetActionPerformed
        // TODO add your handling code here:
        clearCart();
    }//GEN-LAST:event_btn_ResetActionPerformed

    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed
        // TODO add your handling code here:
        payment();
    }//GEN-LAST:event_btn_SaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Reset;
    private javax.swing.JButton btn_Save;
    private javax.swing.JComboBox<String> cbo_TextNote;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_Cart;
    private javax.swing.JTable tbl_Product;
    private javax.swing.JTextField txt_CashChange;
    private javax.swing.JTextField txt_CustomerCash;
    private javax.swing.JTextField txt_TotalAmount;
    // End of variables declaration//GEN-END:variables
}
