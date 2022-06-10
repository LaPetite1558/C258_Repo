import static java.lang.System.out;

class A {
    int x;

    int getX() {
        return this.x;
    }
}

public class TestThis {
    public static void main(String[] args) {
        A obj = new A();
        obj.x = 50;

        A obj2 = new A();

        out.println(obj.x);
        out.println(obj2.x);



    }
}
