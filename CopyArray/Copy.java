import java.util.Arrays;

public class Copy 
{
    public static void main(String[] args) 
    {
        int[] originalArray = {1, 2, 3, 4, 5};

        int[] copiedArray = Arrays.copyOf(originalArray,5);

        originalArray[0] = 10;

        System.out.println(Arrays.toString(copiedArray));
        
        System.out.println(Arrays.toString(originalArray));
    }
}
