/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import utils.Validator;

public final class Triangle implements Shape {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle() {
    }

    public Triangle(double sideA, double sideB, double sideC) throws Exception {
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new Exception("Sum of two side must be more than side remaining! Try again");
        }
        setSideA(sideA);
        setSideB(sideB);
        setSideC(sideC);
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
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
        if (sideA > 0) {
            this.sideA = sideA;
        } else {
            throw new Exception("Side A must be >0");
        }
    }

    public void setSideB(double sideB) throws Exception {
        if (sideB > 0) {
            this.sideB = sideB;
        } else {
            throw new Exception("Side B must be >0");
        }
    }

    public void setSideC(double sideC) throws Exception {
        if (sideC > 0) {
            this.sideC = sideC;
        } else {
            throw new Exception("Side C must be >0");
        }
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
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new Exception("Invalid Triangle!");
        }
        return (sideA + sideB + sideC);
    }

    @Override
    public double getArea() throws Exception {
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new Exception("Invalid Triangle!");
        }
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public void input() {
        while (true) {
            sideA = Validator.getDouble("Please input side A of Triangle: ",
                    "Please enter number >0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
            sideB = Validator.getDouble("Please input side B of Triangle: ",
                    "Please enter number >0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
            sideC = Validator.getDouble("Please input side C of Triangle: ",
                    "Please enter number >0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
            if (sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA) {
                break;
            } else {
                System.out.println("Sum of two side must be more than side remaining! Try again");
            }
        }
    }
}
