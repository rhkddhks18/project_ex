package org.example.ticketing.entity;

import lombok.Getter;

public class Schedule {
    @Getter
    private int id;
    private int movie_id;
    private String movieTime;

    public Schedule(int id, int movie_id, String movieTime) {
        this.id = id;
        this.movie_id = movie_id;
        this.movieTime = movieTime;
    }


    public String getMovieTime() {
        return movieTime;
    }
}
