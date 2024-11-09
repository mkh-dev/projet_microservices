package com.esprit.microservice.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, String> {

    @Query("select p from Patient p where p.lastName like :name")
    public Page<Patient> patientByLastName(@Param("name") String lastName, Pageable pageable);
}
