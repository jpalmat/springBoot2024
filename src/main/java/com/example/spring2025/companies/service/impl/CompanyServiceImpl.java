package com.example.spring2025.companies.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.spring2025.companies.data.Company;
import com.example.spring2025.companies.data.CompanyRepository;
import com.example.spring2025.companies.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
    CompanyRepository companiesRepository;

    public CompanyServiceImpl(CompanyRepository companiesRepository) {
        this.companiesRepository = companiesRepository;
    }


    int count = 0;
    @Override
    public List<Company> getCompanies() {
        List<Company> list = companiesRepository.findAll();

        list.stream().forEach(c -> {
            if(c.getId()==3) {
                c.setTest(Arrays.asList("Jimmyyyyyyyyyyyyy", "test"));
            } else {
                c.setTest(Arrays.asList("Jimmy" + ++count, "test"));
            }
        });
        return list;
    }

    @Override
    public void addCompanies(Company companies) {
        companiesRepository.save(companies);
    }

    @Override
    public Company getCompaniesById(Long id) {
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
    public boolean updateCompanies(Long id, Company companies_updated) {

        Optional<Company> companiesOptional = companiesRepository.findById(id);
        if(companiesOptional.isPresent()) {
            Company companies = companiesOptional.get();
            companies.setName(companies_updated.getName());
            companies.setDescription(companies_updated.getDescription());
            companies.setJobs(companies_updated.getJobs());
            companiesRepository.save(companies);
            return true;
        }
        return false;
    }

    @Override
    public List<Integer> getCompanyTest(Long id) {
        Company company = companiesRepository.findById(id).orElse(null);

        company.setTest(Arrays.asList("Jimmy", "Mayra"));

        return company.getTest().stream().map(test -> test.length()).collect(Collectors.toList());
    }

	@Override
	public Integer getNumbermployee() {
		List<Company> list = companiesRepository.findAll();

        return list.stream().map(c -> c.getNumberEmployees())
        .reduce(0, (a, b) -> a + b);
    
    }
    
}
