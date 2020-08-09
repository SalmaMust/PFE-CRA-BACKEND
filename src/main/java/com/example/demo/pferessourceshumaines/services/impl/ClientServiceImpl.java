package com.example.demo.pferessourceshumaines.services.impl;

import com.example.demo.pferessourceshumaines.models.dao.ClientDao;
import com.example.demo.pferessourceshumaines.models.entity.Client;
import com.example.demo.pferessourceshumaines.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    private final ClientDao clientDao;

    @Autowired
    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public Client addClient(Client client) {
        return clientDao.addClient(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientDao.updateClient(client);
    }

    @Override
    public Optional<Client> findClientById(Long clientId) {
        return clientDao.findClientById(clientId);
    }

    @Override
    public List<Client> getAll(){
        return clientDao.getAll();
    }
}
