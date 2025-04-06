package hbv7d.repository;

import hbv7d.database.DBConnection;
import hbv7d.model.Company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyRepository {
    
    //Býr til Company töflunna í gagnagrunn ef ekki til núþegar.
    public void createCompanyTable(){
        String sqlString = "CREATE TABLE IF NOT EXISTS Company ("
                   + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                   + "name TEXT NOT NULL"
                   + ");";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlString)) {
            pstmt.executeUpdate();
            System.out.println("Company Table Made.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    
    public Company findById(int companyId) {
        Company company = null;
        String sql = "SELECT id, name FROM Company WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, companyId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    company = new Company();
                    company.setCompanyId(rs.getInt("id"));
                    company.setName(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    public void save(Company company) {
        String sqlString = "INSERT INTO Company (name) VALUES (?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlString)) {
            pstmt.setString(1, company.getName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int companyId) {
        String sql = "DELETE FROM Company WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, companyId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}