package com.example.demo.pferessourceshumaines.models.dao;

import com.example.demo.pferessourceshumaines.models.entity.Absence;

import java.util.List;
import java.util.Optional;

public interface AbsenceDao {
    List<Absence> getAll ();

    Absence addAbsence(Absence absence);

    Absence updateAbsence(Absence absence);

    Optional<Absence> findAbsenceById (Long absenceId);
}
