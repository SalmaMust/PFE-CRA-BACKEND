package com.example.demo.pferessourceshumaines.services;

import com.example.demo.pferessourceshumaines.models.entity.Production;

import java.util.Optional;

public interface ProductionService {

    Production addProduction (Production production);

    Production updateProduction(Production production);

    Optional<Production> findProductionById(Long productionId);
}
