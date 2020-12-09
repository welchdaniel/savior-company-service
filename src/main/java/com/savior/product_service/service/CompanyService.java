package com.savior.product_service.service;

import com.savior.product_service.dao.Company.CompanyDao;
import com.savior.product_service.model.Company;
import com.savior.product_service.utils.exception.data.KeyDoesNotExistException;
import com.savior.product_service.utils.exception.service.CompanyDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

  private final CompanyDao companyDao;

  @Autowired
  public CompanyService(@Qualifier("mysql-company") CompanyDao companyDao) {
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
