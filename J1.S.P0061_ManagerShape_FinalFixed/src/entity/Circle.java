package entity;

import utils.Validator;

public final class Circle implements Shape {

    private double radius;

    public Circle() {
    }

    public Circle(double radius) throws Exception {
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws Exception {
        if (radius <= 0) {
            throw new Exception("Radius must be >0");
        }
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void printResult() {
        System.out.println("-----Circle-----");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

    @Override
    public void input() throws Exception {
        setRadius(Validator.getDouble(
                "Please input radius of Circle:",
                "Please enter number >0",
                "Invalid!",
                Double.MIN_VALUE,
                Double.MAX_VALUE));
    }
}
