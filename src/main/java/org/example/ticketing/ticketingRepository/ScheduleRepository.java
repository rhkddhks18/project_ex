package org.example.ticketing.ticketingRepository;

import org.example.Container;
import org.example.db.DBConnection;
import org.example.ticketing.entity.Schedule;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScheduleRepository {
    private DBConnection dbConnection;
    public ScheduleRepository() {
        dbConnection = Container.getDBconnection();
    }

    public List<Schedule> getAllSchedules() {
        List<Schedule> schedules = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        sb.append("SELECT * FROM schedule");

        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for (Map<String, Object> row : rows) {
            int id = (int) row.get("id");
            String movieTime = (String) row.get("movie_time");
            schedules.add(new Schedule(id, movieTime));
        }
        return schedules;
    }
}
