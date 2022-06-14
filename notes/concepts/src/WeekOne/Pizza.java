package WeekOne;

/*
3) Create a command line based application for WeekOne.Pizza delivery,
WeekOne.Pizza Menu, prices, quantity, checkout and total bill with quantity,
consider these functionalities and use OOP approach.
 */
public class Pizza {
    private String type;
    private int pID;
    private double price;

    public Pizza(int pID, String type, double price) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
