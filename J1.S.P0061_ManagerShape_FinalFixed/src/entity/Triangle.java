package entity;

import utils.Validator;

public final class Triangle implements Shape {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle() {
    }

    public Triangle(double sideA, double sideB, double sideC) throws Exception {
        setSideA(sideA);
        setSideB(sideB);
        setSideC(sideC);
        validateTriangle();
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    private void validateTriangle() throws Exception {
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new Exception(
                    "Sum of two side must be more than side remaining! Try again");
        }
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideA(double sideA) throws Exception {
        if (sideA <= 0) {
            throw new Exception("Side A must be >0");
        }
        this.sideA = sideA;
    }

    public void setSideB(double sideB) throws Exception {
        if (sideB <= 0) {
            throw new Exception("Side B must be >0");
        }
        this.sideB = sideB;
    }

    public void setSideC(double sideC) throws Exception {
        if (sideC <= 0) {
            throw new Exception("Side C must be >0");
        }
        this.sideC = sideC;
    }

    @Override
    public void printResult() {
        System.out.println("-----Triangle-----");
        System.out.println("Side A: " + sideA);
        System.out.println("Side B: " + sideB);
        System.out.println("Side C: " + sideC);
        try {
            System.out.println("Area: " + getArea());
            System.out.println("Perimeter: " + getPerimeter());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public double getPerimeter() throws Exception {
        validateTriangle();
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() throws Exception {
        validateTriangle();
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public void input() throws Exception {
        while (true) {
            setSideA(Validator.getDouble(
                    "Please input side A of Triangle: ",
                    "Please enter number >0",
                    "Invalid!",
                    Double.MIN_VALUE,
                    Double.MAX_VALUE));
            setSideB(Validator.getDouble(
                    "Please input side B of Triangle: ",
                    "Please enter number >0",
                    "Invalid!",
                    Double.MIN_VALUE,
                    Double.MAX_VALUE));
            setSideC(Validator.getDouble(
                    "Please input side C of Triangle: ",
                    "Please enter number >0",
                    "Invalid!",
                    Double.MIN_VALUE,
                    Double.MAX_VALUE));
            if (isValidTriangle(sideA, sideB, sideC)) {
                break;
            }
            System.out.println(
                    "Sum of two side must be more than side remaining! Try again");
        }
    }
}
