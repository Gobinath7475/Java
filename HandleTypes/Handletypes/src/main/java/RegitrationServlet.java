import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mysql.cj.jdbc.MysqlDataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class RegitrationServlet extends HttpServlet {
    private Connection jdbcConnection;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Registration> listreg = new ArrayList<>();
        String sql = "SELECT * FROM Registration";
        Statement statement;
        try {
            connect();
            statement = jdbcConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int registration_id = resultSet.getInt("registration_id");
                String event_name = resultSet.getString("event_name");
                String athlete_name = resultSet.getString("athlete_name");
                Date registration_date = resultSet.getDate("registration_date");
                Registration registration = new Registration(registration_id, event_name, athlete_name,
                        registration_date);
                listreg.add(registration);

            }

             JsonArray listregarr = new Gson().toJsonTree(listreg).getAsJsonArray();
           
            // Athletes who registered for the most events in September.?

            List<Registration> septemberRegistrations = listreg.stream()
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

            // Events with the earliest registration date in September ?

            Optional<Registration> earliestInSeptember = listreg.stream()
                    .filter(registration -> registration.getRegistration_date().getMonth() == 8) // Month is zero-based
                    .min((r1, r2) -> r1.getRegistration_date().compareTo(r2.getRegistration_date()));

            // Convert the result to JSON
            String json2 = earliestInSeptember.map(registration -> new Gson().toJson(registration)).orElse("{}");

            // Athletes who registered for events in October and not in September ?

            List<Registration> octoberRegistrations = listreg.stream()
                    .filter(registration -> registration.getRegistration_date().toLocalDate().getMonthValue() == 10)
                    .collect(Collectors.toList());

            List<Registration> septemberRegistrations1 = listreg.stream()
                    .filter(registration -> registration.getRegistration_date().toLocalDate().getMonthValue() == 9)
                    .collect(Collectors.toList());

            List<String> athletesInOctoberNotInSeptember = octoberRegistrations.stream()
                    .filter(octoberRegistration -> septemberRegistrations1.stream()
                            .noneMatch(septemberRegistration1 -> septemberRegistration1.getAthlete_name()
                                    .equals(octoberRegistration.getAthlete_name())))
                    .map(Registration::getAthlete_name)
                    .collect(Collectors.toList());

            String json3 = new Gson().toJson(athletesInOctoberNotInSeptember);

            // List of athletes who registered for "Marathon." ?

            List<String> marathonAthletes = listreg.stream()
                    .filter(registration -> "Marathon12".equals(registration.getEvent_name()))
                    .map(Registration::getAthlete_name)
                    .collect(Collectors.toList());

            String json4 = new Gson().toJson(marathonAthletes);

            // Events with names that are unique (considering case sensitivity).

            List<Registration> uniqueEvents = listreg.stream()
                    .collect(Collectors.groupingBy(Registration::getEvent_name, Collectors.counting()))
                    .entrySet().stream()
                    .filter(entry -> entry.getValue() == 1)
                    .map(entry -> entry.getKey())
                    .map(eventName -> listreg.stream().filter(reg -> reg.getEvent_name().equals(eventName)).findFirst()
                            .orElse(null))
                    .collect(Collectors.toList());

            String json5 = new Gson().toJson(uniqueEvents);

            // Event with the most registrations in October.

            Map<String, Long> registrationsByEventInOctober = listreg.stream()
                    .filter(registration -> registration.getRegistration_date().toLocalDate().getMonthValue() == 10)
                    .collect(Collectors.groupingBy(Registration::getEvent_name, Collectors.counting()));

            Optional<Map.Entry<String, Long>> maxEntryInOctober = registrationsByEventInOctober.entrySet().stream()
                    .max(Comparator.comparing(Map.Entry::getValue));

            String eventWithMostRegistrationsInOctober = maxEntryInOctober.map(Map.Entry::getKey)
                    .orElse("No registrations in October");

            // Convert the result to JSON
            String json6 = new Gson().toJson(eventWithMostRegistrationsInOctober);

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

            JsonArray table = new Gson().toJsonTree(listreg).getAsJsonArray();
            mainJsonObject.add("table1", table);

            String combinedJson = new Gson().toJson(mainJsonObject);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(combinedJson);

            resultSet.close();
            statement.close();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            MysqlDataSource d = new MysqlDataSource();
            d.setUrl("jdbc:mysql://localhost:3306/Gobinath T");
            d.setUser("root");
            d.setPassword("");
            jdbcConnection = d.getConnection();
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
}