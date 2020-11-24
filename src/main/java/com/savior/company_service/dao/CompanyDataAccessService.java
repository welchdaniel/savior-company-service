package com.savior.company_service.dao;

import com.savior.company_service.model.Company;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mysql")
public class CompanyDataAccessService implements CompanyDao {
    @Override
    public int insertCompany(UUID id, Company company) {
        return 0;
    }

    @Override
    public List<Company> selectAllCompanies() {
        return null;
    }

    @Override
    public Optional<Company> selectCompanyById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteCompanyById(UUID id) {
        return 0;
    }

    @Override
    public int updateCompanyById(UUID id, Company company) {
        return 0;
    }
}
