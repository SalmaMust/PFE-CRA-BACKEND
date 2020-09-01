package com.example.demo.pferessourceshumaines.controllers;

import com.example.demo.pferessourceshumaines.models.entity.Internal;
import com.example.demo.pferessourceshumaines.models.entity.Production;
import com.example.demo.pferessourceshumaines.models.entity.Timesheet;
import com.example.demo.pferessourceshumaines.models.repository.InternalRepository;
import com.example.demo.pferessourceshumaines.models.repository.ProductionRepository;
import com.example.demo.pferessourceshumaines.models.repository.TimesheetRepository;
import com.example.demo.pferessourceshumaines.services.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @CrossOrigin("*")
@RequestMapping("/api/timesheet")
public class TimesheetController {
    private  final TimesheetService timesheetService;
    private  final TimesheetRepository timesheetRepository;
    private final InternalRepository internalRepository;
    private final ProductionRepository productionRepository;
    @Autowired
    public TimesheetController(TimesheetService timesheetService, TimesheetRepository timesheetRepository, InternalRepository internalRepository, ProductionRepository productionRepository) {
        this.timesheetService = timesheetService;
        this.timesheetRepository = timesheetRepository;
        this.internalRepository = internalRepository;
        this.productionRepository = productionRepository;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Timesheet> addTimesheet (@RequestBody Timesheet timesheet){
        Timesheet ts = timesheetService.addTimesheet(timesheet);
        return new ResponseEntity<>(ts, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Timesheet> updateTimesheet(@RequestBody Timesheet timesheet){
        Timesheet ts = timesheetService.addTimesheet(timesheet);
        return new ResponseEntity<>(ts, HttpStatus.OK);
    }

   /* @GetMapping("/{id}")
    public ResponseEntity<Optional<Timesheet>> findTimesheetById (@PathVariable Long id) {
        Optional<Timesheet> ts = timesheetService.findTimesheetById(id);
        return new ResponseEntity<>(ts, HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<Timesheet> getTimesheetById(@PathVariable(value = "id") Long timesheetId)
            throws ResourceNotFoundException {
        Timesheet timesheet = timesheetRepository.findById(timesheetId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + timesheetId));

        return ResponseEntity.ok().body(timesheet);
    }

    @GetMapping("/{id}/intern")
    public ResponseEntity<List<Internal>> getInternByTimesheetId(@PathVariable(value = "id") Long timesheetId)
            throws ResourceNotFoundException {
        List<Internal> interns = internalRepository.findAllByTimesheetId(timesheetId);

        //        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + timesheetId));

        return ResponseEntity.ok().body(interns);
    }


    @GetMapping("/{id}/production")
    public ResponseEntity<List<Production>> getProductionByTimesheetId(@PathVariable(value = "id") Long timesheetId)
            throws ResourceNotFoundException {
        List<Production> productions = productionRepository.findAllByTimesheetId(timesheetId);
               // .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + timesheetId));

        return ResponseEntity.ok().body(productions);
    }

    @GetMapping("/all")
    public List<Timesheet> getAllTimesheets() {
        return timesheetRepository.findAll();
    }

    @GetMapping("/byuser/{id}")
    public List<Timesheet> getTimesheetsByUserId(@PathVariable(value = "id") Long userId) {
        return timesheetRepository.findAllByUserId(userId);
    }


}
