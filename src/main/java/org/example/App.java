package org.example;

import org.example.db.DBConnection;

public class App {
    public App() {
        DBConnection.DB_NAME = "beginner_pro";
        DBConnection.DB_USER = "root";
        DBConnection.DB_PORT = 3306;
        DBConnection.DB_PASSWORD = "";
        Container.getDBconnection().connect();
    }

    public void run() {
        System.out.println("== 대전시네마 ==");

        while (true) {


        }
    }
}
