import java.util.Arrays;

public class copyofrange 
{
    public static void main(String[] args) 
    {

        int[] originalArray = {1, 2, 3, 4, 5};

        int[] copiedArray = Arrays.copyOfRange(originalArray, 1, 4);

        copiedArray[0] = 10;

        System.out.println(Arrays.toString(copiedArray));

        System.err.println(Arrays.toString(originalArray));
    }
}
