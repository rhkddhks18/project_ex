package org.example.ticketing.ticketingRepository;

import org.example.Container;
import org.example.db.DBConnection;
import org.example.movie.entity.Movie;
import org.example.ticketing.entity.MovieReservation;
import org.example.ticketing.entity.Schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MovieReservationRepository {
    private DBConnection dbConnection;


    public MovieReservationRepository() {
        dbConnection = Container.getDBconnection();
    }

    public int insertSeat(int user_id, int schedule_id, int seat_x, int seat_y) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("INSERT INTO movie_reservation "));
        sb.append(String.format("SET user_id = '%d', ", user_id));
        sb.append(String.format("schedule_id = '%d', ", schedule_id));
        sb.append(String.format("seat_x = '%d', ", seat_x));
        sb.append(String.format("seat_y = '%d'; ", seat_y));

        int cnt = dbConnection.insert(sb.toString());

        return cnt;
    }
    public List<MovieReservation> getMovieReservation(int schedule_id){
        List<MovieReservation> movieReservations = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("select * from movie_reservation where schedule_id = ").append(schedule_id);

        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());
        for (Map<String, Object> row : rows) {
            movieReservations.add(new MovieReservation(row));
        }
        return movieReservations;
    }

    public int deleteSeat(int id) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("DELETE FROM movie_reservation "));
        sb.append(String.format("WHERE id = '%d' ", id));

        int cnt = dbConnection.delete(sb.toString());

        return cnt;
    }
}
