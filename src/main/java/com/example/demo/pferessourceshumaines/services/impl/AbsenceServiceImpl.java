package com.example.demo.pferessourceshumaines.services.impl;

import com.example.demo.pferessourceshumaines.models.dao.AbsenceDao;
import com.example.demo.pferessourceshumaines.models.entity.Absence;
import com.example.demo.pferessourceshumaines.services.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AbsenceServiceImpl implements AbsenceService {
    private final AbsenceDao absenceDao ;

    @Autowired
    public AbsenceServiceImpl(AbsenceDao absenceDao) {
        this.absenceDao = absenceDao;
    }

    @Override
    public Absence addAbsence(Absence absence) {
        return absenceDao.addAbsence(absence);
    }

    @Override
    public Absence updateAbsence(Absence absence) {
        return absenceDao.updateAbsence(absence);
    }

    @Override
    public Optional<Absence> findAbsenceById(Long absenceId) {
        return absenceDao.findAbsenceById(absenceId);
    }

    @Override
    public List<Absence> getAll(){
        return absenceDao.getAll();
    }


}
