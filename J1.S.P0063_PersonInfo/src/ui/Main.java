package ui;

import entity.Person;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====Management Person programer=====");
        Person[] persons = new Person[3];
        for (int i = 0; i < persons.length; i++) {
            System.out.println("Input Information of Person");
            while (true) {
                try {
                    System.out.print("Please input name:");
                    String name = sc.nextLine();
                    System.out.print("Please input address:");
                    String address = sc.nextLine();
                    System.out.print("Please input salary:");
                    String salary = sc.nextLine();
                    persons[i] = Person.inputPersonInfo(name, address, salary);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        try {
            persons = Person.sortBySalary(persons);
            for (Person p : persons) {
                Person.displayPersonInfo(p);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
