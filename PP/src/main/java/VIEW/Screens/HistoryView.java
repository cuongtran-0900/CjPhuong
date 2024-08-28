package VIEW.Screens;

import DAO.*;
import MODEL.*;
import UX.LeVanAn;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class HistoryView extends javax.swing.JPanel {
    private final BillDAO billDAO = new BillDAO();
    private final BillDetailDAO billDetailDAO = new BillDetailDAO();    
    private List<Bill> billList;
    private final LeVanAn levanan = new LeVanAn();
    
    private final Date today = Calendar.getInstance().getTime();
    
    public HistoryView(String branchName) {
        initComponents();
        loadBillList();
        if(tbl_ShowAllBill_.getRowCount() == 0){
            sp_SearchBill_.setEnabled(false);
            sp_SearchBill_.setValue(0);
        }
        updateTotalMoneyLabel();
        cld_SearchBill_.setDate(today);
        loadBillDataByDate(today, 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        Bill = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ShowAllBill_ = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txt_SearchBill_ = new javax.swing.JTextField();
        lbl_TitleBill = new javax.swing.JLabel();
        cbx_SearchBill_ = new javax.swing.JComboBox<>();
        cld_SearchBill_ = new com.toedter.calendar.JDateChooser();
        BillDetail = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_ShowAllBillDetail = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbl_TitleBillDetail = new javax.swing.JLabel();
        sp_SearchBill_ = new javax.swing.JSpinner();
        lbl_TotalMoney = new javax.swing.JLabel();

        setBackground(new java.awt.Color(229, 237, 239));
        setLayout(new java.awt.GridBagLayout());

        Bill.setBackground(new java.awt.Color(229, 237, 239));
        Bill.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setColumnHeaderView(null);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(454, 404));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(454, 404));
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
            tbl_ShowAllBill_.getColumnModel().getColumn(1).setMinWidth(90);
            tbl_ShowAllBill_.getColumnModel().getColumn(1).setPreferredWidth(90);
            tbl_ShowAllBill_.getColumnModel().getColumn(1).setMaxWidth(90);
            tbl_ShowAllBill_.getColumnModel().getColumn(3).setMinWidth(300);
            tbl_ShowAllBill_.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbl_ShowAllBill_.getColumnModel().getColumn(3).setMaxWidth(300);
            tbl_ShowAllBill_.getColumnModel().getColumn(5).setMinWidth(90);
            tbl_ShowAllBill_.getColumnModel().getColumn(5).setPreferredWidth(90);
            tbl_ShowAllBill_.getColumnModel().getColumn(5).setMaxWidth(90);
        }
        // Tạo đối tượng DefaultTableCellRenderer để định dạng ngày giờ và căn giữa
        DefaultTableCellRenderer timeRenderer = new DefaultTableCellRenderer() {
            private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

            @Override
            protected void setValue(Object value) {
                if (value instanceof java.sql.Timestamp) {
                    value = dateFormat.format(((java.sql.Timestamp) value).getTime());
                }
                setHorizontalAlignment(javax.swing.JLabel.CENTER); // Căn giữa văn bản
                super.setValue(value);
            }
        };

        // Áp dụng renderer cho cột thời gian (cột index 3)
        tbl_ShowAllBill_.getColumnModel().getColumn(3).setCellRenderer(timeRenderer);

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

        txt_SearchBill_.setBackground(new java.awt.Color(28, 61, 90));
        txt_SearchBill_.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txt_SearchBill_.setForeground(new java.awt.Color(255, 255, 255));
        txt_SearchBill_.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_SearchBill_.setMaximumSize(new java.awt.Dimension(64, 28));
        txt_SearchBill_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchBill_KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        Bill.add(txt_SearchBill_, gridBagConstraints);

        lbl_TitleBill.setBackground(new java.awt.Color(255, 255, 255));
        lbl_TitleBill.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_TitleBill.setForeground(new java.awt.Color(249, 0, 64));
        lbl_TitleBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_TitleBill.setText("Hóa Đơn Của Ngày Hôm Nay");
        lbl_TitleBill.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));
        lbl_TitleBill.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 25, 10);
        Bill.add(lbl_TitleBill, gridBagConstraints);

        cbx_SearchBill_.setBackground(new java.awt.Color(28, 61, 90));
        cbx_SearchBill_.setEditable(true);
        cbx_SearchBill_.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbx_SearchBill_.setForeground(new java.awt.Color(255, 255, 255));
        cbx_SearchBill_.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hôm nay", "Hôm qua", "Tất cả" }));
        cbx_SearchBill_.setMaximumSize(new java.awt.Dimension(100, 26));
        cbx_SearchBill_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_SearchBill_ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        Bill.add(cbx_SearchBill_, gridBagConstraints);

        cld_SearchBill_.setForeground(new java.awt.Color(255, 255, 255));
        cld_SearchBill_.setDateFormatString("dd - MMMM - yyyy");
        cld_SearchBill_.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cld_SearchBill_.setMaxSelectableDate(new java.util.Date(1767204063000L));
        cld_SearchBill_.setMaximumSize(new java.awt.Dimension(137, 22));
        cld_SearchBill_.setMinSelectableDate(new java.util.Date(1724608863000L));
        cld_SearchBill_.setMinimumSize(new java.awt.Dimension(137, 22));
        cld_SearchBill_.setOpaque(false);
        cld_SearchBill_.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cld_SearchBill_PropertyChange(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        Bill.add(cld_SearchBill_, gridBagConstraints);
        cld_SearchBill_.setLocale(new Locale("vi", "VN"));

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
        jScrollPane2.setMaximumSize(new java.awt.Dimension(454, 404));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(454, 404));
        jScrollPane2.setRowHeaderView(null);

        tbl_ShowAllBillDetail.setBackground(new java.awt.Color(255, 192, 57));
        tbl_ShowAllBillDetail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.darkGray, java.awt.Color.darkGray));
        tbl_ShowAllBillDetail.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
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
        tbl_ShowAllBillDetail.setRowHeight(50);
        tbl_ShowAllBillDetail.setSelectionBackground(new java.awt.Color(200, 136, 0));
        tbl_ShowAllBillDetail.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_ShowAllBillDetail.setShowHorizontalLines(true);
        tbl_ShowAllBillDetail.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbl_ShowAllBillDetail);
        if (tbl_ShowAllBillDetail.getColumnModel().getColumnCount() > 0) {
            tbl_ShowAllBillDetail.getColumnModel().getColumn(0).setMinWidth(40);
            tbl_ShowAllBillDetail.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbl_ShowAllBillDetail.getColumnModel().getColumn(0).setMaxWidth(40);
            tbl_ShowAllBillDetail.getColumnModel().getColumn(1).setMinWidth(300);
            tbl_ShowAllBillDetail.getColumnModel().getColumn(1).setPreferredWidth(300);
            tbl_ShowAllBillDetail.getColumnModel().getColumn(1).setMaxWidth(300);
        }
        // Khai báo và khởi tạo centerRenderer
        DefaultTableCellRenderer centerRenderer2 = new DefaultTableCellRenderer();
        centerRenderer2.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        // Đặt renderer cho tất cả các cột để căn giữa
        for (int i = 0; i < tbl_ShowAllBillDetail.getColumnModel().getColumnCount(); i++) {
            tbl_ShowAllBillDetail.getColumnModel().getColumn(i).setCellRenderer(centerRenderer2);
        }
        // Khai báo và khởi tạo leftRenderer cho cột thứ 2 (index 1)
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        tbl_ShowAllBillDetail.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);

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

        lbl_TitleBillDetail.setBackground(new java.awt.Color(255, 255, 255));
        lbl_TitleBillDetail.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_TitleBillDetail.setForeground(new java.awt.Color(249, 0, 64));
        lbl_TitleBillDetail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_TitleBillDetail.setText("Chi Tiết Hóa Đơn");
        lbl_TitleBillDetail.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));
        lbl_TitleBillDetail.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 25, 10);
        BillDetail.add(lbl_TitleBillDetail, gridBagConstraints);

        sp_SearchBill_.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        sp_SearchBill_.setMaximumSize(new java.awt.Dimension(64, 28));
        sp_SearchBill_.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sp_SearchBill_StateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        BillDetail.add(sp_SearchBill_, gridBagConstraints);
        sp_SearchBill_.setBackground(new java.awt.Color(28, 61, 90));
        sp_SearchBill_.setForeground(new java.awt.Color(255, 255, 255));
        // Tùy chỉnh editor để giá trị nằm giữa
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) sp_SearchBill_.getEditor();
        JFormattedTextField textField = editor.getTextField();
        textField.setHorizontalAlignment(JFormattedTextField.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        add(BillDetail, gridBagConstraints);

        lbl_TotalMoney.setBackground(new java.awt.Color(255, 255, 255));
        lbl_TotalMoney.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_TotalMoney.setForeground(new java.awt.Color(255, 27, 86));
        lbl_TotalMoney.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_TotalMoney.setText("Tổng tiền bán trong ngày hôm nay:");
        lbl_TotalMoney.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));
        lbl_TotalMoney.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        add(lbl_TotalMoney, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void cld_SearchBill_PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cld_SearchBill_PropertyChange
        updateCalendar();
    }//GEN-LAST:event_cld_SearchBill_PropertyChange

    private void cbx_SearchBill_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_SearchBill_ActionPerformed
        updateComboBox();
    }//GEN-LAST:event_cbx_SearchBill_ActionPerformed

    private void txt_SearchBill_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchBill_KeyReleased
        // Bấm tới đầu tìm tới đó, tìm nhưng chữ cái xuất hiện trong bảng tbl_ShowAllBill_
        levanan.filterDataByTableToTextField(tbl_ShowAllBill_, txt_SearchBill_);
    }//GEN-LAST:event_txt_SearchBill_KeyReleased

    private void sp_SearchBill_StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sp_SearchBill_StateChanged
        updateSpinner();
    }//GEN-LAST:event_sp_SearchBill_StateChanged

    private void tbl_ShowAllBill_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ShowAllBill_MouseClicked
        updateBillDetails();
        updateTotalMoneyLabel();
    }//GEN-LAST:event_tbl_ShowAllBill_MouseClicked
    
    // Luôn có dữ liệu mới nhất trên database
    private void loadBillList() {
        billList = billDAO.loadAllBillData();
    }
    
    // Cập nhật thông tin chi tiết hóa đơn khi người dùng chọn hóa đơn trong bảng
    private void updateBillDetails() {
        int selectedRow = tbl_ShowAllBill_.getSelectedRow();
        if (selectedRow != -1) {
            // Lấy billID từ hàng được chọn
            String billID = (String) tbl_ShowAllBill_.getValueAt(selectedRow, 1);
            // Hiển thị số thứ tự hóa đơn và tải chi tiết hóa đơn
            sp_SearchBill_.setValue(selectedRow + 1);
            lbl_TitleBillDetail.setText("Chi Tiết Hóa Đơn Số: " + (selectedRow + 1));
            loadBillDetailData(billID);
        }
    }

    // Cập nhật bảng chi tiết hóa đơn dựa trên số thứ tự đã chọn
    private void updateSpinner() {
        int rowCount = tbl_ShowAllBill_.getRowCount();
        int selectedIndex = (int) sp_SearchBill_.getValue();
        
        if (selectedIndex <= 0) {
            // Xóa bảng chi tiết hóa đơn nếu số thứ tự không hợp lệ
            clearBillDetailTable();
            sp_SearchBill_.setValue(0);
            lbl_TitleBillDetail.setText("Chọn để xem hóa đơn chi tiết");
        } else if (selectedIndex <= rowCount) {
            // Lấy billID từ hàng tương ứng
            String billID = (String) tbl_ShowAllBill_.getValueAt(selectedIndex - 1, 1);
            loadBillDetailData(billID);
            lbl_TitleBillDetail.setText("Chi Tiết Hóa Đơn Số: " + selectedIndex);
        } else {
            // Điều chỉnh số thứ tự nếu vượt quá số hàng hiện có
            sp_SearchBill_.setValue(rowCount);
            lbl_TitleBillDetail.setText("Chi Tiết Hóa Đơn Số: " + rowCount);
        }
    }

    // Cập nhật thông tin hóa đơn dựa trên ngày chọn từ lịch
    private void updateCalendar() {
        Date selectedDate = cld_SearchBill_.getDate();
        if (selectedDate == null) {
            selectedDate = new Date();
        }

        Calendar today = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(selectedDate);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = sdf.format(selectedDate);

        if (isToday(calendar, today)) {
            lbl_TitleBill.setText("Hóa Đơn Của Ngày Hôm Nay");
            cbx_SearchBill_.setSelectedIndex(0);
        } else if (isYesterday(calendar, today)) {
            lbl_TitleBill.setText("Hóa Đơn Của Ngày Hôm Qua");
            cbx_SearchBill_.setSelectedIndex(1);
        } else {
            lbl_TitleBill.setText("Hóa Đơn Của Ngày " + formattedDate);
            cbx_SearchBill_.setSelectedIndex(-1);
        }

        loadBillDataByDate(selectedDate, 0);

        if (tbl_ShowAllBill_.getRowCount() > 0) {
            sp_SearchBill_.setEnabled(true);
            sp_SearchBill_.setValue(0);
            lbl_TitleBillDetail.setText("Chọn hóa đơn để xem chi tiết");
        } else {
            sp_SearchBill_.setEnabled(false);
            sp_SearchBill_.setValue(0);
            clearBillDetailTable();
            lbl_TitleBillDetail.setText("Không có hóa đơn để xem chi tiết");
        }
    }

    // Cập nhật bảng hóa đơn dựa trên giá trị của ComboBox
    private void updateComboBox() {
        Calendar calendar = Calendar.getInstance();
        if(cbx_SearchBill_.getSelectedIndex() == 2){
            lbl_TitleBill.setText("Tất cả hóa đơn");
            cld_SearchBill_.setDate(null);
            cbx_SearchBill_.setSelectedIndex(2);
            loadBillDataByDate(today, 1);
        } else if (cbx_SearchBill_.getSelectedIndex() == 1) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            cld_SearchBill_.setDate(calendar.getTime());
            lbl_TitleBill.setText("Hóa Đơn Của Ngày Hôm Qua");
            loadBillDataByDate(calendar.getTime(), 0);
        } else if (cbx_SearchBill_.getSelectedIndex() == 0) {
            cld_SearchBill_.setDate(today);
            lbl_TitleBill.setText("Hóa Đơn Của Ngày Hôm Nay");
            loadBillDataByDate(today, 0);
        }

        if (tbl_ShowAllBill_.getRowCount() > 0) {
            sp_SearchBill_.setEnabled(true);
            sp_SearchBill_.setValue(0);
            lbl_TitleBillDetail.setText("Chọn hóa đơn để xem chi tiết");
        } else {
            sp_SearchBill_.setEnabled(false);
            sp_SearchBill_.setValue(0);
            clearBillDetailTable();
            lbl_TitleBillDetail.setText("Không có hóa đơn để xem chi tiết");
        }
    }

    // Cộng tổng tiền các hóa đơn trên bản và hiển thị
    private void updateTotalMoneyLabel() {
        DefaultTableModel model = (DefaultTableModel) tbl_ShowAllBill_.getModel();
        int totalAmount = 0;

        // Kiểm tra nếu bảng không có hàng nào
        if (model.getRowCount() == 0) {
            lbl_TotalMoney.setText("Tổng tiền bán: 0đ");
            return;
        }

        // Duyệt qua tất cả các hàng trong bảng
        for (int i = 0; i < model.getRowCount(); i++) {
            // Lấy giá trị tại cột index 4 (cột số tiền)
            Object value = model.getValueAt(i, 4);
            boolean status = (boolean) model.getValueAt(i, 5);
            if (value != null && status != false) {
                // Chuyển đổi giá trị thành số nguyên và cộng vào tổng
                int amount = Integer.parseInt(levanan.formatMoney(value, 0));
                totalAmount += amount;
                // Xử lý ngoại lệ nếu giá trị không phải là số
                System.err.println("Giá trị không hợp lệ tại hàng " + i + ": " + value);
            }
        }

        // Định dạng tổng tiền
        String formattedTotal = levanan.formatMoney(totalAmount,1);

        // Cập nhật lbl_TotalMoney với tổng giá trị
        lbl_TotalMoney.setText("Tổng tiền bán: " + formattedTotal);
    }

    // Tải dữ liệu hóa đơn vào bảng theo ngày đã chọn
    private void loadBillDataByDate(Date selectedDate, int choice) {
        loadBillList(); // Tải lại dữ liệu mới nhất
        DefaultTableModel model = (DefaultTableModel) tbl_ShowAllBill_.getModel();
        model.setRowCount(0);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String selectedDateStr = (selectedDate != null) ? sdf.format(selectedDate) : null;

        int count = 1;
        for (Bill bill : billList) {
            String billDateStr = sdf.format(bill.getCreateDate());
            String paymentType = (bill.getBillpayment() == 0) ? "Chuyển khoản" : "Tiền mặt";

            if (choice == 1 || (selectedDateStr != null && billDateStr.equals(selectedDateStr) && choice == 0)) {
                Object[] rowData = new Object[]{
                    count++,
                    bill.getBillID(),
                    paymentType,
                    bill.getCreateDate(),
                    levanan.formatMoney(bill.getBillTotalAmount(), 1),
                    bill.getBillStatus() != 0
                };
                model.addRow(rowData);
            }
        }
        tbl_ShowAllBill_.setModel(model);
        updateTotalMoneyLabel();
    }

    // Tải dữ liệu chi tiết hóa đơn vào bảng
    private void loadBillDetailData(String billID) {
        DefaultTableModel model = (DefaultTableModel) tbl_ShowAllBillDetail.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ

        List<BillDetail> billDetails = billDetailDAO.loadBillDetailByBillID(billID);
        int count = 1;
        for (BillDetail detail : billDetails) {
            Object[] rowData = new Object[]{
                count++,
                detail.getProductName(),
                detail.getProductPrice(),
                detail.getQuantity(),
                detail.getTotalPrice()
            };
            model.addRow(rowData);
        }
        tbl_ShowAllBillDetail.setModel(model);
    }
    
    // Xóa dữ liệu trong bảng chi tiết hóa đơn
    private void clearBillDetailTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_ShowAllBillDetail.getModel();
        model.setRowCount(0);
    }

    // Kiểm tra xem ngày có phải là hôm nay không
    private boolean isToday(Calendar dateToCheck, Calendar today) {
        return (dateToCheck.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                dateToCheck.get(Calendar.MONTH) == today.get(Calendar.MONTH) &&
                dateToCheck.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH));
    }

    // Kiểm tra xem ngày có phải là ngày hôm qua không
    private boolean isYesterday(Calendar dateToCheck, Calendar today) {
        // Tạo một bản sao của ngày hôm nay để thao tác
        Calendar yesterday = (Calendar) today.clone();
        yesterday.add(Calendar.DAY_OF_MONTH, -1);

        return (dateToCheck.get(Calendar.YEAR) == yesterday.get(Calendar.YEAR) &&
                dateToCheck.get(Calendar.MONTH) == yesterday.get(Calendar.MONTH) &&
                dateToCheck.get(Calendar.DAY_OF_MONTH) == yesterday.get(Calendar.DAY_OF_MONTH));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bill;
    private javax.swing.JPanel BillDetail;
    private javax.swing.JComboBox<String> cbx_SearchBill_;
    private com.toedter.calendar.JDateChooser cld_SearchBill_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_TitleBill;
    private javax.swing.JLabel lbl_TitleBillDetail;
    private javax.swing.JLabel lbl_TotalMoney;
    private javax.swing.JSpinner sp_SearchBill_;
    private javax.swing.JTable tbl_ShowAllBillDetail;
    private javax.swing.JTable tbl_ShowAllBill_;
    private javax.swing.JTextField txt_SearchBill_;
    // End of variables declaration//GEN-END:variables
}
