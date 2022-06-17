package WeekTwo;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
 /*
 Order Map
 Key - Customer name? Customer ID?
 Values - Customer orders
            --> orderID
            --> pizzas ordered
                --> type of pizza
                --> quantity of pizza
  */

public class Order {
    private long orderID;
    private Map<Pizza, Integer> pizzas;
    public Order(long orderID) {
        setOrderID(orderID);
        this.pizzas = new HashMap<>();
        // OrderID --> pizzas (map of pizzaIDs and tuples of Pizza objects and quantities
        // i.e. map of pizzaIDs and Pizza, quantity tuples with Order object
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public Map<Pizza, Integer> getPizzas() {
        return pizzas;
    }

    public void addPizzas(Pizza pizza, int quantity) {
        /* check if customer has already ordered specified
        type of pizza in a previous loop for this order */
        if (getPizzas().containsKey(pizza)) {
            int currQt = getPizzas().get(pizza); // get current quantity of pizza type in this order
            getPizzas().replace(pizza, currQt + quantity); // add quantity just specified to existing
        } else getPizzas().put(pizza, quantity); // otherwise just put new pizza and quantity in
    }

    //    private int orderID;
//    private String customerName;
//    private final Map<Pizza, Integer> pizzaOrder;
//
//    public Order(int orderID, String customerName) {
//        setOrderID(orderID);
//        setCustomerName(customerName);
//        this.pizzaOrder = new HashMap<>();
//    }
//
//    public void addPizza(Pizza pizza, Integer qt) {
//        if (pizzaOrder.containsKey(pizza)) {
//            pizzaOrder.replace(pizza, pizzaOrder.get(pizza)+qt);
//        } else pizzaOrder.put(pizza, qt);
//    }
//
//    public int getOrderID() {
//        return orderID;
//    }
//
//    public void setOrderID(int orderID) {
//        this.orderID = orderID;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public Map<Pizza, Integer> getPizzaOrder() {
//        return pizzaOrder;
//    }

//    public void setPizzaOrder(Map<WeekOne.Pizza, Integer> pizzaOrder) {
//        this.pizzaOrder = pizzaOrder;
//    }
}
