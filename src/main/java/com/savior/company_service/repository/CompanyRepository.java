package com.savior.company_service.repository;

import com.savior.company_service.constants.Constants;
import com.savior.company_service.model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company, String> {
  @Query(value = "SELECT * FROM " + Constants.COMPANY_TABLE + " WHERE deleted_at IS NULL", nativeQuery = true)
  List<Company> findAllCompanies();

  @Query(value = "SELECT * FROM " + Constants.COMPANY_TABLE + " WHERE id = :cid AND deleted_at IS NULL", nativeQuery = true)
  Optional<Company> findCompanyById(@Param("cid") String id);

  @Query(value = "DELETE FROM " + Constants.COMPANY_TABLE + " WHERE id = :cid", nativeQuery = true)
  void hardDeleteCompanyById(@Param("cid") String id);
}
