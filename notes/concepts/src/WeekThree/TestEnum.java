package WeekThree;

enum MyEnum {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

enum CoffeeSizes {

    SMALL(100),
    MEDIUM(100),
    LARGE(100);
    private final int quantity;

    CoffeeSizes(int quantity) {
        this.quantity = quantity;
    }
}

public class TestEnum {
    public static void main(String[] args) {
        MyEnum enum1 = MyEnum.MONDAY;
        System.out.println(enum1);
    }
}
