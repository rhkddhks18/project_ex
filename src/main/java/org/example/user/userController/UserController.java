package org.example.user.userController;

import org.example.Container;
import org.example.user.userService.UserService;

import java.util.Scanner;

public class UserController {
    Scanner sc = Container.getSc();
    UserService userService = new UserService();

    public void sign() {
        if (Container.getLoginedUser() != null){
            return;
        }

        String userId;
        String userPW;
        String userPWCheck;
        String userName;
        String userBirth;
        String email;

        System.out.println("사용하실 아이디를 입력해주세요");

        while (true) {
            System.out.print("입력 ) ");
            userId = sc.nextLine();
            if (userService.checkIdList(userId)) {
                break;
            } else {
                System.out.println("이미 사용중인 아이디입니다. 다시 입력해주세요");
            }
        }

        System.out.println("사용하실 비밀번호를 입력해주세요");
        while (true) {
            System.out.print("입력 ) ");
            userPW = sc.nextLine();
            System.out.println("비밀번호를 확인해주세요");
            System.out.print("입력 ) ");
            userPWCheck = sc.nextLine();

            if (!userPW.equals(userPWCheck)) {
                System.out.println("비밀번호가 다릅니다. 다시 입력해주세요");
                userPW = null;
            }
            if (userPW != null) {
                break;
            }
        }

        while (true) {
            System.out.println("성함을 알려주세요");
            System.out.print("입력 ) ");
            userName = sc.nextLine();
            System.out.println(userName + "님 맞나요? (Y/N)");
            String check;
            while (true) {
                System.out.print("입력 ) ");
                check = sc.nextLine();
                if (check.equals("y") || check.equals("Y") || check.equals("n") || check.equals("N")){
                    break;
                }
            }
            if (check.equals("y") || check.equals("Y")) {
                break;
            }
        }

        while (true) {
            System.out.println("생년월일을 알려주세요 ex) 96.05.16 ");
            System.out.print("입력 ) ");
            userBirth = sc.nextLine();
            System.out.println(userBirth + " 맞나요?? (Y/N)");
            String check;
            while (true) {
                System.out.print("입력 ) ");
                 check = sc.nextLine();
                if (check.equals("y") || check.equals("Y") || check.equals("n") || check.equals("N")){
                    break;
                }
            }

            if (check.equals("y") || check.equals("Y")) {
                break;
            }
        }

        while (true) {
            System.out.println("이메일을 알려주세요");
            System.out.print("입력 ) ");
            email = sc.nextLine();
            if (userService.emailCheck(email)) {
                break;
            }
        }

        userService.sign(userId, userPW, userName, userBirth, email);

        System.out.println("회원가입이 완료되었습니다!");
    }

    public void login() {
        if (Container.getLoginedUser() != null){
            return;
        }
        System.out.println("아이디를 입력해주세요");
        System.out.print("입력 ) ");
        String ID = sc.nextLine();

        System.out.println("비밀번호를 입력해주세요");
        System.out.print("입력 ) ");
        String PW = sc.nextLine();

        if(userService.login(ID,PW)){
            System.out.println(Container.getLoginedUser().getName() + " 님 안녕하세요!");
        }else {
            System.out.println("회원정보가 없습니다.");
        }
    }

    public void logout() {
        if (Container.getLoginedUser() == null){
            return;
        }
        Container.setLoginedUser(null);
    }
}
