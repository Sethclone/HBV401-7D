package hbv7d.main;

import hbv7d.api.Api;
import hbv7d.controller.CompanyController;
import hbv7d.model.Company;
import hbv7d.repository.CompanyRepository;
import hbv7d.repository.TourRepository;

public class Main {
    public static void main(String[] args) {

        //Býr til töflunnar ef þær eru ekki núþegar til
//        CompanyRepository companyRepository = new CompanyRepository();
//        TourRepository tourRepository = new TourRepository();
//        CompanyController companyController = new CompanyController(companyRepository,tourRepository);
//        companyRepository.createCompanyTable();
//        tourRepository.createTourTable();
//
//        Company company1 = companyController.getCompany(1);
//        System.out.println(company1.getName());
        Api api = new Api();
    }
}
