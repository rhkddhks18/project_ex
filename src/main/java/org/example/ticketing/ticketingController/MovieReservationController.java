package org.example.ticketing.ticketingController;

import java.util.Scanner;

public class MovieReservationController {
    public void reservation() {
        Scanner sc = new Scanner(System.in);
        ScheduleController scheduleController = new ScheduleController();
        SeatController seatController = new SeatController();
        while (true) {
            scheduleController.choice();
            seatController.seat();

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
