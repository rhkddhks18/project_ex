package org.example.ticketing.ticketingController;

import org.example.Container;
import org.example.ticketing.entity.Seat;
import org.example.ticketing.ticketingRepository.SeatRepository;
import org.example.ticketing.ticketingService.SeatService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SeatController {
    SeatService seatService = new SeatService();
    public void seat() {


        int seatRow = 7;   // 행
        int seatCol = 10;  // 열

        char[][] seats = new char[seatRow][seatCol];
        for (int i = 0; i < seatRow; i++) {
            for (int j = 0; j < seatCol; j++) {
                seats[i][j] = 'O';
            }
        }

        System.out.println("좌석 선택을 시작합니다.");

        while (true) {
            System.out.println("현재 좌석 상태:");
            displaySeat(seats);

            int seat_y;
            char seat_x = 0;

            try {
                System.out.print("열 번호를 선택하세요 (1-" + seatCol + ") 또는 '0'을 입력하여 종료: ");
                seat_y = Container.getSc().nextInt();
                if (seat_y == 0) {
                    System.out.println("좌석 선택을 취소합니다.");
                    break;
                }

                System.out.print("행 번호를 선택하세요 (A-" + (char) ('A' + seatRow - 1) + "): ");
                seat_x = Container.getSc().next().charAt(0);

                int id = seatService.seat(seat_x, seat_y);
                if (seat_y < 1 || seat_y > seatCol || seat_x < 'A' || seat_x > (char) ('A' + seatRow - 1)) {
                    System.out.println("잘못된 좌석을 선택하셨습니다. 다시 선택하세요.");
                    continue;
                }

                int rowIndex = seat_x - 'A';
                if (seats[rowIndex][seat_y - 1] == 'X') {
                    System.out.println("이미 예매된 좌석입니다. 다른 좌석을 선택하세요.");
                    continue;
                }

                seats[rowIndex][seat_y - 1] = 'X';
                displaySeat(seats);
                System.out.printf("%s%d 좌석이 예매되었습니다.", seat_x, seat_y);
                break;
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자 또는 알파벳을 다시 입력하세요.");
                Container.getSc().nextLine();
            }
        }
    }

    public static void displaySeat(char[][] seats) {
        for (int i = 1; i <= seats[0].length; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();

        for (int i = 0; i < seats.length; i++) {
            System.out.print((char) ('A' + i) + " ");

            for (char c : seats[i]) {
                if (c == 'O') {
                    System.out.print("[ ] ");
                } else if (c == 'X') {
                    System.out.print("[X] ");
                }
            }
            System.out.println();
        }
    }
}