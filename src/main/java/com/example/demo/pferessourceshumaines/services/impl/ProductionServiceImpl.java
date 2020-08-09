package com.example.demo.pferessourceshumaines.services.impl;

import com.example.demo.pferessourceshumaines.models.dao.ProductionDao;
import com.example.demo.pferessourceshumaines.models.entity.Production;
import com.example.demo.pferessourceshumaines.services.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;



@Service
@Transactional
public class ProductionServiceImpl implements ProductionService {
    private final ProductionDao productionDao;

    @Autowired
    public ProductionServiceImpl(ProductionDao productionDao) {
        this.productionDao = productionDao;
    }

    @Override
    public Production addProduction(Production production) {
        return productionDao.addProduction(production);
    }

    @Override
    public Production updateProduction(Production production) {
        return productionDao.updateProduction(production);
    }

    @Override
    public Optional<Production> findProductionById(Long productionId) {
        return productionDao.findProductionById(productionId);
    }
}
