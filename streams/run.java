import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class run {
    public static void main(String[] args) {
        List<String> students = Arrays.asList("gobinath", "joshika", "swathi", "praveen", "kavin", "priya");

        // students.forEach(System.out::println);

        Consumer<String> con = (String t) -> System.out.println(t);
        students.forEach(con);

    }
}
