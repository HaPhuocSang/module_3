package com.example.bai_tap_1.repository;

import com.example.bai_tap_1.enity.Client;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements IClientRepository{
    private final static List<Client> clientList = new ArrayList<>();
    static {
        clientList.add(new Client(1, "Mai Văn Toàn", Date.valueOf("1983-08-20"), "Hà Nội", "1.jpg"));
        clientList.add(new Client(2, "Nguyễn Văn Nam", Date.valueOf("1983-08-21"), "Bắc Giang", "2.jpg"));
        clientList.add(new Client(3, "Nguyễn Thái Hòa", Date.valueOf("1983-08-22"), "Nam Định", "3.jpg"));
        clientList.add(new Client(4, "Trần Đăng Khoa", Date.valueOf("1983-08-17"), "Hà Tây", "4.jpg"));
        clientList.add(new Client(5, "Nguyễn Đình Thi", Date.valueOf("1983-08-19"), "Hà Nội", "5.jpg"));
    }
    @Override
    public List<Client> findAll() {
        return clientList;
    }
}
