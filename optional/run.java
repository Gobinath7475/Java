import java.util.Optional;

public class run {
    public static void main(String[] args) {

        String[] str = new String[10];

        Optional<String> optional = Optional.ofNullable(str[9]);

        if (optional.isPresent()) {
            String str1 = str[9].substring(2, 5);

            System.out.println(str1);
        } 
        else
            System.out.println("Value is null");

        str[9] = "David kumar";

        Optional<String> optional1 = Optional.ofNullable(str[9]);

        if (optional1.isPresent()) {
            String str2 = str[9].substring(2, 6);

            System.out.println(str2);
        } 
        else
            System.out.println("Value is nor present");
    }
}
