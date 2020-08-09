package com.example.demo.pferessourceshumaines.models.impl;

import com.example.demo.pferessourceshumaines.models.dao.TimesheetDao;
import com.example.demo.pferessourceshumaines.models.entity.Timesheet;
import com.example.demo.pferessourceshumaines.models.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class TimesheetDaoImpl implements TimesheetDao {
    private final TimesheetRepository timesheetRepository;


    @Autowired
    public TimesheetDaoImpl(TimesheetRepository timesheetRepository) {
        this.timesheetRepository = timesheetRepository;
    }

    @Override
    public Timesheet addTimesheet(Timesheet timesheet) {
        try {
            return timesheetRepository.save(timesheet);
        } catch (DataIntegrityViolationException ex){
            throw new RuntimeException((ex.getMessage()));
        }
    }

    @Override
    public Timesheet updateTimesheet(Timesheet timesheet) {
        try {
            return timesheetRepository.save(timesheet);
        } catch (DataIntegrityViolationException ex){
            throw new RuntimeException((ex.getMessage()));
        }
    }

    @Override
    public Optional<Timesheet> findTimesheetById(Long timesheetId) {

        return timesheetRepository.findById(timesheetId);
    }
}
