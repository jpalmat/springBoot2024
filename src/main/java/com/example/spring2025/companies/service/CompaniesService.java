package com.example.spring2025.companies.service;

import java.util.List;

import com.example.spring2025.companies.data.Companies;

public interface CompaniesService {
    List<Companies> getCompanies();
    void addCompanies(Companies companies);
    Companies getCompaniesById(Long id);
    boolean deleteCompanies(Long id);
    boolean updateCompanies(Long id, Companies companies_updated);
}
