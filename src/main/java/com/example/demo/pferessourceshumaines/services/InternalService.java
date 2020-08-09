package com.example.demo.pferessourceshumaines.services;

import com.example.demo.pferessourceshumaines.models.entity.Internal;

import java.util.Optional;

public interface InternalService {

    Internal addInternal (Internal internal);

    Internal updateInternal(Internal internal);

    Optional<Internal> findInternalById(Long internalId);
}
