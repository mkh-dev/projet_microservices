package com.esprit.microservice.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientRestAPI {
    @Autowired
    private PatientService patientService;
    private String title = "Hello, I'm the patient Micro-Service";

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println(title);
        return title;
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.addPatient(patient), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") String id,
                                                 @RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.updatePatient(id, patient), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deletePatient(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(patientService.deletePatient(id), HttpStatus.OK);
    }
}
