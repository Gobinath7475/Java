import java.util.Arrays;

public class Clone 
{
 public static void main(String[] args) 
 {
    int[] originalArray = {1, 2, 3, 4, 5};

    int[] copiedArray = originalArray.clone();

    copiedArray[0] = 1000000000;

    System.out.println(Arrays.toString(copiedArray));

    System.out.println(Arrays.toString(originalArray));

 }   
}
