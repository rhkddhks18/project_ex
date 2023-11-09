package org.example.review.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Review {
    private int id;
    //리뷰 id(고유번호)
    private int reservation_id;
    //유저 아이디
    //영화
    private int score;
    //평점
    private String writing;
    //글(한줄평)
    private String regDate;

    private String movie_title;

    private String userId;

    private String userName;


    public Review(Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.score = (int) row.get("score");
        this.movie_title = (String) row.get("movie_title");
        this.userId = (String) row.get("userId");
        this.writing = (String) row.get("writing");
        this.reservation_id = (int)row.get("reservation_id");
        this.regDate = (String)row.get("regDate");
        this.userName = (String) row.get("userName");
    }
}
