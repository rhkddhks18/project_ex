package org.example.movie.movieService;

import org.example.movie.entity.Movie;
import org.example.movie.repository.MovieRepository;

import java.util.List;

public class MovieService {

    MovieRepository movieRepository = new MovieRepository();

    public List<Movie> getMovies() {
        return movieRepository.getMovies();
    }

    public Movie getMovie(String number) {
        return movieRepository.getMovie(number);
    }
}