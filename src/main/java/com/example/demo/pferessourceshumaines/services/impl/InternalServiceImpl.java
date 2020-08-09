package com.example.demo.pferessourceshumaines.services.impl;

import com.example.demo.pferessourceshumaines.models.dao.InternalDao;
import com.example.demo.pferessourceshumaines.models.entity.Internal;
import com.example.demo.pferessourceshumaines.services.InternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class InternalServiceImpl implements InternalService {
    private final InternalDao internalDao;

    @Autowired
    public InternalServiceImpl(InternalDao internalDao) {
        this.internalDao = internalDao;
    }

    @Override
    public Internal addInternal(Internal internal) {
        return internalDao.addInternal(internal);
    }

    @Override
    public Internal updateInternal(Internal internal) {
        return internalDao.updateInternal(internal);
    }

    @Override
    public Optional<Internal> findInternalById(Long internalId) {
        return internalDao.findInternalById(internalId);
    }
}
