package com.esprit.microservice.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(String id, Patient newPatient) {
        if (patientRepository.findById(id).isPresent()) {
            Patient existingPatient = patientRepository.findById(id).get();
            existingPatient.setFirstName(newPatient.getFirstName());
            existingPatient.setLastName(newPatient.getLastName());
            existingPatient.setDateOfBirth(newPatient.getDateOfBirth());
            existingPatient.setAddress(newPatient.getAddress());
            existingPatient.setPhoneNumber(newPatient.getPhoneNumber());
            existingPatient.setEmail(newPatient.getEmail());

            return patientRepository.save(existingPatient);
        } else
            return null;
    }

    public String deletePatient(String id) {
        if (patientRepository.findById(id).isPresent()) {
            patientRepository.deleteById(id);
            return "patient supprimé";
        } else
            return "patient non supprimé";
    }
}
