package hbv7d.model;

import java.util.List;

public class User {
    private int userId;
    private String name;
    private String email;
    private List<Booking> bookings;


    
    public User(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
}