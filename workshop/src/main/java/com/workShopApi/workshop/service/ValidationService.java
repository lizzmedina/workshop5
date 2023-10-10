package com.workShopApi.workshop.service;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class ValidationService {

    public boolean validateLine(String line) {
        // Lógica para validar una línea según las reglas
        String[] parts = line.split(",");
        if (parts.length != 3) {
            return false; // La línea debe tener tres campos (email, date of birth, job title)
        }

        String email = parts[0];
        String dob = parts[1];
        String jobTitle = parts[2];

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

        return true; // La línea es válida si pasa todas las reglas
    }
}