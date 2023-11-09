package org.example.review.reviewRepository;

import org.example.Container;
import org.example.db.DBConnection;
import org.example.movie.movieService.MovieService;
import org.example.review.entity.Review;
import org.example.review.entity.UserReview;
import org.example.ticketing.entity.MovieReservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReviewRepository {
    private DBConnection dbConnection;
    MovieService movieService = new MovieService();


    public ReviewRepository () {
        dbConnection = Container.getDBconnection();
    }
    public int create(int score, int reservation_id, String movie_id, String writing, String regDate) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("INSERT INTO review "));
        sb.append(String.format("SET score = '%d', ", score));
        sb.append(String.format("movieTitle = '%s', ", movie_id));
        sb.append(String.format("reservation_id = '%s' , ", reservation_id));
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

    public List<UserReview> getReviewUserList() {
        List<UserReview> reviewList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT R.id, R.reservation_id , R.score , R.writing ,R.regDate , R.movieTitle , `user`.name FROM review AS R "));
        sb.append(String.format("INNER JOIN movie_reservation "));
        sb.append(String.format("ON R.reservation_id = movie_reservation.id "));
        sb.append(String.format("INNER JOIN `user` "));
        sb.append(String.format("ON movie_reservation.user_id = `user`.id = %d " , Container.getLoginedUser().getId()));

        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for (Map<String, Object> row : rows) {
            reviewList.add(new UserReview(row));
        }
        return reviewList;
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
    public boolean isReserved() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * "));
        sb.append(String.format("FROM movie_reservation "));
        sb.append(String.format("WHERE user_id = '%d' ;", Container.getLoginedUser().getId()));

        List<MovieReservation> reservationList = new ArrayList<>();

        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for (Map<String, Object> row : rows) {
            reservationList.add(new MovieReservation(row));
        }


        if(reservationList.size() != 0){
            return true;
        }else {
            return false;
        }
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