package org.example.review.reviewController;

import org.example.Container;
import org.example.movie.controller.MovieController;
import org.example.movie.entity.Movie;
import org.example.review.entity.Review;
import org.example.review.reviewService.ReviewService;
import org.example.ticketing.entity.MovieReservation;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.List;

public class ReviewController {
    ReviewService reviewService = new ReviewService();
    MovieController movieController = new MovieController();
    MovieReservation movieReservation;

    public void write() {
//        if (movieReservation.getIsComplete() == false) {
//            System.out.println("영화예약을 먼저 완료하고 이용해주세요.");
//            return;
//        }
//        int score;
        System.out.println(Container.getSelectedMovieTitle() + " 리뷰작성");

        int score = reviewService.checkScore();
        System.out.print("리뷰 내용: ");
        String writing = Container.getSc().nextLine();

        int id = reviewService.create(score, Container.getSelectedMovieTitle(), writing, Container.getLoginedUser().getUser_id(), Util.nowDateTime());
        System.out.println(id + "번째 리뷰가 등록되었습니다.");
    }

    public void list() {
        List<Review> reviewList = reviewService.getReviewAllList();

        while (true) {
            System.out.println("열람하실 게시판을 선택해주세요");
            System.out.println("1. 전체게시판 / " + "2. " + Container.getSelectedMovieTitle() + " 게시판 ");
            String reviewArticle = Container.getSc().nextLine().trim();
            if (reviewArticle.equals("전체게시판") || reviewArticle.equals("1")) {
                if (reviewList.size() == 0) {
                    System.out.println("게시물이 없습니다.");
                } else {
                    System.out.println("게시물 번호 / 영화제목 /작성자 / 평점 / 리뷰내용 / 작성일자");
                    for (int i = 0; i < reviewList.size(); i++) {
                        Review review = reviewList.get(i);
                        System.out.printf("%d / %s / %s / %d / %s / %s\n", review.getId(), review.getMovieTitle(), review.getUser_id(), review.getScore(), review.getWriting(), review.getRegDate());
                    }
                    break;
                }
            } else if (reviewArticle.equals(Container.getSelectedMovieTitle() + " 게시판") || reviewArticle.equals("2")) {
                if (reviewList.size() == 0) {
                    System.out.println("게시물이 없습니다.");
                } else {
                    System.out.println("게시물 번호 / 영화제목 /작성자 / 평점 / 리뷰내용 / 작성일자");
                    for (int i = 0; i < reviewList.size(); i++) {
                        Review review = reviewList.get(i);
                        if (Container.getSelectedMovieTitle().equals(review.getMovieTitle())) {
                            System.out.printf("%d / %s / %s / %d / %s / %s\n", review.getId(), review.getMovieTitle(), review.getUser_id(), review.getScore(), review.getWriting(), review.getRegDate());
                        }
                    }
                    break;
                }
            }
        }
    }

    public void remove() {
        if (reviewService.getReviewUserListById() == null) {
            System.out.println("작성한 리뷰가 존재하지 않습니다.");
        } else {
            System.out.println("==== 내 리뷰 ====");
            reviewService.getReviewUserList();
            System.out.println("삭제할 리뷰의 ID 번호를 입력해주세요");
            int id = Integer.parseInt(Container.getSc().nextLine());
            Review review = reviewService.getReviewListById(id);
            if (review.getId() == 0) {
                System.out.printf("%d번 리뷰내용이 존재하지 않습니다.\n", id);
                return;
            } else if (Container.getLoginedUser().getUser_id().equals(review.getUser_id()) == false) {
                System.out.println("다른 사용자의 게시물은 삭제가 불가합니다.");
                return;
            }
            System.out.printf("%d번 리뷰내용이 삭제 되었습니다.\n", id);
            this.reviewService.remove(review);

        }
    }

    public void modify() {
        if (reviewService.getReviewUserListById() == null) {
            System.out.println("작성한 리뷰가 존재하지 않습니다.");
        } else {
            System.out.println("==== 내 리뷰 ====");
            reviewService.getReviewUserList();
            System.out.println("수정할 리뷰의 ID 번호를 입력해주세요");
            int id = Integer.parseInt(Container.getSc().nextLine());
            Review review = reviewService.getReviewListById(id);
            if (review.getId() == 0) {
                System.out.printf("%d번 리뷰내용이 존재하지 않습니다.\n", id);
                return;
            } else if (Container.getLoginedUser().getUser_id().equals(review.getUser_id()) == false) {
                System.out.println("다른 사용자의 게시물은 수정이 불가합니다.");
                return;
            }
            int score = reviewService.checkScore();

            System.out.print("리뷰 수정: ");
            String writing = Container.getSc().nextLine();

            reviewService.modify(review, score, writing);
        }
    }
}
