package org.example.ticketing.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class MovieReservation {
    private int id;
    private int user_id;
    private int schedule_id;
    private int seat_x;  // 행 (알파벳)
    private int seat_y;  // 열

    public MovieReservation (Map<String, Object> row) {
        this.id = (int) row.get("id");
        this.user_id = (int) row.get("user_id");
        this.schedule_id = (int) row.get("schedule_id");
        this.seat_x = (int) row.get("seat_x");
        this.seat_y = (int) row.get("seat_y");
    }

    public MovieReservation(int user_id, int schedule_id, int seat_x, int seat_y) {
        this.user_id = user_id;
        this.schedule_id = schedule_id;
        this.seat_x = seat_x;
        this.seat_y = seat_y;
    }


    public void setUser_id() {
    }

    public void setSeat_x() {
    }
}
