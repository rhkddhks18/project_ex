package org.example.review.reviewRepository;

import org.example.Container;
import org.example.db.DBConnection;
import org.example.review.entity.Review;
import org.example.review.entity.UserReview;
import org.example.ticketing.entity.MovieReservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReviewRepository {
    private DBConnection dbConnection;

    public ReviewRepository () {
        dbConnection = Container.getDBconnection();
    }
    public int create(int score, String writing, int user_id, String regDate) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("INSERT INTO review "));
        sb.append(String.format("SET score = '%d', ", score));
        sb.append(String.format("writing = '%s', ", writing));
        sb.append(String.format("user_id = '%s' , ", user_id));
        sb.append(String.format("movie_id = '%s' , ", Container.getSelectedMovie().getId()));
        sb.append(String.format("regDate = now(); "));

        int id = dbConnection.insert(sb.toString());

        return id;
    }

    public List<UserReview> getReviewAllList() {
        List<UserReview> reviewList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT R.id,`user`.name,R.score,R.writing,R.regDate from review as R inner join `user` on R.user_id = `user`.id AND movie_id = '%s';",Container.getSelectedMovie().getId()));

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
        sb.append(String.format("WHERE user_id = '%d' AND movie_id = '%d';",Container.getLoginedUser().getId(),Container.getSelectedMovie().getId() ));



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

    public List<UserReview> getReviewThisUserList() {
        List<UserReview> reviewList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT R.id,`user`.name,R.score,R.writing,R.regDate from review as R inner join `user` on R.user_id = `user`.id = '%s' AND movie_id = '%s';",Container.getLoginedUser().getId(),Container.getSelectedMovie().getId()));

        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for (Map<String, Object> row : rows) {
            reviewList.add(new UserReview(row));
        }
        return reviewList;
    }
}