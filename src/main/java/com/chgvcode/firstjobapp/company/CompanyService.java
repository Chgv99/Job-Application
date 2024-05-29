package com.chgvcode.firstjobapp.company;

import java.util.List;

public interface CompanyService {

    List<Company> getAll();

    Company getCompanyById(Long id);

    void addCompany(Company company);

    boolean updateCompany(Long id, Company company);

    boolean deleteCompanyById(Long id);
}
