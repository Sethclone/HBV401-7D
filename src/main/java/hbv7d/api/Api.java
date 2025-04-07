package hbv7d.api;

import hbv7d.controller.CompanyController;
import hbv7d.controller.UserController;
import hbv7d.model.Company;
import hbv7d.model.Tour;
import hbv7d.repository.CompanyRepository;
import hbv7d.repository.TourRepository;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Api {
    CompanyController companyController;
    UserController userController;
    public Api(){
        userController = new UserController();
        start();
    }

    private void start(){
        //Býr til töflunnar ef þær eru ekki núþegar til
        CompanyRepository companyRepository = new CompanyRepository();
        TourRepository tourRepository = new TourRepository();
        companyController = new CompanyController(companyRepository,tourRepository);
        companyRepository.createCompanyTable();
        tourRepository.createTourTable();
    }

    public boolean createCompany(Company company){
        return companyController.createCompany(company);
    }

    public Company getCompany(int companyId) {
        return companyController.getCompany(companyId);
    }

    public boolean deleteCompany(int companyId){
        return companyController.deleteCompany(companyId);
    }

    public boolean addTour(int companyId, Tour tour){
        return companyController.addTour(companyId,tour);
    }

    public List<Tour> viewCompanyTours(int companyId){
        return companyController.viewCompanyTours(companyId);
    }


}
