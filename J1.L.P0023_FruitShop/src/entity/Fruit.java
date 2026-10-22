package entity;

public class Fruit {

    private String fruitId;
    private String fruitName;
    private double price;
    private int quantity;
    private String origin;

    public Fruit() {
    }

    public Fruit(String fruitId, String fruitName, double price, int quantity, String origin) {
        setFruitId(fruitId);
        setFruitName(fruitName);
        setPrice(price);
        setQuantity(quantity);
        setOrigin(origin);
    }

    public String getFruitId() {
        return fruitId;
    }

    public void setFruitId(String fruitId) {
        if (fruitId == null || fruitId.trim().isEmpty()) {
            throw new IllegalArgumentException("Fruit Id cannot be empty");
        }
        this.fruitId = fruitId.trim();
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        if (fruitName == null || fruitName.trim().isEmpty()) {
            throw new IllegalArgumentException("Fruit Name cannot be empty");
        }
        this.fruitName = fruitName.trim();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be > 0");
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be >= 0");
        }
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        if (origin == null || origin.trim().isEmpty()) {
            throw new IllegalArgumentException("Origin cannot be empty");
        }
        this.origin = origin.trim();
    }

    @Override
    public String toString() {
        return String.format("%-10s%-15s%-12s%-10.0f$%-8d", fruitId, fruitName, origin, price, quantity);
    }
}
