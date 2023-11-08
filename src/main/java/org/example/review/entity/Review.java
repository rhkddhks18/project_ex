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

    private int reservation_id;

    private int score;

    private String writing;

    private String regDate;

    private String title;

    private String user_id;

    public Review(Map<String, Object> row) {
        Object idObj = row.get("id");
        this.id = (idObj != null) ? (int) idObj : 0;
        Object scoreObj = row.get("score");
        this.score = (scoreObj != null) ? (int) scoreObj : 0;
        this.writing = (String)row.get("writing");
        this.regDate = (String)row.get("regDate");
    }
}
