package com.savior.product_service.dao.Company;

import com.savior.product_service.model.Company;
import com.savior.product_service.repository.CompanyRepository;
import com.savior.product_service.utils.exception.data.KeyDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("mysql")
public class CompanyDataAccessService implements CompanyDao {

  @Autowired
  private CompanyRepository companyRepository;

  @Override
  public Company insertCompany(Company company) {
    return companyRepository.save(company);
  }

  @Override
  public List<Company> selectAllCompanies() {
    return companyRepository.findAllCompanies();
  }

  @Override
  public Company selectCompanyById(String id) throws KeyDoesNotExistException {
    Optional<Company> storedCompany = companyRepository.findCompanyById(id);
    if (storedCompany.isEmpty()) {
      throw new KeyDoesNotExistException();
    }
    return storedCompany.get();
  }

  @Override
  public void deleteCompanyById(String id) throws KeyDoesNotExistException {
    if (!companyWithIdExists(id)) {
      throw new KeyDoesNotExistException();
    }
    companyRepository.deleteById(id);
  }

  @Override
  public Company updateCompanyById(String id, Company company) throws KeyDoesNotExistException {
    Company updateCompany = selectCompanyById(id);
    updateCompany.setName(company.getName());
    updateCompany.setWebsite(company.getWebsite());
    return companyRepository.save(updateCompany);
  }

  @Override
  public boolean companyWithIdExists(String id) {
    return companyRepository.existsById(id);
  }
}
