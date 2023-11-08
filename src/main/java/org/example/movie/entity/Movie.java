package org.example.movie.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class Movie {
    private int id;
    private String title;
    private String director;
    private String actor;
    private String genre;

    public Movie (Map<String, Object> row) {
        this.id = (int) row.get("id");
        this.title = (String) row.get("title");
    }

}

