package com.example.demo.pferessourceshumaines.controllers;

import com.example.demo.pferessourceshumaines.models.entity.Internal;
import com.example.demo.pferessourceshumaines.models.entity.Production;
import com.example.demo.pferessourceshumaines.models.repository.InternalRepository;
import com.example.demo.pferessourceshumaines.services.InternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController  @CrossOrigin("*")
@RequestMapping("/api/interne")
public class InternalController {
    private final InternalService internalService;
    private final InternalRepository internalRepository;

    @Autowired
    public InternalController(InternalService internalService, InternalRepository internalRepository) {
        this.internalService = internalService;
        this.internalRepository = internalRepository;
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

    @GetMapping("/{id}/intern")
    public ResponseEntity<List<Internal>> getInternByTimesheetId(@PathVariable(value = "id") Long timesheetId)
            throws ResourceNotFoundException {
        List<Internal> interns = internalRepository.findAllByTimesheetId(timesheetId);

        //        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + timesheetId));

        return ResponseEntity.ok().body(interns);
    }
}
