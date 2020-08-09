package com.example.demo.pferessourceshumaines.models.impl;

import com.example.demo.pferessourceshumaines.models.dao.ClientDao;
import com.example.demo.pferessourceshumaines.models.entity.Client;
import com.example.demo.pferessourceshumaines.models.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientDaoImpl  implements ClientDao {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientDaoImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public Client addClient(Client client) {
        try {
            return clientRepository.save(client);
        } catch (DataIntegrityViolationException ex) {
            throw new RuntimeException((ex.getMessage()));
        }
    }

    @Override
    public Client updateClient(Client client) {
        try {
            return clientRepository.save(client);
        } catch (DataIntegrityViolationException ex) {
            throw new RuntimeException((ex.getMessage()));
        }
    }

    @Override
    public Optional<Client> findClientById(Long clientId) {
        return clientRepository.findById(clientId);
    }

    @Override
    public List<Client> getAll() {
        try {
            return clientRepository.findAll();
        } catch (DataIntegrityViolationException ex) {
            throw new RuntimeException((ex.getMessage()));
        }
    }

}
