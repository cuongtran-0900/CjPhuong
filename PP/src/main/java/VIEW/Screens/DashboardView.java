package VIEW.Screens;

public class DashboardView extends javax.swing.JPanel {

    public DashboardView(String branchName) {
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(229, 237, 239));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(249, 0, 64));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tổng Quan");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));
        jLabel1.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 25, 10);
        add(jLabel1, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setMaximumSize(new java.awt.Dimension(240, 180));
        jPanel3.setMinimumSize(new java.awt.Dimension(240, 180));
        jPanel3.setPreferredSize(new java.awt.Dimension(240, 180));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel2.setBackground(new java.awt.Color(216, 216, 216));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(28, 61, 90));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("HÔM QUA");
        jLabel2.setMaximumSize(new java.awt.Dimension(183, 40));
        jLabel2.setMinimumSize(new java.awt.Dimension(183, 40));
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(183, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        jPanel3.add(jLabel2, gridBagConstraints);

        jLabel6.setBackground(new java.awt.Color(25, 55, 81));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(178, 178, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Hiện tiền");
        jLabel6.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.2;
        jPanel3.add(jLabel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        add(jPanel3, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.setMaximumSize(new java.awt.Dimension(240, 180));
        jPanel4.setMinimumSize(new java.awt.Dimension(240, 180));
        jPanel4.setPreferredSize(new java.awt.Dimension(240, 180));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel3.setBackground(new java.awt.Color(216, 216, 216));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(28, 61, 90));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Đơn hoàn thành");
        jLabel3.setMaximumSize(new java.awt.Dimension(183, 40));
        jLabel3.setMinimumSize(new java.awt.Dimension(183, 40));
        jLabel3.setOpaque(true);
        jLabel3.setPreferredSize(new java.awt.Dimension(183, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        jPanel4.add(jLabel3, gridBagConstraints);

        jLabel7.setBackground(new java.awt.Color(25, 55, 81));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 178, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Hiện đơn");
        jLabel7.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.2;
        jPanel4.add(jLabel7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        add(jPanel4, gridBagConstraints);

        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel5.setMaximumSize(new java.awt.Dimension(240, 180));
        jPanel5.setMinimumSize(new java.awt.Dimension(240, 180));
        jPanel5.setPreferredSize(new java.awt.Dimension(240, 180));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel4.setBackground(new java.awt.Color(216, 216, 216));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(28, 61, 90));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Đơn lỗi");
        jLabel4.setMaximumSize(new java.awt.Dimension(183, 40));
        jLabel4.setMinimumSize(new java.awt.Dimension(183, 40));
        jLabel4.setOpaque(true);
        jLabel4.setPreferredSize(new java.awt.Dimension(183, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        jPanel5.add(jLabel4, gridBagConstraints);

        jLabel8.setBackground(new java.awt.Color(25, 55, 81));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(178, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Hiện đơn lỗi");
        jLabel8.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.2;
        jPanel5.add(jLabel8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        add(jPanel5, gridBagConstraints);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setColumnHeaderView(null);
        jScrollPane2.setRowHeaderView(null);

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setBackground(new java.awt.Color(255, 192, 57));
        jTable2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.darkGray, java.awt.Color.darkGray));
        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Bánh cuốn", "100", "20,000,000 đ"}
            },
            new String [] {
                "MÓN ĂN", "BÁN ĐƯỢC", "TỔNG TIỀN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(28, 61, 90));
        jTable2.setMaximumSize(new java.awt.Dimension(225, 40));
        jTable2.setMinimumSize(new java.awt.Dimension(225, 40));
        jTable2.setName(""); // NOI18N
        jTable2.setRowHeight(50);
        jTable2.setSelectionBackground(new java.awt.Color(200, 136, 0));
        jTable2.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable2.setShowGrid(false);
        jTable2.setShowHorizontalLines(true);
        jScrollPane2.setViewportView(jTable2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(25, 10, 10, 10);
        add(jScrollPane2, gridBagConstraints);

        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel6.setMaximumSize(new java.awt.Dimension(240, 180));
        jPanel6.setMinimumSize(new java.awt.Dimension(240, 180));
        jPanel6.setPreferredSize(new java.awt.Dimension(240, 180));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(28, 61, 90));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("HÔM NAY");
        jLabel5.setMaximumSize(new java.awt.Dimension(183, 40));
        jLabel5.setMinimumSize(new java.awt.Dimension(183, 40));
        jLabel5.setOpaque(true);
        jLabel5.setPreferredSize(new java.awt.Dimension(183, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        jPanel6.add(jLabel5, gridBagConstraints);

        jLabel9.setBackground(new java.awt.Color(28, 61, 90));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Hiện tiền");
        jLabel9.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.2;
        jPanel6.add(jLabel9, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        add(jPanel6, gridBagConstraints);

        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.setMaximumSize(new java.awt.Dimension(240, 180));
        jPanel7.setMinimumSize(new java.awt.Dimension(240, 180));
        jPanel7.setPreferredSize(new java.awt.Dimension(240, 180));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(28, 61, 90));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Đơn hoàn thành");
        jLabel10.setMaximumSize(new java.awt.Dimension(183, 40));
        jLabel10.setMinimumSize(new java.awt.Dimension(183, 40));
        jLabel10.setOpaque(true);
        jLabel10.setPreferredSize(new java.awt.Dimension(183, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        jPanel7.add(jLabel10, gridBagConstraints);

        jLabel11.setBackground(new java.awt.Color(28, 61, 90));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 255, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Hiện đơn");
        jLabel11.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.2;
        jPanel7.add(jLabel11, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        add(jPanel7, gridBagConstraints);

        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel8.setMaximumSize(new java.awt.Dimension(240, 180));
        jPanel8.setMinimumSize(new java.awt.Dimension(240, 180));
        jPanel8.setPreferredSize(new java.awt.Dimension(240, 180));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(28, 61, 90));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Đơn lỗi");
        jLabel12.setMaximumSize(new java.awt.Dimension(183, 40));
        jLabel12.setMinimumSize(new java.awt.Dimension(183, 40));
        jLabel12.setOpaque(true);
        jLabel12.setPreferredSize(new java.awt.Dimension(183, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        jPanel8.add(jLabel12, gridBagConstraints);

        jLabel13.setBackground(new java.awt.Color(28, 61, 90));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Hiện đơn lỗi");
        jLabel13.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.2;
        jPanel8.add(jLabel13, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        add(jPanel8, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
