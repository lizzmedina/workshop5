package com.validationService.validationService.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class ValidationService {
    public boolean validateLine(String email, String dob, String jobTitle) {
        // Reglas de validación para email
        if (!email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")) {
            return false;
        }

        // Reglas de validación para Date of Birth
        LocalDate dobDate = LocalDate.parse(dob);
        LocalDate minValidDate = LocalDate.of(1980, 1, 1);
        if (dobDate.isBefore(minValidDate)) {
            return false;
        }

        // Reglas de validación para Job Title
        List<String> validJobTitles = Arrays.asList("Haematologist", "Phytotherapist", "Building surveyor", "Insurance account manager", "Educational psychologist");
        if (!validJobTitles.contains(jobTitle)) {
            return false;
        }

        return true;
    }
}