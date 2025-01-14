package com.example.spring2025.review.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring2025.companies.data.Company;
import com.example.spring2025.companies.service.CompanyService;
import com.example.spring2025.review.data.Review;
import com.example.spring2025.review.data.ReviewRepository;
import com.example.spring2025.review.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviewsByCompany(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompaniesById(companyId);
        if(company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review findReview(Long companyId, Long reviewId) {
        return reviewRepository.findReviewByCompanyIdAndReviewId(companyId, reviewId);
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        try {
            Company company = companyService.getCompaniesById(companyId);   
            Review review = reviewRepository.findById(reviewId).orElse(null);
            if(company != null && review != null) {
                company.getReviews().remove(review);
                companyService.updateCompanies(companyId, company);
                review.setCompany(null);
                reviewRepository.deleteById(reviewId);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review review_updated) {

        Company company = companyService.getCompaniesById(companyId);
        if(company != null) {
            review_updated.setCompany(company);
            review_updated.setId(reviewId);
            reviewRepository.save(review_updated);
            return true;
        }
        return false;
    }
    
}
