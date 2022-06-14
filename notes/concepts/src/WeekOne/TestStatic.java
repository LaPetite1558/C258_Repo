package WeekOne;

import static java.lang.System.out;

class MyClass {
    public static int x = 20;

    public int getX() {
        return x;
    }
}

public class TestStatic {
    /*public static int x = 10;
    public int y = 20;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }*/

    public static void main(String[] args) {
//        WeekOne.MyClass myClass = new WeekOne.MyClass();
//        out.println(myClass.getX());

        out.println(MyClass.x);

        MyClass.x = 50;

        out.println(MyClass.x);
    }
}
