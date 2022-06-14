package WeekTwo;

import java.nio.charset.StandardCharsets;
import java.util.*;

import org.apache.commons.lang3.RandomStringUtils;

import static java.lang.System.out;

class CustomObject {
    private int id;
    private String name;

    public CustomObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomObject that = (CustomObject) o;
        return getId() == that.getId() && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        byte[] bytes = getName().getBytes(StandardCharsets.UTF_8);
        int byteHash = Arrays.hashCode(bytes);
        return byteHash + getId();
    }
}

class CustomObject2 {
    private int id;
    private String name;

    public CustomObject2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class ObjectTest {
    public static int find(List<?> objects, int left,
                    int right, CustomObject obj) {
        if (right >= 1) {
            int mid = left + (right - left)/2;

            if (objects.get(mid).equals(obj)) {
                return mid;
            } else if (objects.subList(left, mid).contains(obj)) {
                return find(objects, left, mid - 1, obj);
            } else
            return find(objects, mid + 1, right, obj);
        }
        return -1;
    }

    public static int find(List<?> objects, int left,
                           int right, CustomObject2 obj) {
        if (right >= 1) {
            int mid = left + (right - left)/2;

            if (objects.get(mid).equals(obj)) {
                return mid;
            } else if (objects.subList(left, mid).contains(obj)) {
                return find(objects, left, mid - 1, obj);
            } else
                return find(objects, mid + 1, right, obj);
        }
        return -1;
    }

    public static void main(String[] args) {
        List<CustomObject> objects = new ArrayList<>();
        List<CustomObject2> objects2 = new ArrayList<>();

        for (int i = 1; i < 101; i++) {
            objects.add(new CustomObject(i, RandomStringUtils.randomAlphabetic(5).toLowerCase()));

            objects2.add(new CustomObject2(i, RandomStringUtils.randomAlphabetic(5).toLowerCase()));
        }

        // find random object
        Random random = new Random();
        int rIdx = random.nextInt(100);

        CustomObject rObj = objects.get(rIdx);
        CustomObject2 rObj2 = objects2.get(rIdx);

//        long start = System.nanoTime();
//        out.println(find(objects2, 0, objects2.size()-1, rObj2));
//        out.println("Time taken to run is " + (System.nanoTime() - start) + "s");

        long start = System.nanoTime();
        out.println(find(objects, 0, objects.size()-1, rObj));
        out.println("Time taken to run is " + (System.nanoTime() - start) + "s");






//        WeekTwo.CustomObject obj1 = new WeekTwo.CustomObject(1, "Bob");
//        WeekTwo.CustomObject obj2 = new WeekTwo.CustomObject(1, "Bob");
//        WeekTwo.CustomObject obj3 = new WeekTwo.CustomObject(101, "Bob");
//
//        out.println(obj1.equals(obj2));
//        out.println(obj1.equals(obj3));
//        out.println(obj2.equals(obj3));
//        out.println(obj1.hashCode() == obj2.hashCode());
//        out.println(obj1.hashCode() == obj3.hashCode());
//        out.println(obj2.hashCode() == obj3.hashCode());
    }
}