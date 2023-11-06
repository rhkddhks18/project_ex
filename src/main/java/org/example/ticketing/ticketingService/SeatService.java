package org.example.ticketing.ticketingService;

import org.example.ticketing.entity.Seat;
import org.example.ticketing.ticketingRepository.SeatRepository;

public class SeatService {
    SeatRepository seatRepository = new SeatRepository();

    public int seat(int seat_x, int seat_y){
        return this.seatRepository.seat(seat_x, seat_y);
    }
}
