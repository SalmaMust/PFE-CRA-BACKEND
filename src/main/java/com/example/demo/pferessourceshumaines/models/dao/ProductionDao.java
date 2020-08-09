package com.example.demo.pferessourceshumaines.models.dao;

import com.example.demo.pferessourceshumaines.models.entity.Production;

import java.util.Optional;

public interface ProductionDao {
    Production addProduction (Production production);

    Production updateProduction (Production production);

    Optional<Production> findProductionById (Long productionId);


}
