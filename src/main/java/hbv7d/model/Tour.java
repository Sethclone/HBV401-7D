package hbv7d.model;

import java.util.Date;
import java.util.List;

public class Tour {
    private int tourId;
    private String name;
    private String description;
    private String location;
    private int price;
    private Date date;
    private int duration;
    private int groupSize;
    private String difficultyRating;
    private String type;
    private boolean pickupService;
    private List<Booking> bookings;
    private Company host;


    
    public Tour(int tourId, String name, String description, String location, int price, Date date, int duration, 
                int groupSize, String difficultyRating, String type, boolean pickupService, Company host) {
        this.tourId = tourId;
        this.name = name;
        this.description = description;
        this.location = location;
        this.price = price;
        this.date = date;
        this.duration = duration;
        this.groupSize = groupSize;
        this.difficultyRating = difficultyRating;
        this.type = type;
        this.pickupService = pickupService;
        this.host = host;
    }

}