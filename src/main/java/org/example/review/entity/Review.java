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

    private String user_id;

    private String movieTitle;

    private int score;

    private String writing;

    private String regDate;

    public Review(Map<String, Object> row) {
        Object idObj = row.get("id");
        this.id = (idObj != null) ? (int) idObj : 0;
        this.movieTitle = (String)row.get("movieTitle");
        Object scoreObj = row.get("score");
        this.score = (scoreObj != null) ? (int) scoreObj : 0;
        this.writing = (String)row.get("writing");
        this.user_id = (String)row.get("user_id");
        this.regDate = (String)row.get("regDate");
    }
}
