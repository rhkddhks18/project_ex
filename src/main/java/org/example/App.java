package org.example;

import org.example.db.DBConnection;
import org.example.movie.controller.MovieController;
import org.example.user.userController.UserController;

import java.util.Scanner;

public class App {
    public App() {
        DBConnection.DB_NAME = "beginner_pro";
        DBConnection.DB_USER = "root";
        DBConnection.DB_PORT = 3306;
        DBConnection.DB_PASSWORD = "";
        Container.getDBconnection().connect();
    }

    public void run() {
        Scanner sc = Container.getSc();
        MovieController movieController = new MovieController();
        UserController userController = new UserController();

        while (true) {

            System.out.println("\n== 대전시네마 ==\n");
            if (Container.getLoginedUser() == null) {
                System.out.println("영화 예매\n로그인\n회원가입\n종료");
            } else {
                System.out.println("영화 예매\n로그아웃\n종료");
            }
            System.out.print("\n명령 ) ");
            String command = sc.nextLine().trim();
            switch (command) {
                case "영화 예매":
                case "영화예매":
                    movieController.run();
                    break;
                case "회원가입":
                    userController.sign();
                    break;
                case "로그인":
                    userController.login();
                    break;
                case "로그아웃":
                    userController.logout();
                    break;

                case "종료":
                    return;

            }
        }
    }
}