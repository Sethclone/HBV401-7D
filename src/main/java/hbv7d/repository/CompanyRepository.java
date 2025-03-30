package hbv7d.repository;

import hbv7d.model.Company;
import java.util.HashMap;
import java.util.Map;

public class CompanyRepository {
    

    private Map<Integer, Company> companyStorage = new HashMap<>();

    public Company findById(int companyId) {
        return companyStorage.get(companyId);
    }

    public void save(Company company) {
        companyStorage.put(company.getCompanyId(), company);
    }

    public void delete(int companyId) {
        companyStorage.remove(companyId);
    }
}