package VIEW.Screens;

import DAO.*;
import MODEL.*;
import java.util.List;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;

public class HistoryView extends javax.swing.JPanel {
    private final BillDAO billDAO = new BillDAO();
    private final BillDetailDAO billDetailDAO = new BillDetailDAO();    
    
    private final List<Bill> billList = billDAO.loadAllBillData();
    
    
    public HistoryView(String branchName) {
        initComponents();
        loadBillDataToTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        Bill = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ShowAllBill_ = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txt_SearchBill = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbx_SearchBill = new javax.swing.JComboBox<>();
        cld_SearchBill = new com.toedter.calendar.JDateChooser();
        BillDetail = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_ShowAllBillDetail = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sp_SearchBill = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(229, 237, 239));
        setLayout(new java.awt.GridBagLayout());

        Bill.setBackground(new java.awt.Color(229, 237, 239));
        Bill.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setColumnHeaderView(null);
        jScrollPane1.setRowHeaderView(null);

        tbl_ShowAllBill_.setAutoCreateRowSorter(true);
        tbl_ShowAllBill_.setBackground(new java.awt.Color(255, 192, 57));
        tbl_ShowAllBill_.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.darkGray, java.awt.Color.darkGray));
        tbl_ShowAllBill_.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbl_ShowAllBill_.setForeground(new java.awt.Color(255, 255, 255));
        tbl_ShowAllBill_.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hóa đơn", "Thanh toán", "Thời gian", "Tổng tiền", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_ShowAllBill_.setGridColor(new java.awt.Color(28, 61, 90));
        tbl_ShowAllBill_.setName(""); // NOI18N
        tbl_ShowAllBill_.setRowHeight(25);
        tbl_ShowAllBill_.setSelectionBackground(new java.awt.Color(200, 136, 0));
        tbl_ShowAllBill_.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_ShowAllBill_.setShowHorizontalLines(true);
        tbl_ShowAllBill_.getTableHeader().setReorderingAllowed(false);
        tbl_ShowAllBill_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ShowAllBill_MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_ShowAllBill_);
        if (tbl_ShowAllBill_.getColumnModel().getColumnCount() > 0) {
            tbl_ShowAllBill_.getColumnModel().getColumn(0).setMinWidth(40);
            tbl_ShowAllBill_.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbl_ShowAllBill_.getColumnModel().getColumn(0).setMaxWidth(40);
            tbl_ShowAllBill_.getColumnModel().getColumn(3).setMinWidth(200);
            tbl_ShowAllBill_.getColumnModel().getColumn(3).setPreferredWidth(200);
            tbl_ShowAllBill_.getColumnModel().getColumn(3).setMaxWidth(200);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        Bill.add(jScrollPane1, gridBagConstraints);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(28, 61, 90));
        jLabel4.setText("Tìm kiếm:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        Bill.add(jLabel4, gridBagConstraints);

        txt_SearchBill.setBackground(new java.awt.Color(28, 61, 90));
        txt_SearchBill.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txt_SearchBill.setForeground(new java.awt.Color(255, 255, 255));
        txt_SearchBill.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        Bill.add(txt_SearchBill, gridBagConstraints);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(249, 0, 64));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Hóa Đơn Của Ngày Hôm Nay");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));
        jLabel3.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 25, 10);
        Bill.add(jLabel3, gridBagConstraints);

        cbx_SearchBill.setBackground(new java.awt.Color(28, 61, 90));
        cbx_SearchBill.setEditable(true);
        cbx_SearchBill.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbx_SearchBill.setForeground(new java.awt.Color(255, 255, 255));
        cbx_SearchBill.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hôm nay", "Hôm qua", "Hôm kia" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        Bill.add(cbx_SearchBill, gridBagConstraints);

        cld_SearchBill.setForeground(new java.awt.Color(255, 255, 255));
        cld_SearchBill.setDateFormatString("dd - MMMM - yyyy");
        cld_SearchBill.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cld_SearchBill.setMaxSelectableDate(new java.util.Date(1767204063000L));
        cld_SearchBill.setMinSelectableDate(new java.util.Date(1724695263000L));
        cld_SearchBill.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        Bill.add(cld_SearchBill, gridBagConstraints);
        cld_SearchBill.setLocale(new Locale("vi", "VN"));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        add(Bill, gridBagConstraints);

        BillDetail.setBackground(new java.awt.Color(229, 237, 239));
        BillDetail.setLayout(new java.awt.GridBagLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setRowHeaderView(null);

        tbl_ShowAllBillDetail.setBackground(new java.awt.Color(255, 192, 57));
        tbl_ShowAllBillDetail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.darkGray, java.awt.Color.darkGray));
        tbl_ShowAllBillDetail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbl_ShowAllBillDetail.setForeground(new java.awt.Color(255, 255, 255));
        tbl_ShowAllBillDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Món ăn", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_ShowAllBillDetail.setGridColor(new java.awt.Color(28, 61, 90));
        tbl_ShowAllBillDetail.setRowHeight(25);
        tbl_ShowAllBillDetail.setSelectionBackground(new java.awt.Color(200, 136, 0));
        tbl_ShowAllBillDetail.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_ShowAllBillDetail.setShowHorizontalLines(true);
        tbl_ShowAllBillDetail.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbl_ShowAllBillDetail);
        if (tbl_ShowAllBillDetail.getColumnModel().getColumnCount() > 0) {
            tbl_ShowAllBillDetail.getColumnModel().getColumn(0).setMinWidth(40);
            tbl_ShowAllBillDetail.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbl_ShowAllBillDetail.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        BillDetail.add(jScrollPane2, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 61, 90));
        jLabel1.setText("Đơn thứ:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        BillDetail.add(jLabel1, gridBagConstraints);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(249, 0, 64));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Chi Tiết Hóa Đơn");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));
        jLabel5.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 25, 10);
        BillDetail.add(jLabel5, gridBagConstraints);

        sp_SearchBill.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        BillDetail.add(sp_SearchBill, gridBagConstraints);
        sp_SearchBill.setBackground(new java.awt.Color(28, 61, 90));
        sp_SearchBill.setForeground(new java.awt.Color(255, 255, 255));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        add(BillDetail, gridBagConstraints);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 27, 86));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Tổng tiền bán trong ngày hôm nay:");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));
        jLabel2.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        add(jLabel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_ShowAllBill_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ShowAllBill_MouseClicked
        int selectRow = tbl_ShowAllBill_.getSelectedRow();
        if (selectRow != -1) {
        // Lấy billID từ hàng được chọn
        String billID = (String) tbl_ShowAllBill_.getValueAt(selectRow, 1);

        // Hiển thị số thứ tự đơn hàng
        sp_SearchBill.setValue(selectRow + 1);

        // Tải và hiển thị chi tiết hóa đơn
        loadBillDetailDataToTable(billID);
    }
    }//GEN-LAST:event_tbl_ShowAllBill_MouseClicked

    private void loadBillDataToTable() {
        int count = 1;
        // Tạo DefaultTableModel với các cột tương ứng
        DefaultTableModel model = (DefaultTableModel) tbl_ShowAllBill_.getModel();

        // Xóa toàn bộ dữ liệu hiện tại trong bảng (nếu có)
        model.setRowCount(0);

        // Lặp qua danh sách bill và thêm vào model
        for (Bill bill : billList) {
            boolean status = true;
            String payment = "Tiền mặt";
            if(bill.getBillStatus() == 0){
                status = false;
            }
            if(bill.getBillpayment() == 0){
                payment = "Chuyển khoản";
            }
            Object[] rowData = new Object[]{
                count,
                bill.getBillID(),
                payment,
                bill.getCreateDate(),
                bill.getBillTotalAmount(),  
                status
            };
            count ++;
            model.addRow(rowData); // Thêm dòng dữ liệu vào model
        }

        // Gán model cho JTable
        tbl_ShowAllBill_.setModel(model);
    }
    private void loadBillDetailDataToTable(String billID) {
        DefaultTableModel model = (DefaultTableModel) tbl_ShowAllBillDetail.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ

        // Giả sử bạn có phương thức trong BillDAO để lấy chi tiết hóa đơn
        List<BillDetail> billDetailList = billDetailDAO.loadBillDetailByBillID(billID);

        int count = 1;
        for (BillDetail billDetail : billDetailList) {
            Object[] rowData = new Object[]{
                count,
                billDetail.getProductName(),
                billDetail.getProductPrice(),
                billDetail.getQuantity(),
                billDetail.getTotalPrice()
            };
            model.addRow(rowData);
            count++;
        }

        tbl_ShowAllBillDetail.setModel(model);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bill;
    private javax.swing.JPanel BillDetail;
    private javax.swing.JComboBox<String> cbx_SearchBill;
    private com.toedter.calendar.JDateChooser cld_SearchBill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner sp_SearchBill;
    private javax.swing.JTable tbl_ShowAllBillDetail;
    private javax.swing.JTable tbl_ShowAllBill_;
    private javax.swing.JTextField txt_SearchBill;
    // End of variables declaration//GEN-END:variables
}
