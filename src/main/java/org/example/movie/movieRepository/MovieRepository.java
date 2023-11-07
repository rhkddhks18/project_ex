package org.example.movie.movieRepository;

import org.example.Container;
import org.example.movie.entity.Movie;

import java.util.Map;

public class MovieRepository {
    public Movie getMovie(int movie_id){
        String selectQuery = "select * from movie where id = " + movie_id;

        Map<String, Object> movieData = Container.getDBconnection().selectRow(selectQuery);
        return new Movie(movieData);
    }
}
