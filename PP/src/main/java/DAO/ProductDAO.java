package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import MODEL.Product;

public class ProductDAO extends ConnectSQL {
    
    public List<Product> loadAllProductData() {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM PRODUCT";
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Product product = new Product(
                    rs.getString("PRODUCTID"),
                    rs.getString("PRODUCTNAME"),
                    rs.getInt("PRODUCTPRICE"),
                    rs.getBoolean("PRODUCTSTATUS")
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
}