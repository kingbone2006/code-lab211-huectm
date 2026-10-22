package ui;

import entity.SalaryHistory;
import entity.SalaryStatus;
import entity.Worker;
import management.Management;
import utils.Validator;

public class Main {

    public static void main(String[] args) {
        Management manager = new Management();
        while (true) {
            System.out.println("======== Worker Management =========");
            System.out.println("1. Add Worker");
            System.out.println("2. Up salary");
            System.out.println("3. Down salary");
            System.out.println("4. Display Information salary");
            System.out.println("5. Exit");
            int choice = Validator.getInt("Enter your choice: ", "Must be 1-5", "Invalid!", 1, 5);
            try {
                switch (choice) {
                    case 1:
                        System.out.println("--------- Add Worker ----------");
                        String id = Validator.getString("Enter Code: ", "Invalid!", "^.+$");
                        String name = Validator.getString("Enter Name: ", "Invalid!", "^.+$");
                        int age = Validator.getInt("Enter Age: ", "Age 18-50", "Invalid!", 18, 50);
                        double salary = Validator.getDouble("Enter Salary: ", "Salary > 0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
                        String loc = Validator.getString("Enter work location: ", "Invalid!", "^.+$");
                        manager.addWorker(new Worker(id, name, age, salary, loc));
                        System.out.println("Add successful!");
                        break;
                    case 2:
                    case 3:
                        System.out.println("------- Up/Down Salary --------");
                        String code = Validator.getString("Enter Code: ", "Invalid!", "^.+$");
                        double amount = Validator.getDouble("Enter Salary: ", "Amount > 0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
                        manager.changeSalary(choice == 2 ? SalaryStatus.UP : SalaryStatus.DOWN, code, amount);
                        System.out.println("Update successful!");
                        break;
                    case 4:
                        System.out.println("--------------------Display Information Salary-----------------------");
                        System.out.printf("%-8s%-15s%-6s%-12s%-8s%s%n", "Code", "Name", "Age", "Salary", "Status", "Date");
                        for (SalaryHistory h : manager.getInfomationSalary()) {
                            System.out.println(h);
                        }
                        break;
                    case 5:
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
