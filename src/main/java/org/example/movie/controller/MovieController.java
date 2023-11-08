package org.example.movie.controller;

import org.example.Container;
import org.example.movie.entity.Movie;

import java.util.*;

public class MovieController {
    public int movie_id = 0;

    public void run() {

        if (Container.getLoginedUser() == null) {
            System.out.println("로그인해야 예매할 수 있습니다");
            return;
        }
        FirstMovieController firstMovieController = new FirstMovieController();

        List<Movie> movieList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("SELECT id, title FROM movie;"));
        List<Map<String, Object>> rows = Container.getDBconnection().selectRows(sb.toString());
        for (Map<String, Object> row : rows) {
            movieList.add(new Movie(row));
        }

        System.out.println("예매하실 영화를 선택해주세요");
        for (Movie movie : movieList) {
            System.out.println(movie.getTitle());
        }
        System.out.print("\n명령 ) ");
        String command = Container.getSc().nextLine();

        //movieList에서 command에 입력한 영화 정보를 찾는다.
        for (Movie movie : movieList) {
            if (movie.getTitle().equals(command))
                movie_id = movie.getId();
        }

        if (movie_id == 0) {
            System.out.println("잘못된 영화를 선택 하셨습니다.");
            return;
        }

        firstMovieController.run(movie_id);
    }

}
