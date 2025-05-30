package com.example.spring2025.companies.controler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring2025.companies.data.Company;
import com.example.spring2025.companies.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyControler {

    private CompanyService companyService;

    public CompanyControler(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getCompanies() {
        return new ResponseEntity<>(this.companyService.getCompanies(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCompanies(@RequestBody Company companies) {
        this.companyService.addCompanies(companies);
        return new ResponseEntity<>("Companies added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompaniesById(@PathVariable Long id) {
        Company companies = this.companyService.getCompaniesById(id);
        if (companies == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @GetMapping("/{id}/test")
    public ResponseEntity<List<Integer>> getCompaniesTestById(@PathVariable Long id) {
        return new ResponseEntity<>(this.companyService.getCompanyTest(id), HttpStatus.OK);
    }
    @GetMapping("/numberEmployee")
    public ResponseEntity<Integer> getNumbermployee(@PathVariable Long id) {
        Integer num = this.companyService.getNumbermployee();
        return new ResponseEntity<>(num, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanies(@PathVariable Long id) {
        boolean deleted = this.companyService.deleteCompanies(id);
        if (!deleted) {
            return new ResponseEntity<>("Companies not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Companies deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanies(@PathVariable Long id, @RequestBody Company companiesUpdated) {
        boolean updated = this.companyService.updateCompanies(id, companiesUpdated);
        if (!updated) {
            return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
    }
}
