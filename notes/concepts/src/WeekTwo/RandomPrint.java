package WeekTwo;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomPrint {
    public static void printRandom(List<Integer> arr){
        Collections.shuffle(arr);
//        arr.iterator().forEachRemaining(System.out::println);
        arr.forEach(System.out::println);

        for (int i : arr) {
            System.out.println(i);
        }
//        arr.stream().unordered().forEach((System.out::println));
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(50);
        list.add(6);
        list.add(1);
        list.add(21);
        list.add(4);
        list.add(18);

        printRandom(list);
    }
}
