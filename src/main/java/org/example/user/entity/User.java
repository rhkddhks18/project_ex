package org.example.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
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

    public User(Map<String, Object> row) {
        this.id = (int) row.get("id");
        this.user_id = (String) row.get("user_id");
        this.password = (String) row.get("password");
        this.name = (String) row.get("name");
        this.birth = (String) row.get("birth");
        this.email = (String) row.get("email");
    }


    //유저 이메일
}
