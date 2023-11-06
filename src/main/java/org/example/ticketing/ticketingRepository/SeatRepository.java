package org.example.ticketing.ticketingRepository;

import org.example.Container;
import org.example.db.DBConnection;

public class SeatRepository {
    private DBConnection dbConnection;

    public SeatRepository() {
        dbConnection = Container.getDBconnection();
    }

    public int seat(int seat_x, int seat_y) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("INSERT INTO seat "));
        sb.append(String.format("SET seat_x = '%d', ", seat_x));
        sb.append(String.format("seat_y = '%d'; ", seat_y));

        int id = dbConnection.insert(sb.toString());

        return id;
    }
}
