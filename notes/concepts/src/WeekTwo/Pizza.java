package WeekTwo;

import java.util.Objects;

/*
3) Create a command line based application for WeekOne.Pizza delivery,
WeekOne.Pizza Menu, prices, quantity, checkout and total bill with quantity,
consider these functionalities and use OOP approach.
 */
public class Pizza {
    private String type;
    private int pID;
    private float price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return getpID() == pizza.getpID() && Objects.equals(getType(), pizza.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getpID());
    }

    public Pizza(int pID, String type, float price) {
        setpID(pID);
        setType(type);
        setPrice(price);
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
