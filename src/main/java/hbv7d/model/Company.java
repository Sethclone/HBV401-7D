package hbv7d.model;

import java.util.List;

public class Company {
    private int companyId;
    private String name;
    private List<Tour> toursOffered;


    // Constructor
    public Company(int companyId, String name) {
        this.companyId = companyId;
        this.name = name;
    }
    // Getters and setters
    public int getCompanyId() { return companyId; } //companyId: int

    public String getName() { return name; } //name: string

    public void setName(String name) {
        this.name = name;
    }

    public List<Tour> viewCompanyTours() {
        return toursOffered;
    } //toursOffered

    // METHODS
    public void addTour(Tour tour) {
        toursOffered.add(tour);
    } //makeTour



    //Ekki betra addTour??
    public void setTour(List<Tour> toursOffered) {
        this.toursOffered = toursOffered;
    } //updateTour

    public void cancelTour(Tour tour) {
        toursOffered.remove(tour);
    } //deleteTour

}