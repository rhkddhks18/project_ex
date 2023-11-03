package org.example.ticketing.ticketingController;

import org.example.Container;
import org.example.ticketing.entity.Schedule;

import java.util.Scanner;

public class MovieReservationController {
    public void reservation() {
        Scanner sc = Container.getSc();
        ScheduleController scheduleController = new ScheduleController();
        SeatController seatController = new SeatController();

        while (true) {
            Schedule selectedSchedule = scheduleController.choice();
            seatController.seat(selectedSchedule);

            System.out.print("예매를 완료하려면 'Y', 취소하려면 'N'을 입력하세요: ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                System.out.println("예매가 완료되었습니다.");
                break;
            } else if (choice.equalsIgnoreCase("N")) {
                System.out.println("예매가 취소되었습니다.");
            }
        }
    }
}
