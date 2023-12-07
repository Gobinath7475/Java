import java.util.Optional;
import java.util.stream.Stream;

public class methodrun {
    public static void main(String[] args) {

        Optional<String> optional1 = Optional.of("default value ");

        Optional<String> optional2 = Optional.empty();

        // of method
        // if (optional1.isPresent())
        // System.out.println("call optional1");
        // else
        // System.out.println("no value");

        // // empty method
        // if (optional2.isPresent())
        // System.out.println("call optional1");
        // else
        // System.out.println("no value");

        // optional1.ifPresent(s -> System.out.println("call optional1"));
        // optional2.ifPresent(s -> System.out.println("call optional2"));

        // System.out.println(optional1.orElse("value is not present"));
        // System.out.println(optional2.orElse("value is not present"));

        // System.out.println(optional1.orElseGet(() -> "default value for of"));
        // System.out.println(optional2.orElseGet(() -> "default valuefor empty"));

        // System.out.println(optional1.orElseThrow());
        // System.out.println(optional2.orElseThrow());

        // String s1 = optional1.get();
        // System.out.println(s1);

        // String s2 = optional2.get();
        // System.out.println(s2);

        // Stream<String> h = optional1.stream().filter(s -> s.equalsIgnoreCase("DEFAULT VALUE "));
        // h.forEach(System.out::println);

        // Optional <Integer> i1 = Optional.of(5);
        // System.out.println(i1.filter(s -> s.equals(5)));

        // Optional <Integer> i2 = Optional.of(5);
        // System.out.println(i2.filter(s -> s.equals(4)));

        // Optional<String> s3 = optional1.map(String::toUpperCase);
        // System.out.println(s3);

        Optional<Optional<String>> anotherOptional = Optional.of(Optional.of("BreakingBad")); 
         
        System.out.println(anotherOptional.flatMap(s -> s.map(String :: toUpperCase)));

    }
}
