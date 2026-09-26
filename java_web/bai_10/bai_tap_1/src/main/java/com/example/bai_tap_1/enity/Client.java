package com.example.bai_tap_1.enity;

import java.util.Date;

public class Client {
    private int id;
    private String name;
    private Date birthday;
    private String address;
    private String img;

    public Client() {
    }

    public Client(int id, String name, Date birthday, String address, String img) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.img = img;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
