package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import MODEL.Bill;
import MODEL.BillDetail;
import UI.Home;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BillDAO extends ConnectSQL {

    List<Bill> billList = new ArrayList<>();

    public List<Bill> loadAllBillData() {

        try {
            String sql
                    = "select B.billID, b.accountID,b.billTotalAmount,b.billNote,b.createDate,bd.productID,bd.quantity,bd.totalPrice,pr.productName,B.billStatus from Bill as B inner join BillDetail as BD on B.billID = BD.billID inner join Product as PR on PR.productID = BD.productID where b.billStatus = 1;";
            try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                billList.clear();
                Bill currentBill = null;
                while (rs.next()) {
                    // Kiểm tra nếu hóa đơn nhập mới{
                    currentBill = new Bill();
                    currentBill.setBillID(rs.getString("BillID"));
                    currentBill.setBillNote(rs.getString("BillNote"));
                    currentBill.setBillTotalAmount(rs.getInt("BillTotalAmount"));
                    currentBill.setCreateDate(rs.getTimestamp("CreateDate"));
                    currentBill.setBillStatus(rs.getInt("billStatus"));
                    currentBill.setBillDetailList(new ArrayList<>()); // Khởi tạo danh sách chi tiết hóa đơn
                    billList.add(currentBill);
                    // Thêm chi tiết hóa đơn vào danh sách của hóa đơn nhập hiện tại
                    BillDetail chiTiet = new BillDetail();
                    chiTiet.setProductID(rs.getString("ProductID"));
                    chiTiet.setProductName(rs.getString("ProductName"));
                    chiTiet.setProductPrice(rs.getInt("ProductPrice"));
                    chiTiet.setQuantity(rs.getInt("Quantity"));
                    chiTiet.setTotalPrice(rs.getInt("TotalPrice"));
                    currentBill.getBillDetailList().add(chiTiet);
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
            String sql1 = "INSERT INTO BILL (BILLID, ACCOUNTID, BILLTOTALAMOUNT, BILLNOTE, CREATEDATE, BILLSTATUS) VALUES(?,?,?,?,?,?)";
            PreparedStatement st1 = con.prepareStatement(sql1);

            st1.setString(1, bill.getBillID());
            st1.setString(2, bill.getAccountID());
            st1.setInt(3, bill.getBillTotalAmount());
            st1.setString(4, bill.getBillNote());
            st1.setDate(5, new java.sql.Date(bill.getCreateDate().getTime()));
            st1.setInt(6, 1);

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
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                return row1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

}
