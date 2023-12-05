
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LineRead {

    public static void main(String[] args) throws IOException {

        String fileName = "C:\\Users\\joshika.d\\Documents\\read.txt";
        
        Stream<String> lines = Files.lines(Paths.get(fileName));

        lines.forEach(System.out::println);
    }
}