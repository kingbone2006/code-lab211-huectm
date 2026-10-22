/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package array;

import java.util.Random;
public class MyArray {
    
    private int[] array;

    public MyArray(int number) throws Exception {
        if (number <= 0) {
            throw new Exception("number parameter must be > 0");
        }
        this.array = new int[number];
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void genRandomArray() throws Exception {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(array.length);
        }
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < array.length; i++) {
            str += array[i];
            if (i == array.length - 1) {
                str += "]";
            } else {
                str += ", ";
            }
        }
        return str;
    }

    public int searchIndex(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
