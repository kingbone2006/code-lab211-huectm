package ui;

import entity.Circle;
import entity.Rectangle;
import entity.Shape;
import entity.Triangle;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("=====Calculator Shape Program=====");
        Shape[] shapes = {new Rectangle(), new Circle(), new Triangle()};
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].input();
        }
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].printResult();
        }
    }
}
