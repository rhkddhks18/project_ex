package org.example.movie.controller;

import org.example.Container;
import org.example.movie.entity.Movie;
import org.example.movie.service.MovieService;
import org.example.review.reviewController.ReviewController;
import org.example.ticketing.ticketingController.MovieReservationController;

public class MovieController {
    ReviewController reviewController = new ReviewController();
    MovieReservationController movieReservationController = new MovieReservationController();
    MovieService movieService = new MovieService();
    public void run() {

        while (true) {
            System.out.println("-".repeat(30));
            System.out.printf("== %s == \n", Container.getSelectedMovie().getTitle());
            System.out.printf("감독 : %s \n배우 : %s \n장르 : %s\n\n", Container.getSelectedMovie().getDirector(), Container.getSelectedMovie().getActor(), Container.getSelectedMovie().getGenre());
            System.out.println("예매하기\n리뷰작성\n리뷰게시판\n리뷰삭제\n리뷰수정\n돌아가기");
            System.out.println("-".repeat(30));
            System.out.print("입력 ) ");
            String command = Container.getSc().nextLine().trim();

            switch (command) {
                case "돌아가기":
                    return;
                case "예매하기":
                    movieReservationController.reservation();
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
