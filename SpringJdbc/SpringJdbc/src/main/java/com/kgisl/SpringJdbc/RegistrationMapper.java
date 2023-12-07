package com.kgisl.SpringJdbc;


    import java.sql.ResultSet;
import java.sql.SQLException;
 
import org.springframework.jdbc.core.RowMapper;
 
public class RegistrationMapper implements RowMapper<Registration> {
 
    @Override
    public Registration mapRow(ResultSet arg0, int arg1) throws SQLException {

        Registration registration=new Registration();

        registration.setRegistration_id(arg0.getInt("registration_id"));
        registration.setAthlete_name(arg0.getString("Athlete_name"));
        registration.setEvent_name(arg0.getString("Event_name"));
        registration.setRegistration_date(arg0.getDate("Registration_date"));
        
        return registration;
    }
}

