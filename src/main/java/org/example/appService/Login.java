package org.example.appService;

import org.example.Container;

import java.util.Scanner;

public class Login {
    Scanner sc = Container.getSc();
    boolean islogin = false;
    public void loginPage (){
        if (islogin == true){
            System.out.println("로그인 되었습니다.");
            return;
        }



        while (true){

            if (islogin == true) {
                System.out.println("로그인 되었습니다.");
                break;
            }
            System.out.println("1번 로그인 2번 회원가입.");
            String command = sc.nextLine();

            if (command.equals("1")){
                System.out.println("id 입력");
                String userId = sc.nextLine();
                System.out.println("비밀번호 입력");
                String userPW = sc.nextLine();
                //대충 DB에서 아이디 비밀번호 확인하는 내용
                if (userId.equals("1234") && userPW.equals("1234")){
                    islogin = true;
                }

            }
            if (command.equals("2")){
                System.out.println("id입력");
                String userId = sc.nextLine();
                while(true){
                    System.out.println("비밀번호 입력");
                    String userPW = sc.nextLine();
                    System.out.println("비밀번호 확인");
                    String userPWcheck = sc.nextLine();

                    if (userPW.equals(userPWcheck)){
                        System.out.println("생성이 완료되었습니다");
                        // 대충 db에 집어넣는 내용 ++
                        break;
                    }else {
                        System.out.println("비밀번호가 다릅니다 다시 입력해주세요.");
                    }
                }


            }

        }
    }

}
