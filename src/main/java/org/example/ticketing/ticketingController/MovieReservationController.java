package org.example.ticketing.ticketingController;

import org.example.Container;
import org.example.ticketing.entity.MovieReservation;
import org.example.ticketing.entity.Schedule;
import org.example.ticketing.ticketingService.MovieReservationService;

import java.util.Scanner;

public class MovieReservationController {

    public void reservation(int movie_id) {
        Scanner input = new Scanner(System.in);

        ScheduleController scheduleController = new ScheduleController();
        MovieSeat movieSeat = new MovieSeat();
        while (true) {
            Schedule scheduleData = scheduleController.choice(movie_id);
            if(scheduleData == null)
            {
                System.out.println("편성표 선택이 잘못 됐습니다.");
                break;
            }
            int reserveId =  movieSeat.seat(scheduleData.getId());

            if(reserveId > 0)
            {
                System.out.print("예매를 완료하려면 'Y', 취소하려면 'N'을 입력하세요: ");
                String selectYN = input.nextLine();

                if (selectYN.equalsIgnoreCase("Y")) {
                    System.out.println("예매가 완료되었습니다.");
                    break;
                } else if (selectYN.equalsIgnoreCase("N")) {
                    MovieReservationService movieReservationService = new MovieReservationService();
                    int cnt = movieReservationService.deleteSeat(reserveId);

                    if(cnt > 0)
                        System.out.println("예매가 취소 되었습니다.");
                    else
                        System.out.println("예매가 취소에 실패 했습니다.");
                }
            }
            else
            {
                System.out.println("예매에 실패 했습니다.");
            }
//            실패
//            else{
        }
    }
}