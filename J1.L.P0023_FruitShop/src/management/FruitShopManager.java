package management;

import entity.Fruit;
import entity.OrderItem;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class FruitShopManager {

    private final List<Fruit> fruits = new ArrayList<>();
    private final Hashtable<String, List<OrderItem>> orders = new Hashtable<>();

    public void addFruit(Fruit fruit) {
        if (fruit == null) {
            throw new IllegalArgumentException("Fruit cannot be null");
        }
        for (Fruit f : fruits) {
            if (f.getFruitId().equalsIgnoreCase(fruit.getFruitId())) {
                throw new IllegalArgumentException("Fruit Id already exists");
            }
        }
        fruits.add(fruit);
    }

    public void displayFruits() {
        System.out.println("List of Fruit:");
        System.out.printf("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |%n");
        int i = 1;
        for (Fruit f : fruits) {
            if (f.getQuantity() > 0) {
                System.out.printf("%10d %-15s %-12s %.0f$%n",
                        i++, f.getFruitName(), f.getOrigin(), f.getPrice());
            }
        }
    }

    public Fruit getAvailableFruitByItem(int item) {
        int i = 1;
        for (Fruit f : fruits) {
            if (f.getQuantity() > 0) {
                if (i == item) {
                    return f;
                }
                i++;
            }
        }
        return null;
    }

    public int countAvailable() {
        int c = 0;
        for (Fruit f : fruits) {
            if (f.getQuantity() > 0) {
                c++;
            }
        }
        return c;
    }

    public void addOrder(String customerName, List<OrderItem> items) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order items cannot be empty");
        }
        orders.put(customerName.trim(), items);
    }

    public void viewOrders() {
        for (Map.Entry<String, List<OrderItem>> e : orders.entrySet()) {
            System.out.println("Customer: " + e.getKey());
            System.out.println("Product | Quantity | Price | Amount");
            double total = 0;
            int i = 1;
            for (OrderItem item : e.getValue()) {
                System.out.printf("%d. %-12s %-8d %.0f$ %.0f$%n",
                        i++, item.getFruitName(), item.getQuantity(),
                        item.getPrice(), item.getAmount());
                total += item.getAmount();
            }
            System.out.println("Total: " + (int) total + "$");
        }
    }

    public List<Fruit> getFruits() {
        return fruits;
    }
}
