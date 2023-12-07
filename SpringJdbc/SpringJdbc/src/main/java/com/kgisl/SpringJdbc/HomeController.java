package com.kgisl.SpringJdbc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/home")
public class HomeController {

    {
        System.out.println("home control loaded");
    }

    // @Autowired
    // private EmployeeDao employeeDao;

    @Autowired
    private RegistrationDao registrationDao;

    @RequestMapping("/")
    public String showpage() {
        // int status = employeeDao.saveEmployee(new Employee(102, "gopi", 5000));
        // System.out.println(status);

        // int status1 = employeeDao.updateEmployee(new Employee(102, "Sonoo", 15000));
        // System.out.println(status1);
        // return null;

        // Employee e = new Employee();
        // e.setId(1);
        // int status = employeeDao.deleteEmployee(e);
        // System.out.println(status);
        // return null ;

        // List<Employee> allEmployees = employeeDao.allEmployees();
        // allEmployees.stream().forEach(System.out::println);
        // return null ;

        List<Registration> allregistration = registrationDao.listall();

        // 1 . Athletes who registered for the most events in September.?

        List<Registration> septemberRegistrations = allregistration.stream()
                .filter(registration -> registration.getRegistration_date().toLocalDate().getMonthValue() == 9)
                .collect(Collectors.toList());

        // Group registrations by athlete name
        Map<String, Long> registrationsByAthlete = septemberRegistrations.stream()
                .collect(Collectors.groupingBy(Registration::getAthlete_name, Collectors.counting()));

        // Find the athlete(s) with the most registrations

        Optional<Map.Entry<String, Long>> maxEntry = registrationsByAthlete.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));

        String athleteWithMostRegistrations = maxEntry.map(Map.Entry::getKey)
                .orElse("No registrations in September");
                
                String json1 = new Gson().toJson(athleteWithMostRegistrations);

        // septemberRegistrations.stream().forEach(System.out::println);

        // 2 . Events with the earliest registration date in September ?
        Optional<Registration> earliestInSeptember = allregistration.stream()
                .filter(registration -> registration.getRegistration_date().getMonth() == 8) // Month is zero-based
                .min((r1, r2) -> r1.getRegistration_date().compareTo(r2.getRegistration_date()));

                String json2 = earliestInSeptember.map(registration -> new Gson().toJson(registration)).orElse("{}");

        // earliestInSeptember.stream().forEach(System.out::println);

        // 3 . Athletes who registered for events in October and not in September ?
        List<Registration> octoberRegistrations = allregistration.stream()
                .filter(registration -> registration.getRegistration_date().toLocalDate().getMonthValue() == 10)
                .collect(Collectors.toList());

        List<Registration> septemberRegistrations1 = allregistration.stream()
                .filter(registration -> registration.getRegistration_date().toLocalDate().getMonthValue() == 9)
                .collect(Collectors.toList());

        List<String> athletesInOctoberNotInSeptember = octoberRegistrations.stream()
                .filter(octoberRegistration -> septemberRegistrations1.stream()
                        .noneMatch(septemberRegistration1 -> septemberRegistration1.getAthlete_name()
                                .equals(octoberRegistration.getAthlete_name())))
                .map(Registration::getAthlete_name)
                .collect(Collectors.toList());
                String json3 = new Gson().toJson(athletesInOctoberNotInSeptember);

        // earliestInSeptember.stream().forEach(System.out::println);

        // 4 . List of athletes who registered for "Marathon." ?

        List<String> marathonAthletes = allregistration.stream()
                .filter(registration -> "Marathon12".equals(registration.getEvent_name()))
                .map(Registration::getAthlete_name)
                .collect(Collectors.toList());
                String json4 = new Gson().toJson(marathonAthletes);

        // marathonAthletes.stream().forEach(System.out::println);

        // 5 . Event with the most registrations in October.

        Map<String, Long> registrationsByEventInOctober = allregistration.stream()
                .filter(registration -> registration.getRegistration_date().toLocalDate().getMonthValue() == 10)
                .collect(Collectors.groupingBy(Registration::getEvent_name, Collectors.counting()));

        Optional<Map.Entry<String, Long>> maxEntryInOctober = registrationsByEventInOctober.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));

        String eventWithMostRegistrationsInOctober = maxEntryInOctober.map(Map.Entry::getKey)
                .orElse("No registrations in October");
                String json6 = new Gson().toJson(eventWithMostRegistrationsInOctober);

        // System.out.println(registrationsByEventInOctober);

        // 6 . Events with names that are unique (considering case sensitivity).

        Map<String, Long> eventCountMap = allregistration.stream()
                .collect(Collectors.groupingBy(
                        registration -> registration.getEvent_name().toLowerCase(),
                        Collectors.counting()));

        List<Registration> uniqueEvents = allregistration.stream()
                .filter(registration -> eventCountMap.get(registration.getEvent_name().toLowerCase()) == 1)
                .collect(Collectors.toList());
                String json5 = new Gson().toJson(uniqueEvents);

        // uniqueEvents.stream().forEach(System.out::println);

        
// Create a JsonObject to hold the lists
            JsonObject mainJsonObject = new JsonObject();
            // Add earliestInSeptember to the mainJsonObject
            earliestInSeptember.ifPresent(registration -> {
            JsonObject earliestInSeptemberJson = new JsonObject();
            earliestInSeptemberJson.addProperty("registration_id", registration.getRegistration_id());
            earliestInSeptemberJson.addProperty("event_name", registration.getEvent_name());
            earliestInSeptemberJson.addProperty("athlete_name", registration.getAthlete_name());
            earliestInSeptemberJson.addProperty("registration_date", registration.getRegistration_date().toString());

            mainJsonObject.add("earliestInSeptember", earliestInSeptemberJson);
        });

        // Add registrationsByEventInOctober to the mainJsonObject
        JsonArray registrationsByEventArray = new JsonArray();
        registrationsByEventInOctober.forEach((event, count) -> {
            JsonObject eventObject = new JsonObject();
            eventObject.addProperty("event_name", event);
            eventObject.addProperty("registration_count", count);
            registrationsByEventArray.add(eventObject);
        });

        mainJsonObject.add("registrationsByEventInOctober", registrationsByEventArray);
        // Convert the listBook to a JsonArray and add it to the mainJsonObject
        JsonArray septemberRegistrationsarr = new Gson().toJsonTree(septemberRegistrations).getAsJsonArray();
        mainJsonObject.add("septemberRegistrationsarr", septemberRegistrationsarr);

        JsonArray octoberRegistrationsarr = new Gson().toJsonTree(octoberRegistrations).getAsJsonArray();
        mainJsonObject.add("octoberRegistrationsarr", octoberRegistrationsarr);

        JsonArray marathonAthletesarr = new Gson().toJsonTree(marathonAthletes).getAsJsonArray();
        mainJsonObject.add("marathonAthletesarr", marathonAthletesarr);

        JsonArray uniqueEventsarr = new Gson().toJsonTree(uniqueEvents).getAsJsonArray();
        mainJsonObject.add("uniqueEventsarr", uniqueEventsarr);
        // Convert the JsonObject to a JSON string

        JsonArray table = new Gson().toJsonTree(allregistration).getAsJsonArray();
        mainJsonObject.add("table1", table);

        String combinedJson = new Gson().toJson(mainJsonObject);

        // System.out.println(combinedJson);

        Arrays.stream(combinedJson.split(",")).map(String::trim).forEach(System.out::println);

        return null;
    }
}
