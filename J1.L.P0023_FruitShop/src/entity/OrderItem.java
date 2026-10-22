package entity;

public class OrderItem {

    private String fruitName;
    private int quantity;
    private double price;

    public OrderItem() {
    }

    public OrderItem(String fruitName, int quantity, double price) {
        setFruitName(fruitName);
        setQuantity(quantity);
        setPrice(price);
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        if (fruitName == null || fruitName.trim().isEmpty()) {
            throw new IllegalArgumentException("Fruit name cannot be empty");
        }
        this.fruitName = fruitName.trim();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be > 0");
        }
        this.quantity = quantity;
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

    public double getAmount() {
        return quantity * price;
    }
}
