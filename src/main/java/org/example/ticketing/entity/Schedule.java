package org.example.ticketing.entity;

public class Schedule {
    private int id;
    private String movieTime;

    public Schedule(int id, String movieTime) {
        this.id = id;
        this.movieTime = movieTime;
    }

    public int getId() {
        return id;
    }

    public String getMovieTime() {
        return movieTime;
    }
}
