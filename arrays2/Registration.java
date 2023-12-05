import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Registration {
    private int registration_id;
    private int event_id;
    private int athlete_id;
    private Date registration_date;

    public Registration(int registration_id, int event_id, int athlete_id, Date date) {
        this.registration_id = registration_id;
        this.event_id = event_id;
        this.athlete_id = athlete_id;
        this.registration_date = date;
    }

    public int getRegistration_id() 
    {
        return registration_id;
    }

    public void setRegistration_id(int registration_id) 
    {
        this.registration_id = registration_id;
    }

    public int getEvent_id() 
    {
        return event_id;
    }

    public void setEvent_id(int event_id) 
    {
        this.event_id = event_id;
    }

    public int getAthlete_id() 
    {
        return athlete_id;
    } 

    public void setAthlete_id(int athlete_id) 
    {
        this.athlete_id = athlete_id;
    }

    public Date getRegistration_date() 
    {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) 
    {
        this.registration_date = registration_date;
    }

    
    @Override
    public String toString() {
        return "Registration [registration_id=" + registration_id + ", event_id=" + event_id + ", athlete_id="
                + athlete_id + ", registration_date=" + registration_date + "]";
    }

    public static void main(String [] args) 
    {
        // Creating sample data
        Registration[] registrations = new Registration[5];
        registrations[0] = new Registration(1, 101, 1001, new Date());
        registrations[1] = new Registration(2, 102, 1002, new Date());
        registrations[2] = new Registration(3, 103, 1003, new Date());
        registrations[3] = new Registration(4, 104, 1004, new Date());
        registrations[4] = new Registration(5, 105, 1005, new Date());

        //System.out.println(Arrays.toString(registrations));

        // Create a map to store registration_date and count                                                                                                                                                                                                                                                                                                                                                
        Map<Date, Integer> dateCountMap = new HashMap<>();

        // Count registration_date occurrences
        for (Registration registration : registrations)                                                                                                                                                                      
        {
            Date registrationDate = registration.getRegistration_date();
            dateCountMap.put(registrationDate, dateCountMap.getOrDefault(registrationDate, 0) + 1);
        }

        // Print registration_date and count
        for (Map.Entry<Date, Integer> entry : dateCountMap.entrySet()) 
        {
            Date registrationDate = entry.getKey();
            int count = entry.getValue();
            System.out.println("Registration Date: " + registrationDate + ", Count: " + count);
        }
    }
}
