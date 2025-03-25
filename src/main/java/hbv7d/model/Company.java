package hbv7d.model;

import java.util.List;

public class Company {
    private int companyId;
    private String name;
    private List<Tour> toursOffered;


    
    public Company(int companyId, String name) {
        this.companyId = companyId;
        this.name = name;
    }

}