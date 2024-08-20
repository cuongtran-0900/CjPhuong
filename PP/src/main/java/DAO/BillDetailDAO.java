package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import MODEL.BillDetail;

public class BillDetailDAO extends ConnectSQL {
    
    public List<BillDetail> loadAllBillDetailData() {
        List<BillDetail> billDetailList = new ArrayList<>();
        String query = "SELECT * FROM BILLDETAIL";
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                BillDetail billDetail = new BillDetail(
                    rs.getString("BILLID"),
                    rs.getString("PRODUCTID"),
                    rs.getString("PRODUCTNAME"),
                    rs.getInt("PRODUCTPRICE"),
                    rs.getInt("QUANTITY"),
                    rs.getInt("TOTALPRICE")
                );
                billDetailList.add(billDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billDetailList;
    }

    public void showAllBillDetailDataToConsole() {
        List<BillDetail> billDetails = loadAllBillDetailData();
        for (BillDetail billDetail : billDetails) {
            System.out.println(billDetail);
        }
    }
}