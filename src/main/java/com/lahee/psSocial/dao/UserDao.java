package com.lahee.psSocial.dao;

import com.lahee.psSocial.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import static java.lang.System.getenv;

public class UserDao {
    public void add() throws ClassNotFoundException, SQLException {
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement("insert into users(id, real_name, password) values(?, ?, ?)");
        pstmt.setString(1, String.valueOf(new Random().nextInt()));
        pstmt.setString(2, "kyeongrok");
        pstmt.setString(3, "12345678");

        pstmt.executeUpdate();
        pstmt.close();
        conn.close();

    }


    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Map<String, String> env = getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection
                ("jdbc:mysql://" + dbHost + "/likelion", dbUser, dbPassword);
        return con;
    }


    public User get() {
        return new User();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        userDao.add();
    }
}
