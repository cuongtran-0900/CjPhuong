package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import MODEL.Bill;
import MODEL.BillDetail;
import VIEW.Home;

public class BillDAO extends DatabaseConnection {

    List<Bill> billList = new ArrayList<>();

    public List<Bill> loadAllBillData() {
        try {
            String sql = "SELECT B.billID, B.accountID, B.billTotalAmount, B.billNote, B.createDate, " +
                         "B.billPayment, BD.productID, BD.quantity, BD.totalPrice, PR.productName, PR.productPrice, " +
                         "B.billStatus " +
                         "FROM Bill AS B " +
                         "INNER JOIN BillDetail AS BD ON B.billID = BD.billID " +
                         "INNER JOIN Product AS PR ON PR.productID = BD.productID " + 
                         "ORDER BY B.createDate DESC";

            try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                billList.clear();
                Bill currentBill = null;
                String lastBillID = null;

                while (rs.next()) {
                    String billID = rs.getString("billID");

                    // Kiểm tra nếu đang xử lý một hóa đơn mới
                    if (!billID.equals(lastBillID)) {
                        currentBill = new Bill();
                        currentBill.setBillID(billID);
                        currentBill.setAccountID(rs.getString("accountID"));
                        currentBill.setBillTotalAmount(rs.getInt("billTotalAmount"));
                        currentBill.setBillNote(rs.getString("billNote"));
                        currentBill.setCreateDate(rs.getTimestamp("createDate"));
                        currentBill.setBillpayment(rs.getInt("billPayment"));  // Set giá trị billPayment
                        currentBill.setBillStatus(rs.getInt("billStatus"));
                        currentBill.setBillDetailList(new ArrayList<>());  // Khởi tạo danh sách chi tiết hóa đơn
                        billList.add(currentBill);
                        lastBillID = billID;
                    }

                    // Thêm chi tiết hóa đơn vào danh sách của hóa đơn hiện tại
                    BillDetail billDetail = new BillDetail();
                    billDetail.setProductID(rs.getString("productID"));
                    billDetail.setProductName(rs.getString("productName"));
                    billDetail.setProductPrice(rs.getInt("productPrice"));
                    billDetail.setQuantity(rs.getInt("quantity"));
                    billDetail.setTotalPrice(rs.getInt("totalPrice"));
                    currentBill.getBillDetailList().add(billDetail);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return billList;
    }

    public void showAllBillDataToConsole() {
        List<Bill> bills = loadAllBillData();
        for (Bill bill : bills) {
            System.out.println(bill);
        }
    }

    public boolean check(String ma) {
        for (Bill hdn : billList) {
            if (ma.equals(hdn.getBillID())) {
                return false;
            }
        }
        return true;
    }

    public int save(Bill bill) {
        try {
            String sql1 = "INSERT INTO BILL (BILLID, ACCOUNTID, BILLTOTALAMOUNT, BILLNOTE, CREATEDATE, BILLSTATUS, BILLPAYMENT) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement st1 = con.prepareStatement(sql1);

            st1.setString(1, bill.getBillID());
            st1.setString(2, bill.getAccountID());
            st1.setInt(3, bill.getBillTotalAmount());
            st1.setString(4, bill.getBillNote());
            st1.setDate(5, new java.sql.Date(bill.getCreateDate().getTime()));
            st1.setInt(6, bill.getBillStatus());
            st1.setInt(7, bill.getBillpayment());  // Lưu giá trị billPayment

            int row1 = st1.executeUpdate();

            String sql2 = "INSERT INTO BIllDETAIL (BillID, ProductID, Quantity, TotalPrice) VALUES(?,?,?,?)";
            PreparedStatement st2 = con.prepareStatement(sql2);

            for (BillDetail chiTiet : bill.getBillDetailList()) {
                st2.setString(1, bill.getBillID());
                st2.setString(2, chiTiet.getProductID());
                st2.setInt(3, chiTiet.getQuantity());
                st2.setInt(4, chiTiet.getTotalPrice());
                st2.addBatch();
            }
            st2.executeBatch();

            if (row1 > 0) {
                return row1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public String CheckBillID() {
        String mps = null;
        try {
            String sql = "SELECT TOP 1 billID FROM bill WHERE billID LIKE 'HD%' ORDER BY billID DESC";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                mps = rs.getString("billID");
            }

            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mps;
    }

    public String NewBillID() {
        String lastBillID = CheckBillID();

        if (lastBillID == null || lastBillID.isEmpty()) {
            return "HDA001";
        } else {
            // Lấy phần chữ và phần số
            String prefix = lastBillID.substring(2, 3); // A, B, C...
            int number = Integer.parseInt(lastBillID.substring(3, 6)); // 001, 002,...

            if (number < 999) {
                number++;
            } else {
                // Khi số đã đạt 999, chuyển sang chữ cái tiếp theo
                prefix = String.valueOf((char) (prefix.charAt(0) + 1));
                number = 1;
            }

            // Định dạng số về dạng 3 chữ số
            String newNumber = String.format("%03d", number);
            return "HD" + prefix + newNumber;
        }
    }
}
