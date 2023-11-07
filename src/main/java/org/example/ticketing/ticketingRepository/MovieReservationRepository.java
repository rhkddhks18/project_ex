package org.example.ticketing.ticketingRepository;

import org.example.Container;
import org.example.db.DBConnection;
import org.example.movie.entity.Movie;
import org.example.ticketing.entity.MovieReservation;

import java.util.Map;

public class MovieReservationRepository {
    private DBConnection dbConnection;


    public MovieReservationRepository() {
        dbConnection = Container.getDBconnection();
    }

    public int seat(int user_id, int schedule_id, int seat_x, int seat_y) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("INSERT INTO movie_reservation "));
        sb.append(String.format("SET user_id = '%d', ", user_id));
        sb.append(String.format("schedule_id = '%d', ", schedule_id));
        sb.append(String.format("seat_x = '%d', ", seat_x));
        sb.append(String.format("seat_y = '%d'; ", seat_y));

        int id = dbConnection.insert(sb.toString());

        return id;
    }
    public MovieReservation getMovie(int schedule_id){
        String selectQuery = "select * from schedule where id = " + schedule_id;

        Map<String, Object> reservData = Container.getDBconnection().selectRow(selectQuery);
        return new MovieReservation(reservData);
    }
}
