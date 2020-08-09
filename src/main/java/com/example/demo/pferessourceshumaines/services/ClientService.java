package com.example.demo.pferessourceshumaines.services;

import com.example.demo.pferessourceshumaines.models.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ClientService {

    Client addClient (Client client);

    Client updateClient (Client client);

    Optional<Client> findClientById(Long clientId);

    List<Client> getAll();
}
