package com.savior.company_service.repository;

import com.savior.company_service.model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends CrudRepository<Company, UUID> {
    @Query("select company from Company company")
    public List<Company> findAllCompanies();

    @Query("select company from Company company where course.id=:cid")
    public Optional<Company> findCompanyById(@Param("cid") UUID id);
}
