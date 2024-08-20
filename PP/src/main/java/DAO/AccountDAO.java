package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import MODEL.Account;

public class AccountDAO extends ConnectSQL {
    
    public List<Account> loadAllAccountData() {
        List<Account> accountList = new ArrayList<>();
        String query = "SELECT * FROM ACCOUNT";
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Account account = new Account(
                    rs.getString("ACCOUNTID"),
                    rs.getString("ACCOUNTROLE")
                );
                accountList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
    }

    public void showAllAccountDataToConsole() {
        List<Account> accounts = loadAllAccountData();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}