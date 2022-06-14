public class CarInventory {
    private String modelName;
    private long modelNumber;
    private String manufacturer;
    private double horsePower;
    private double mileage;
    private int seats;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public long getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(long modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(double horsePower) {
        this.horsePower = horsePower;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
