package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import MODEL.BillDetail;

public class BillDetailDAO extends DatabaseConnection {

    public List<BillDetail> loadBillDetailByBillID(String billID) {
        List<BillDetail> billDetailList = new ArrayList<>();
        String query = "SELECT bd.BILLID, p.PRODUCTID, p.PRODUCTNAME, p.PRODUCTPRICE, bd.QUANTITY, bd.TOTALPRICE " +
                       "FROM BILLDETAIL bd " +
                       "INNER JOIN PRODUCT p ON bd.PRODUCTID = p.PRODUCTID " +
                       "WHERE bd.BILLID = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, billID);
            try (ResultSet rs = ps.executeQuery()) {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billDetailList;
    }
}