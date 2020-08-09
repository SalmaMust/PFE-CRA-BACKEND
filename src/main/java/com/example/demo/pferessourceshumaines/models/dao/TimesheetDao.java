package com.example.demo.pferessourceshumaines.models.dao;

import com.example.demo.pferessourceshumaines.models.entity.Timesheet;

import java.util.Optional;

public interface TimesheetDao {

    Timesheet addTimesheet (Timesheet timesheet);

    Timesheet updateTimesheet (Timesheet timesheet);

    Optional<Timesheet> findTimesheetById (Long timesheetId);
}
