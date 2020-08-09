package com.example.demo.pferessourceshumaines.controllers;

import com.example.demo.pferessourceshumaines.models.entity.Production;
import com.example.demo.pferessourceshumaines.services.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/production")
public class ProductionController {
    private final ProductionService productionService;

    @Autowired
    public ProductionController(ProductionService productionService) {
        this.productionService = productionService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Production> addProduction (@RequestBody Production production){
        Production prod = productionService.addProduction(production);
        return new ResponseEntity<>(prod, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Production> updateProduction (@RequestBody Production production){
        Production prod = productionService.addProduction(production);
        return new ResponseEntity<>(prod, HttpStatus.OK);
    }

    @GetMapping("/{productionId}")
    public ResponseEntity<Optional<Production>> findProductionById (@PathVariable Long productionId) {
        Optional<Production> prod = productionService.findProductionById(productionId);
        return new ResponseEntity<>(prod, HttpStatus.OK);
    }
}