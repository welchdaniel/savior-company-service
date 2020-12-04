package com.savior.company_service.dao.Company;

import com.savior.company_service.model.Company;
import com.savior.company_service.utils.exception.data.KeyDoesNotExistException;

import java.util.List;

public interface CompanyDao {

  Company insertCompany(Company company);

  List<Company> selectAllCompanies();

  Company selectCompanyById(String id) throws KeyDoesNotExistException;

  void deleteCompanyById(String id) throws KeyDoesNotExistException;

  Company updateCompanyById(String id, Company company) throws KeyDoesNotExistException;

  boolean companyWithIdExists(String id);

}
