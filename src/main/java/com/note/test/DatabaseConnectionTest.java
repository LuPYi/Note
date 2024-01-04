package com.note.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/note";
        String dbUser = "web";
        String dbPassword = "12345678";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
            System.out.println("Connected to the database!");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
