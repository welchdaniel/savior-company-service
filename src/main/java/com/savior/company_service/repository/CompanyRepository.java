package com.savior.company_service.repository;

import com.savior.company_service.model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company, String> {
    @Query(value = "select * from company", nativeQuery = true)
    public List<Company> findAllCompanies();

    @Query(value = "select * from company where id = :cid", nativeQuery = true)
    public Optional<Company> findCompanyById(@Param("cid") String id);
}
