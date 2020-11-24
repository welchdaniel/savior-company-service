package com.savior.company_service.dao;

import com.savior.company_service.model.Company;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("javaDao")
public class JavaCompanyDataAccessService implements CompanyDao {
    public static List<Company> DB = new ArrayList<>();

    @Override
    public void insertCompany(Company company) {
        DB.add(new Company(UUID.randomUUID(), company.getName(), company.getWebsite()));
    }

    @Override
    public List<Company> selectAllCompanies() {
        return DB;
    }

    @Override
    public Optional<Company> selectCompanyById(UUID id) {
        return DB.stream()
                .filter(company -> company.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deleteCompanyById(UUID id) {
        Optional<Company> maybeCompany = selectCompanyById(id);
        if(maybeCompany.isEmpty()) {
            return;
        }
        DB.remove(maybeCompany.get());
    }

    @Override
    public void updateCompanyById(UUID id, Company company) {
        selectCompanyById(id)
                .map(c -> {
                    int index = DB.indexOf(c);
                    if (index >= 0) {
                        DB.set(index, new Company(id, company.getName(), company.getWebsite()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
