package org.example.ticketing.ticketingService;

import org.example.movie.entity.Movie;
import org.example.ticketing.entity.MovieReservation;
import org.example.ticketing.ticketingRepository.MovieReservationRepository;

public class MovieReservationService {
    MovieReservationRepository movieReservationRepository = new MovieReservationRepository();

    public int seat(int user_id, int schedule_id, int seat_x, int seat_y){
        return this.movieReservationRepository.seat(user_id,schedule_id,seat_x, seat_y);
    }

    public MovieReservation getMovie(int schedule_id) {
        return movieReservationRepository.getMovie(schedule_id);
    }
}
