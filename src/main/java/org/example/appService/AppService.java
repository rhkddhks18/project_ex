package org.example.appService;

import org.example.Container;

import java.util.Scanner;

public class AppService {
    Login login = new Login();
    Review review = new Review();
    Ticketing ticketing = new Ticketing();
    Scanner sc = Container.getSc();

    public void firstMovie() {
        // 대충 db에서 정보 가져오는 내용 ( 제목 감독 장르 배우)
        System.out.println("제목 : ㄱㄱ");
        System.out.println("감독 : ㄱㄱ");
        System.out.println("장르 : ㄱㄱ");
        System.out.println("배우 : ㄱㄱ,ㄴㄴ,ㄷㄷ,ㄹㄹ");
        System.out.println("1번 리뷰 2번 예매");
        String command = sc.nextLine();
        if (command.equals("1")){
            review.run();
        }
        if (command.equals("2")){
            ticketing.run();
        }
    }

    public void secondMovie() {
        // 대충 db에서 정보 가져오는 내용 ( 제목 감독 장르 배우)
        System.out.println("제목 : ㄱㄱ");
        System.out.println("감독 : ㄱㄱ");
        System.out.println("장르 : ㄱㄱ");
        System.out.println("배우 : ㄱㄱ,ㄴㄴ,ㄷㄷ,ㄹㄹ");
        System.out.println("1번 리뷰 2번 예매");
        String command = sc.nextLine();
        if (command.equals("1")){
            review.run();
        }
        if (command.equals("2")){
            ticketing.run();
        }
    }

    public void thirdMovie() {
        // 대충 db에서 정보 가져오는 내용 ( 제목 감독 장르 배우)
        System.out.println("제목 : ㄱㄱ");
        System.out.println("감독 : ㄱㄱ");
        System.out.println("장르 : ㄱㄱ");
        System.out.println("배우 : ㄱㄱ,ㄴㄴ,ㄷㄷ,ㄹㄹ");
        System.out.println("1번 리뷰 2번 예매");
        String command = sc.nextLine();
        if (command.equals("1")){
            review.run();
        }
        if (command.equals("2")){
            ticketing.run();
        }
    }

    public void loginpage() {
        login.loginPage();
    }
}
