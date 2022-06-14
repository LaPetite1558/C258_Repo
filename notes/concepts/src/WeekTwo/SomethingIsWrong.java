package WeekTwo;

public interface SomethingIsWrong {
    static void aMethod(int aValue) {
        if (aValue > 0) {
            for (int i = 0; i < aValue; i++) {
                System.out.println("Hi Mom");
            }
        } else System.out.println("Invalid.");
    }
}
