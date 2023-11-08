package org.example.ticketing.ticketingController;

import org.example.Container;
import org.example.ticketing.entity.MovieReservation;
import org.example.ticketing.entity.Schedule;

import java.util.Scanner;

public class MovieReservationController {

    public void reservation(int schedule_id, int movie_id) {
        ScheduleController scheduleController = new ScheduleController();
        MovieSeat movieSeat = new MovieSeat();
        while (true) {
            Schedule scheduleData = scheduleController.choice(movie_id);
            if(scheduleData == null)
            {
                System.out.println("편성표 선택이 잘못 됐습니다.");
                break;
            }
            MovieReservation reservData =  movieSeat.seat(schedule_id);
            reservData.setSchedule_id(scheduleData.getId());


            //예매정보 인서트




//            if(인서트 결과가 성공이면)
            {
                System.out.print("예매를 완료하려면 'Y', 취소하려면 'N'을 입력하세요: ");
                String choice = Container.getSc().nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    System.out.println("예매가 완료되었습니다.");
                    break;
                } else if (choice.equalsIgnoreCase("N")) {
                    System.out.println("예매가 취소되었습니다.");
                }
            }
//            실패
//            else{
        }
    }
}
