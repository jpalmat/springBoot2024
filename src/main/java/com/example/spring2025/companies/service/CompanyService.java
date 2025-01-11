package com.example.spring2025.companies.service;

import java.util.List;

import com.example.spring2025.companies.data.Company;

public interface CompanyService {
    List<Company> getCompanies();
    void addCompanies(Company companies);
    Company getCompaniesById(Long id);
    boolean deleteCompanies(Long id);
    boolean updateCompanies(Long id, Company companies_updated);
}
