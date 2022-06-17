package WeekTwo;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PizzaStoreRevamped {
    private final Scanner in;
    private long orderID;
    /*
    Pizza --> quantity
    integer quantity associated with Pizza
     */
    private final Map<Pizza, Integer> pizzaStock;

    /* customer --> List of Orders
    i.e. list of Order objects associated with customer */
    private final Map<String, ArrayList<Order>> customerOrders;

    public PizzaStoreRevamped() {
        this(new Scanner(System.in), new HashMap<>(), new HashMap<>(), 1);
    }

    public PizzaStoreRevamped(int[] pizzaIDs, String[] pizzaNames,
                              float[] pizzaPrices, int[] quantities) {
        this(new Scanner(System.in), new HashMap<>(), new HashMap<>(), 1);

        assert pizzaIDs.length == pizzaNames.length
                && pizzaIDs.length == quantities.length
                && pizzaNames.length == pizzaPrices.length;

        for (int i = 0; i < pizzaIDs.length; i++) {
            getPizzaStock().put(
                    new Pizza(pizzaIDs[i],
                            pizzaNames[i],
                            pizzaPrices[i]),
                    quantities[i]);
        }
    }

    public PizzaStoreRevamped(Scanner in, Map<Pizza, Integer> pizzaStock,
                              Map<String, ArrayList<Order>> customerOrders, long orderID) {
        this.in = in;
        this.pizzaStock = pizzaStock;
        this.customerOrders = customerOrders;
        this.orderID = orderID;
    }

    private boolean canOrder(Pizza pizza, int quantity) {
        return getPizzaStock().get(pizza) >= quantity;
    }

    private @Nullable Pizza canOrder(int pizzaID) {
        for (Pizza p : getPizzaStock().keySet()) {
            if (p.getpID() == pizzaID) {
                return p;
            }
        }
        return null;
    }

    public void checkOut(String customer) {
        if (getCustomerOrders().containsKey(customer)) {
            System.out.println("Customer: " + customer);
            float bill = 0;
            for (Order o : getOrders(customer)) {
                System.out.println("Order " + o.getOrderID());
                System.out.println("Pizza\t\tPrice\t\tQt");
                System.out.println("---------------------------");
                for (Pizza p : o.getPizzas().keySet()) {
                    bill += p.getPrice()*o.getPizzas().get(p);
                    System.out.printf("%s\t$%.2f\t\t%d\n",
                            p.getType(),p.getPrice(),o.getPizzas().get(p));
                }
                System.out.println("===========================");
                System.out.printf("\t\t\tTotal: $%.2f\n", bill);
            }
        } else System.out.println(customer + " has not made any orders.");
    }

    public void makeOrder(String customer) {
        Order newOrder = new Order(orderID); // create new order
        String more = "Y", input = "";
        do {
            // if customer does not have existing orders
            if (!getCustomerOrders().containsKey(customer)) {
                getCustomerOrders().put(customer, new ArrayList<>()); // create new customer and list of Orders
            }
            try {
                // get pizza type
                System.out.print("Enter pizzaID: ");
                input = in.nextLine();
                int pizzaID = Integer.parseInt(input);

                Pizza pizza = canOrder(pizzaID);
                // if pizza exists
                if (pizza != null) {
                    // get quantity of pizza type to order
                    System.out.print("Enter quantity to order: ");
                    input = in.nextLine();
                    int quantity = Integer.parseInt(input);
                    // if there is enough stock of pizza type
                    if (canOrder(pizza, quantity)) {
                        newOrder.addPizzas(pizza, quantity);
                        updateStock(pizza, quantity);
                    } else System.out.println("Insufficient stock.");
                } else System.out.println("No such pizza in stock.");
                
                System.out.print("Order more pizza? [Y|N] ");
                more = in.nextLine();
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            } 
        } while (more.equals("Y") || more.equals("y") || input.isEmpty());
        // loop until customer gives valid input or finishes order

        if (newOrder.getPizzas().isEmpty()) {
            System.out.println("No pizzas ordered.");
            // don't add order to list if nothing was ordered
        } else {
            getOrders(customer).add(newOrder);
            this.orderID++; // increment orderID if order was added
        }
    }

    public Map<Pizza, Integer> getPizzaStock() {
        return pizzaStock;
    }

    public Map<String, ArrayList<Order>> getCustomerOrders() {
        return customerOrders;
    }

    private ArrayList<Order> getOrders(String customer) {
        return getCustomerOrders().get(customer);
    }

    private void updateStock(Pizza pizza, int quantity) {
        int currStock = getPizzaStock().get(pizza); // get current store stock for type of pizza ordered
        getPizzaStock().replace(pizza, currStock - quantity); // subtract quantity ordered from current stock
    }
}

class TestPizzaStore {
    public static void main(String[] args) {
        int[] pizzaIDs = {101,102,111,120};
        String[] pizzaNames = {"Mushroom","Pepperoni","Veggie","Hawaiian"};
        float[] pizzaPrices = {12.25f,13.95f,9.99f,10.99f};
        int[] quantities = {10,12,2,8};

        PizzaStoreRevamped pizzaHut = new PizzaStoreRevamped(pizzaIDs,pizzaNames,pizzaPrices,quantities);

        pizzaHut.makeOrder("Bob");
        pizzaHut.checkOut("Bob");
//        pizzaHut.makeOrder("Bob");
//        pizzaHut.printOrder("Bob");
//        pizzaHut.makeOrder("Bob");
////        pizzaHut.printOrder("Bob");
////        pizzaHut.makeOrder("Jane");
////
//        pizzaHut.checkOut("Bob");
//        pizzaHut.printOrder("Bob");
    }
}
