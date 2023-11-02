package org.example.movie.controller;

import org.example.Container;
import org.example.review.reviewController.ReviewController;

public class ThirdMovieController {
    ReviewController reviewController = new ReviewController();
    MovieController movieController = new MovieController();
//    TicketingController ticketingController = new TicketingController();

    public void run() {
        while (true) {
            System.out.println("-".repeat(30));
            System.out.println("== 타임 패러독스 ==");
            System.out.println("예매하기\n리뷰작성\n리뷰게시판\n리뷰삭제\n리뷰수정\n돌아가기");
            System.out.println("-".repeat(30));
            String command = Container.getSc().nextLine().trim();
            switch (command) {
                case "돌아가기":
                    movieController.run();
                case "예매하기":
//                    ticketingController.run();
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
