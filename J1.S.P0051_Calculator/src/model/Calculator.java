package model;

public class Calculator {

    public Double checkin(String inputVal) {
        try {
            return Double.parseDouble(inputVal.trim());
        } catch (Exception e) {
            return null;
        }
    }

    public Operator checkOperator(String operator) {
        return Operator.fromString(operator);
    }

    public double calculate(double a, Operator operator, double b) {
        if (operator == null) {
            throw new IllegalArgumentException("Operator cannot be null");
        }
        switch (operator) {
            case ADD:
                return a + b;
            case SUB:
                return a - b;
            case MUL:
                return a * b;
            case DIV:
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return a / b;
            case POW:
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    public BMIStatus calculateBMI(double weight, double height) {
        if (weight <= 0 || height <= 0) {
            throw new IllegalArgumentException("Weight and height must be > 0");
        }
        double heightM = height / 100.0;
        double bmi = weight / (heightM * heightM);
        System.out.printf("BMI Number: %.2f%n", bmi);
        if (bmi < 19) {
            return BMIStatus.UNDER_STANDARD;
        } else if (bmi <= 25) {
            return BMIStatus.STANDARD;
        } else if (bmi <= 30) {
            return BMIStatus.OVERWEIGHT;
        } else if (bmi <= 40) {
            return BMIStatus.FAT;
        } else {
            return BMIStatus.VERY_FAT;
        }
    }
}
