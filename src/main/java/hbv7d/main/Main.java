package hbv7d.main;

import hbv7d.repository.CompanyRepository;
import hbv7d.repository.TourRepository;

public class Main {
    public static void main(String[] args) {

        //Býr til töflunnar ef þær eru ekki núþegar til
        new CompanyRepository().createCompanyTable();
        new TourRepository().createTourTable(); 
    }
}
