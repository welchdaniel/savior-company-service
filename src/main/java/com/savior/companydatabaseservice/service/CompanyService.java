package com.savior.companydatabaseservice.service;

import com.savior.companydatabaseservice.dao.CompanyDao;
import com.savior.companydatabaseservice.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyService {
    private final CompanyDao companyDao;

    @Autowired
    public CompanyService(@Qualifier("mysql") CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public int insertCompany(Company company) {
        return companyDao.insertCompany(company);
    }

    public List<Company> getAllCompanies() {
        return companyDao.selectAllCompanies();
    }

    public Optional<Company> getCompanyById(UUID id) {
        return companyDao.selectCompanyById(id);
    }

    public int deleteCompany(UUID id) {
        return companyDao.deleteCompanyById(id);
    }

    public int updateCompany(UUID id, Company newCompany) {
        return companyDao.updateCompanyById(id, newCompany);
    }

}
