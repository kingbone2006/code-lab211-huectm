package model;

public class CarRequest {

    private String name;
    private String color;
    private int price;
    private String today;

    public CarRequest() {
    }

    public CarRequest(String name, String color, int price, String today) {
        setName(name);
        setColor(color);
        setPrice(price);
        setToday(today);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Car break");
        }
        this.name = name.trim().toUpperCase();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Color Car does not exist");
        }
        this.color = color.trim().toUpperCase();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price greater than zero");
        }
        this.price = price;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        if (today == null || today.trim().isEmpty()) {
            throw new IllegalArgumentException("Day is invalid");
        }
        this.today = today.trim().toUpperCase();
    }
}
