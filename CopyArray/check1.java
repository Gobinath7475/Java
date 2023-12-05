// import java.lang.reflect.Array;
import java.util.Arrays;

public class check1 {
    public static void main(String[] args) 
    {
        int[] myArray = {1, 2, 3}; 

        int[] copy = myArray;

        copy[0] = 4;

        System.out.println(myArray[0]);

        System.out.println(Arrays.toString(myArray));
    }
}
