package com.savior.company_service.dao;

import com.savior.company_service.model.Company;
import com.savior.company_service.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("mysql")
public class CompanyDataAccessService implements CompanyDao {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void insertCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public List<Company> selectAllCompanies() {
        return companyRepository.findAllCompanies();
    }

    @Override
    public Optional<Company> selectCompanyById(String id) {
        return companyRepository.findCompanyById(id);
    }

    @Override
    public void deleteCompanyById(String id) {
        companyRepository.deleteById(id);
    }

    @Override
    public void updateCompanyById(String id, Company company) {
        Optional<Company> optional = companyRepository.findById(id);
        Company updateCompany = optional.get();
        updateCompany.setName(company.getName());
        updateCompany.setWebsite(company.getWebsite());
        companyRepository.save(updateCompany);
    }
}
