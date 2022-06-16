package WeekTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import static java.lang.System.in;
import static java.lang.System.out;

public class ListOfNumbers {
    public static Vector<?> readList(File file) throws IOException {
        Vector<Integer> vector = new Vector<>();

        try {
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                int line = in.nextInt();
                out.println(line);
                vector.add(line);
            }
        } catch (FileNotFoundException e) {
            out.printf("%s not found.\n", file.getPath());
        } catch (InputMismatchException e) {
            out.println("Non-numerical value found. Ending program.");
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return vector;
    }

    public static void cat(File file) throws IOException {
        RandomAccessFile input = null;
        String line;

        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("concepts/src/WeekTwo/numbers.txt");

        try {
            cat(file);
        } catch (RuntimeException e) {
            out.println("No file found!");
        } catch (IOException e) {
            out.println(e);
        }

        Vector<?> vector = null;

        try {
            vector = readList(file);
        } catch (IOException e) {
            out.println(e);
        } finally {
            out.println(vector);
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
