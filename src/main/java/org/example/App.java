package org.example;

import org.example.appService.AppService;
import org.example.systemService.SystemService;

public class App {
    SystemService systemService = new SystemService();
    AppService appService = new AppService();

    public void run() {
        System.out.println("== 대전시네마 ==");

        while (true) {
            systemService.menu();
            System.out.print("명령) ");
            String command = Container.getSc().nextLine();

            if (command.equals("1") || command.equals("인셉션")) {
                appService.firstMovie();
            }

            if (command.equals("2") || command.equals("인터스텔라")) {
                appService.secondMovie();
            }

            if (command.equals("3") || command.equals("타임 패러독스")) {
                appService.thirdMovie();
            }

            if (command.equals("4") || command.equals("로그인")) {
                appService.loginpage();
            }


            if (command.equals("5") || command.equals("종료")) {
                systemService.appClose();
                break;
            }

        }
    }
}
