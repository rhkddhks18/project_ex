package org.example.review.reviewRepository;

import org.example.Container;
import org.example.db.DBConnection;
import org.example.review.entity.Review;
import org.example.ticketing.entity.MovieReservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReviewRepository {
    private DBConnection dbConnection;
    MovieReservation movieReservation;

    public ReviewRepository () {
        dbConnection = Container.getDBconnection();
    }
    public int create(int score, int reservation_id, String writing, String regDate) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("INSERT INTO review "));
        sb.append(String.format("SET score = '%d', ", score));
        sb.append(String.format("reservation_id = '%d', ", reservation_id));
        sb.append(String.format("writing = '%s', ", writing));
        sb.append(String.format("regDate = now(); "));

        int id = dbConnection.insert(sb.toString());

        return id;
    }

    public List<Review> getReviewAllList() {
        List<Review> reviewList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * FROM review"));

        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for (Map<String, Object> row : rows) {
            reviewList.add(new Review(row));
        }
        return reviewList;
    }

    public void getReviewUserList() {
        List<Review> reviewList = getReviewAllList();

        String user_id = Container.getLoginedUser().getUser_id();
        System.out.println("게시물 번호 / 작성자 / 평점 / 리뷰 내용 / 영화 제목 / 작성일자");
        for (int i = 0; i < reviewList.size(); i++) {
            Review review = reviewList.get(i);
            if (review.getUser_id().equals(user_id)) {
                System.out.printf("%d, %s, %d, %s, %s, %s\n", review.getId(), review.getUser_id(), review.getScore(), review.getWriting(), review.getMovieTitle(), review.getRegDate());
            }
        }
    }

    public void remove(Review review) {
        int id = review.getId();

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("DELETE FROM review "));
        sb.append(String.format("WHERE id = '%d' ", id));

        dbConnection.delete(sb.toString());
    }
    public void modify(Review review, int score, String writing) {
        int id = review.getId();

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("UPDATE review "));
        sb.append(String.format("SET score = '%d', ", score ));
        sb.append(String.format("writing = '%s' ", writing));
        sb.append(String.format("WHERE id = '%d' ", id));

        dbConnection.update(sb.toString());
    }
    public Review getReviewListById(int id) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * "));
        sb.append(String.format("FROM review "));
        sb.append(String.format("WHERE id = '%d' ", id));


        Map<String, Object> row = dbConnection.selectRow(sb.toString());

        Review review = new Review(row);

        return review;
    }
    public Review getReviewUserListById() {
        List<Review> reviewList = getReviewAllList();
        for (int i = 0; i < reviewList.size(); i++) {
            Review review = reviewList.get(i);
            if (review.getUser_id().equals(Container.getLoginedUser().getUser_id())) {
                return review;
            }
        }
        return null;
    }
    public List<Review> getReviewTitleUserListById() {
        List<Review> reviewList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT review.* , "));
        sb.append(String.format("movie.title, `user`.user_id "));
        sb.append(String.format("from review "));
        sb.append(String.format("left join movie_reservation "));
        sb.append(String.format("on review.reservation_id = movie_reservation.id "));
        sb.append(String.format("left join movie "));
        sb.append(String.format("on review.reservation_id = movie.id "));
        sb.append(String.format("left join `user` "));
        sb.append(String.format("on review.reservation_id = `user`.id; "));

        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for (Map<String, Object> row : rows) {
            reviewList.add(new Review(row));
        }
        return reviewList;
    }

    public int checkScore() {
        int score;
        while (true) {
            System.out.print("평점(1~5): ");
            try {
                score = Integer.parseInt(Container.getSc().nextLine());
                if ((score < 1) || (score > 5)) {
                    System.out.println("평점을 1~5사이의 점수로 등록해주세요.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("1에서 5 사이의 정수값을 입력해주세요.");
                continue;
            }
            break;
        }
        return score;
    }
}