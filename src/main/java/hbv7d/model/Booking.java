package hbv7d.model;


public class Booking {
    private int bookingID;
    private Tour tour;
    private User user;
    private BookingStatus status;


    
    public Booking(User user, Tour tour) {
        this.user = user;
        this.tour = tour;
        this.status = BookingStatus.PENDING;
    }


    enum BookingStatus {
        PENDING, CONFIRMED, CANCELLED
    }
}