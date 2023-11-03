package org.example.movie.repository;

import org.example.Container;
import org.example.movie.entity.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MovieRepository {
    public List<Movie> getMovies() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("SELECT title FROM movie;"));
        List<Movie> movieList = new ArrayList<>();
        List<Map<String, Object>> rows = Container.getDBconnection().selectRows(sb.toString());
        for (Map<String, Object> row : rows) {
            movieList.add(new Movie(row));
        }

        return movieList;
    }

    public Movie getMovie(String number) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("SELECT * FROM movie WHERE id = "));
        sb.append(String.format(number));

        Map <String,Object> map = Container.getDBconnection().selectRow(sb.toString());
        return new Movie(map);

    }
}
