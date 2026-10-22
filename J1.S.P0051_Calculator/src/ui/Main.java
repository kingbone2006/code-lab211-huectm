package ui;

import java.util.Scanner;
import model.BMIStatus;
import model.Calculator;
import model.Operator;
import utils.Validator;

public class Main {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("========= Calculator Program =========");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");
            int choice = Validator.getInt("Please choice one option: ",
                    "Must be 1-3", "Invalid!", 1, 3);
            switch (choice) {
                case 1:
                    normalCalculator(calc, sc);
                    break;
                case 2:
                    bmiCalculator(calc, sc);
                    break;
                case 3:
                    return;
            }
        }
    }

    private static void normalCalculator(Calculator calc, Scanner sc) {
        System.out.println("----- Normal Calculator -----");
        double memory = readNumber(calc, sc, "Enter number: ");
        while (true) {
            Operator op = readOperator(calc, sc);
            if (op == Operator.EQUAL) {
                System.out.println("Result:" + memory);
                return;
            }
            double b = readNumber(calc, sc, "Enter number: ");
            try {
                memory = calc.calculate(memory, op, b);
                System.out.println("Memory:" + memory);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void bmiCalculator(Calculator calc, Scanner sc) {
        System.out.println("----- BMI Calculator -----");
        double weight = readPositive(calc, sc, "Enter Weight(kg): ");
        double height = readPositive(calc, sc, "Enter Height(cm): ");
        BMIStatus status = calc.calculateBMI(weight, height);
        System.out.println("BMI Status: " + status.getMessage());
    }

    private static double readNumber(Calculator calc, Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            Double v = calc.checkin(sc.nextLine());
            if (v != null) {
                return v;
            }
            System.out.println("BMI is digit");
        }
    }

    private static double readPositive(Calculator calc, Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            Double v = calc.checkin(sc.nextLine());
            if (v == null) {
                System.out.println("BMI is digit");
            } else if (v <= 0) {
                System.out.println("Must be greater than zero");
            } else {
                return v;
            }
        }
    }

    private static Operator readOperator(Calculator calc, Scanner sc) {
        while (true) {
            System.out.print("Enter Operator: ");
            Operator op = calc.checkOperator(sc.nextLine().trim());
            if (op != null) {
                return op;
            }
            System.out.println("Please input (+, -, *, /, ^)");
        }
    }
}
