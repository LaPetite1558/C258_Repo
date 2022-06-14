package WeekOne;

import java.util.*;
import static java.lang.System.out;

public class PizzaStore {
    private final Map<Pizza, Integer> menu;
    private final Stack<Order> queuedOrders;
    private final Stack<Order> completedOrders;
    private double earnings;
    private static int orderCount = 0;

    public PizzaStore(List<Pizza> pizzas, int[] stock) {
        this.menu = new HashMap<>();
        queuedOrders = new Stack<>();
        completedOrders = new Stack<>();

        for (Pizza p:pizzas) {
            menu.put(p, stock[pizzas.indexOf(p)]);
        }
    }

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    public Map<Pizza, Integer> getMenu() {
        return menu;
    }

    public void checkoutOrder() {
        Order checkout = queuedOrders.pop(); // pop order from top of stack
        double bill = getBill(checkout); // get bill
        completedOrders.add(checkout); // add to completed orders
        setEarnings(getEarnings()+bill); // add bill to store earnings
    }

    private Pizza hasPizza(int id) {
        for (Pizza p:getMenu().keySet()) {
            if (p.getpID()==id) {
                return p;
            }
        }
        return null;
    }

    public void printMenu() {
        out.println("\n-----------MENU-----------");
        out.println("ID\tType\t\tPrice\tQt");

        for (Pizza p:getMenu().keySet()) {
            out.printf("%d\t%s\t$%.2f\t%d\n",p.getpID(),
                    p.getType(),p.getPrice(),getMenu().get(p));
        }
    }

    public void addToMenu(Scanner in) {
        out.print("Enter id: ");
        int id = in.nextInt();
        Pizza p = hasPizza(id);
        String usrInput;
        int qt;

        if (p != null) {
            out.printf("%d has %d in stock. " +
                    "Replenish stock? [Y|N] ",
                    id, getMenu().get(p));

            usrInput = in.next();
            if (usrInput.equals("Y")) {
                out.print("Enter quantity to add to current stock: ");
                qt = in.nextInt();
                getMenu().replace(p, getMenu().get(p)+qt);
            }

        } else {
            out.print("No such item in menu. Add new pizza? [Y|N] ");
            usrInput = in.next();
            if (usrInput.equals("Y")) {
                out.print("Enter type for new pizza: ");
                String type = in.next();

                out.print("Enter price for new pizza: ");
                double price = in.nextDouble();

                out.print("Enter quantity of new pizza: ");
                qt = in.nextInt();
                getMenu().put(new Pizza(id, type, price), qt);
            }
        }
    }

    public void addOrder(Scanner in) {
        boolean finished;

        out.print("\nEnter customer name: ");
        String name = in.next();

        // create new order
        Order newOrder = new Order(orderCount, name);

        do {
            printMenu();
            out.print("\nEnter pizza ID: ");
            int id = in.nextInt();
            Pizza p = hasPizza(id);

            if (p != null) {
                int stock = getMenu().get(p);

                // if no stock of queried pizza
                if (stock == 0) {
                    out.printf("No %s pizza in stock.\n",
                            p.getType());
                } else {
                    out.printf("Enter quantity of %s to order: ",
                            p.getType());
                    int qt = in.nextInt();

                    // if quantity more than current stock of pizza
                    if (qt > stock) {
                        out.printf("Only %d %s pizza/s in stock.\n",
                                stock, p.getType());
                    } else {
                        // subtract qt from stock
                        getMenu().replace(p, stock-qt);
                        // add pizza to new order
                        newOrder.addPizza(p, qt);
                    }
                }
            } else out.println("No such item in the menu.");

            printBill(newOrder);
            out.print("WeekOne.Order more items? [Y|N] ");
            String more = in.next();
            finished = more.equals("Y") || more.equals("y");
        } while (finished); // repeat ordering process until finished

        // do not add to storeOrders if no items ordered
        if (newOrder.getPizzaOrder().isEmpty()) {
            out.println("No items selected.");
        } else {
            queuedOrders.add(newOrder); // add new order to storeOrders
            orderCount++;
        }
    }

    public void printBill(Order order) {
        double bill = 0;
        out.println("\n-------------BILL--------------");
        out.printf("WeekOne.Order %d\nCustomer: %s\n",
                order.getOrderID(), order.getCustomerName());
        out.println("Item\t\tPrice\tQt\tSubtotal");
        for (Pizza p:order.getPizzaOrder().keySet()) {
            int qt = order.getPizzaOrder().get(p); // quantity of WeekOne.Pizza p ordered
            double pTotal = p.getPrice()*qt; // total cost of WeekOne.Pizza/s p ordered
            out.printf("%s\t$%.2f\t%d\t$%.2f\n",
                    p.getType(),p.getPrice(), qt, pTotal);
            bill += pTotal;
        }
        out.println("--------------------------------");
        out.printf("Total:\t\t\t\t\t$%.2f\n", bill);
        out.println("--------------------------------");
    }

    public double getBill(Order order) {
        double bill = 0;
        for (Pizza p:order.getPizzaOrder().keySet()) {
            bill += p.getPrice()*order.getPizzaOrder().get(p);
        }
        return bill;
    }

    public Stack<Order> getQueuedOrders() {
        return queuedOrders;
    }

    public Stack<Order> getCompletedOrders() {
        return completedOrders;
    }

}
