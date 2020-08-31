package com.example.demo.pferessourceshumaines.models.repository;

import com.example.demo.pferessourceshumaines.models.entity.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TimesheetRepository extends JpaRepository <Timesheet , Long> {
    List<Timesheet> findAllByUserId(Long id);
}
