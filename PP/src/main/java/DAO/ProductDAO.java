package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import MODEL.Product;
import UI.Home;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProductDAO extends ConnectSQL {
            List<Product> productList = new ArrayList<>();

    public List<Product> loadAllProductData() {
        String query = "SELECT * FROM PRODUCT";
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Product product = new Product(
                    rs.getString("PRODUCTID"),
                    rs.getString("PRODUCTNAME"),
                    rs.getInt("PRODUCTPRICE")
                );
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public void showAllProductDataToConsole() {
        List<Product> products = loadAllProductData();
        for (Product product : products) {
            System.out.println(product);
        }
    }
    public boolean check(String ma) {
        for (Product nv : productList) {
            if (ma.equals(nv.getProductID())) {
                return false;
            }
        } 
        return true;
    }

    public boolean removeProduct(String ID) {
        try {
            String sql = "UPDATE product SET isdelete = ? WHERE manv LIKE ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, 0);
            st.setString(2, ID);
            int row = st.executeUpdate();

            return row > 0;
        } catch (SQLException e) {
            int errorCode = e.getErrorCode();
            String errorMessage = e.getMessage();
            System.out.println("SQL Error Code: " + errorCode);
            System.out.println("SQL Error Message: " + errorMessage);
            e.printStackTrace();
        }
        return false;
    }

    public int save(Product pr) {
        try {
            String sql1 = "INSERT INTO product (PRODUCTID, PRODUCTNAME, PRODUCTPRICE, isdelete) VALUES (?, ?, ?, ?)";
            PreparedStatement st1 = con.prepareStatement(sql1);

            st1.setString(1, pr.getProductID());
            st1.setString(2, pr.getProductName());
            st1.setInt(3, pr.getProductPrice());
            st1.setInt(4, 1);
            int row1 = st1.executeUpdate();

            if (row1 > 0) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                return row1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int update(Product pr) {
        try {
            String sql = "UPDATE product SET PRODUCTNAME = ?, PRODUCTPRICE = ? WHERE PRODUCTID = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, pr.getProductName());
            st.setInt(2, pr.getProductPrice());
            st.setString(3, pr.getProductID());
            int rows = st.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                return rows;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}