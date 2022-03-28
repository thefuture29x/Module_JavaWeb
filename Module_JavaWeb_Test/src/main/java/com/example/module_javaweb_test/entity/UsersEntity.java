package com.example.module_javaweb_test.entity;

public class UsersEntity {
    private int id;
    private String name;
    private String address;
    private int age;
    private String phone;
    private String image;
    private int id_position;

    @Override
    public String toString() {
        return "UsersEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", image='" + image + '\'' +
                ", id_position=" + id_position +
                '}';
    }

    public UsersEntity() {
    }

    public UsersEntity(int id, String name, String address, int age, String phone, String image, int id_position) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.phone = phone;
        this.image = image;
        this.id_position = id_position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId_position() {
        return id_position;
    }

    public void setId_position(int id_position) {
        this.id_position = id_position;
    }
}
