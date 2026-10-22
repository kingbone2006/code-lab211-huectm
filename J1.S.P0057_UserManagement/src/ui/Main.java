package ui;

import entity.Account;
import management.UserManager;
import utils.Validator;

public class Main {

    public static void main(String[] args) {
        UserManager manager = new UserManager("user.dat");
        while (true) {
            System.out.println("====== USER MANAGEMENT SYSTEM ======");
            System.out.println("1. Create a new account");
            System.out.println("2. Login system");
            System.out.println("3. Exit");
            int choice = Validator.getInt("> Choose: ", "Must be 1-3", "Invalid!", 1, 3);
            switch (choice) {
                case 1:
                    createAccount(manager);
                    break;
                case 2:
                    login(manager);
                    break;
                case 3:
                    return;
            }
        }
    }

    private static void createAccount(UserManager manager) {
        Account acc = readAccount();
        try {
            manager.addAccount(acc);
            System.out.println("Create account successful!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void login(UserManager manager) {
        Account acc = readAccount();
        try {
            Account found = manager.find(acc);
            if (found != null) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid user name or password");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Account readAccount() {
        while (true) {
            try {
                String user = Validator.getStringAllowEmpty("Enter Username: ");
                String pass = Validator.getStringAllowEmpty("Enter Password: ");
                return new Account(user, pass);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
