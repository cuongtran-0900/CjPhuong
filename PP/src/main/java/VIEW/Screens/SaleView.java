/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package VIEW.Screens;

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
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPrintable;

/**
 *
 * @author levan
 */
public final class SaleView extends javax.swing.JPanel {

    /**
     * Creates new form Dashboard
     *
     * @param branch
     */
    public SaleView(String branch) {
        initComponents();
        tableEvent();
        txt_CashChange.setEditable(false);
        txt_TotalAmount.setEditable(false);
        levanan.clearData(tbl_Cart);
        loadProductsToPanel(pn_Product, (DefaultTableModel) tbl_Cart.getModel());
        BranchName = branch;
    }
    public LeVanAn levanan = new LeVanAn();
    DecimalFormat moneyFormat = new DecimalFormat("#,### đ");
    public String BranchName = "";
    public String TimeNow;

    public int UndomoneyFormat(String formatted) {
        String numericString = formatted.replaceAll("[^0-9.-]", ""); // Kết quả sẽ là "1234567"
        // Chuyển đổi chuỗi số thành int
        int originalValue = Integer.parseInt(numericString);
        return originalValue;
    }

    public static int roundUpToNearest(int number, int multiple) {
        return (int) (Math.ceil((int) number / multiple) * multiple);
    }

    private boolean isUpdatingTable = false;

    BillDAO billdao = new BillDAO();
    List<Bill> billList = billdao.loadAllBillData();
    ProductDAO productdao = new ProductDAO();
    List<Product> ProductList = productdao.loadAllProductData();

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
        gbc.weighty = 0.6;
        panel.add(imgLabel, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.2;
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
        pn_Product.removeAll();

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

        int totalHeight = (350 + 5) * (currentRow + 1);
        int totalWidth = (250 + 5) * maxProductsPerRow;

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
                    String ProductID = "";
                    ProductID = (String) tbl_Cart.getValueAt(row, 0);
                    int quantity = (int) tbl_Cart.getValueAt(row, column);
                    // Nếu số lượng hợp lệ, cập nhật thành tiền
                    int price = UndomoneyFormat((String) tbl_Cart.getValueAt(row, 2));
                    int totalprice = quantity * price;
                    tbl_Cart.setValueAt(moneyFormat.format(totalprice), row, 4); // Cập nhật thành tiền
                    if ("MP01".equals(ProductID)) {
                        applyDiscount(row);
                    }
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
                if ("MP01".equalsIgnoreCase(productID) && newQuantity % 3 == 0) {
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
        int price = (int) UndomoneyFormat((String) tbl_Cart.getValueAt(rowIndex, 2));
        double discountPrice = price - 0.7; // Giảm giá 0.7 cho ví dụ

        // Cập nhật giá thành sau khi giảm giá
        int multiple = 10000;
        int totalPriceAfterDiscount = roundUpToNearest((int) Math.round(quantity * discountPrice), multiple);
        tbl_Cart.setValueAt(moneyFormat.format(totalPriceAfterDiscount), rowIndex, 4); // Cập nhật thành tiền

        // Cập nhật tổng tiền
        updateTotalAmount();
    }

    private static Timestamp TimeNow() {
        // Tạo đối tượng Timestamp với thời gian hiện tại
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        // Định dạng Timestamp thành chuỗi theo định dạng mong muốn
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(currentTimestamp);

        // Chuyển đổi chuỗi trở lại thành Timestamp
        try {
            // Chuyển chuỗi thành đối tượng Date
            java.util.Date date = sdf.parse(formattedDate);
            // Chuyển đổi đối tượng Date thành Timestamp
            Timestamp TimeFinal = new Timestamp(date.getTime());
            return TimeFinal;
        } catch (ParseException e) {
            return null;
        }

    }

    public void payment() throws PrinterException {
        if (tbl_Cart.getRowCount() != 0) {
            Bill bill = new Bill();
            bill.setBillID(billdao.NewBillID());
            bill.setAccountID("CN01"); //BrachName
            bill.setBillNote("none");
            bill.setCreateDate(TimeNow());
            bill.setBillTotalAmount(UndomoneyFormat(txt_TotalAmount.getText()));
            bill.setBillpayment(cbo_OptionPayment.getSelectedIndex());

            List<BillDetail> billdetailList = new ArrayList<>();

            for (int i = 0; i < tbl_Cart.getRowCount(); i++) {
                BillDetail billdetail = new BillDetail();
                billdetail.setProductID((String) tbl_Cart.getValueAt(i, 0));
                billdetail.setProductName((String) tbl_Cart.getValueAt(i, 1));
                billdetail.setProductPrice(UndomoneyFormat((String) tbl_Cart.getValueAt(i, 2)));
                billdetail.setQuantity((int) tbl_Cart.getValueAt(i, 3));
                billdetail.setTotalPrice(UndomoneyFormat((String) tbl_Cart.getValueAt(i, 4)));

                billdetailList.add(billdetail);
            }
            bill.setBillDetailList(billdetailList);
            int result = billdao.save(bill);

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Thanh toán thành công");
                ExtrackBillPDF(bill);
                PrintBill();
                ((DefaultTableModel) tbl_Cart.getModel()).setRowCount(0); // Làm rỗng giỏ hàng
            } else {
                JOptionPane.showMessageDialog(this, "Thanh Toán thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm ");
        }

    }

    private void ExtrackBillPDF(Bill bill) {
        try {
            // Đường dẫn đến file báo cáo .jasper đã biên dịch
            String jasperFilePath = "src\\main\\resources\\Bill\\hoadon.jasper";

            // Tạo dữ liệu cho báo cáo (danh sách đối tượng Product trong ví dụ này)
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(bill.getBillDetailList());

            // Tạo các tham số báo cáo nếu cần
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("accountID", bill.getAccountID());
            parameters.put("createDate", bill.getCreateDate());
            parameters.put("billID", bill.getBillID());
            parameters.put("billTotalAmount", bill.getBillTotalAmount());

            // Tạo báo cáo
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFilePath, parameters, dataSource);

            // Xuất báo cáo ra file PDF
            // Lưu file PDF tại đường dẫn tùy chỉnh
            String outputPath = "src\\main\\resources\\Bill\\report.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputPath);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    private void PrintBill() throws PrinterException {
        try {
            // Đường dẫn đến file PDF bạn muốn in
            File pdfFile = new File("src\\main\\resources\\Bill\\report.pdf");

            // Tạo đối tượng PDFBox PDDocument từ file
            PDDocument document = PDDocument.load(pdfFile);

            // Tạo đối tượng PrinterJob
            PrinterJob printerJob = PrinterJob.getPrinterJob();

            // Cài đặt máy in ngoài
            PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
            PrintService selectedPrintService = null;

            // Lựa chọn máy in
            for (PrintService printService : printServices) {
                if (printService.getName().contains("Canon LBP2900")) { // Thay "Tên máy in của bạn" bằng tên máy in thực tế
                    selectedPrintService = printService;
                    break;
                }
            }

            if (selectedPrintService == null) {
                System.out.println("Không tìm thấy máy in.");
                document.close();
                return;
            }

            // Cài đặt máy in cho PrinterJob
            printerJob.setPrintService(selectedPrintService);

            // Cài đặt Printable cho PrinterJob
            PDFPrintable printable = new PDFPrintable(document);
            printerJob.setPrintable(printable);

            // Cài đặt số bản sao
            printerJob.setCopies(2); // Số bản sao bạn muốn in

            // Thực hiện in
            printerJob.print();

            // Đóng tài liệu PDF
            document.close();

        } catch (IOException e) {
            e.printStackTrace();
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

        jLabel6 = new javax.swing.JLabel();
        pn_Product = new javax.swing.JPanel();
        pn_Pay = new javax.swing.JPanel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Cart = new javax.swing.JTable();

        setBackground(new java.awt.Color(229, 237, 239));
        setLayout(new java.awt.GridBagLayout());

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(249, 0, 64));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Bán Hàng");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));
        jLabel6.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 25, 10);
        add(jLabel6, gridBagConstraints);

        pn_Product.setBackground(new java.awt.Color(28, 61, 90));
        pn_Product.setMaximumSize(new java.awt.Dimension(380, 540));
        pn_Product.setMinimumSize(new java.awt.Dimension(380, 540));
        pn_Product.setPreferredSize(new java.awt.Dimension(380, 540));

        javax.swing.GroupLayout pn_ProductLayout = new javax.swing.GroupLayout(pn_Product);
        pn_Product.setLayout(pn_ProductLayout);
        pn_ProductLayout.setHorizontalGroup(
            pn_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );
        pn_ProductLayout.setVerticalGroup(
            pn_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        add(pn_Product, gridBagConstraints);

        pn_Pay.setBackground(new java.awt.Color(28, 61, 90));
        pn_Pay.setMaximumSize(new java.awt.Dimension(378, 353));
        pn_Pay.setLayout(new java.awt.GridBagLayout());

        txt_TotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_TotalAmount.setForeground(new java.awt.Color(255, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pn_Pay.add(txt_TotalAmount, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Tổng Tiền");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        pn_Pay.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Phương Thức");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        pn_Pay.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Khách Đưa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        pn_Pay.add(jLabel4, gridBagConstraints);

        txt_CustomerCash.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pn_Pay.add(txt_CustomerCash, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Trả Khách");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        pn_Pay.add(jLabel5, gridBagConstraints);

        txt_CashChange.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pn_Pay.add(txt_CashChange, gridBagConstraints);

        cbo_OptionPayment.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbo_OptionPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TIỀN MẶT", "CHUYỂN KHOẢN" }));
        cbo_OptionPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_OptionPaymentActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pn_Pay.add(cbo_OptionPayment, gridBagConstraints);

        Jpn_OptionButton.setBackground(new java.awt.Color(28, 61, 90));
        Jpn_OptionButton.setLayout(new java.awt.GridBagLayout());

        btn_Reset.setBackground(new java.awt.Color(255, 192, 57));
        btn_Reset.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_Reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_Reset.setText("Làm Mới");
        btn_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ResetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Jpn_OptionButton.add(btn_Reset, gridBagConstraints);

        btn_Save.setBackground(new java.awt.Color(255, 192, 57));
        btn_Save.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_Save.setForeground(new java.awt.Color(255, 255, 255));
        btn_Save.setText("Hoàn Tất");
        btn_Save.setMaximumSize(new java.awt.Dimension(129, 39));
        btn_Save.setMinimumSize(new java.awt.Dimension(129, 39));
        btn_Save.setPreferredSize(new java.awt.Dimension(129, 39));
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Jpn_OptionButton.add(btn_Save, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        pn_Pay.add(Jpn_OptionButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        add(pn_Pay, gridBagConstraints);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setColumnHeaderView(null);
        jScrollPane1.setRowHeaderView(null);

        tbl_Cart.setAutoCreateRowSorter(true);
        tbl_Cart.setBackground(new java.awt.Color(255, 192, 57));
        tbl_Cart.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.darkGray, java.awt.Color.darkGray));
        tbl_Cart.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tbl_Cart.setForeground(new java.awt.Color(255, 255, 255));
        tbl_Cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Món Ăn", "Tên Món", "Đơn Giá", "Số Lượng", "Thành Tiền"
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
        tbl_Cart.setGridColor(new java.awt.Color(28, 61, 90));
        tbl_Cart.setName(""); // NOI18N
        tbl_Cart.setRowHeight(45);
        tbl_Cart.setSelectionBackground(new java.awt.Color(200, 136, 0));
        tbl_Cart.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_Cart.setShowHorizontalLines(true);
        tbl_Cart.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl_Cart);
        if (tbl_Cart.getColumnModel().getColumnCount() > 0) {
            tbl_Cart.getColumnModel().getColumn(0).setMinWidth(75);
            tbl_Cart.getColumnModel().getColumn(0).setPreferredWidth(75);
            tbl_Cart.getColumnModel().getColumn(0).setMaxWidth(75);
            tbl_Cart.getColumnModel().getColumn(2).setMinWidth(100);
            tbl_Cart.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbl_Cart.getColumnModel().getColumn(2).setMaxWidth(100);
            tbl_Cart.getColumnModel().getColumn(3).setMinWidth(75);
            tbl_Cart.getColumnModel().getColumn(3).setPreferredWidth(75);
            tbl_Cart.getColumnModel().getColumn(3).setMaxWidth(75);
            tbl_Cart.getColumnModel().getColumn(4).setMinWidth(100);
            tbl_Cart.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbl_Cart.getColumnModel().getColumn(4).setMaxWidth(100);
        }
        // Khai báo và khởi tạo centerRenderer
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        // Đặt renderer cho tất cả các cột để căn giữa
        for (int i = 0; i < tbl_Cart.getColumnModel().getColumnCount(); i++) {
            tbl_Cart.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        // Khai báo và khởi tạo leftRenderer cho cột thứ 2 (index 1)
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        tbl_Cart.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        add(jScrollPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed
        // TODO add your handling code here:

        if (cbo_OptionPayment.getSelectedIndex() == 0) {
            if (txt_CashChange.getText().isBlank() || UndomoneyFormat(txt_CashChange.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "Số tiền trả khách không được trống hoặc âm");
                levanan.clearData(txt_CustomerCash);
            } else {
                try {
                    payment();
                } catch (PrinterException ex) {
                    Logger.getLogger(SaleView.class.getName()).log(Level.SEVERE, null, ex);
                }
                btn_ResetActionPerformed(null);
            }
        } else {
            try {
                payment();
            } catch (PrinterException ex) {
                Logger.getLogger(SaleView.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        String customerCash;

        if (txt_CustomerCash.getText().isBlank()) {
            customerCash = "0";
        } else {
            customerCash = txt_CustomerCash.getText();
        }
        int cashchange = Integer.parseInt(customerCash) - UndomoneyFormat(txt_TotalAmount.getText());
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
    private javax.swing.JPanel Jpn_OptionButton;
    private javax.swing.JButton btn_Reset;
    private javax.swing.JButton btn_Save;
    private javax.swing.JComboBox<String> cbo_OptionPayment;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pn_Pay;
    private javax.swing.JPanel pn_Product;
    private javax.swing.JTable tbl_Cart;
    private javax.swing.JTextField txt_CashChange;
    private javax.swing.JTextField txt_CustomerCash;
    private javax.swing.JTextField txt_TotalAmount;
    // End of variables declaration//GEN-END:variables
}
