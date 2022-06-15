package WeekTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.Vector;

import static java.lang.System.out;

public class ListOfNumbers {
    public static Vector<?> readList(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner in = new Scanner(file);
        Vector<Integer> vector = new Vector<>();

        while (in.hasNextInt()) {
            int line = in.nextInt();
            out.println(line);
            vector.add(line);
        }
        return vector;
    }

    public static void cat(File file) throws IOException {
        String line;
        try (RandomAccessFile input = new RandomAccessFile(file, "r")) {
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            out.printf("%s not found.", file.getPath());
        }
    }

    public static void main(String[] args) {
        try {
            cat(new File("concepts/src/WeekTwo/numbers.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        Vector<?> vector = null;
//        try {
//            vector = readList("concepts/src/WeekTwo/numbers.txt");
//        } catch (FileNotFoundException e) {
//            out.println("No file found.");
//        } finally {
//            out.println(vector);
//        }
    }
}
