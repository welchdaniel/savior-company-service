package com.savior.company_service.dao;

import com.savior.company_service.model.Company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyDao {

    void insertCompany(Company company);

    List<Company> selectAllCompanies();

    Optional<Company> selectCompanyById(UUID id);

    void deleteCompanyById(UUID id);

    void updateCompanyById(UUID id, Company company);

}
