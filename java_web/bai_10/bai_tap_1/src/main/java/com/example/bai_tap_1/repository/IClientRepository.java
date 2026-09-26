package com.example.bai_tap_1.repository;

import com.example.bai_tap_1.enity.Client;

import java.util.List;

public interface IClientRepository {
    List<Client> findAll();
}
