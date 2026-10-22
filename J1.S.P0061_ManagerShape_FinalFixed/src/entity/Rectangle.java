package entity;

import utils.Validator;

public final class Rectangle implements Shape {

    private double width;
    private double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) throws Exception {
        setWidth(width);
        setLength(length);
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double width) throws Exception {
        if (width <= 0) {
            throw new Exception("Width must be >0");
        }
        this.width = width;
    }

    public void setLength(double length) throws Exception {
        if (length <= 0) {
            throw new Exception("Length must be >0");
        }
        if (length < width) {
            throw new Exception("Length must be >= Width");
        }
        this.length = length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public void printResult() {
        System.out.println("-----Rectangle-----");
        System.out.println("Width: " + width);
        System.out.println("Length: " + length);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

    @Override
    public void input() throws Exception {
        setWidth(Validator.getDouble(
                "Please input side width of Rectangle: ",
                "Please enter number >0",
                "Invalid!",
                Double.MIN_VALUE,
                Double.MAX_VALUE));
        setLength(Validator.getDouble(
                "Please input side length of Rectangle: ",
                "Please enter number >= " + width,
                "Invalid!",
                width,
                Double.MAX_VALUE));
    }
}
