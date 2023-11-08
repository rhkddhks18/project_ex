package org.example.movie.controller;

import org.example.Container;
import org.example.movie.entity.Movie;
import org.example.movie.movieService.MovieService;
import org.example.review.reviewController.ReviewController;
import org.example.ticketing.ticketingController.MovieReservationController;
import org.example.ticketing.ticketingService.MovieReservationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FirstMovieController {
    ReviewController reviewController = new ReviewController();
    MovieController movieController = new MovieController();
    MovieReservationController movieReservationController = new MovieReservationController();
    MovieService movieService = new MovieService();

    public void run(int movie_id) {
        while (true) {
            System.out.println("-".repeat(30));

           Movie movieData = movieService.getMovie(movie_id);

            System.out.println("== " + movieData.getTitle() + " ==");
            System.out.printf("감독 : %s \n배우 : %s \n장르 : %s\n\n", movieData.getDirector(), movieData.getActor(), movieData.getGenre());
            System.out.println("예매하기\n리뷰작성\n리뷰게시판\n리뷰삭제\n리뷰수정\n돌아가기");
            System.out.println("-".repeat(30));
            String command = Container.getSc().nextLine().trim();
            switch (command) {
                case "돌아가기":
                    return;
                case "예매하기":
                    movieReservationController.reservation(movie_id);
                    break;
                case "리뷰작성":
                    reviewController.write();
                    break;
                case "리뷰게시판":
                    reviewController.list();
                    break;
                case "리뷰삭제":
                    reviewController.remove();
                    break;
                case "리뷰수정":
                    reviewController.modify();
                    break;
            }
        }
    }

}
