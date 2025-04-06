package hbv7d.controller;

import hbv7d.repository.*;
import hbv7d.model.Company;
import hbv7d.model.Tour;
import java.util.List;

public class CompanyController {
    private CompanyRepository companyRepository; // Mocked in testing

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public boolean createCompany(Company company) {
        if (companyRepository.findById(company.getCompanyId()) == null) {
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    public Company getCompany(int companyId) {
        return companyRepository.findById(companyId);
    }

    public boolean deleteCompany(int companyId) {
        Company company = companyRepository.findById(companyId);
        if (company != null) {
            companyRepository.delete(companyId);
            return true;
        }
        return false;
    }

    public boolean addTour(int companyId, Tour tour) {
        Company company = companyRepository.findById(companyId);
        if (company != null) {
            company.addTour(tour);
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    public List<Tour> viewCompanyTours(int companyId) {
        Company company = companyRepository.findById(companyId);
        return (company != null) ? company.viewCompanyTours() : null;
    }
}
