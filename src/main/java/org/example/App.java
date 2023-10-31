package org.example;

import org.example.db.DBConnection;
import org.example.movie.controller.FirstMovieController;
import org.example.movie.controller.SecondMovieController;
import org.example.movie.controller.ThirdMovieController;
import org.example.movie.entity.Movie;
import org.example.user.userController.UserController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        FirstMovieController firstMovieController = new FirstMovieController();
        SecondMovieController secondMovieController = new SecondMovieController();
        ThirdMovieController thirdMovieController = new ThirdMovieController();
        UserController userController = new UserController();
        System.out.println("== 대전시네마 ==\n");

        while (true) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("SELECT title FROM movie;"));
            List<Movie> movieList = new ArrayList<>();
            List<Map<String, Object>> rows = Container.getDBconnection().selectRows(sb.toString());
            for (Map<String, Object> row : rows) {
                movieList.add(new Movie(row));
            }
            List<String>movieNameList = new ArrayList<>();
            for (Movie movie : movieList) {
                System.out.println(movie.getTitle());
                movieNameList.add(movie.getTitle());
            }
            System.out.println("로그인\n회원가입\n로그아웃");
            System.out.print("\n명령 ) ");
            String command = sc.nextLine();

            if (command.equals(movieNameList.get(0))){
                firstMovieController.run();
            }

            if (command.equals(movieNameList.get(1))){
                secondMovieController.run();
            }

            if (command.equals(movieNameList.get(2))){
                thirdMovieController.run();
            }

            if (command.equals("회원가입")){
                userController.sign();
            }

            if (command.equals("로그인")){
                userController.login();
            }

            if (command.equals("로그아웃")){
                userController.logout();
            }

        }
    }
}
