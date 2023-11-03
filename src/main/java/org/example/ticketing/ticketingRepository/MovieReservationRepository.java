package org.example.ticketing.ticketingRepository;

import org.example.Container;
import org.example.ticketing.entity.MovieReservation;
import org.example.ticketing.entity.Schedule;
import org.example.user.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MovieReservationRepository {

    public void seat(int seatX, int seatY, Schedule time) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO movie_reservation");
        sb.append(String.format("SET user_id = '%s',", Container.getLoginedUser().getId()));
        sb.append(String.format("seat_y = '%s',", seatY));
        sb.append(String.format("seat_x = '%s',", seatX));

        Container.getDBconnection().insert(sb.toString());
    }

    public List<MovieReservation> getReservatedSeat(Schedule time) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("SELECT * FROM MOVIE_RESERVATION WHERE schedule_id = '%s'", time.getId()));
        List<MovieReservation> reservationList = new ArrayList<>();
        List<Map<String, Object>> users = Container.getDBconnection().selectRows(sb.toString());
        for (Map<String, Object> row : users) {
            reservationList.add(new MovieReservation(row));
        }
        return reservationList;
    }
}
