package com.example.demo.pferessourceshumaines.controllers;

import com.example.demo.pferessourceshumaines.models.entity.Timesheet;
import com.example.demo.pferessourceshumaines.services.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/timesheet")
public class TimesheetController {
    private  final TimesheetService timesheetService;

    @Autowired
    public TimesheetController(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
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

    @GetMapping("/{timesheetId}")
    public ResponseEntity<Optional<Timesheet>> findTimesheetById (@PathVariable Long timesheetId) {
        Optional<Timesheet> ts = timesheetService.findTimesheetById(timesheetId);
        return new ResponseEntity<>(ts, HttpStatus.OK);
    }
}
