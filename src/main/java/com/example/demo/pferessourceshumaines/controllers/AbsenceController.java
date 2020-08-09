package com.example.demo.pferessourceshumaines.controllers;

import com.example.demo.pferessourceshumaines.models.entity.Absence;
import com.example.demo.pferessourceshumaines.models.repository.AbsenceRepository;
import com.example.demo.pferessourceshumaines.services.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController @CrossOrigin("*")
@RequestMapping("/api")
public class AbsenceController {

    @Autowired
    private AbsenceRepository absenceRepository;

    @GetMapping("/absences")
    public List<Absence> getAllAbsences() {
        return absenceRepository.findAll();
    }

    @PostMapping( "/absence")
    public Absence createAbsence (@Valid @RequestBody Absence absence){
        return absenceRepository.save(absence);
    }
    @PutMapping("/absences/{id}")
    public ResponseEntity<Absence> updateAbsence(@PathVariable(value = "id") Long absenceId,
                                                 @Valid @RequestBody Absence absenceDetails) throws ResourceNotFoundException {
        Absence absence = absenceRepository.findById(absenceId)
                .orElseThrow(() -> new ResourceNotFoundException("Absence not found for this id :: " + absenceId));

        absence.setType(absenceDetails.getType());
        absence.setStartDate(absenceDetails.getStartDate());
        absence.setEndDate(absenceDetails.getEndDate());
        absence.setStatus(absenceDetails.getStatus());
        final Absence updatedAbsence = absenceRepository.save(absence);
        return ResponseEntity.ok(updatedAbsence);
    }

    @GetMapping("/absences/{id}")
    public ResponseEntity<Absence> getAbsenceById(@PathVariable(value = "id") Long absenceId)
            throws ResourceNotFoundException {
        Absence absence = absenceRepository.findById(absenceId)
                .orElseThrow(() -> new ResourceNotFoundException("Absence not found for this id :: " + absenceId));
        return ResponseEntity.ok().body(absence);
    }
    @DeleteMapping("/absences/{id}")
    public Map<String, Boolean> deleteAbsence(@PathVariable(value = "id") Long absenceId)
            throws ResourceNotFoundException {
        Absence absence = absenceRepository.findById(absenceId)
                .orElseThrow(() -> new ResourceNotFoundException("Absence not found for this id :: " + absenceId));

        absenceRepository.delete(absence);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
