import java.util.Arrays;

public class null1 
{
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3};
int[] copy = myArray;
copy[0] = 5;
System.out.println(myArray[0]);
}
}
