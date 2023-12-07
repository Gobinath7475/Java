import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import javax.sound.sampled.SourceDataLine;

class PersonTest {
  public static void main(String[] args) {
    List<Person> persons = Arrays.asList(
        new Person("Alice", 95),
        new Person("Bob", 30),
        new Person("Charlie", 35),
        new Person("David", 40),
        new Person("Evi", 40),
        new Person("Frank", 50),
        new Person("Gracd", 55),
        new Person("Henrd", 60),
        new Person("Isaad", 65),
        new Person("David", 40),
        new Person("David", 40),
        new Person("John", 70));

    // Stream<Person> nameendsWithe = persons.stream().filter(x ->
    // x.getName().endsWith("e"));
    // nameendsWithe.filter(x -> x.getAge() > 50).forEach(System.out::println);
    // persons.stream().max(Comparator.comparing(Person::getName)).ifPresent(System.out::println);

    // persons.stream().max(Comparator.comparing(Person::getAge))
    // .ifPresent(System.out::println);

    // persons.stream().min(Comparator.comparing(Person::getAge))
    // .ifPresent(System.out::println);

    // Set<Person> l1 = persons.stream().filter(s -> s.getName().endsWith("e")).collect(Collectors.toSet());
    // l1.forEach(System.out::println);

    // long Count = persons.stream().filter(e -> e.getName().endsWith("e")).count();
    // System.out.println(Count);

    // List<String> l2 = persons.stream().map(Person::getName).distinct().collect(Collectors.toList());
    // l2.forEach(System.out::println);

    // persons.stream().skip(10).forEach(System.out::println);

    // persons.stream().limit(2).forEach(System.out::println);

    // boolean b = persons.stream().allMatch(x -> x.getAge()>=30 );
    // System.err.println(b);

    // boolean b1 = persons.stream().noneMatch(x -> x.getAge() >=100);
    // System.out.println(b1);

    // boolean b2 = persons.stream().anyMatch(x -> x.getAge() >= 100);
    // System.out.println(b2);

    // String[] myArray = { "this ", "is ", "a ", "sentence" };
    // String result = Arrays.stream(myArray).reduce("", (a, b) -> a + b);
    // System.out.println(result);

    // int[] myArray1 = { 1, 2, 3, 4 };
    // int result1 = Arrays.stream(myArray1).reduce(0, (a, b) -> a + b);
    // System.out.println(result1);

    // Optional<Person>
    // b5=persons.stream().filter(s->s.getName().endsWith("i")).findAny();
    // System.out.println(b5);

    // Optional<Person> o1 = persons.stream().filter(emp -> emp.getAge() < 20).findFirst();
    // if (o1.isPresent())
    // System.out.println(o1.get());

    // List<Person> slist = persons.stream().sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList());
    // slist.stream().peek(i -> System.out.println(i));

    // Person[] type = persons.stream().filter(s -> s.getName().endsWith("i")).toArray(Person[]::new);
    // Stream.of(type).forEach(System.out::println);

    // List<Integer> list = Arrays.asList(10, 11, 12);
    // list.stream().peek(i -> System.out.println(i * i)).collect(Collectors.toList());

    //persons.stream().forEachOrdered();

    // Stream<Person> stream = persons.parallelStream();
    // List<Person> evenNumbersArr = stream.filter(emp -> emp.getAge() >40).collect(Collectors.toList());
    // evenNumbersArr.parallelStream().forEach(System.out::println);

    // Double sum1 = persons.stream().mapToDouble(Person::getAge).average().getAsDouble();
    // System.out.println(sum1);

    Stream.Builder<String> b = Stream.builder();
    Stream <String> c = b.add("S").add("a").add("david").add("c").add("d").build();
    List<String> list = c.map(String :: toUpperCase).collect(Collectors.toList());
    System.out.println(list);

  }
}
