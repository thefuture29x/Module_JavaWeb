package com.example.module_javaweb_test.dao.impl;

import com.example.module_javaweb_test.entity.PositionEntity;
import com.example.module_javaweb_test.entity.UsersEntity;

import java.util.List;

public interface IPositionDAO {
    PositionEntity findById(Integer id);

    List<PositionEntity> findAll();

    void save(PositionEntity positionEntity);

    Integer update(PositionEntity positionEntity);

    Integer delete(Integer id);
}
