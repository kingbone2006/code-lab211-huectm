package ui;

import management.ContactManagement;
import utils.Validator;
import entity.Contact;

public class Main {

    public static void main(String[] args) {
        ContactManagement manager = new ContactManagement();
        while (true) {
            System.out.println("========= Contact program =========");
            System.out.println("1. Add a Contact");
            System.out.println("2. Display all Contact");
            System.out.println("3. Delete a Contact");
            System.out.println("4. Exit");
            int choice = Validator.getInt("Please choice one option: Your choice: ",
                    "Must be 1-4", "Invalid!", 1, 4);
            switch (choice) {
                case 1:
                    System.out.println("-------- Add a Contact --------");
                    String name = Validator.getString("Enter Name: ", "Name cannot be empty!", "^.+$");
                    String group = Validator.getString("Enter Group: ", "Group cannot be empty!", "^.+$");
                    String address = Validator.getString("Enter Address: ", "Address cannot be empty!", "^.+$");
                    String phone;
                    while (true) {
                        phone = Validator.getStringAllowEmpty("Enter Phone: ");
                        try {
                            manager.createContact(name, group, address, phone);
                            System.out.println("Successful");
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Please input Phone flow");
                            System.out.println("• 1234567890");
                            System.out.println("• 123-456-7890");
                            System.out.println("• 123-456-7890 x1234");
                            System.out.println("• 123-456-7890 ext1234");
                            System.out.println("• (123)-456-7890");
                            System.out.println("• 123.456.7890");
                            System.out.println("• 123 456 7890");
                        }
                    }
                    break;
                case 2:
                    System.out.println("--------------------------------- Display all Contact ----------------------------");
                    manager.displayAll();
                    break;
                case 3:
                    System.out.println("------- Delete a Contact -------");
                    int id = Validator.getInt("Enter ID: ", "ID is digit", "ID is digit", 1, Integer.MAX_VALUE);
                    if (manager.deleteById(id)) {
                        System.out.println("Successful");
                    } else {
                        System.out.println("No found contact");
                    }
                    break;
                case 4:
                    return;
            }
        }
    }
}
