package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.db.DBConnection;
import org.example.movie.entity.Movie;
import org.example.user.entity.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Container {
    private static Scanner sc;
    private static DBConnection dbConnection;
    @Getter
    @Setter
    private static User loginedUser;

    @Getter
    @Setter
    private static Movie selectedMovie;
    @Getter
    private static LocalDate nowDate = LocalDate.now();
    @Getter
    private static LocalTime nowTime = java.time.LocalTime.now();

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static Scanner getSc() {
        return sc;
    }

    public static void close() {
        sc.close();
    }

    public static DBConnection getDBconnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
}
