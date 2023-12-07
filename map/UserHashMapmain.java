import java.util.HashMap;
import java.util.Map;
class UserHashMapmain{

    public static void main(String[] args) {
        insertuser();
        //removeuser();
        updateuser();
        displayuser();
    }
    static Map<Integer,usermap> users=new HashMap<>();
    
    static void insertuser(){

        usermap obj1=new usermap(1, "user1", "password1", "user1@example.com", "John", "Doe", "athlete");

        usermap obj2 = new usermap(2, "user2", "password2", "user2@example.com", "Jane", "Smith", "coach");

        usermap obj3 = new usermap(3, "user3", "pass@123", "user3@gmail.com", "user3", "T", "athlete");

        usermap obj4 = new usermap(4, "user4", "pass@123", "user4@gmail.com", "user4", "N", "athlete");

        usermap obj5 = new usermap(5, "user5", "pass@123", "user5@gmail.com", "user5", "D", "athlete");
        
        users.put(obj1.getUser_id(),obj1);
        users.put(obj2.getUser_id(),obj2);
        users.put(obj3.getUser_id(),obj3);
        users.put(obj4.getUser_id(),obj4);
        users.put(obj5.getUser_id(),obj5);
      
    }
    
    static void displayuser() {
        for (usermap user : users.values()) {
            System.out.println(user);
            
        }
            
        }
    static void updateuser() {
        usermap userToUpdate = users.get(1); 
        userToUpdate.setUsername("updated_username");
        userToUpdate.setEmail("updated@example.com");

    }
    static void removeuser() {
        users.remove(2);
    }
}