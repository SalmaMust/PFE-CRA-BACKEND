package com.example.demo.pferessourceshumaines.services.impl;

import com.example.demo.pferessourceshumaines.models.dao.TimesheetDao;
import com.example.demo.pferessourceshumaines.models.entity.Timesheet;
import com.example.demo.pferessourceshumaines.services.TimesheetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class TimesheetServiceImpl implements TimesheetService {
    private final TimesheetDao timesheetDao;

    public TimesheetServiceImpl(TimesheetDao timesheetDao) {
        this.timesheetDao = timesheetDao;
    }


    @Override
    public Timesheet addTimesheet(Timesheet timesheet) {
        return timesheetDao.addTimesheet(timesheet);
    }

    @Override
    public Timesheet updateTimesheet(Timesheet timesheet) {
        return timesheetDao.updateTimesheet(timesheet);
    }

    @Override
    public Optional<Timesheet> findTimesheetById(Long timesheetId) {
        return timesheetDao.findTimesheetById(timesheetId);
    }
}
