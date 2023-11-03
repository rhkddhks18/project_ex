package org.example.ticketing.ticketingService;

import org.example.ticketing.entity.MovieReservation;
import org.example.ticketing.entity.Schedule;
import org.example.ticketing.ticketingRepository.MovieReservationRepository;

import java.util.List;

public class MovieReservationService {

    MovieReservationRepository movieReservationRepository = new MovieReservationRepository();

    public List<MovieReservation> getReservatedSeat(Schedule time) {
         return movieReservationRepository.getReservatedSeat(time);
    }
}
