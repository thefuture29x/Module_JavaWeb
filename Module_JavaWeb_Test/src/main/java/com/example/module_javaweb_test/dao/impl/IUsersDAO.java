package com.example.module_javaweb_test.dao.impl;

import com.example.module_javaweb_test.entity.UsersEntity;

import java.util.List;

public interface IUsersDAO {
    UsersEntity findById(Integer id);

    List<UsersEntity> findAll();

    void save(UsersEntity usersEntity);

    Integer update(UsersEntity usersEntity);

    Integer delete(Integer id);

    List<UsersEntity> SearchUser(String name,String address, String phone);

    List<UsersEntity> FilterUser(int min, int max);

    List<UsersEntity> findUserByPosition(Integer id);
}
