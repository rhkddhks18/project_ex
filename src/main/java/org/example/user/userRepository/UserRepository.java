package org.example.user.userRepository;

import org.example.Container;
import org.example.user.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserRepository {
    public UserRepository() {
    }

    public boolean checkIdList(String userId) {
        boolean canUseId = true;
        String str = "SELECT * FROM `USER`";
        List<User> userList = new ArrayList<>();
        List<Map<String, Object>> users = Container.getDBconnection().selectRows(str);

        for (Map<String, Object> row : users) {
            userList.add(new User(row));
        }

        for (User user : userList) {
            if (userId.equals(user.getUser_id())) {
                canUseId = false;
                break;
            }
        }
        return canUseId;
    }

    public void sign(String userId, String userPW, String userName, String userBirth, String email) {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("INSERT INTO `user` "));
        sb.append(String.format("SET user_id = '%s', ", userId));
        sb.append(String.format("`password` = '%s', ", userPW));
        sb.append(String.format("name = '%s', ", userName));
        sb.append(String.format("birth = '%s', ", userBirth));
        sb.append(String.format("email = '%s'; ", email));

        Container.getDBconnection().insert(sb.toString());
    }

    public boolean login(String id, String pw) {
        boolean canLogin = false;
        String str = "SELECT * FROM `USER`;";
        List<User> userList = new ArrayList<>();
        List<Map<String, Object>> users = Container.getDBconnection().selectRows(str);
        for (Map<String, Object> row : users) {
            userList.add(new User(row));
        }

        for (User user : userList) {
            if (id.equals(user.getUser_id()) && pw.equals((user.getPassword()))) {
                canLogin = true;
                Container.setLoginedUser(user);
                break;
            }
        }
        return canLogin;
    }
}
