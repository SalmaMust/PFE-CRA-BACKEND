package com.example.demo.pferessourceshumaines.models.repository;

import com.example.demo.pferessourceshumaines.models.entity.Internal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface InternalRepository extends JpaRepository <Internal , Long>{

    public List<Internal> findAllByTimesheetId (Long id);

}
