package org.example.movie.controller;

import org.example.Container;
import org.example.movie.entity.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MovieController {
    public void run() {

        if (Container.getLoginedUser() == null){
            System.out.println("로그인해야 예매할 수 있습니다");
            return;
        }
        FirstMovieController firstMovieController = new FirstMovieController();
        SecondMovieController secondMovieController = new SecondMovieController();
        ThirdMovieController thirdMovieController = new ThirdMovieController();
        Scanner sc = Container.getSc();

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("SELECT title FROM movie;"));
        List<Movie> movieList = new ArrayList<>();
        List<Map<String, Object>> rows = Container.getDBconnection().selectRows(sb.toString());
        for (Map<String, Object> row : rows) {
            movieList.add(new Movie(row));
        }
        List<String> movieNameList = new ArrayList<>();
        System.out.println("예매하실 영화를 선택해주세요");
        for (Movie movie : movieList) {
            System.out.println(movie.getTitle());
            movieNameList.add(movie.getTitle());
        }
        System.out.print("\n명령 ) ");
        String command = sc.nextLine();
//
        if (command.equals(movieNameList.get(0))) {
            firstMovieController.run();
        }

        if (command.equals(movieNameList.get(1))) {
            secondMovieController.run();
        }

        if (command.equals(movieNameList.get(2))) {
            thirdMovieController.run();
        }
    }
}
