package WeekTwo;

import static java.lang.System.out;

public class IntString {
    protected static class Blah {
        static void blah() {
            out.println("blah");
        }
    }
    public static String convert(int number) {
        return String.valueOf(number);
    }

    public static int convert(String number) {
        return Integer.parseInt(number);
    }
    public static void main(String[] args) {
        String fifty = convert(50);
        Integer fiftyBack = convert(fifty);

        out.println(fifty);
        out.println(fiftyBack);

        out.println(fifty.getClass());
        out.println(fiftyBack.getClass());

        Blah.blah();
    }
}
