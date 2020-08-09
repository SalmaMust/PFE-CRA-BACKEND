package com.example.demo.pferessourceshumaines.models.impl;

import com.example.demo.pferessourceshumaines.models.dao.AbsenceDao;
import com.example.demo.pferessourceshumaines.models.entity.Absence;
import com.example.demo.pferessourceshumaines.models.repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class AbsenceDaoImpl implements AbsenceDao {
    private final AbsenceRepository absenceRepository;

    @Autowired
    public AbsenceDaoImpl(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

    @Override
    public List<Absence> getAll() {
        return this.absenceRepository.findAll();
    }

    @Override
    public Absence addAbsence(Absence absence) {
        try {
            return absenceRepository.save(absence);
        } catch (DataIntegrityViolationException ex){
            throw new RuntimeException((ex.getMessage()));
        }
    }

    @Override
    public Absence updateAbsence(Absence absence) {
        try {
            return absenceRepository.save(absence);
        } catch (DataIntegrityViolationException ex){
            throw new RuntimeException((ex.getMessage()));
        }
    }

    @Override
    public Optional<Absence> findAbsenceById(Long absenceId) {
        return absenceRepository.findById(absenceId);
        }

}
