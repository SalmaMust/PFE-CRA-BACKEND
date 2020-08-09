package com.example.demo.pferessourceshumaines.services;


import com.example.demo.pferessourceshumaines.models.entity.Absence;

import java.util.List;
import java.util.Optional;

public interface AbsenceService {
    Absence addAbsence (Absence absence);

    Absence updateAbsence (Absence absence);

    Optional<Absence> findAbsenceById(Long absenceId);

    List<Absence> getAll();


}
