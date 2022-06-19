import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        readFile();
    }

    public static void readFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("lorem2.txt"));

        String lines = bufferedReader.readLine();
        System.out.println(lines);
        bufferedReader.close();

    }
}