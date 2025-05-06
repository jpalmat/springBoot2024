package com.example.spring2025.companies.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.spring2025.companies.data.Company;
import com.example.spring2025.companies.data.CompanyRepository;


@ExtendWith(MockitoExtension.class)
public class CompanyServiceImplTest {

    @InjectMocks
    private CompanyServiceImpl companyServiceImpl;

    @Mock
    private CompanyRepository companyRepository;

    // @BeforeEach
    // void setup() throws Exception {
    //     MockitoAnnotations.initMocks(this);
    // }

    @Test
    void testGetNumbermployee() {

        Company company1 = new Company();
        company1.setDescription("s");
        company1.setName("name");
        company1.setNumberEmployees(10);

        Company company2 = new Company();
        company2.setDescription("d");
        company2.setName("names");
        company2.setNumberEmployees(10);

        List<Company> listCompanies = Stream.of(company1, company2).collect(Collectors.toList());

        int expectedNumberEmployees = 20;

        when(companyRepository.findAll()).thenReturn(listCompanies);

        int numberReal = companyServiceImpl.getNumbermployee();

        assertEquals(expectedNumberEmployees, numberReal);



    }
}
