package org.example.review.reviewService;

import org.example.review.entity.Review;
import org.example.review.reviewRepository.ReviewRepository;

import java.util.List;

public class ReviewService {
    ReviewRepository reviewRepository = new ReviewRepository();

    public int create(int score, int reservation_id, String writing, String regDate) {
        return this.reviewRepository.create(score, reservation_id, writing, regDate);
    }

    public List<Review> getReviewAllList() {
        return this.reviewRepository.getReviewAllList();
    }
    public void getReviewUserList() {
        this.reviewRepository.getReviewUserList();
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
    public Review getReviewUserListById() {
        return this.reviewRepository.getReviewUserListById();
    }
    public boolean isReserved(int movie_id) {
        return this.reviewRepository.isReserved(movie_id);
    }
//    public List<Review> getReviewTitleUserList() {return this.reviewRepository.getReviewTitleUserList(); }
//    public boolean isReserved() {
//        return reviewRepository.isReserved();
//    }
    public int checkScore() {
        return this.reviewRepository.checkScore();
    }

}
