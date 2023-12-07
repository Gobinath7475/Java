import java.util.HashSet;


public class Hashset {
    static  HashSet <User> users = new HashSet<>();
    public static void main(String[] args) {
        insertuser();
        //displayuser();
        deleteuser();
        displayuser();
        //updateuser();
        //searchuser();
    }
    public static void insertuser()
    {
        users.add(new User(1, "john_doe", "password123", "john@example.com", "John", "Doe", "athlete"));
        users.add(new User(2, "jane_smith", "pass456", "jane@example.com", "Jane", "Smith", "coach")); 
        users.add(new User(3, "admin_user", "adminPass", "admin@example.com", "Admin", "User", "administrator"));       
    }

    public static void displayuser()
    {
        for (User i : users) {
            System.out.println("User ID: " + i.getUser_id());
            System.out.println("Username: " + i.getUsername());
            System.out.println("Email: " + i.getEmail());
            System.out.println("First Name: " + i.getFirst_name());
            System.out.println("Last Name: " + i.getLast_name());
            System.out.println("User Type: " + i.getUser_type());
            System.out.println();
        }
    }
    public static void deleteuser()
        {
            //users.remove(0);
            users.removeIf(user -> user.getUser_id() == 3);
        }
}