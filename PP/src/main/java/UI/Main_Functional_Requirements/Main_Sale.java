/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Main_Functional_Requirements;

import DAO.*;
import javax.swing.table.DefaultTableModel;
import MODEL.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import UX.LeVanAn;

/**
 *
 * @author levan
 */
public final class Main_Sale extends javax.swing.JPanel {

    /**
     * Creates new form Dashboard
     */
    public Main_Sale() {
        initComponents();
        tableEvent();
        txt_CashChange.setEditable(false);
        txt_TotalAmount.setEditable(false);
        levanan.clearData(tbl_Cart);
        loadProductsToPanel(Jpn_Product, (DefaultTableModel) tbl_Cart.getModel());
    }
    public LeVanAn levanan = new LeVanAn();
    DecimalFormat moneyFormat = new DecimalFormat("#,### đ");

    public int UndomoneyFormat(String formatted) {
        String numericString = formatted.replaceAll("[^0-9]", ""); // Kết quả sẽ là "1234567"
        // Chuyển đổi chuỗi số thành int
        int originalValue = Integer.parseInt(numericString);
        return originalValue;
    }
    
    public static int roundUpToNearest(int number, int multiple) {
        return (int) (Math.ceil((int) number / multiple) * multiple);
    }

    BillDAO billdao = new BillDAO();
    List<Bill> billList = billdao.loadAllBillData();
    ProductDAO productdao = new ProductDAO();
    List<Product> ProductList = productdao.loadAllProductData();

    private boolean isUpdatingTable = false;

    private JPanel createProduct(Product product, DefaultTableModel tableModel) {
        String pathProductImage = "src/main/resources/Image_product/";
        String imgPath = "photo-min"; //product.getImages();
        String currentImg;

        if (imgPath == null || imgPath.trim().isEmpty() || !new File(pathProductImage + imgPath).exists()) {
            currentImg = pathProductImage + "photo-min";
        } else {
            currentImg = pathProductImage + imgPath;
        }

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 280));
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(255, 255, 255));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);

        ImageIcon resizedImg = levanan.resizeImage(new ImageIcon(currentImg), 180, 200);

        String productID = product.getProductID();
        String productName = product.getProductName();
        int productPrice = product.getProductPrice();
        JLabel imgLabel = new JLabel(resizedImg);
        JLabel nameLabel = new JLabel(productName);
        JLabel priceLabel = new JLabel(moneyFormat.format(productPrice));

        imgLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        imgLabel.setOpaque(true);

        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        nameLabel.setForeground(new Color(0, 102, 204));
        priceLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        priceLabel.setForeground(new Color(255, 69, 0));

        imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.7;
        panel.add(imgLabel, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.1;
        panel.add(nameLabel, gbc);

        gbc.gridy = 2;
        gbc.weighty = 0.2;
        panel.add(priceLabel, gbc);

        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setToolTipText("Click để xem chi tiết");

        // Khai báo biến để lưu trữ MouseListener
        MouseAdapter mouseAdapter;
        mouseAdapter = new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel.setBackground(new Color(240, 240, 240));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel.setBackground(new Color(255, 255, 255));
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel.setBackground(new Color(210, 210, 210));
                addProductToCart(productID, productName, productPrice, tableModel);
            }
        };

// Thêm MouseListener vào panel
        panel.addMouseListener(mouseAdapter);

        return panel;
    }

    public void loadProductsToPanel(JPanel jPanel, DefaultTableModel tableModel) {
        Jpn_Product.removeAll();

        jPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        int maxProductsPerRow = 4;
        int currentRow = 0;
        int currentColumn = 0;

        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);

        for (Product product : ProductList) {
            JPanel productPanel = createProduct(product, tableModel);

            gbc.gridx = currentColumn;
            gbc.gridy = currentRow;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;

            jPanel.add(productPanel, gbc);

            currentColumn++;
            if (currentColumn >= maxProductsPerRow) {
                currentColumn = 0;
                currentRow++;
            }
        }

        int totalHeight = (280 + 5) * (currentRow + 1);
        int totalWidth = (100 + 5) * maxProductsPerRow;

        jPanel.setPreferredSize(new Dimension(totalWidth, totalHeight));

        jPanel.revalidate();
        jPanel.repaint();
    }

    private void tableEvent() {
        // add sự kiện nếu thay đổi số lượng thì cập nhật thành tiền
        tbl_Cart.getModel().addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                // Kiểm tra nếu cột thay đổi là cột số lượng
                if (column == 3) {
                    int quantity = (int) tbl_Cart.getValueAt(row, column);
                    // Nếu số lượng hợp lệ, cập nhật thành tiền
                    int price = UndomoneyFormat((String) tbl_Cart.getValueAt(row, 2));
                    int totalprice = quantity * price;
                    tbl_Cart.setValueAt(moneyFormat.format(totalprice), row, 4); // Cập nhật thành tiền
                    updateTotalAmount(); // Cập nhật tổng tiền
                }
            }
        });
        

    }

    private void updateTotalAmount() {
        DefaultTableModel cartmodel = (DefaultTableModel) tbl_Cart.getModel();
        int totalAmount = 0;
        for (int i = 0; i < cartmodel.getRowCount(); i++) {
            int thanhTien = 0;
            thanhTien = UndomoneyFormat((String) cartmodel.getValueAt(i, 4));
            totalAmount += thanhTien;
        }
        txt_TotalAmount.setText(String.valueOf(moneyFormat.format(totalAmount)));
    }

    private void addProductToCart(String productID, String productName, int productPrice, DefaultTableModel model) {
        int quantity = 1;
        int totalprice = quantity * productPrice;
        boolean productExists = false;

        for (int i = 0; i < tbl_Cart.getRowCount(); i++) {
            String IDProductInCart = String.valueOf(tbl_Cart.getValueAt(i, 0));
            if (productID.equalsIgnoreCase(IDProductInCart)) { // kiểm tra sản phẩm có tồn tại trong bảng chưa
                int currentQuantity = (int) tbl_Cart.getValueAt(i, 3);
                int newQuantity = currentQuantity + quantity;
                totalprice = newQuantity * productPrice;
                
                isUpdatingTable = true;
                tbl_Cart.setValueAt(newQuantity, i, 3); // Cập nhật số lượng
                tbl_Cart.setValueAt(moneyFormat.format(totalprice), i, 4); // Cập nhật thành tiền
                isUpdatingTable = false;
                productExists = true; // Đánh dấu sản phẩm đã tồn tại

                // Kiểm tra và áp dụng giảm giá nếu mã sản phẩm là "MP001"
                if ("MP01".equalsIgnoreCase(productID)  && newQuantity % 3 == 0) {
                    applyDiscount(i);
                }
                
                break;
            }
        }

        if (!productExists) {
            // Thêm sản phẩm mới vào bảng nếu không tìm thấy
            Object[] rowData = new Object[]{productID, productName, moneyFormat.format(productPrice), quantity, moneyFormat.format(totalprice)};
            model.addRow(rowData);

            // Kiểm tra và áp dụng giảm giá nếu mã sản phẩm là "MP001"
            if ("MP001".equalsIgnoreCase(productID)) {
                int rowIndex = model.getRowCount() - 1; // Lấy chỉ số hàng mới thêm
                applyDiscount(rowIndex);
            }
        }

        // Cập nhật tổng tiền
        updateTotalAmount();
    }

    private void applyDiscount(int rowIndex) {
        // Giả sử bạn muốn giảm giá cho hàng tại rowIndex
        int quantity = (int) tbl_Cart.getValueAt(rowIndex, 3);
        int price = (int) UndomoneyFormat((String) tbl_Cart.getValueAt(rowIndex, 2)) ;
        double discountPrice = price - 0.7; // Giảm giá 0.7 cho ví dụ

        // Cập nhật giá thành sau khi giảm giá
        int multiple = 10000;
        int totalPriceAfterDiscount = roundUpToNearest((int) Math.round(quantity * discountPrice), multiple);
        tbl_Cart.setValueAt(moneyFormat.format(totalPriceAfterDiscount), rowIndex, 4); // Cập nhật thành tiền

        // Cập nhật tổng tiền
        updateTotalAmount();
    }

    private String TimeNow() {
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(System.currentTimeMillis());
        String newTime = String.valueOf(currentTimestamp);
        return newTime;
    }

    public void payment() {
        if (tbl_Cart.getRowCount() != 0) {
            Bill bill = new Bill();
            bill.setBillID(billdao.NewBillID());
            bill.setAccountID("CN01");
            bill.setBillNote("none");
            bill.setCreateDate(Timestamp.valueOf(TimeNow()));
            bill.setBillTotalAmount(UndomoneyFormat(txt_TotalAmount.getText()));
            bill.setBillpayment(cbo_OptionPayment.getSelectedIndex());

            List<BillDetail> billdetailList = new ArrayList<>();

            for (int i = 0; i < tbl_Cart.getRowCount(); i++) {
                BillDetail billdetail = new BillDetail();

                billdetail.setProductID((String) tbl_Cart.getValueAt(i, 0));
                billdetail.setProductPrice(UndomoneyFormat((String) tbl_Cart.getValueAt(i, 2)));
                billdetail.setQuantity((int) tbl_Cart.getValueAt(i, 3));
                billdetail.setTotalPrice(UndomoneyFormat((String) tbl_Cart.getValueAt(i, 4)));

                billdetailList.add(billdetail);
            }
            bill.setBillDetailList(billdetailList);
            int result = billdao.save(bill);
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Thanh toán thành công");
                ((DefaultTableModel) tbl_Cart.getModel()).setRowCount(0); // Làm rỗng giỏ hàng
            } else {
                JOptionPane.showMessageDialog(this, "Thanh Toán thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm ");
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

        jLabel1 = new javax.swing.JLabel();
        Jpn_Product = new javax.swing.JPanel();
        Jpn_InfoContaint = new javax.swing.JPanel();
        txt_TotalAmount = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_CustomerCash = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_CashChange = new javax.swing.JTextField();
        cbo_OptionPayment = new javax.swing.JComboBox<>();
        Jpn_OptionButton = new javax.swing.JPanel();
        btn_Reset = new javax.swing.JButton();
        btn_Save = new javax.swing.JButton();
        Jpn_tableContaint = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Cart = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 192, 57));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BÁN HÀNG");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 653;
        gridBagConstraints.ipady = 28;
        add(jLabel1, gridBagConstraints);

        javax.swing.GroupLayout Jpn_ProductLayout = new javax.swing.GroupLayout(Jpn_Product);
        Jpn_Product.setLayout(Jpn_ProductLayout);
        Jpn_ProductLayout.setHorizontalGroup(
            Jpn_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        Jpn_ProductLayout.setVerticalGroup(
            Jpn_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        add(Jpn_Product, gridBagConstraints);

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0};
        jPanel1Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        Jpn_InfoContaint.setLayout(jPanel1Layout);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Jpn_InfoContaint.add(txt_TotalAmount, gridBagConstraints);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Tổng Tiền");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        Jpn_InfoContaint.add(jLabel2, gridBagConstraints);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Phương Thức");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        Jpn_InfoContaint.add(jLabel3, gridBagConstraints);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Khách Đưa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        Jpn_InfoContaint.add(jLabel4, gridBagConstraints);

        txt_CustomerCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CustomerCashActionPerformed(evt);
            }
        });
        txt_CustomerCash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CustomerCashKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Jpn_InfoContaint.add(txt_CustomerCash, gridBagConstraints);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Trả Khách");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        Jpn_InfoContaint.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Jpn_InfoContaint.add(txt_CashChange, gridBagConstraints);

        cbo_OptionPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền Mặt", "Chuyển Khoản", " " }));
        cbo_OptionPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_OptionPaymentActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Jpn_InfoContaint.add(cbo_OptionPayment, gridBagConstraints);

        Jpn_OptionButton.setLayout(new java.awt.GridBagLayout());

        btn_Reset.setText("Làm Mới");
        btn_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ResetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Jpn_OptionButton.add(btn_Reset, gridBagConstraints);

        btn_Save.setText("Lưu In");
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Jpn_OptionButton.add(btn_Save, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        Jpn_InfoContaint.add(Jpn_OptionButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        add(Jpn_InfoContaint, gridBagConstraints);

        Jpn_tableContaint.setLayout(new java.awt.BorderLayout());

        tbl_Cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Món Ăn", "Tên Món Ăn", "Đơn Giá", "Số Lượng", "Thành Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_Cart);

        Jpn_tableContaint.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        add(Jpn_tableContaint, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed
        // TODO add your handling code here:
        if(cbo_OptionPayment.getSelectedIndex()==0){
            if (txt_CashChange.getText().isBlank() || UndomoneyFormat(txt_CustomerCash.getText()) < UndomoneyFormat(txt_TotalAmount.getText())) {
            JOptionPane.showMessageDialog(this, "Số tiền trả khách không được trống hoặc âm");
            levanan.clearData(txt_CustomerCash);
        } else {
            payment();
            btn_ResetActionPerformed(null);
        }
        }else{
            payment();
            btn_ResetActionPerformed(null);
        }
        

    }//GEN-LAST:event_btn_SaveActionPerformed

    private void btn_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ResetActionPerformed
        // TODO add your handling code here:
        levanan.clearData(tbl_Cart, txt_TotalAmount, txt_CustomerCash, txt_CashChange);
        cbo_OptionPayment.setSelectedIndex(0);
    }//GEN-LAST:event_btn_ResetActionPerformed

    private void txt_CustomerCashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CustomerCashKeyReleased
        // TODO add your handling code here:
        int cashchange = Integer.parseInt(txt_CustomerCash.getText()) - UndomoneyFormat(txt_TotalAmount.getText());
        txt_CashChange.setText(moneyFormat.format(cashchange));
    }//GEN-LAST:event_txt_CustomerCashKeyReleased

    private void txt_CustomerCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CustomerCashActionPerformed
        // TODO add your handling code here:

        btn_SaveActionPerformed(null);


    }//GEN-LAST:event_txt_CustomerCashActionPerformed

    private void cbo_OptionPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_OptionPaymentActionPerformed
        // TODO add your handling code here:
        if (cbo_OptionPayment.getSelectedIndex() == 1) {
            levanan.clearData(txt_CustomerCash, txt_CashChange);
            txt_CustomerCash.setEditable(false);
        } else {
            txt_CustomerCash.setEditable(true);
        }
    }//GEN-LAST:event_cbo_OptionPaymentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpn_InfoContaint;
    private javax.swing.JPanel Jpn_OptionButton;
    private javax.swing.JPanel Jpn_Product;
    private javax.swing.JPanel Jpn_tableContaint;
    private javax.swing.JButton btn_Reset;
    private javax.swing.JButton btn_Save;
    private javax.swing.JComboBox<String> cbo_OptionPayment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_Cart;
    private javax.swing.JTextField txt_CashChange;
    private javax.swing.JTextField txt_CustomerCash;
    private javax.swing.JTextField txt_TotalAmount;
    // End of variables declaration//GEN-END:variables
}
