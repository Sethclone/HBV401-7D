package hbv7d.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hbv7d.database.DBConnection;
import hbv7d.model.Tour;

public class TourRepository {

    //Býr til tour töflu í gagnagrunni ef ekki núþegar til.
    public void createTourTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Tour ("
                   + "tourId INTEGER PRIMARY KEY AUTOINCREMENT, "
                   + "name TEXT NOT NULL, "
                   + "description TEXT, "
                   + "location TEXT, "
                   + "price INTEGER, "
                   + "date DATE, "
                   + "duration INTEGER, "
                   + "groupSize INTEGER, "
                   + "difficultyRating TEXT, "
                   + "type TEXT, "
                   + "pickupService BOOLEAN, "
                   + "companyId INTEGER, "
                   + "FOREIGN KEY (companyId) REFERENCES Company(id)"
                   + ");";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
            System.out.println("Tour Table Created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }        

    //Vistar Tour í gagnagrunn
    public void save(Tour tour) {
        String sql = "INSERT INTO Tour (name, description, location, price, date, duration, groupSize, difficultyRating, type, pickupService, companyId) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tour.getName());
            pstmt.setString(2, tour.getDescription());
            pstmt.setString(3, tour.getLocation());
            pstmt.setInt(4, tour.getPrice());
            pstmt.setDate(5, new java.sql.Date(tour.getDate().getTime()));
            pstmt.setInt(6, tour.getDuration());
            pstmt.setInt(7, tour.getGroupSize());
            pstmt.setString(8, tour.getDifficultyRating());
            pstmt.setString(9, tour.getType());
            pstmt.setBoolean(10, tour.isPickupService());
            
            //Skilgreint hvaða fyrirtæki á tourið
            if (tour.getHost() != null) {
                pstmt.setInt(11, tour.getHost().getCompanyId());
            } else {
                pstmt.setNull(11, java.sql.Types.INTEGER);
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Finnur tour eftir fyrirtæki
    public List<Tour> findByCompanyId(int companyId) {
        List<Tour> tours = new ArrayList<>();
        String sql = "SELECT tourId, name, description, location, price, date, duration, groupSize, difficultyRating, type, pickupService "
                   + "FROM Tour WHERE companyId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, companyId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Tour tour = new Tour(
                        rs.getInt("tourId"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("location"),
                        rs.getInt("price"),
                        rs.getDate("date"),
                        rs.getInt("duration"),
                        rs.getInt("groupSize"),
                        rs.getString("difficultyRating"),
                        rs.getString("type"),
                        rs.getBoolean("pickupService"),
                        null   
                    );
                    tours.add(tour);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tours;
    }


}

