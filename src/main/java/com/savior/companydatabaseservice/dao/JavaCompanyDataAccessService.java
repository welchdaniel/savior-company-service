package com.savior.companydatabaseservice.dao;

import com.savior.companydatabaseservice.model.Company;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("javaDao")
public class JavaCompanyDataAccessService implements CompanyDao {
    public static List<Company> DB = new ArrayList<>();

    @Override
    public int insertCompany(UUID id, Company company) {
        DB.add(new Company(id, company.getName(), company.getWebsite()));
        return 1;
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
    public int deleteCompanyById(UUID id) {
        Optional<Company> maybeCompany = selectCompanyById(id);
        if(maybeCompany.isEmpty()) {
            return 0;
        }
        DB.remove(maybeCompany.get());
        return 1;
    }

    @Override
    public int updateCompanyById(UUID id, Company company) {
        return selectCompanyById(id)
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
