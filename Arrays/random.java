import java.util.Arrays;
// import java.util.concurrent.ThreadLocalRandom;

public class random {
    public static void main(String[] args) {

        // for (int i = 0; i < 5; i++)
        // {
        // int randomNum = ThreadLocalRandom.current().nextInt(1, 41);
        // System.out.print(randomNum + " ");
        // }

        int r[] = { 32,26,34,18,35,

            7,1,20,28,23,
            
            6,17,5,12,25,
            
            2,39,3,24,40,
            
            11,14,36,13,38,
            
            15,16,27,30,29,
            
            9,37,10,22,31,
            
            4,19,33,21,8 };
                Arrays.sort(r);
                System.out.println(Arrays.toString(r));
    }
}
