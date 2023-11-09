package org.example.review.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
public class UserReview {
    private int id;
    private int score;
    private String writing;
    private String regDate;
    private String name;
    private String movie_title;

    public UserReview(Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.score = (int) row.get("score");
        this.writing = (String) row.get("writing");
        this.regDate = (String)row.get("regDate");
        this.name = (String)row.get("name");
        this.movie_title = (String)row.get("movie_title");
    }
}
