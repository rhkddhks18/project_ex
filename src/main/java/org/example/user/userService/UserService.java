package org.example.user.userService;

import org.example.Container;
import org.example.user.userRepository.UserRepository;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;


public class UserService {
    UserRepository userRepository = new UserRepository();

    public boolean checkIdList(String userId) {
        return userRepository.checkIdList(userId);
    }

    public void sign(String userId, String userPW, String userName, String userBirth, String email) {
        userRepository.sign(userId, userPW, userName, userBirth, email);
    }

    public boolean login(String id, String pw) {
        return userRepository.login(id,pw);
    }




    public boolean emailCheck(String email) {
        Random random = new Random();
        final String username = "rhkddhks18@gmail.com";
        final String password = "witw mktv cccs fkee";
        int checkNum = random.nextInt(888888) + 111111;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); // Gmail SMTP 서버 주소
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // Gmail SMTP 서버 주소
        props.put("mail.smtp.port", "587"); // Gmail SMTP 포트
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sender", "대전 시네마", StandardCharsets.UTF_8.toString()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("이메일 인증번호 발송");
            message.setText("인증번호는 '" + checkNum + "' 입니다.");

            Transport.send(message);

            System.out.println("이메일이 발송되었습니다. 잘못 입력하셨으면 0을 입력해주세요");
        } catch (MessagingException | UnsupportedEncodingException e) {
            System.out.println("이메일을 다시 입력해주세요.");
            return false;
        }

        Scanner sc = Container.getSc();
        while (true) {
            System.out.print("인증번호: ");
            try {

                int inputAuthNum = Integer.parseInt(sc.nextLine());


                if (inputAuthNum == 0){
                    return false;
                }

                if (inputAuthNum == checkNum) {
                    System.out.println("인증이 완료되었습니다.");
                    return true;
                } else {
                    System.out.println("인증번호가 올바르지 않습니다.");
                }

            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요");
            }
        }
    }
}
