package com.Pengyanlong.dao;

import com.Pengyanlong.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql="insert into userTB values(?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,user.getId());
            ps.setString(2,user.getUsername());
            ps.setString(3,user.getPassword());
            ps.setString(4,user.getEmail());
            ps.setString(5,user.getGender());
            ps.setDate(6, (java.sql.Date) user.getBirthDate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps.execute();
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql="delete from userTB where username=? and password=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps.executeUpdate();
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql="update userTB set email=?,gender=?,birthdate=? where username=? and password=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getEmail());
            ps.setString(2,user.getGender());
            ps.setDate(3, (java.sql.Date) user.getBirthDate());
            ps.setString(4,user.getUsername());
            ps.setString(5,user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps.executeUpdate();
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        User user = null;
        String sqlQuery="select * from userTB where id=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlQuery);
            ps.setInt(1,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        User user = null;
        String sqlQuery="select * from userTB where username=? and password=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlQuery);
            ps.setString(1,username);
            ps.setString(2,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        List<User> listuser = null;
        String sqlQuery="select * from userTB where username=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlQuery);
            ps.setString(1,username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
                listuser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        List<User> listuser = null;
        String sqlQuery="select * from userTB where password=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlQuery);
            ps.setString(1,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
                listuser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        List<User> listuser = null;
        String sqlQuery="select * from userTB where email=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlQuery);
            ps.setString(1,email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
                listuser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        List<User> listuser = null;
        String sqlQuery="select * from userTB where gender=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlQuery);
            ps.setString(1,gender);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
                listuser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        List<User> listuser = null;
        String sqlQuery="select * from userTB where birthdate=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlQuery);
            ps.setDate(1, (java.sql.Date) birthDate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
                listuser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        List<User> listuser = null;
        String sqlQuery="select * from userTB";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
                listuser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }
}