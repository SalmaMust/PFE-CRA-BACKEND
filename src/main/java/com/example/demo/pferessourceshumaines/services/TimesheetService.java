package com.example.demo.pferessourceshumaines.services;

import com.example.demo.pferessourceshumaines.models.entity.Timesheet;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface TimesheetService {

    Timesheet addTimesheet ( Timesheet timesheet);

    Timesheet updateTimesheet( Timesheet timesheet);

    Optional<Timesheet> findTimesheetById(Long timesheetId);
}
