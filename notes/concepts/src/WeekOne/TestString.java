package WeekOne;

import java.util.Arrays;

public class TestString {
    // String --> collection of chars --> " "

    public static void main(String[] args) {
        String name = "Debs";
        System.out.println(name);

        char[] chars = {'D','e','b','s'};
        boolean check = Arrays.equals(name.toCharArray(), chars);
        System.out.println(check);
    }
}
