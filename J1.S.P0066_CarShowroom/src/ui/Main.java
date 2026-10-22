package ui;

import java.util.Scanner;
import model.Car;
import model.CarRequest;
import model.ShowroomService;
import utils.Validator;

public class Main {

    public static void main(String[] args) {
        ShowroomService service = new ShowroomService(Car.defaultShowroom());
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Showroom car program =====");
        do {
            System.out.println("Input Information of Car");
            try {
                System.out.print("Name: ");
                String name = sc.nextLine().trim();
                System.out.print("Color: ");
                String color = sc.nextLine().trim();
                System.out.print("Price: ");
                String priceStr = sc.nextLine().trim();
                System.out.print("Today: ");
                String today = sc.nextLine().trim();

                int price;
                try {
                    price = Integer.parseInt(priceStr);
                } catch (NumberFormatException e) {
                    System.out.println("Can't sell Car");
                    System.out.println("Price is digit");
                    continue;
                }
                if (price <= 0) {
                    System.out.println("Can't sell Car");
                    System.out.println("Price greater than zero");
                    continue;
                }

                CarRequest request = new CarRequest(name, color, price, today);
                String err = service.checkSell(request);
                if (err == null) {
                    System.out.println("Sell Car");
                } else {
                    System.out.println("Can't sell Car");
                    System.out.println(err);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Can't sell Car");
                System.out.println(e.getMessage());
            }
        } while (Validator.getYesNo("Do you want find more?(Y/N):"));
    }
}
