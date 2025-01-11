package com.example.spring2025.companies.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompaniesRepository extends JpaRepository<Companies, Long> {
    
}
