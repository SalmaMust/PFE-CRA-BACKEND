package com.example.demo.pferessourceshumaines.controllers;

import com.example.demo.pferessourceshumaines.models.entity.Production;
import com.example.demo.pferessourceshumaines.models.repository.ProductionRepository;
import com.example.demo.pferessourceshumaines.services.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController  @CrossOrigin("*")
@RequestMapping("/api/production")
public class ProductionController {
    private final ProductionService productionService;
    private final ProductionRepository productionRepository;

    @Autowired
    public ProductionController(ProductionService productionService, ProductionRepository productionRepository) {
        this.productionService = productionService;
        this.productionRepository = productionRepository;
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

    @GetMapping("/{id}/production")
    public ResponseEntity<List<Production>> getProductionByTimesheetId(@PathVariable(value = "id") Long timesheetId)
            throws ResourceNotFoundException {
        List<Production> productions = productionRepository.findAllByTimesheetId(timesheetId);
        // .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + timesheetId));

        return ResponseEntity.ok().body(productions);
    }

}