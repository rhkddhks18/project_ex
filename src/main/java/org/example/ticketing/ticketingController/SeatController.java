package org.example.ticketing.ticketingController;

import org.example.ticketing.entity.MovieReservation;
import org.example.ticketing.entity.Schedule;
import org.example.ticketing.entity.Seat;
import org.example.ticketing.ticketingRepository.MovieReservationRepository;
import org.example.ticketing.ticketingService.MovieReservationService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SeatController {

    public void seat(Schedule time) {

        Scanner sc = new Scanner(System.in);

        MovieReservationService movieReservationService = new MovieReservationService();
        int seatX = 7;
        int seatY = 10;
        Seat[][] seats = new Seat[seatX][seatY];

        int seatId = 1;
        for (int i = 0; i < seatX; i++) {
            for (int j = 0; j < seatY; j++) {
                String seatXList = String.valueOf((char) ('A' + i));
                String seatYList = String.valueOf(j + 1);
                seats[i][j] = new Seat(seatId, seatXList, seatYList, false);
                seatId++;
            }
        }


        List<MovieReservation> reservedSeat = movieReservationService.getReservatedSeat(time);
        for (MovieReservation movieReservation : reservedSeat) {
            seats[movieReservation.getSeat_x()][movieReservation.getSeat_y()].reserve();
        }



        System.out.println("좌석 선택을 시작합니다.");

        while (true) {
            System.out.println("현재 좌석 상태:");
            displaySeat(seats);

            int seatYChoice;
            String seatXChoice;

            try {
                System.out.print("좌석을 선택하세요 (1-" + seatY + ") 또는 '0'을 입력하여 종료: ");
                seatYChoice = Integer.parseInt(sc.nextLine());
                if (seatYChoice == 0) {
                    System.out.println("좌석 선택을 취소합니다.");
                    break;
                }
                System.out.print("좌석을 선택하세요 (A-" + (char) ('A' + seatX - 1) + "): ");
                seatXChoice = sc.nextLine();

                if (seatYChoice < 1 || seatYChoice > seatY || seatXChoice.length() != 1 || seatXChoice.charAt(0) < 'A' || seatXChoice.charAt(0) > (char) ('A' + seatX - 1)) {
                    System.out.println("잘못된 좌석을 선택하셨습니다. 다시 선택하세요.");
                    continue;
                }
                int rowIndex = seatXChoice.charAt(0) - 'A';
                if (seats[rowIndex][seatYChoice - 1].isReserved()) {
                    System.out.println("이미 예매된 좌석입니다. 다른 좌석을 선택하세요.");
                    continue;
                }

                seats[rowIndex][seatYChoice - 1].reserve();
                displaySeat(seats);
                System.out.printf("%s 열 %d 번 좌석을 선택하셨습니다.\n", seatXChoice, seatYChoice);
                break;

            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                sc.nextLine();
            }
        }

    }

    public static void displaySeat(Seat[][] seats) {
        for (int i = 1; i <= seats[0].length; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();

        for (int i = 0; i < seats.length; i++) {
            System.out.print((char) ('A' + i) + " ");

            for (Seat seat : seats[i]) {
                if (seat.isReserved()) {
                    System.out.print("[X] ");
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.println();
        }
    }
}