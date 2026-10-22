package model;

import java.util.Arrays;
import java.util.List;

public class Car {

    private String name;
    private List<String> colors;
    private List<Integer> prices;
    private List<String> soldDays;

    public Car() {
    }

    public Car(String name, List<String> colors, List<Integer> prices, List<String> soldDays) {
        setName(name);
        setColors(colors);
        setPrices(prices);
        setSoldDays(soldDays);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Car name cannot be empty");
        }
        this.name = name.trim().toUpperCase();
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        if (colors == null || colors.isEmpty()) {
            throw new IllegalArgumentException("Colors cannot be empty");
        }
        this.colors = colors;
    }

    public List<Integer> getPrices() {
        return prices;
    }

    public void setPrices(List<Integer> prices) {
        if (prices == null || prices.isEmpty()) {
            throw new IllegalArgumentException("Prices cannot be empty");
        }
        this.prices = prices;
    }

    public List<String> getSoldDays() {
        return soldDays;
    }

    public void setSoldDays(List<String> soldDays) {
        if (soldDays == null || soldDays.isEmpty()) {
            throw new IllegalArgumentException("Sold days cannot be empty");
        }
        this.soldDays = soldDays;
    }

    public static List<Car> defaultShowroom() {
        return Arrays.asList(
                new Car("AUDI",
                        Arrays.asList("WHITE", "YELLOW", "ORANGE", "NO COLOR"),
                        Arrays.asList(5500, 3000, 4500),
                        Arrays.asList("FRIDAY", "SUNDAY", "MONDAY")),
                new Car("MERCEDES",
                        Arrays.asList("GREEN", "BLUE", "PURPLE", "NO COLOR"),
                        Arrays.asList(5000, 6000, 8500),
                        Arrays.asList("TUESDAY", "SATURDAY", "WEDNESDAY")),
                new Car("BMW",
                        Arrays.asList("PINK", "RED", "BROWN", "NO COLOR"),
                        Arrays.asList(2500, 3000, 3500),
                        Arrays.asList("MONDAY", "SUNDAY", "THURSDAY"))
        );
    }
}
