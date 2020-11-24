package com.savior.companydatabaseservice.dao;

import com.savior.companydatabaseservice.model.Company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyDao {

    int insertCompany(UUID id, Company company);

    default int insertCompany(Company company) {
        UUID id = UUID.randomUUID();
        return insertCompany(id, company);
    }

    List<Company> selectAllCompanies();

    Optional<Company> selectCompanyById(UUID id);

    int deleteCompanyById(UUID id);

    int updateCompanyById(UUID id, Company company);

}
