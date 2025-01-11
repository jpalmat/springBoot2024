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

import com.example.spring2025.companies.data.Companies;
import com.example.spring2025.companies.service.CompaniesService;

@RestController
@RequestMapping("/companies")
public class CompaniesControler {

    private CompaniesService companiesService;

    public CompaniesControler(CompaniesService companiesService) {
        this.companiesService = companiesService;
    }

    @GetMapping
    public ResponseEntity<List<Companies>> getCompanies() {
        return new ResponseEntity<>(this.companiesService.getCompanies(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCompanies(@RequestBody Companies companies) {
        this.companiesService.addCompanies(companies);
        return new ResponseEntity<>("Companies added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Companies> getCompaniesById(@PathVariable Long id) {
        Companies companies = this.companiesService.getCompaniesById(id);
        if (companies == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanies(@PathVariable Long id) {
        boolean deleted = this.companiesService.deleteCompanies(id);
        if (!deleted) {
            return new ResponseEntity<>("Companies not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Companies deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanies(@PathVariable Long id, @RequestBody Companies companiesUpdated) {
        boolean updated = this.companiesService.updateCompanies(id, companiesUpdated);
        if (!updated) {
            return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
    }
}
