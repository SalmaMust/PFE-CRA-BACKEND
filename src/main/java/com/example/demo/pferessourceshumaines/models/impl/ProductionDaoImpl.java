package com.example.demo.pferessourceshumaines.models.impl;

import com.example.demo.pferessourceshumaines.models.dao.ProductionDao;
import com.example.demo.pferessourceshumaines.models.entity.Production;
import com.example.demo.pferessourceshumaines.models.repository.ProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class ProductionDaoImpl implements ProductionDao {

    private final ProductionRepository productionRepository;

    @Autowired
    public ProductionDaoImpl(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    @Override
    public Production addProduction(Production production) {
        try {
            return productionRepository.save(production);
        } catch (DataIntegrityViolationException ex){
            throw new RuntimeException((ex.getMessage()));
        }
    }

    @Override
    public Production updateProduction(Production production) {
        try {
            return productionRepository.save(production);
        } catch (DataIntegrityViolationException ex){
            throw new RuntimeException((ex.getMessage()));
        }
    }

    @Override
    public Optional<Production> findProductionById(Long productionId) {
        return productionRepository.findById(productionId);
    }
}
