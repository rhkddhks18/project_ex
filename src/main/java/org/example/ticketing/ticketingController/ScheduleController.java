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

        int cnt = 1;
        for (Schedule schedule : schedules) {
            System.out.println((cnt++) + ". " + schedule.getMovieTime());
        }

        while (true) {
            String info = "영화 시간을 입력하세요: (";

            for(int i = 1; i <= schedules.size(); i++){
                if(i == schedules.size())
                    info += i;
                else
                    info += i + ", ";
            }

            System.out.print(info + ") : ");

            int selectedTime = Container.getSc().nextInt();;

            Schedule selectedSchedule = schedules.get(selectedTime - 1);

            if (selectedSchedule != null) {
                System.out.println(selectedSchedule.getMovieTime() + "을 선택 하셨습니다. ");
                return selectedSchedule;
            } else {
                System.out.println("올바른 선택이 아닙니다.");
                return null;
            }
        }
    }
}
