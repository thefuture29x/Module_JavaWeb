package com.example.module_javaweb_test.dao;

import com.example.module_javaweb_test.connection.Connection;
import com.example.module_javaweb_test.dao.impl.IPositionDAO;
import com.example.module_javaweb_test.entity.PositionEntity;
import com.example.module_javaweb_test.entity.UsersEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO implements IPositionDAO {
    Connection conn = new Connection();
    @Override
    public PositionEntity findById(Integer id) {
        PositionEntity positionEntity = new PositionEntity();
        try {
            PreparedStatement pre = conn.getConnection().prepareStatement("select * from position where id = ?");
            pre.setInt(1,id);
            ResultSet resultSet = pre.executeQuery();
            while (resultSet.next()){
                positionEntity.setId(resultSet.getInt("id"));
                positionEntity.setPosition(resultSet.getString("position"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return positionEntity;
    }

    @Override
    public List<PositionEntity> findAll() {
        List<PositionEntity> entityList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from position");
        try {
            ResultSet resultSet = conn.StatementConection().executeQuery(sql.toString());
            while (resultSet.next()){
                PositionEntity positionEntity = new PositionEntity();
                positionEntity.setId(resultSet.getInt("id"));
                positionEntity.setPosition(resultSet.getString("position"));
                entityList.add(positionEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entityList;
    }

    @Override
    public void save(PositionEntity positionEntity) {
        try {
            PreparedStatement pre = conn.getConnection().prepareStatement("INSERT INTO position VALUES (0,?)");
            pre.setString(1,positionEntity.getPosition());
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer update(PositionEntity positionEntity) {
        try {
            PreparedStatement pre = conn.getConnection().prepareStatement("UPDATE position SET position = ?WHERE id = ?");
            pre.setString(1,positionEntity.getPosition());
            pre.setInt(2,positionEntity.getId());
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  positionEntity.getId();
    }

    @Override
    public Integer delete(Integer id) {
        try {
            PreparedStatement pre = conn.getConnection().prepareStatement("DELETE FROM position WHERE id = ?");
            pre.setInt(1,id);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static void main(String[] args) {
        PositionDAO positionDAO = new PositionDAO();
//        positionDAO.findById(1);
//        positionDAO.findAll();
//        positionDAO.save(new PositionEntity(0,"test position"));
//        positionDAO.update(new PositionEntity(5,"test position "));
//        positionDAO.delete(5);
    }
}
