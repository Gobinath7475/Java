package com.kgisl.SpringQuery.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kgisl.SpringQuery.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
        // 1 .Athletes who registered for the most events in September.
        Registration findFirstByRegistrationDateBetweenOrderByRegistrationDateDesc(
                        LocalDate startDate, LocalDate endDate);

        // 2 . Events with the earliest registration date in September:
        List<Registration> findFirstByRegistrationDateBetweenOrderByRegistrationDateAsc(
                        LocalDate startDate, LocalDate endDate);

        // 3.Athletes who registered for events in October and not in September.

        @Query(value = "SELECT * FROM registrations " +
                        "WHERE registration_date BETWEEN :startOfSeptember AND :endOfSeptember " +
                        "AND registration_date NOT BETWEEN :startOfOctober AND :endOfOctober", nativeQuery = true)
        List<Registration> findRegistrationsInSeptemberNotInOctober(
                        @Param("startOfSeptember") LocalDate startOfSeptember,
                        @Param("endOfSeptember") LocalDate endOfSeptember,
                        @Param("startOfOctober") LocalDate startOfOctober,
                        @Param("endOfOctober") LocalDate endOfOctober);

        // 4. List of athletes who registered for "Marathon."

        @Query("SELECT r.athleteName FROM Registration r WHERE r.eventName = 'Marathon'")
        List<String> findAthletesForMarathon();

        // 5. Events with names that are unique (considering case sensitivity).

        @Query(value = "SELECT event_name " +
                        "FROM registrations " +
                        "GROUP BY event_name " +
                        "HAVING COUNT(event_name) = 1", nativeQuery = true)
        List<String> findUniqueEventNamesNativeQuery();

        // 6 . Event with the most registrations in October.

        @Query(value = "SELECT event_name " +
                        "FROM registrations " +
                        "WHERE registration_date BETWEEN :startOfOctober AND :endOfOctober " +
                        "GROUP BY event_name " +
                        "ORDER BY COUNT(*) DESC " +
                        "LIMIT 1", nativeQuery = true)
        String findEventWithMostRegistrationsInOctober(
                        @Param("startOfOctober") LocalDate startOfOctober,
                        @Param("endOfOctober") LocalDate endOfOctober);

       
}
