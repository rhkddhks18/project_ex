package org.example.user.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {
    private int id;
    //유저고유번호

    private String user_id;
    //유저아이디

    private String password;
    //유저비밀번호

    private String name;
    //유저 이름

    private String birth;
    //유저 생년월일

    private String email;
    //유저 이메일
}
