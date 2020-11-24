package com.savior.companydatabaseservice.api;

import com.savior.companydatabaseservice.model.Company;
import com.savior.companydatabaseservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/company")
@RestController
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public void insertCompany(@RequestBody Company company) {
        companyService.insertCompany(company);
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping(path = "/{id}")
    public Company getCompanyById(@PathVariable("id") UUID id) {
        return companyService.getCompanyById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCompanyById(@PathVariable("id") UUID id) {
        companyService.deleteCompany(id);
    }

    @PutMapping(path = "{id}")
    public void updateCompany(@PathVariable("id") UUID id, @RequestBody Company company) {
        companyService.updateCompany(id, company);
    }
}
