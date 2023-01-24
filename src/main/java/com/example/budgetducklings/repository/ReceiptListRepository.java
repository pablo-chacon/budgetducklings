package com.example.budgetducklings.repository;

import com.example.budgetducklings.db.MySqlDb;
import com.example.budgetducklings.model.Receipt;
import com.example.budgetducklings.model.ReceiptList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptListRepository {

    private MySqlDb db;

    public ReceiptListRepository() {
        db = MySqlDb.getInstance();
    }

    public ReceiptList getReceiptList(String name) {
        Connection conn = db.getConnection();
        ReceiptList list = new ReceiptList(name);
        String sql = "" +
                "SELECT * FROM shoppingLists " +
                "JOIN listOwners " +
                "ON shoppingLists.ownerId=listOwners.id " +
                "WHERE listOwners.name = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);

            ResultSet rs = pstmt.executeQuery();

            if(!rs.next()) { return null; } //guardian clause

            System.out.println(name);
            do {
                Receipt receipt = new Receipt();
                receipt.setTitle(rs.getString("Title"));
                receipt.setDateOfPurchase(rs.getString("Date"));

                list.getReceiptList().add(receipt);
            } while(rs.next());


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public void addItem(String name, Receipt receipt) {
        Connection conn = db.getConnection();
        String sql = "SELECT id FROM listEmployee WHERE name=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);

            ResultSet rs = pstmt.executeQuery();
            int employeeId;

            if(!rs.next()) { // Gå till första raden i query svaret
                employeeId = this.createNew(name);
            } else {
                employeeId = rs.getInt("id");
            }

            sql = "INSERT INTO shoppingLists (employeeId, title, dateOfPurchase, category, price, description)" +
                    "VALUES (?, ?, ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, employeeId);
            pstmt.setString(2, receipt.getDateOfPurchase());
            pstmt.setString(3, receipt.getCategory());
            pstmt.setString(4, receipt.getPrice());
            pstmt.setString(5, receipt.getTitle());
            pstmt.setString(6, receipt.getDescription());

            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int createNew(String username) {
        Connection conn = db.getConnection();
        String sql = "INSERT INTO listOwners (name) VALUES (?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, username);
            return stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
