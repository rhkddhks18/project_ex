package org.example.ticketing.ticketingController;

import org.example.Container;
import org.example.ticketing.entity.Schedule;
import org.example.ticketing.ticketingService.ScheduleService;

import java.util.List;
import java.util.Scanner;

public class ScheduleController {

    public Schedule choice(int movie_id) {
        System.out.println("영화 상영 시간표:");
        ScheduleService scheduleService = new ScheduleService();

        List<Schedule> schedules = scheduleService.getAllSchedules(movie_id);


        for (Schedule schedule : schedules) {
            System.out.println(schedule.getMovieTime());
        }

        while (true) {
            System.out.print("영화 시간을 입력하세요: ");
            String selectedTime = Container.getSc().nextLine().trim();

            Schedule selectedSchedule = null;

            for (Schedule schedule : schedules) {
                if (schedule.getMovieTime().equals(selectedTime)) {
                    selectedSchedule = schedule;
                    break;
                }
            }
            if (selectedSchedule != null) {

                System.out.println(selectedTime + "을 선택 하셨습니다. ");
                return selectedSchedule;
            } else {
                System.out.println("올바른 선택이 아닙니다.");
                return null;
            }
        }
    }
}
