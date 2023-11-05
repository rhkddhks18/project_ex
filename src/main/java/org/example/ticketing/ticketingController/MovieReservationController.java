package org.example.ticketing.ticketingController;

import org.example.Container;
import org.example.ticketing.entity.MovieReservation;
import org.example.ticketing.entity.Schedule;
import org.example.ticketing.ticketingService.MovieReservationService;

import java.util.Scanner;

public class MovieReservationController {
    public void reservation() {
        Scanner sc = Container.getSc();
        ScheduleController scheduleController = new ScheduleController();
        SeatController seatController = new SeatController();
        MovieReservationService movieReservationService = new MovieReservationService();
        while (true) {

            Schedule selectedSchedule = scheduleController.choice();
            if (selectedSchedule == null) {
                break;
            }

            MovieReservation reservedSeat = seatController.seat(selectedSchedule);
            if (reservedSeat == null) {
                continue;
            }

            System.out.print("예매를 완료하려면 'Y', 취소하려면 'N'을 입력하세요: ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                System.out.println("예매가 완료되었습니다.");
                movieReservationService.reservation(reservedSeat);
                break;
            } else if (choice.equalsIgnoreCase("N")) {
                System.out.println("예매가 취소되었습니다.");
            }
        }
    }
}
