package org.example.movie.movieService;

import org.example.movie.entity.Movie;
import org.example.movie.movieRepository.MovieRepository;

public class MovieService {
    MovieRepository movieRepository = new MovieRepository();

    public Movie getMovie(int movie_id) {
        return movieRepository.getMovie(movie_id);
    }
}
