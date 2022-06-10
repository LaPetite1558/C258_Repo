import java.io.IOException;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class PizzaTest {
    public static void main(String[] args) throws IOException {
        List<Pizza> storeMenu = new ArrayList<>();
        int[] stock = {100, 2, 5, 1, 21, 12};

        storeMenu.add(new Pizza(101, "Margherita", 12.80));
        storeMenu.add(new Pizza(123,"Pepperoni", 13.90));
        storeMenu.add(new Pizza(312,"Mushroom", 11.75));
        storeMenu.add(new Pizza(104,"Hawaiian", 12.55));
        storeMenu.add(new Pizza(102, "Seafood ", 16.40));
        storeMenu.add(new Pizza(111, "Vegetarian", 10.20));

        PizzaStore store = new PizzaStore(storeMenu, stock);

        try (Scanner in = new Scanner(System.in)) {
            store.addToMenu(in);
            for (int i = 0; i < 2; i++) {
                store.addOrder(in);
                store.checkoutOrder();
            }

        } catch (EmptyStackException e) {
            out.println("No order found.");
        } catch (InputMismatchException e) {
            out.println("Invalid input.");
        } finally {
            in.close();
        }

        Stack<Order> completed = store.getCompletedOrders();

        for (Order o:completed) {
            store.printBill(o);
        }

        store.printMenu();

    }
}
