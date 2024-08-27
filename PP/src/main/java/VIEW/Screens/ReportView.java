package VIEW.Screens;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ReportView extends javax.swing.JPanel {
    public ReportView(String branchName) {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lbl_Title = new javax.swing.JLabel();
        cld_SelectDate = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_WrongBill = new javax.swing.JTable();
        btn_RemoveWrongBill = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbl_TitleRevenueByDay = new javax.swing.JLabel();
        lbl_ShowRevenueByDay = new javax.swing.JLabel();
        lbl_ShowTotalBillByDay = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_ShowProductSoldByDay = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lbl_TitleRevenueByWeek = new javax.swing.JLabel();
        lbl_ShowRevenueByWeek = new javax.swing.JLabel();
        lbl_ShowTotalBillByWeek = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_TitleRevenueByYear = new javax.swing.JLabel();
        lbl_ShowRevenueByYear = new javax.swing.JLabel();
        lbl_ShowTotalBillByYear = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_TitleRevenueByMonth = new javax.swing.JLabel();
        lbl_ShowRevenueByMonth = new javax.swing.JLabel();
        lbl_ShowTotalBillByMonth = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_ShowProductSoldByWeek = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_ShowProductSoldByMonth = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_ShowProductSoldByYear = new javax.swing.JTable();

        setBackground(new java.awt.Color(229, 237, 239));
        setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        setLayout(new java.awt.GridBagLayout());

        lbl_Title.setBackground(new java.awt.Color(255, 255, 255));
        lbl_Title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_Title.setForeground(new java.awt.Color(249, 0, 64));
        lbl_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Title.setText("Báo cáo thống kê hôm nay");
        lbl_Title.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));
        lbl_Title.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 1160;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 15, 10);
        add(lbl_Title, gridBagConstraints);

        cld_SelectDate.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        cld_SelectDate.setForeground(new java.awt.Color(0, 0, 0));
        cld_SelectDate.setDecorationBackgroundColor(new java.awt.Color(255, 255, 255));
        cld_SelectDate.setDecorationBordersVisible(true);
        cld_SelectDate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cld_SelectDate.setMaxSelectableDate(new java.util.Date(1767204092000L));
        cld_SelectDate.setMinSelectableDate(new java.util.Date(1724608892000L));
        cld_SelectDate.setOpaque(false);
        cld_SelectDate.setSundayForeground(new java.awt.Color(255, 0, 0));
        cld_SelectDate.setTodayButtonText("Quay lại ngày hôm nay");
        cld_SelectDate.setTodayButtonVisible(true);
        cld_SelectDate.setWeekdayForeground(new java.awt.Color(0, 0, 255));
        cld_SelectDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cld_SelectDatePropertyChange(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 225;
        gridBagConstraints.ipady = 59;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 5);
        add(cld_SelectDate, gridBagConstraints);
        // Thiết lập ngôn ngữ là Tiếng Việt
        cld_SelectDate.setLocale(new Locale("vi", "VN"));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setColumnHeaderView(null);
        jScrollPane1.setRowHeaderView(null);

        tbl_WrongBill.setAutoCreateRowSorter(true);
        tbl_WrongBill.setBackground(new java.awt.Color(255, 192, 57));
        tbl_WrongBill.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.darkGray, java.awt.Color.darkGray));
        tbl_WrongBill.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbl_WrongBill.setForeground(new java.awt.Color(255, 255, 255));
        tbl_WrongBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2", "HDA002", "21-07-2005", "125,000 đ", "Đơn lỗi"}
            },
            new String [] {
                "STT", "Mã hóa đơn", "Thời gian", "Tổng tiền", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_WrongBill.setGridColor(new java.awt.Color(28, 61, 90));
        tbl_WrongBill.setName(""); // NOI18N
        tbl_WrongBill.setRowHeight(25);
        tbl_WrongBill.setSelectionBackground(new java.awt.Color(200, 136, 0));
        tbl_WrongBill.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_WrongBill.setShowHorizontalLines(true);
        tbl_WrongBill.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl_WrongBill);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 524;
        gridBagConstraints.ipady = 256;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 5);
        add(jScrollPane1, gridBagConstraints);

        btn_RemoveWrongBill.setBackground(new java.awt.Color(28, 61, 90));
        btn_RemoveWrongBill.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_RemoveWrongBill.setForeground(new java.awt.Color(255, 255, 255));
        btn_RemoveWrongBill.setText("Xóa hóa đơn lỗi");
        btn_RemoveWrongBill.setToolTipText("Vào trang chủ");
        btn_RemoveWrongBill.setMargin(new java.awt.Insets(5, 14, 5, 14));
        btn_RemoveWrongBill.setMaximumSize(new java.awt.Dimension(186, 60));
        btn_RemoveWrongBill.setMinimumSize(new java.awt.Dimension(186, 60));
        btn_RemoveWrongBill.setName(""); // NOI18N
        btn_RemoveWrongBill.setPreferredSize(new java.awt.Dimension(186, 60));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 66;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
        add(btn_RemoveWrongBill, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setMaximumSize(new java.awt.Dimension(240, 180));
        jPanel1.setMinimumSize(new java.awt.Dimension(240, 180));
        jPanel1.setPreferredSize(new java.awt.Dimension(240, 180));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lbl_TitleRevenueByDay.setBackground(new java.awt.Color(255, 255, 255));
        lbl_TitleRevenueByDay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_TitleRevenueByDay.setForeground(new java.awt.Color(255, 27, 86));
        lbl_TitleRevenueByDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_TitleRevenueByDay.setText("Doanh thu hôm nay");
        lbl_TitleRevenueByDay.setMaximumSize(new java.awt.Dimension(183, 40));
        lbl_TitleRevenueByDay.setMinimumSize(new java.awt.Dimension(183, 40));
        lbl_TitleRevenueByDay.setOpaque(true);
        lbl_TitleRevenueByDay.setPreferredSize(new java.awt.Dimension(183, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(lbl_TitleRevenueByDay, gridBagConstraints);

        lbl_ShowRevenueByDay.setBackground(new java.awt.Color(28, 61, 90));
        lbl_ShowRevenueByDay.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        lbl_ShowRevenueByDay.setForeground(new java.awt.Color(51, 255, 51));
        lbl_ShowRevenueByDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ShowRevenueByDay.setText("Hiện tiền");
        lbl_ShowRevenueByDay.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.2;
        jPanel1.add(lbl_ShowRevenueByDay, gridBagConstraints);

        lbl_ShowTotalBillByDay.setBackground(new java.awt.Color(28, 61, 90));
        lbl_ShowTotalBillByDay.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_ShowTotalBillByDay.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ShowTotalBillByDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ShowTotalBillByDay.setText("Hiện đơn");
        lbl_ShowTotalBillByDay.setToolTipText("");
        lbl_ShowTotalBillByDay.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        jPanel1.add(lbl_ShowTotalBillByDay, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        add(jPanel1, gridBagConstraints);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setColumnHeaderView(null);
        jScrollPane2.setRowHeaderView(null);

        tbl_ShowProductSoldByDay.setAutoCreateRowSorter(true);
        tbl_ShowProductSoldByDay.setBackground(new java.awt.Color(28, 61, 90));
        tbl_ShowProductSoldByDay.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.darkGray, java.awt.Color.darkGray));
        tbl_ShowProductSoldByDay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tbl_ShowProductSoldByDay.setForeground(new java.awt.Color(51, 255, 51));
        tbl_ShowProductSoldByDay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Bánh cuốn", "100", "20,000,000 đ"}
            },
            new String [] {
                "Món ăn", "Bán", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_ShowProductSoldByDay.setGridColor(new java.awt.Color(28, 61, 90));
        tbl_ShowProductSoldByDay.setName(""); // NOI18N
        tbl_ShowProductSoldByDay.setRowHeight(25);
        tbl_ShowProductSoldByDay.setSelectionBackground(new java.awt.Color(200, 136, 0));
        tbl_ShowProductSoldByDay.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_ShowProductSoldByDay.setShowGrid(false);
        tbl_ShowProductSoldByDay.setShowHorizontalLines(true);
        jScrollPane2.setViewportView(tbl_ShowProductSoldByDay);
        if (tbl_ShowProductSoldByDay.getColumnModel().getColumnCount() > 0) {
            tbl_ShowProductSoldByDay.getColumnModel().getColumn(1).setMinWidth(50);
            tbl_ShowProductSoldByDay.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbl_ShowProductSoldByDay.getColumnModel().getColumn(1).setMaxWidth(50);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 218;
        gridBagConstraints.ipady = 450;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 0);
        add(jScrollPane2, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setMaximumSize(new java.awt.Dimension(240, 180));
        jPanel2.setMinimumSize(new java.awt.Dimension(240, 180));
        jPanel2.setPreferredSize(new java.awt.Dimension(240, 180));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lbl_TitleRevenueByWeek.setBackground(new java.awt.Color(255, 255, 255));
        lbl_TitleRevenueByWeek.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_TitleRevenueByWeek.setForeground(new java.awt.Color(255, 27, 86));
        lbl_TitleRevenueByWeek.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_TitleRevenueByWeek.setText("Doanh thu tuần");
        lbl_TitleRevenueByWeek.setMaximumSize(new java.awt.Dimension(183, 40));
        lbl_TitleRevenueByWeek.setMinimumSize(new java.awt.Dimension(183, 40));
        lbl_TitleRevenueByWeek.setOpaque(true);
        lbl_TitleRevenueByWeek.setPreferredSize(new java.awt.Dimension(183, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(lbl_TitleRevenueByWeek, gridBagConstraints);

        lbl_ShowRevenueByWeek.setBackground(new java.awt.Color(28, 61, 90));
        lbl_ShowRevenueByWeek.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbl_ShowRevenueByWeek.setForeground(new java.awt.Color(255, 255, 51));
        lbl_ShowRevenueByWeek.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ShowRevenueByWeek.setText("Hiện tiền");
        lbl_ShowRevenueByWeek.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel2.add(lbl_ShowRevenueByWeek, gridBagConstraints);

        lbl_ShowTotalBillByWeek.setBackground(new java.awt.Color(28, 61, 90));
        lbl_ShowTotalBillByWeek.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_ShowTotalBillByWeek.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ShowTotalBillByWeek.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ShowTotalBillByWeek.setText("Hiện đơn");
        lbl_ShowTotalBillByWeek.setToolTipText("");
        lbl_ShowTotalBillByWeek.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        jPanel2.add(lbl_ShowTotalBillByWeek, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        add(jPanel2, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setMaximumSize(new java.awt.Dimension(240, 180));
        jPanel3.setMinimumSize(new java.awt.Dimension(240, 180));
        jPanel3.setPreferredSize(new java.awt.Dimension(240, 180));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        lbl_TitleRevenueByYear.setBackground(new java.awt.Color(255, 255, 255));
        lbl_TitleRevenueByYear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_TitleRevenueByYear.setForeground(new java.awt.Color(255, 27, 86));
        lbl_TitleRevenueByYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_TitleRevenueByYear.setText("Doanh thu năm");
        lbl_TitleRevenueByYear.setMaximumSize(new java.awt.Dimension(183, 40));
        lbl_TitleRevenueByYear.setMinimumSize(new java.awt.Dimension(183, 40));
        lbl_TitleRevenueByYear.setOpaque(true);
        lbl_TitleRevenueByYear.setPreferredSize(new java.awt.Dimension(183, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        jPanel3.add(lbl_TitleRevenueByYear, gridBagConstraints);

        lbl_ShowRevenueByYear.setBackground(new java.awt.Color(28, 61, 90));
        lbl_ShowRevenueByYear.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbl_ShowRevenueByYear.setForeground(new java.awt.Color(255, 51, 255));
        lbl_ShowRevenueByYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ShowRevenueByYear.setText("Hiện tiền");
        lbl_ShowRevenueByYear.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel3.add(lbl_ShowRevenueByYear, gridBagConstraints);

        lbl_ShowTotalBillByYear.setBackground(new java.awt.Color(28, 61, 90));
        lbl_ShowTotalBillByYear.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_ShowTotalBillByYear.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ShowTotalBillByYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ShowTotalBillByYear.setText("Hiện đơn");
        lbl_ShowTotalBillByYear.setToolTipText("");
        lbl_ShowTotalBillByYear.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        jPanel3.add(lbl_ShowTotalBillByYear, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        add(jPanel3, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.setMaximumSize(new java.awt.Dimension(240, 180));
        jPanel4.setMinimumSize(new java.awt.Dimension(240, 180));
        jPanel4.setPreferredSize(new java.awt.Dimension(240, 180));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        lbl_TitleRevenueByMonth.setBackground(new java.awt.Color(255, 255, 255));
        lbl_TitleRevenueByMonth.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_TitleRevenueByMonth.setForeground(new java.awt.Color(255, 27, 86));
        lbl_TitleRevenueByMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_TitleRevenueByMonth.setText("Doanh thu tháng");
        lbl_TitleRevenueByMonth.setMaximumSize(new java.awt.Dimension(183, 40));
        lbl_TitleRevenueByMonth.setMinimumSize(new java.awt.Dimension(183, 40));
        lbl_TitleRevenueByMonth.setOpaque(true);
        lbl_TitleRevenueByMonth.setPreferredSize(new java.awt.Dimension(183, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        jPanel4.add(lbl_TitleRevenueByMonth, gridBagConstraints);

        lbl_ShowRevenueByMonth.setBackground(new java.awt.Color(28, 61, 90));
        lbl_ShowRevenueByMonth.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbl_ShowRevenueByMonth.setForeground(new java.awt.Color(51, 255, 255));
        lbl_ShowRevenueByMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ShowRevenueByMonth.setText("Hiện tiền");
        lbl_ShowRevenueByMonth.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel4.add(lbl_ShowRevenueByMonth, gridBagConstraints);

        lbl_ShowTotalBillByMonth.setBackground(new java.awt.Color(28, 61, 90));
        lbl_ShowTotalBillByMonth.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_ShowTotalBillByMonth.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ShowTotalBillByMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ShowTotalBillByMonth.setText("Hiện đơn");
        lbl_ShowTotalBillByMonth.setToolTipText("");
        lbl_ShowTotalBillByMonth.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        jPanel4.add(lbl_ShowTotalBillByMonth, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        add(jPanel4, gridBagConstraints);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setColumnHeaderView(null);
        jScrollPane3.setRowHeaderView(null);

        tbl_ShowProductSoldByWeek.setAutoCreateRowSorter(true);
        tbl_ShowProductSoldByWeek.setBackground(new java.awt.Color(28, 61, 90));
        tbl_ShowProductSoldByWeek.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.darkGray, java.awt.Color.darkGray));
        tbl_ShowProductSoldByWeek.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tbl_ShowProductSoldByWeek.setForeground(new java.awt.Color(255, 255, 51));
        tbl_ShowProductSoldByWeek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Bánh cuốn", "100", "20,000,000 đ"}
            },
            new String [] {
                "Món ăn", "Bán", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_ShowProductSoldByWeek.setGridColor(new java.awt.Color(28, 61, 90));
        tbl_ShowProductSoldByWeek.setName(""); // NOI18N
        tbl_ShowProductSoldByWeek.setRowHeight(25);
        tbl_ShowProductSoldByWeek.setSelectionBackground(new java.awt.Color(200, 136, 0));
        tbl_ShowProductSoldByWeek.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_ShowProductSoldByWeek.setShowGrid(false);
        tbl_ShowProductSoldByWeek.setShowHorizontalLines(true);
        jScrollPane3.setViewportView(tbl_ShowProductSoldByWeek);
        if (tbl_ShowProductSoldByWeek.getColumnModel().getColumnCount() > 0) {
            tbl_ShowProductSoldByWeek.getColumnModel().getColumn(1).setMinWidth(50);
            tbl_ShowProductSoldByWeek.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbl_ShowProductSoldByWeek.getColumnModel().getColumn(1).setMaxWidth(50);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 218;
        gridBagConstraints.ipady = 450;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        add(jScrollPane3, gridBagConstraints);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setColumnHeaderView(null);
        jScrollPane4.setRowHeaderView(null);

        tbl_ShowProductSoldByMonth.setAutoCreateRowSorter(true);
        tbl_ShowProductSoldByMonth.setBackground(new java.awt.Color(28, 61, 90));
        tbl_ShowProductSoldByMonth.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.darkGray, java.awt.Color.darkGray));
        tbl_ShowProductSoldByMonth.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tbl_ShowProductSoldByMonth.setForeground(new java.awt.Color(51, 255, 255));
        tbl_ShowProductSoldByMonth.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Bánh cuốn", "100", "20,000,000 đ"}
            },
            new String [] {
                "Món ăn", "Bán", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_ShowProductSoldByMonth.setGridColor(new java.awt.Color(28, 61, 90));
        tbl_ShowProductSoldByMonth.setName(""); // NOI18N
        tbl_ShowProductSoldByMonth.setRowHeight(25);
        tbl_ShowProductSoldByMonth.setSelectionBackground(new java.awt.Color(200, 136, 0));
        tbl_ShowProductSoldByMonth.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_ShowProductSoldByMonth.setShowGrid(false);
        tbl_ShowProductSoldByMonth.setShowHorizontalLines(true);
        jScrollPane4.setViewportView(tbl_ShowProductSoldByMonth);
        if (tbl_ShowProductSoldByMonth.getColumnModel().getColumnCount() > 0) {
            tbl_ShowProductSoldByMonth.getColumnModel().getColumn(1).setMinWidth(50);
            tbl_ShowProductSoldByMonth.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbl_ShowProductSoldByMonth.getColumnModel().getColumn(1).setMaxWidth(50);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 218;
        gridBagConstraints.ipady = 450;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        add(jScrollPane4, gridBagConstraints);

        jScrollPane5.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setColumnHeaderView(null);
        jScrollPane5.setRowHeaderView(null);

        tbl_ShowProductSoldByYear.setAutoCreateRowSorter(true);
        tbl_ShowProductSoldByYear.setBackground(new java.awt.Color(28, 61, 90));
        tbl_ShowProductSoldByYear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.darkGray, java.awt.Color.darkGray));
        tbl_ShowProductSoldByYear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tbl_ShowProductSoldByYear.setForeground(new java.awt.Color(255, 51, 255));
        tbl_ShowProductSoldByYear.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Bánh cuốn", "100", "20,000,000 đ"}
            },
            new String [] {
                "Món ăn", "Bán", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_ShowProductSoldByYear.setGridColor(new java.awt.Color(28, 61, 90));
        tbl_ShowProductSoldByYear.setName(""); // NOI18N
        tbl_ShowProductSoldByYear.setRowHeight(25);
        tbl_ShowProductSoldByYear.setSelectionBackground(new java.awt.Color(200, 136, 0));
        tbl_ShowProductSoldByYear.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_ShowProductSoldByYear.setShowGrid(false);
        tbl_ShowProductSoldByYear.setShowHorizontalLines(true);
        jScrollPane5.setViewportView(tbl_ShowProductSoldByYear);
        if (tbl_ShowProductSoldByYear.getColumnModel().getColumnCount() > 0) {
            tbl_ShowProductSoldByYear.getColumnModel().getColumn(1).setMinWidth(50);
            tbl_ShowProductSoldByYear.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbl_ShowProductSoldByYear.getColumnModel().getColumn(1).setMaxWidth(50);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 218;
        gridBagConstraints.ipady = 450;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jScrollPane5, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Nhận giá trị date khi người dùng nhấp trên lịch
    private void cld_SelectDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cld_SelectDatePropertyChange
        Report_SetUp();
    }//GEN-LAST:event_cld_SelectDatePropertyChange

    // Hiển thị ngày được chọn
    private void Report_SetUp() {
        // Lấy ngày hiện tại
        Calendar today = Calendar.getInstance();

        // Cấu hình cho ngày tối đa của lịch là ngày hôm nay
        cld_SelectDate.setMaxSelectableDate(today.getTime());

        // Lấy ngày mà người dùng chọn
        Date selectedDate = cld_SelectDate.getDate();

        // Chuyển đổi đối tượng Date thành Calendar để lấy ngày, tháng, năm
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(selectedDate);

        // Lấy các giá trị ngày, tháng, năm
        String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String week = String.valueOf(calendar.get(Calendar.WEEK_OF_YEAR));
        String month = String.valueOf(calendar.get(Calendar.MONTH) + 1); // Lưu ý: Tháng bắt đầu từ 0 (0 = tháng 1)
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String showDate = day + " / " + month + " / " + year;

        // Kiểm tra xem ngày được chọn có phải là ngày hôm nay không
        if (calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
            calendar.get(Calendar.MONTH) == today.get(Calendar.MONTH) &&
            calendar.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH)) {
            day = "hôm nay";
        }
        // Kiểm tra xem ngày được chọn có phải là ngày hôm qua không
        else if (calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                 calendar.get(Calendar.MONTH) == today.get(Calendar.MONTH) &&
                 calendar.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH) - 1) {
            day = "hôm qua";
        }

        // Thực hiện các hành động khi ngày thay đổi (ví dụ: in ra ngày, tháng, năm)
        lbl_Title.setText("Báo cáo thống kê ngày " + showDate);
        lbl_TitleRevenueByDay.setText("Doanh thu ngày " + day);
        lbl_TitleRevenueByWeek.setText("Doanh thu tuần thứ " + week);
        lbl_TitleRevenueByMonth.setText("Doanh thu tháng " + month);
        lbl_TitleRevenueByYear.setText("Doanh thu năm " + year);
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_RemoveWrongBill;
    private com.toedter.calendar.JCalendar cld_SelectDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbl_ShowRevenueByDay;
    private javax.swing.JLabel lbl_ShowRevenueByMonth;
    private javax.swing.JLabel lbl_ShowRevenueByWeek;
    private javax.swing.JLabel lbl_ShowRevenueByYear;
    private javax.swing.JLabel lbl_ShowTotalBillByDay;
    private javax.swing.JLabel lbl_ShowTotalBillByMonth;
    private javax.swing.JLabel lbl_ShowTotalBillByWeek;
    private javax.swing.JLabel lbl_ShowTotalBillByYear;
    private javax.swing.JLabel lbl_Title;
    private javax.swing.JLabel lbl_TitleRevenueByDay;
    private javax.swing.JLabel lbl_TitleRevenueByMonth;
    private javax.swing.JLabel lbl_TitleRevenueByWeek;
    private javax.swing.JLabel lbl_TitleRevenueByYear;
    private javax.swing.JTable tbl_ShowProductSoldByDay;
    private javax.swing.JTable tbl_ShowProductSoldByMonth;
    private javax.swing.JTable tbl_ShowProductSoldByWeek;
    private javax.swing.JTable tbl_ShowProductSoldByYear;
    private javax.swing.JTable tbl_WrongBill;
    // End of variables declaration//GEN-END:variables
}
