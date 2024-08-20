package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import MODEL.Bill;

public class BillDAO extends ConnectSQL {
    
    public List<Bill> loadAllBillData() {
        List<Bill> billList = new ArrayList<>();
        String query = "SELECT * FROM BILL";
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Bill bill = new Bill(
                    rs.getString("BILLID"),
                    rs.getInt("BILLTOTALAMOUNT"),
                    null, // billDetailList needs to be loaded separately
                    rs.getString("BILLNOTE"),
                    rs.getString("ACCOUNTID"),
                    rs.getTimestamp("CREATEDATE"),
                    rs.getBoolean("BILLSTATUS")
                );
                billList.add(bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billList;
    }

    public void showAllBillDataToConsole() {
        List<Bill> bills = loadAllBillData();
        for (Bill bill : bills) {
            System.out.println(bill);
        }
    }
}