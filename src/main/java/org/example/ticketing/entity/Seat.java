package org.example.ticketing.entity;

public class Seat {
    private int id;
    private String seatX;  // 행 (알파벳)
    private String seatY;  // 열
    private boolean reserved;

    public Seat(int id, String seatX, String seatY, boolean reserved) {
        this.id = id;
        this.seatX = seatX;
        this.seatY = seatY;
        this.reserved = reserved;
    }

    public boolean isReserved() {
        return reserved;
    }

    public boolean reserve() {
        reserved = true;

        return this.reserved;
    }

}
