package org.example.ticketing.ticketingService;

import org.example.ticketing.entity.MovieReservation;
import org.example.ticketing.ticketingRepository.MovieReservationRepository;

import java.util.List;

public class MovieReservationService {
    MovieReservationRepository movieReservationRepository = new MovieReservationRepository();

    public int insertSeat(int user_id, int schedule_id, int seat_x, int seat_y){
        return this.movieReservationRepository.insertSeat(user_id,schedule_id,seat_x, seat_y);
    }

    public List<MovieReservation> getMovieReservation(int schedule_id) {
        return movieReservationRepository.getMovieReservation(schedule_id);
    }

    public int deleteSeat(int id)
    {
        return this.movieReservationRepository.deleteSeat(id);
    }
}
