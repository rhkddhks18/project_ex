package org.example.ticketing.entity;

public class Seat {
    private int id;
    private int seat_x;  // 행 (알파벳)
    private int seat_y;  // 열


    public Seat(int id, int seat_x, int seat_y) {
        this.id = id;
        this.seat_x = seat_x;
        this.seat_y = seat_y;
    }



}
