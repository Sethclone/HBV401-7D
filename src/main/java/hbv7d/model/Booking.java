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

    public boolean confirmBooking(){
        return true;
    }

    public boolean cancelBooking(){
        return true;
    }

    public boolean bookingFaild(){
        return true;
    }

    private enum BookingStatus {
        PENDING, CONFIRMED, CANCELLED
    }

    public BookingStatus getStatus() {
        return status;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

}