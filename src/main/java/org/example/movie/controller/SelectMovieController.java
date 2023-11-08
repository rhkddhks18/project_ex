package org.example.movie.controller;

import org.example.Container;
import org.example.movie.entity.Movie;
import org.example.movie.service.MovieService;
import java.util.ArrayList;
import java.util.List;

public class SelectMovieController {
    public void run() {

        if (Container.getLoginedUser() == null) {
            System.out.println("로그인해야 예매할 수 있습니다");
            return;
        }
        MovieController MovieController = new MovieController();
        MovieService movieService = new MovieService();

        List<Movie> movieList = movieService.getMovies();
        List<String> movieNameList = new ArrayList<>();
        System.out.println("예매하실 영화를 선택해주세요");
        for (Movie movie : movieList) {
            System.out.println(movie.getTitle());
            movieNameList.add(movie.getTitle());
        }
        System.out.print("\n입력 ) ");
        String command = Container.getSc().nextLine();

        if (command.equals(movieNameList.get(0))) {
            Container.setSelectedMovie(movieList.get(0));
            MovieController.run();
        }

        if (command.equals(movieNameList.get(1))) {
            Container.setSelectedMovie(movieList.get(1));
            MovieController.run();
        }

        if (command.equals(movieNameList.get(2))) {
            Container.setSelectedMovie(movieList.get(2));
            MovieController.run();
        }
    }
}
