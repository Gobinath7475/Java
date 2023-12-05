import java.util.*;

public class password 
{
    public static void main(String[] args) 
    {
        System.out.println(generatepassword(8));
    }
    public static char [] generatepassword (int length)
    {
         String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
         String lower = "abcdefghijklmnopqrstuvwxyz";
         String number = "1234567890";
         String spl = "~!@#$%^&*()_+|?><";
         String combine = upper + lower + number + spl ;

         char [] password = new char [length];

         Random random = new Random();

         for(int i = 0 ; i<length ; i++)
         {
            password[i] = combine.charAt(random.nextInt(combine.length()));
         }
           return password ;
    }
}
