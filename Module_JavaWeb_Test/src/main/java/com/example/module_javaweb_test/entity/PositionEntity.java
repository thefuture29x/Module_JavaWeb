package com.example.module_javaweb_test.entity;

public class PositionEntity {
    private int id;
    private String position;

    @Override
    public String toString() {
        return "PositionEntity{" +
                "id=" + id +
                ", position='" + position + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public PositionEntity() {
    }

    public PositionEntity(int id, String position) {
        this.id = id;
        this.position = position;
    }
}
