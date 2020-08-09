package com.example.demo.pferessourceshumaines.models.impl;

import com.example.demo.pferessourceshumaines.models.dao.InternalDao;
import com.example.demo.pferessourceshumaines.models.entity.Internal;
import com.example.demo.pferessourceshumaines.models.repository.InternalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public class InternalDaoImpl implements InternalDao {
    private final InternalRepository internalRepository;

    @Autowired
    public InternalDaoImpl(InternalRepository internalRepository) {
        this.internalRepository = internalRepository;
    }

    @Override
    public Internal addInternal(Internal internal) {
        try {
            return internalRepository.save(internal);
        } catch (DataIntegrityViolationException ex){
            throw new RuntimeException((ex.getMessage()));
        }
    }

    @Override
    public Internal updateInternal(Internal internal) {
        try {
            return internalRepository.save(internal);
        } catch (DataIntegrityViolationException ex){
            throw new RuntimeException((ex.getMessage()));
        }
    }

    @Override
    public Optional<Internal> findInternalById(Long InternalId) {
        return internalRepository.findById(InternalId);
    }
}
