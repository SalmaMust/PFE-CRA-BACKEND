package com.example.demo.pferessourceshumaines.models.dao;

import com.example.demo.pferessourceshumaines.models.entity.Client;
import org.hibernate.validator.constraints.EAN;

import java.util.List;
import java.util.Optional;

public interface ClientDao {

    Client addClient(Client client);

    Client updateClient(Client client);

    Optional<Client> findClientById (Long clientId);

    List<Client> getAll();
}
