package org.example.movie.controller;

import org.example.Container;
import org.example.movie.entity.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MovieController {


    public void run() {

        if (Container.getLoginedUser() == null){
            System.out.println("로그인해야 예매할 수 있습니다");
            return;
        }
        if (Container.getSelectedMovieTitle() != null) {
            Container.setSelectedMovieTitle(null);
        }
        SelectedMovieController selectedMovieController = new SelectedMovieController();

        System.out.println("예매하실 영화를 선택해주세요");
        List<Movie> movieList = getMovieTitle();
        List<String> movieNameList = new ArrayList<>();
        for (Movie movie : movieList) {
            System.out.println(movie.getTitle());
            movieNameList.add(movie.getTitle());
        }
        System.out.print("\n명령 ) ");
        String command = Container.getSc().nextLine();
        selectedMovie(command);
        if (command.equals(movieNameList.get(0))) {
            selectedMovieController.run();
        }

        if (command.equals(movieNameList.get(1))) {
            selectedMovieController.run();
        }

        if (command.equals(movieNameList.get(2))) {
            selectedMovieController.run();
        }
    }
    public List<Movie> getMovieTitle() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("SELECT title FROM movie;"));
        List<Movie> movieList = new ArrayList<>();
        List<Map<String, Object>> rows = Container.getDBconnection().selectRows(sb.toString());
        for (Map<String, Object> row : rows) {
            movieList.add(new Movie(row));
        }
        return movieList;
    }
    public boolean selectedMovie(String command) {
        boolean isMovieSelected = false;
        List<Movie> movieList = getMovieTitle();
        for (Movie movie : movieList) {
            if (command.equals(movie.getTitle())) {
                isMovieSelected = true;
                Container.setSelectedMovieTitle(command);
                break;
            }
        } return isMovieSelected;
    }
}
