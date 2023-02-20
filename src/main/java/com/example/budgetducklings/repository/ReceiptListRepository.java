package com.example.budgetducklings.repository;

import com.example.budgetducklings.db.MySqlDb;
import com.example.budgetducklings.model.Receipt;
import com.example.budgetducklings.model.ReceiptList;

import java.sql.*;

public class ReceiptListRepository {

    private MySqlDb db;


    public ReceiptListRepository() {
        db = MySqlDb.getInstance();
    }

    public ReceiptList getReceiptList(String name) {
        Connection conn = db.getConn();
        ReceiptList ducklingList = new ReceiptList(name);
        String sql = "" +
                "SELECT * FROM receipt_tbl " +
                "WHERE ducklingList.name = ?";

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

                ducklingList.getReceiptList().add(receipt);
            } while(rs.next());


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ducklingList;
    }

    public int createNew(String name, Receipt receipt) {
        Connection conn = db.getConn();
        String sql = "INSERT INTO reciept_tbl (name) VALUES (?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, name);
            return stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int update(String name, Receipt receipt) {
        Connection conn = db.getConn();
        String sql = "INSERT INTO receipt_tbl (name) VALUES (?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, name);
            return stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteInvoice(String name, Receipt receipt) {
        Connection conn = db.getConn();
        String sql = "DELETE FROM receipt_tbl WHERE name=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, name);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
