import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class readAllBytes {

    public static void main(String[] args) throws IOException {

        String fileName = "C:\\Users\\joshika.d\\Documents\\read.txt";

        byte[] bytes = Files.readAllBytes(Paths.get(fileName));

        String content = new String(bytes, StandardCharsets.UTF_8);

        System.out.println(content);
    }
}