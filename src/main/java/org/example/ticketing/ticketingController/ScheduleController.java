package org.example.ticketing.ticketingController;

import org.example.ticketing.entity.Schedule;
import org.example.ticketing.ticketingService.ScheduleService;

import java.util.List;
import java.util.Scanner;

public class ScheduleController {

    public void choice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("영화 상영 시간표:");
        ScheduleService scheduleService = new ScheduleService();
        List<Schedule> schedules = scheduleService.getAllSchedules();

        for (Schedule schedule : schedules) {
            System.out.println(schedule.getId() + ". " + schedule.getMovieTime());
        }

        while (true) {
            System.out.print("영화 시간을 선택하세요 (1, 2, 3, 4): ");
            int selectedTimeId = sc.nextInt();

            Schedule selectedSchedule = null;
            for (Schedule schedule : schedules) {
                if (schedule.getId() == selectedTimeId) {
                    selectedSchedule = schedule;
                    break;
                }
            }
            if (selectedSchedule != null) {
                String selectedTime = selectedSchedule.getMovieTime();
                System.out.println(selectedTime + "을 선택 하셨습니다. ");
                break;
            } else {
                System.out.println("올바른 선택이 아닙니다.");
            }
        }
    }
}
