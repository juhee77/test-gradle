package com.lahee.psSocial.book.dao;

import com.lahee.psSocial.book.domain.BUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public abstract class UserDao {
    public void add() throws ClassNotFoundException, SQLException {
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement("insert into buser(id, name, password) values(?, ?, ?)");
        pstmt.setString(1, String.valueOf(new Random().nextInt()));
        pstmt.setString(2, "test");
        pstmt.setString(3, "12345678");

        pstmt.executeUpdate();
        pstmt.close();
        conn.close();

    }

    public BUser get(long id) throws SQLException, ClassNotFoundException {
        Connection con = getConnection();

        PreparedStatement pstm = con.prepareStatement("select * from buser where id=?");
        pstm.setLong(1, id);
        ResultSet rs = pstm.executeQuery();
        rs.next();
        BUser user = new BUser(rs.getLong("id"), rs.getString("name"), rs.getString("password"));

        rs.close();
        pstm.close();
        con.close();
        System.out.println(user);
        return user;
    }

    public abstract Connection getConnection() throws SQLException, ClassNotFoundException;

}
