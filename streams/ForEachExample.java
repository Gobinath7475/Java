import java.util.ArrayList;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(2);

        System.out.println("Using forEach:");
        numbers.forEach(number -> System.out.println(number));

        System.out.println("Using forEachOrdered:");
        numbers.stream().forEachOrdered(number -> System.out.println(number));
    }
}

// import java.util.stream.Stream;
 
// class GFG {
     
//     // Driver code
//     public static void main(String[] args) {
         
//     // Creating a Stream of Strings
//     Stream<String> stream = Stream.of("Geeks", "for", 
//                        "GeeksQuiz", "GeeksforGeeks");
         
//     // Check if all elements of stream
//     // have length greater than 2 using
//     // Stream allMatch(Predicate predicate)
//     boolean answer = stream.allMatch(str -> str.length() > 4);
     
//     // Displaying the result
//     System.out.println(answer);
// }
// }