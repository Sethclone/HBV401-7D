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


    //CONSTRUCTOR
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


    // GET&SET
    // Örruglega óþarfi að hafa svona marga setters miða við hvað við gerum í Update kerfinu.
    public int getTourId() {return tourId;}
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public int getGroupSize() { return groupSize; }
    public void setGroupSize(int groupSize) { this.groupSize = groupSize; }

    public String getDifficultyRating() { return difficultyRating; }
    public void setDifficultyRating(String difficultyRating) { this.difficultyRating = difficultyRating; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public boolean isPickupService() { return pickupService; }
    public void setPickupService(boolean pickupService) { this.pickupService = pickupService; }

    public Company getHost() { return host; }
    public void setHost(Company host) { this.host = host; }




    // Methods
    private boolean reserveSeat(Booking booking) {
        if (bookings.size() < groupSize){
            bookings.add(booking);
            return true;
        }
        return false;
    }


    private void cancelReservation(Booking booking){
        bookings.remove(booking);
    }



    private void updateTour(){
        //TODO: Finna á hvaða hátt við viljum breyta tour.
        //Ásamt því að búa til functionality fyrir að uppfæra tour

    }

}