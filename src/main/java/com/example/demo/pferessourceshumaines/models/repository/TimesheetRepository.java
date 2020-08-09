package com.example.demo.pferessourceshumaines.models.repository;

import com.example.demo.pferessourceshumaines.models.entity.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TimesheetRepository extends JpaRepository <Timesheet , Long> {
}
