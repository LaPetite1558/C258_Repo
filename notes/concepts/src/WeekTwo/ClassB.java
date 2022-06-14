package WeekTwo;

public class ClassB extends ClassA {
//    public static void methodOne(int i) {
//    }
    // overrides ClassA methodTwo
    public void methodTwo(int i) {
        System.out.println("BLAH");
    }

//    public void methodThree(int i) {
//    }

    public static void methodFour(int i) {
        System.out.println("BOO");
    }
}

class TestAB {
    public static void main(String[] args) {
        ClassB.methodFour(2);
        ClassA.methodFour(2);
        ClassA.methodThree(3);

        ClassA mm = new ClassB();
        ClassA mb = new ClassA();

        mb.methodOne(1); // using ClassA methodOne
        mb.methodTwo(2); // using ClassA methodTwo

        mm.methodOne(1); // using ClassA methodOne
        mm.methodTwo(2); // using ClassB methodTwo

        System.out.println(mm.getClass()); // mm is def ClassB
    }
}
