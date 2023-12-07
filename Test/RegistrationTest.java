import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RegistrationTest {
    static Registration[] registrations = new Registration[25];

    public static void main(String[] args) {
        setup();
        // mostRegistrationSep();
        // earliestRegistration ();
        // eventseptember();
         findmarathon();
        // uniquename();
        // regsisteroctomber();
    }

    public static void setup() {

        registrations[0] = new Registration(1, "Marathon", "John Doe", LocalDate.of(2023, 10, 1));
        registrations[1] = new Registration(2, "Swimming Competition", "Alice Smith", LocalDate.of(2023, 9, 25));
        registrations[2] = new Registration(3, "Soccer Tournament", "David Johnson", LocalDate.of(2023, 9, 1));
        registrations[3] = new Registration(4, "Tennis Open", "Emily Davis", LocalDate.of(2023, 10, 5));
        registrations[4] = new Registration(5, "Basketball Championship", "Sophia Brown", LocalDate.of(2023, 9, 15));
        registrations[5] = new Registration(6, "Cycling Race", "John Doe", LocalDate.of(2023, 10, 2));
        registrations[6] = new Registration(7, "Gymnastics Show", "Olivia Lee", LocalDate.of(2023, 9, 15));
        registrations[7] = new Registration(8, "Volleyball Tournament", "Ethan Anderson", LocalDate.of(2023, 10, 8));
        registrations[8] = new Registration(9, "Table Tennis Championship", "Alice Smith", LocalDate.of(2023, 9, 22));
        registrations[9] = new Registration(10, "Weightlifting Competition", "Liam Perez", LocalDate.of(2023, 9, 13));
        registrations[10] = new Registration(11, "Running Race", "Chloe Taylor", LocalDate.of(2023, 10, 1));
        registrations[11] = new Registration(12, "High Jump Championship", "Noah Hernandez", LocalDate.of(2023, 9, 30));
        registrations[12] = new Registration(13, "Badminton Tournament", "Grace Scott", LocalDate.of(2023, 10, 10));
        registrations[13] = new Registration(14, "Diving Competition", "Alice Smith", LocalDate.of(2023, 9, 26));
        registrations[14] = new Registration(15, "Archery Contest", "Aria Adams", LocalDate.of(2023, 10, 7));
        registrations[15] = new Registration(16, "Wrestling Championship", "Mia Turner", LocalDate.of(2023, 9, 19));
        registrations[16] = new Registration(17, "Marathon", "Logan Hall", LocalDate.of(2023, 9, 19));
        registrations[17] = new Registration(18, "Karate Tournament", "Aiden White", LocalDate.of(2023, 9, 6));
        registrations[18] = new Registration(19, "Fencing Championship", "Alice Smith", LocalDate.of(2023, 10, 6));
        registrations[19] = new Registration(20, "Shot Put Competition", "Mason King", LocalDate.of(2023, 9, 23));
        registrations[20] = new Registration(21, "Boxing Match", "Layla Turner", LocalDate.of(2023, 10, 9));
        registrations[21] = new Registration(22, "Marathon", "Jackson Green", LocalDate.of(2023, 9, 27));
        registrations[22] = new Registration(23, "Taekwondo Championship", "Harper Allen", LocalDate.of(2023, 10, 8));
        registrations[23] = new Registration(24, "Pole Vault Competition", "Lucas Adams", LocalDate.of(2023, 9, 21));
        registrations[24] = new Registration(25, "Marathon", "Luna Brown", LocalDate.of(2023, 10, 11));
    }

    public static void mostRegistrationSep() {
        int[] eventCounts = new int[25];
        String[] athleteNames = new String[25];

        int index = 0;

        for (Registration count : registrations) {
            if (count.getRegistration_date().getMonthValue() == 9) {
                athleteNames[index] = count.getAthlete_name();
                eventCounts[index]++;

                for (int i = 0; i < index; i++) {
                    if (athleteNames[i] != null && athleteNames[i].equals(athleteNames[index]))
                        eventCounts[i]++;
                }
                index++;
            }
        }

        int maxEvents = 0;
        for (int count : eventCounts) {
            if (count > maxEvents) {
                maxEvents = count;
            }
        }

        System.out.println("most registered athlete's in September:");
        for (int i = 0; i < eventCounts.length; i++) {
            if (eventCounts[i] == maxEvents) {
                System.out.println(athleteNames[i] + " = " + maxEvents);
            }
        }
    }

    public static void earliestRegistration() {
        LocalDate Ed = null;
        int Ecount = 0;
        Registration[] earliestEvent = new Registration[25];

        for (Registration count : registrations) {
            if (count.getRegistration_date().getMonthValue() == 9) {

                LocalDate registrationDate = count.getRegistration_date();

                if (Ed == null || registrationDate.isBefore(Ed)) {
                    Ed = registrationDate;
                    earliestEvent[0] = count;
                    Ecount = 1;
                } else if (registrationDate.isEqual(Ed)) {
                    earliestEvent[Ecount] = count;
                    Ecount++;
                }
            }
        }

        for (int i = 0; i < Ecount; i++) {
            System.out.println(earliestEvent[i].getEvent_name() + "  " + Ed);
        }
    }

    public static void eventseptember() {

        String Ename[] = new String[25];

        int septemberIndex = 0;

        for (Registration registration : registrations) {
            if (registration.getRegistration_date().getMonthValue() == 9) {
                Ename[septemberIndex] = registration.getAthlete_name();
                septemberIndex++;
            }
        }
        for (int i = 0; i < Ename.length; i++) {
            if (Ename[i] != null)
                System.out.println(Ename[i]);
        }
    }

    public static void findmarathon() {
        List<String> marathon = new ArrayList<>();

        for (Registration registration : registrations) {
            if (registration.getEvent_name().equalsIgnoreCase("Marathon")) {
                marathon.add(registration.getAthlete_name());
            }
        }

        for (String athleteName : marathon) {
            System.out.println(athleteName);
        }
    }

    public static void uniquename() {
        Set<String> uniqueEventNames = new HashSet<>();

        List<Registration> uniqueEvents = new ArrayList<>();

        for (int i = 0; i < registrations.length; i++) {
            String eventName = registrations[i].getEvent_name();

            if (!uniqueEventNames.contains(eventName)) {
                uniqueEventNames.add(eventName);
                uniqueEvents.add(registrations[i]);
            }
        }
        int count = 0;
        for (Registration registration : uniqueEvents) {
            System.out.println(registration.getEvent_name());
            count++;
        }
        System.out.println(count);
    }

    public static void regsisteroctomber() {
        Map<String, Integer> eventRegistrationsInOctober = new HashMap<>();

        for (Registration registration : registrations) {
            if (registration.getRegistration_date().getMonthValue() == 10) {
                String eventName = registration.getEvent_name();
                eventRegistrationsInOctober.put(eventName, eventRegistrationsInOctober.getOrDefault(eventName, 0) + 1);
            }
        }

        String eventMostRegistrations = null;
        int max = 0;

        for (Map.Entry<String, Integer> entry : eventRegistrationsInOctober.entrySet()) {
            if (entry.getValue() > max) {
                eventMostRegistrations = entry.getKey();
                max = entry.getValue();
            }
        }
        System.out.println(eventMostRegistrations + " " + max);
    }
}
