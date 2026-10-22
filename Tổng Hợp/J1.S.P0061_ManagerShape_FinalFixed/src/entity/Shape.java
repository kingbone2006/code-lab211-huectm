/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

    public interface Shape {

    void printResult();

    double getPerimeter() throws Exception;

    double getArea() throws Exception;
    
    public abstract void input();
}
