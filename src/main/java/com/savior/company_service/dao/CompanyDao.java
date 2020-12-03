package com.savior.company_service.dao;

import com.savior.company_service.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyDao {

    void insertCompany(Company company);

    List<Company> selectAllCompanies();

    Optional<Company> selectCompanyById(String id);

    void deleteCompanyById(String id);

    void updateCompanyById(String id, Company company);

}
