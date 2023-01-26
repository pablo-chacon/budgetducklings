package com.example.budgetducklings.repository;

import com.example.budgetducklings.db.MySqlDb;
import com.example.budgetducklings.model.Receipt;
import com.example.budgetducklings.model.ReceiptList;

import java.sql.*;
import java.util.HashMap;

public class ReceiptListRepository {

    private MySqlDb db;

    public ReceiptListRepository() {
        db = MySqlDb.getInstance();
    }

    public ReceiptList getReceiptList(String name) {
        Connection conn = db.getConnection();
        ReceiptList list = new ReceiptList(name);
        String sql = "" +
                "SELECT * FROM receipts_tbl " +
                "JOIN listOwners " +
                "ON receiptsLists.ownerId=listOwners.id " +
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
                receipt.setDateOfPurchase(rs.getDate("Date"));
                receipt.setCategory(rs.getString("Category"));
                receipt.setPrice(rs.getString("Price"));
                receipt.setDescription(rs.getString("Description"));

                list.getReceiptList().add(receipt);
            } while(rs.next());


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public void addInvoice(String name, Receipt receipt) {
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

            sql = "INSERT INTO receiptsList (employeeId, receipt)" +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, employeeId);
            /*pstmt.setDate(2, (Date) receipt.getDateOfPurchase());
            pstmt.setString(3, receipt.getCategory());
            pstmt.setString(4, receipt.getPrice());
            pstmt.setString(5, receipt.getTitle());
            pstmt.setString(6, receipt.getDescription());*/

            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int createNew(String name) {
        Connection conn = db.getConnection();
        String sql = "INSERT INTO listOwners (name) VALUES (?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, name);
            return stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteInvoice(String name, Receipt receipt) {
        Connection conn = db.getConnection();
        String sql = "DELETE FROM receipts_tbl (name) VALUES (receipt.getTitle())";

        try (PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, name);
            return stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
