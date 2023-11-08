package org.example.review.reviewService;

import org.example.review.entity.Review;
import org.example.review.entity.UserReview;
import org.example.review.reviewRepository.ReviewRepository;

import java.util.List;

public class ReviewService {
    ReviewRepository reviewRepository = new ReviewRepository();

    public int create(int score, String writing, int user_id, String regDate) {
        return this.reviewRepository.create(score, writing, user_id, regDate);
    }

    public List<UserReview> getReviewAllList() {
        return this.reviewRepository.getReviewAllList();
    }

    public void remove(Review review) {
        this.reviewRepository.remove(review);
    }
    public void modify(Review review, int score, String writing) {
        reviewRepository.modify(review, score, writing);
    }
    public Review getReviewListById(int id) {
        return this.reviewRepository.getReviewListById(id);
    }

    public boolean isReserved() {
        return reviewRepository.isReserved();
    }

    public List<UserReview> getReviewThisUserList() {
        return this.reviewRepository.getReviewThisUserList();
    }
}
