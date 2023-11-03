package org.example.ticketing.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor


public class MovieReservation {
    private int id;
    private int seat_x;
    private int seat_y;
    private int user_id;

    public MovieReservation(Map<String, Object> row) {
        this.seat_x = (int)row.get("seat_x");
        this.seat_y = (int)row.get("seat_y");
        this.user_id = (int)row.get("user_id");
        this.id=(int)row.get("id");
    }
}

