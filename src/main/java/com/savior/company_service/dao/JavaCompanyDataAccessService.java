package com.savior.company_service.dao;

import com.savior.company_service.model.Company;
import com.savior.company_service.utils.exception.database.KeyDoesNotExistException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("java")
public class JavaCompanyDataAccessService implements CompanyDao {
  public static List<Company> DB = new ArrayList<>();

  @Override
  public Company insertCompany(Company company) {
    Company newCompany = new Company(UUID.randomUUID().toString(), company.getName(), company.getWebsite());
    DB.add(newCompany);
    return newCompany;
  }

  @Override
  public List<Company> selectAllCompanies() {
    return DB;
  }

  @Override
  public Company selectCompanyById(String id) throws KeyDoesNotExistException {
    Optional<Company> storedCompany = DB.stream()
        .filter(company -> company.getId().equals(id))
        .findFirst();
    if (storedCompany.isEmpty()) {
      throw new KeyDoesNotExistException();
    }
    return storedCompany.get();
  }

  @Override
  public void deleteCompanyById(String id) throws KeyDoesNotExistException {
    Company storedCompany = selectCompanyById(id);
    DB.remove(storedCompany);
  }

  @Override
  public Company updateCompanyById(String id, Company company) throws KeyDoesNotExistException {
    Company storedCompany = selectCompanyById(id);
    int index = DB.indexOf(storedCompany);
    Company updatedCompany = new Company(id, company.getName(), company.getWebsite());
    DB.set(index, updatedCompany);
    return updatedCompany;
  }
}
