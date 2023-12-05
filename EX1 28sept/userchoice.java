import java.util.Random;

import java.util.Scanner;

public class userchoice 
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("1.Generate password");

        System.out.println("2.Generate OTP");

        System.out.println("3.Encrypt");

        System.out.println("Enter the option: ");

        int option=sc.nextInt();

        if(option==1)
        {
         System.out.println(generatepassword(6));
        }
        else if (option==2)
        {
            System.out.println(generateotp(6));
        }
    }

    public static char[] generatepassword( int length)
    {
        Random obj=new Random();
 
        String uppercase= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String lowercase= "abcdefghijklmnopqrstuvwxyz";

        String number= "1234567890";

        String splcharacter= "!@#$%&*^";

        String combine=uppercase+lowercase+number+splcharacter;

        char[] password=new char[length];

        for(int i=0;i<length;i++)
        {
            password[i]=combine.charAt(obj.nextInt(combine.length()));
        }
        return password;
    }

    public static char[] generateotp(int length)
        {
            String num="1234567890";

            Random obj=new Random();

            char [] otp=new char[length];

            for(int i=0;i<length;i++)
            {
                otp[i]=num.charAt(obj.nextInt(num.length()));
            }
            return otp;
        }
       
}

