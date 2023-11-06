package org.example.movie.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Schedule {
    private int id;
    //편성 번호

    private int movie_id;
    //영화 고유번호

    private int time;
    //상영시간
}
