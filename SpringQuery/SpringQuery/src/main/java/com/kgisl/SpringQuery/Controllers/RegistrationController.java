package com.kgisl.SpringQuery.Controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.SpringQuery.Repository.RegistrationRepository;
import com.kgisl.SpringQuery.entity.Registration;

@RestController
@RequestMapping("/Registration")
public class RegistrationController {

    @Autowired
    RegistrationRepository RegistrationRepository;

    // 1 .Athletes who registered for the most events in September.
    @GetMapping("/mostRegistrationsInSeptember")
    public ResponseEntity<Registration> findMostRegistrationsInSeptember() {
        LocalDate startOfSeptember = LocalDate.now().withMonth(9).withDayOfMonth(1);
        LocalDate endOfSeptember = LocalDate.now().withMonth(9).withDayOfMonth(30);

        Registration registration = RegistrationRepository
                .findFirstByRegistrationDateBetweenOrderByRegistrationDateDesc(
                        startOfSeptember, endOfSeptember);

        if (registration != null) {
            return new ResponseEntity<>(registration, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 2 . Events with the earliest registration date in September:

    @GetMapping("/earliestRegistrationsInSeptember")
    public ResponseEntity<List<Registration>> findEarliestRegistrationsInSeptember() {
        LocalDate startOfSeptember = LocalDate.now().withMonth(9).withDayOfMonth(1);
        LocalDate endOfSeptember = LocalDate.now().withMonth(9).withDayOfMonth(30);

        List<Registration> registrations = RegistrationRepository
                .findFirstByRegistrationDateBetweenOrderByRegistrationDateAsc(
                        startOfSeptember, endOfSeptember);

        if (!registrations.isEmpty()) {
            return new ResponseEntity<>(registrations, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 3.Athletes who registered for events in October and not in September.

    @GetMapping("/septemberNotInOctober")
    public ResponseEntity<List<Registration>> findRegistrationsInSeptemberNotInOctober() {
        LocalDate startOfSeptember = LocalDate.of(2023, 9, 1);
        LocalDate endOfSeptember = LocalDate.of(2023, 9, 30);
        LocalDate startOfOctober = LocalDate.of(2023, 10, 1);
        LocalDate endOfOctober = LocalDate.of(2023, 10, 31);

        List<Registration> registrations = RegistrationRepository.findRegistrationsInSeptemberNotInOctober(
                startOfSeptember, endOfSeptember, startOfOctober, endOfOctober);

        if (!registrations.isEmpty()) {
            return new ResponseEntity<>(registrations, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 4. List of athletes who registered for "Marathon."

    @GetMapping("/athletesForMarathon")
    public ResponseEntity<List<String>> findAthletesForMarathon() {
        List<String> athletes = RegistrationRepository.findAthletesForMarathon();

        if (!athletes.isEmpty()) {
            return new ResponseEntity<>(athletes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // // 5. Events with names that are unique (considering case sensitivity).

    @GetMapping("/uniqueEventNames")
    public ResponseEntity<List<String>> findUniqueEventNames() {
        List<String> uniqueEventNames = RegistrationRepository.findUniqueEventNamesNativeQuery();

        if (!uniqueEventNames.isEmpty()) {
            return new ResponseEntity<>(uniqueEventNames, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/eventWithMostRegistrationsInOctober")
    public ResponseEntity<String> findEventWithMostRegistrationsInOctober() {
        LocalDate startOfOctober = LocalDate.of(2023, 10, 1);
        LocalDate endOfOctober = LocalDate.of(2023, 10, 31);

        String eventWithMostRegistrations = RegistrationRepository
                .findEventWithMostRegistrationsInOctober(startOfOctober, endOfOctober);

        if (eventWithMostRegistrations != null) {
            return new ResponseEntity<>(eventWithMostRegistrations, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
