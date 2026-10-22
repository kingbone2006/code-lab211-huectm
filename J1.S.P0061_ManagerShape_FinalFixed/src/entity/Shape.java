package entity;

/**
 * Contract for shapes: input data, compute perimeter/area, print result.
 */
public interface Shape {

    void printResult();

    double getPerimeter() throws Exception;

    double getArea() throws Exception;

    void input() throws Exception;
}
