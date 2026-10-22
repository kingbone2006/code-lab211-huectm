/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import array.MyArray;
import java.util.Random;
import java.util.Scanner;
import validator.Validator;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int size = Validator.getInt("Enter number of array: ", "Please enter number > 0",
                "Please enter integer number", 1, Integer.MAX_VALUE);
        int value = Validator.getInt("Enter search value: ", "Error range!",
                "Please enter integer number", Integer.MIN_VALUE, Integer.MAX_VALUE);
        MyArray array = null;
        try {
            array = new MyArray(size);
            array.genRandomArray();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("The array: " + array.toString());
        int index = array.searchIndex(value);
        if (index == -1) {
            System.out.println("Can not found value!");
        } else {
            System.out.println("Found " + value + " at index: " + index);
        }
    }
}

