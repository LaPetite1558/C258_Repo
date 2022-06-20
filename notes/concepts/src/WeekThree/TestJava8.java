package WeekThree;

import java.util.Arrays;
import java.util.List;

public class TestJava8 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2,99,7,14,42,21,84,57,12);

        System.out.println("Squares");
        System.out.println("--------");
        numbers.forEach(integer -> System.out.println(((int) Math.pow(integer, 2))));
        System.out.println();
        System.out.println("Evens");
        System.out.println("------");
        numbers.stream().filter(integer -> integer%2==0).forEach(System.out::println);
        System.out.println();
        System.out.println("Odds");
        System.out.println("------");
        numbers.stream().filter(integer -> integer%2!=0).forEach(System.out::println);

        System.out.println("Original numbers:");
        System.out.println(numbers);
    }
}
