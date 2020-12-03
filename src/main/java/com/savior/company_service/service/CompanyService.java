package com.savior.company_service.service;

import com.savior.company_service.dao.CompanyDao;
import com.savior.company_service.model.Company;
import com.savior.company_service.utils.exception.database.KeyDoesNotExistException;
import com.savior.company_service.utils.exception.service.CompanyDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
  private final CompanyDao companyDao;

  @Autowired
  public CompanyService(@Qualifier("mysql") CompanyDao companyDao) {
    this.companyDao = companyDao;
  }

  public Company insertCompany(Company company) {
    return companyDao.insertCompany(company);
  }

  public List<Company> getAllCompanies() {
    return companyDao.selectAllCompanies();
  }

  public Company getCompanyById(String id) throws CompanyDoesNotExistException {
    try {
      return companyDao.selectCompanyById(id);
    } catch (KeyDoesNotExistException kdne) {
      throw new CompanyDoesNotExistException();
    }
  }

  public void deleteCompany(String id) throws CompanyDoesNotExistException {
    try {
      companyDao.deleteCompanyById(id);
    } catch (KeyDoesNotExistException kdne) {
      throw new CompanyDoesNotExistException();
    }
  }

  public Company updateCompany(String id, Company newCompany) throws CompanyDoesNotExistException {
    try {
      return companyDao.updateCompanyById(id, newCompany);
    } catch (KeyDoesNotExistException kdne) {
      throw new CompanyDoesNotExistException();
    }
  }

}
