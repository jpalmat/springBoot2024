package com.example.spring2025.companies.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.spring2025.companies.data.Companies;
import com.example.spring2025.companies.data.CompaniesRepository;
import com.example.spring2025.companies.service.CompaniesService;

@Service
public class CompaniesServiceImpl implements CompaniesService {
    CompaniesRepository companiesRepository;

    public CompaniesServiceImpl(CompaniesRepository companiesRepository) {
        this.companiesRepository = companiesRepository;
    }

    @Override
    public List<Companies> getCompanies() {
        return companiesRepository.findAll();
    }

    @Override
    public void addCompanies(Companies companies) {
        companiesRepository.save(companies);
    }

    @Override
    public Companies getCompaniesById(Long id) {
        // return companiess.stream().filter(j -> j.getId().equals(id)).findFirst().orElse(null);
        return companiesRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompanies(Long id) {
        // return companiess.removeIf(companies -> companies.getId().equals(id));
        try {
        companiesRepository.deleteById(id);
        return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateCompanies(Long id, Companies companies_updated) {

        Optional<Companies> companiesOptional = companiesRepository.findById(id);
        if(companiesOptional.isPresent()) {
            Companies companies = companiesOptional.get();
            companies.setTitle(companies_updated.getTitle());
            companies.setDescription(companies_updated.getDescription());
            companies.setLocation(companies_updated.getLocation());
            companies.setMinSalary(companies_updated.getMinSalary());
            companies.setMaxSalary(companies_updated.getMaxSalary());
            companiesRepository.save(companies);
            return true;
        }
        return false;
    }
    
}
