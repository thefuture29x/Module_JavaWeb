package com.example.module_javaweb_test.dao;

import com.example.module_javaweb_test.connection.Connection;
import com.example.module_javaweb_test.dao.impl.IUsersDAO;
import com.example.module_javaweb_test.entity.UsersEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO implements IUsersDAO {
    Connection conn = new Connection();
    @Override
    public UsersEntity findById(Integer id) {
        UsersEntity users = new UsersEntity();
        try {
            PreparedStatement pre = conn.getConnection().prepareStatement("select * from users where id = ?");
            pre.setInt(1,id);
            ResultSet resultSet = pre.executeQuery();
            while (resultSet.next()){
                users.setId(resultSet.getInt("id"));
                users.setName(resultSet.getString("name"));
                users.setAddress(resultSet.getString("address"));
                users.setAge(resultSet.getInt("age"));
                users.setPhone(resultSet.getString("phone"));
                users.setImage(resultSet.getString("image"));
                users.setId_position(resultSet.getInt("id_position"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public List<UsersEntity> findAll() {
        List<UsersEntity> entityList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from users");
        try {
            ResultSet resultSet = conn.StatementConection().executeQuery(sql.toString());
            while (resultSet.next()){
                UsersEntity users = new UsersEntity();
                users.setId(resultSet.getInt("id"));
                users.setName(resultSet.getString("name"));
                users.setAddress(resultSet.getString("address"));
                users.setAge(resultSet.getInt("age"));
                users.setPhone(resultSet.getString("phone"));
                users.setImage(resultSet.getString("image"));
                users.setId_position(resultSet.getInt("id_position"));
                entityList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entityList;
    }

    @Override
    public void save(UsersEntity usersEntity) {
        try {
            PreparedStatement pre = conn.getConnection().prepareStatement("INSERT INTO users VALUES (0,?,?,?,?,?,?)");
            pre.setString(1,usersEntity.getName());
            pre.setString(2,usersEntity.getAddress());
            pre.setInt(3,usersEntity.getAge());
            pre.setString(4,usersEntity.getPhone());
            pre.setString(5,usersEntity.getImage());
            pre.setInt(6,usersEntity.getId_position());
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Integer update(UsersEntity usersEntity) {
        try {
            PreparedStatement pre = conn.getConnection().prepareStatement("UPDATE users SET name = ?, address = ?,age=?,phone=?, image = ?,id_position = ? WHERE id = ?");
            pre.setString(1,usersEntity.getName());
            pre.setString(2,usersEntity.getAddress());
            pre.setInt(3,usersEntity.getAge());
            pre.setString(4,usersEntity.getPhone());
            pre.setString(5,usersEntity.getImage());
            pre.setInt(6,usersEntity.getId_position());
            pre.setInt(7,usersEntity.getId());
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersEntity.getId();
    }

    @Override
    public Integer delete(Integer id) {
        try {
            PreparedStatement pre = conn.getConnection().prepareStatement("DELETE FROM users WHERE id = ?");
            pre.setInt(1,id);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public List<UsersEntity> SearchUser(String name, String address, String phone) {
        List<UsersEntity> entityList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from users where 1");
        if (!name.equals("")){
            sql.append(" and name = '" + name + "'");
        }
        if (!address.equals("")){
            sql.append(" and address = '" + address + "'");
        }
        if (!phone.equals("")){
            sql.append(" and phone = '" + phone + "'");
        }
        try {
            ResultSet resultSet = conn.StatementConection().executeQuery(sql.toString());
            while (resultSet.next()){
                UsersEntity users = new UsersEntity();
                users.setId(resultSet.getInt("id"));
                users.setName(resultSet.getString("name"));
                users.setAddress(resultSet.getString("address"));
                users.setAge(resultSet.getInt("age"));
                users.setPhone(resultSet.getString("phone"));
                users.setImage(resultSet.getString("image"));
                users.setId_position(resultSet.getInt("id_position"));
                entityList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entityList;
    }

    @Override
    public List<UsersEntity> FilterUser(int min, int max) {
        List<UsersEntity> entityList = new ArrayList<>();
        try {
            PreparedStatement pre = conn.getConnection().prepareStatement("select * from users where age between ? and ? ");
            pre.setInt(1,min);
            pre.setInt(2,max);
            ResultSet resultSet = pre.executeQuery();
            while (resultSet.next()){
                UsersEntity users = new UsersEntity();
                users.setId(resultSet.getInt("id"));
                users.setName(resultSet.getString("name"));
                users.setAddress(resultSet.getString("address"));
                users.setAge(resultSet.getInt("age"));
                users.setPhone(resultSet.getString("phone"));
                users.setImage(resultSet.getString("image"));
                users.setId_position(resultSet.getInt("id_position"));
                entityList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entityList;
    }

    @Override
    public List<UsersEntity> findUserByPosition(Integer id) {
        List<UsersEntity> entityList = new ArrayList<>();
        try {
            PreparedStatement pre = conn.getConnection().prepareStatement("SELECT * FROM users us JOIN position ps on us.id_position = ps.id WHERE ps.id = ?");
            pre.setInt(1,id);
            ResultSet resultSet = pre.executeQuery();
            while (resultSet.next()){
                UsersEntity users = new UsersEntity();
                users.setId(resultSet.getInt("id"));
                users.setName(resultSet.getString("name"));
                users.setAddress(resultSet.getString("address"));
                users.setAge(resultSet.getInt("age"));
                users.setPhone(resultSet.getString("phone"));
                users.setImage(resultSet.getString("image"));
                users.setId_position(resultSet.getInt("id_position"));
                entityList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entityList;
    }

    public static void main(String[] args) {
        new UsersDAO().findUserByPosition(3);
    }
}
