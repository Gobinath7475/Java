import java.util.Arrays;
import java.util.Scanner;

public class UserMain 
{  
    static User users [] = new User[5];
    public static void main(String[] args)  
    {
        createuser();
        display();
        delete();
        update();
    }
    public static void createuser () 
    {
        users[0] = new User(1, "Scott", "123", "abc@gmail.com", "Scott", "T" , "Athlete");
        users[1] = new User(2, "Tiger", "abc@1234", "abc25@gmail.com", "Tiger", "G" , "Coach");
        users[2] = new User(3, "HR", "123@hgtyu", "abc458@gmail.com", "HR", "H" , "Admin");
        users[3] = new User(4, "James", "123!hjh", "cgt@gmail.com", "James", "J" , "Coach");
        users[4] = new User(5, "William", "321@kja", "abc8785@gmail.com", "William", "W" , "Athlete");
    }

    public static void display()
    {
        for (int i = 0; i < users.length; i++) 
        {
            System.out.println(users[i]);
        }
        System.out.println("------------------------------------------");
    }
        
    public static void delete()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter delete index");
        int index = s.nextInt();
        users[index] = null ;
        for (int i = 0; i < users.length; i++) 
        {
            System.out.println(users[i]);
        } 
        System.out.println("------------------------------------------");
    }

    public static void update()
    {
        users[1] = new User(10, "hill", "ggda@1244", "ghj@gmail.com", "hill", "H", "Admin");
        for (int i = 0; i < users.length; i++) 
        {
            System.out.println(users[i]);
        }
        System.out.println("------------------------------------------");
    }
}



