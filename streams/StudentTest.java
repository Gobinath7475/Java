import java.util.Arrays;
import java.util.List;

public class StudentTest {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(1, "David"),
                new Student(2, "miller"),
                new Student(3, "james"),
                new Student(4, "john"),
                new Student(5, "scott"));

        students.stream().map(s -> s.getName()).forEach(System.out::println);

        students.stream().map(s -> s.getRoll_no()).forEach(System.out::println);
    }
}
