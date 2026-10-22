package ui;

import entity.Fruit;
import entity.OrderItem;
import java.util.ArrayList;
import java.util.List;
import management.FruitShopManager;
import utils.Validator;

public class Main {

    public static void main(String[] args) {
        FruitShopManager manager = new FruitShopManager();
        while (true) {
            System.out.println("FRUIT SHOP SYSTEM");
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
            int choice = Validator.getInt(
                    "(Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program): ",
                    "Must be 1-4", "Invalid!", 1, 4);
            switch (choice) {
                case 1:
                    createFruit(manager);
                    break;
                case 2:
                    manager.viewOrders();
                    break;
                case 3:
                    shopping(manager);
                    break;
                case 4:
                    return;
            }
        }
    }

    private static void createFruit(FruitShopManager manager) {
        do {
            try {
                String id = Validator.getString("Enter Fruit Id: ", "Invalid!", "^.+$");
                String name = Validator.getString("Enter Fruit Name: ", "Invalid!", "^.+$");
                double price = Validator.getDouble("Enter Price: ", "Price > 0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
                int qty = Validator.getInt("Enter Quantity: ", "Quantity >= 0", "Invalid!", 0, Integer.MAX_VALUE);
                String origin = Validator.getString("Enter Origin: ", "Invalid!", "^.+$");
                manager.addFruit(new Fruit(id, name, price, qty, origin));
                System.out.println("Create successful!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (Validator.getYesNo("Do you want to continue (Y/N)? "));
        System.out.println("Created fruits:");
        for (Fruit f : manager.getFruits()) {
            System.out.println(f);
        }
    }

    private static void shopping(FruitShopManager manager) {
        if (manager.countAvailable() == 0) {
            System.out.println("No fruit available!");
            return;
        }
        List<OrderItem> cart = new ArrayList<>();
        while (true) {
            manager.displayFruits();
            int item = Validator.getInt("Select Item: ", "Invalid item", "Invalid!", 1, manager.countAvailable());
            Fruit fruit = manager.getAvailableFruitByItem(item);
            System.out.println("You selected: " + fruit.getFruitName());
            int qty = Validator.getInt("Please input quantity: ", "Invalid quantity", "Invalid!", 1, fruit.getQuantity());
            cart.add(new OrderItem(fruit.getFruitName(), qty, fruit.getPrice()));
            fruit.setQuantity(fruit.getQuantity() - qty);
            if (Validator.getYesNo("Do you want to order now (Y/N)? ")) {
                System.out.println("Product | Quantity | Price | Amount");
                double total = 0;
                for (OrderItem oi : cart) {
                    System.out.printf("%-12s %-8d %.0f$ %.0f$%n",
                            oi.getFruitName(), oi.getQuantity(), oi.getPrice(), oi.getAmount());
                    total += oi.getAmount();
                }
                System.out.println("Total: " + (int) total + "$");
                String name = Validator.getString("Input your name: ", "Invalid!", "^.+$");
                manager.addOrder(name, cart);
                break;
            }
            if (manager.countAvailable() == 0) {
                System.out.println("No more fruit!");
                break;
            }
        }
    }
}
