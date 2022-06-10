import static java.lang.System.out;

public class HelloWorld3 {

    public static int addition(int a, int b) {
        return a+b;
    }

    public static int areaSquare(int side) {
        return side * side;
    }

    public static int volCube(int side) {
        return areaSquare(side) * side;
    }

    public static void main(String[] args) {
        out.println(addition(12,24));

        out.println(areaSquare(5));
        out.println(volCube(5));
    }
}
