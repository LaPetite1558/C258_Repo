package WeekTwo;

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
    private final Map<Pizza, Integer> pizzas;
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
}
