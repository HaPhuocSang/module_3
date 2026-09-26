package com.example.bai_tap_1.service;

import com.example.bai_tap_1.enity.Client;
import com.example.bai_tap_1.repository.ClientRepository;
import com.example.bai_tap_1.repository.IClientRepository;

import java.util.List;

public class ClientService implements IClientService {
    private final IClientRepository clientRepository = new ClientRepository();
    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
