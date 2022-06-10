import java.util.HashMap;
import java.util.Map;


public class Order {
    private int orderID;
    private String customerName;
    private final Map<Pizza, Integer> pizzaOrder;

    public Order(int orderID, String customerName) {
        setOrderID(orderID);
        setCustomerName(customerName);
        this.pizzaOrder = new HashMap<>();
    }

    public void addPizza(Pizza pizza, Integer qt) {
        if (pizzaOrder.containsKey(pizza)) {
            pizzaOrder.replace(pizza, pizzaOrder.get(pizza)+qt);
        } else pizzaOrder.put(pizza, qt);
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Map<Pizza, Integer> getPizzaOrder() {
        return pizzaOrder;
    }

//    public void setPizzaOrder(Map<Pizza, Integer> pizzaOrder) {
//        this.pizzaOrder = pizzaOrder;
//    }
}
