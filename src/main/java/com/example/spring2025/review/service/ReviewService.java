package com.example.spring2025.review.service;

import java.util.List;

import com.example.spring2025.review.data.Review;


public interface ReviewService {
    List<Review> getAllReviewsByCompany(Long companyId);
    boolean addReview(Long companyId, Review review);
    Review findReview(Long companyId, Long reviewId);
    boolean deleteReview(Long companyId, Long reviewId);
    boolean updateReview(Long companyId, Long reviewId, Review review_updated);
}
