package com.example.demo.pferessourceshumaines.controllers;

import com.example.demo.pferessourceshumaines.models.entity.Internal;
import com.example.demo.pferessourceshumaines.services.InternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/internal")
public class InternalController {
    private final InternalService internalService;

    @Autowired
    public InternalController(InternalService internalService) {
        this.internalService = internalService;
    }


    @PostMapping(value = "/add")
    public ResponseEntity<Internal> addInternal (@RequestBody Internal internal){
        Internal intern = internalService.addInternal(internal);
        return new ResponseEntity<>(intern, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Internal> updateInternal (@RequestBody Internal internal){
        Internal intern = internalService.addInternal(internal);
        return new ResponseEntity<>(intern, HttpStatus.OK);
    }

    @GetMapping("/{internalId}")
    public ResponseEntity<Optional<Internal>> findInternalById (@PathVariable Long internalId) {
        Optional<Internal> intern = internalService.findInternalById(internalId);
        return new ResponseEntity<>(intern, HttpStatus.OK);
    }
}
