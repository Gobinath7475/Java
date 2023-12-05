import java.util.HashMap;

public class Count {
    public static void main(String[] args) {
        // Sample array of athlete registration dates
        String[] registrationDates = {
            "2023-10-10", "2023-10-10", "2023-10-11", "2023-10-12", "2023-10-11"
        };

        // Create a HashMap to store date counts
        HashMap<String, Integer> dateCounts = new HashMap<>();

        // Count the athletes for each registration date
        for (String date : registrationDates) {
            dateCounts.put(date, dateCounts.getOrDefault(date, 0) + 1);
        }

        // Print the counts
        for (String date : dateCounts.keySet()) {
            int count = dateCounts.get(date);
            System.out.println("Date: " + date + ", Count: " + count);
        }
    }
}