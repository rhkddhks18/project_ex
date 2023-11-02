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
    private String user_id;
    //유저 아이디
    private int score;
    //평점

    private String writing;
    //글(한줄평)
    private String regDate;

    public Review(Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.score = (int) row.get("score");
        this.writing = (String) row.get("writing");
        this.user_id = (String)row.get("user_id");
        this.regDate = (String)row.get("regDate");
    }
}
