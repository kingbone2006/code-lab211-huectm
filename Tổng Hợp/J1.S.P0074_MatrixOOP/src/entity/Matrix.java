package entity;

import utils.Validator;

public class Matrix {

    private int[][] data;

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public void setSize(int rows, int cols) {
        if (rows < 0 || cols < 0) {
            throw new IllegalArgumentException("Rows and columns cannot be negative!");
        }
        this.data = new int[rows][cols];
    }

    public int getRows() {
        if (this.data == null) {
            return 0;
        }
        return this.data.length;
    }

    public int getCols() {
        if (this.data == null || this.data.length == 0) {
            return 0;
        }
        return this.data[0].length;
    }

    // ================== CÁC HÀM NON-STATIC ==================

    public Matrix add(Matrix other) throws Exception {
        if (this.getRows() != other.getRows() || this.getCols() != other.getCols()) {
            throw new Exception("Rows and cols two matrix must be same");
        }
        Matrix result = new Matrix();
        result.setSize(this.getRows(), this.getCols());
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    public Matrix subtract(Matrix other) throws Exception {
        if (this.getRows() != other.getRows() || this.getCols() != other.getCols()) {
            throw new Exception("Rows and cols two matrix must be same");
        }
        Matrix result = new Matrix();
        result.setSize(this.getRows(), this.getCols());
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) {
                result.data[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) throws Exception {
        if (this.getCols() != other.getRows()) {
            throw new Exception("Cols of matrix 1 must be equal rows of matrix 2");
        }
        Matrix result = new Matrix();
        result.setSize(this.getRows(), other.getCols());
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < other.getCols(); j++) {
                for (int k = 0; k < this.getCols(); k++) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return result;
    }

    // ================== CÁC HÀM STATIC (ĐÃ GỌI TẬN DỤNG HÀM TRÊN) ==================

    public static Matrix add(Matrix matrix1, Matrix matrix2) throws Exception {
        // Tận dụng hoàn toàn logic kiểm tra và tính toán từ phương thức non-static
        return matrix1.add(matrix2);
    }

    public static Matrix subtract(Matrix matrix1, Matrix matrix2) throws Exception {
        // Tận dụng logic subtract non-static
        return matrix1.subtract(matrix2);
    }

    public static Matrix multiply(Matrix matrix1, Matrix matrix2) throws Exception {
        // Tận dụng logic multiply non-static
        return matrix1.multiply(matrix2);
    }

    // ================== CÁC PHƯƠNG THỨC KHÁC ==================

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) {
                str.append(String.format("[%d]", data[i][j]));
            }
            str.append("\n");
        }
        return str.toString();
    }

    public void input(int numberOfMatrix) {
        int rowInput = Validator.getInt("Enter Row Matrix " + numberOfMatrix + ": ", "Just be >0 ",
                "Please enter integer number!", 1, Integer.MAX_VALUE);
        int colInput = Validator.getInt("Enter Column Matrix " + numberOfMatrix + ": ", "Just be >0 ",
                "Please enter integer number!", 1, Integer.MAX_VALUE);
        setSize(rowInput, colInput);

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) {
                this.data[i][j] = Validator.getInt("Enter matrix " + numberOfMatrix + String.format(" [%d][%d]: ", i + 1, j + 1),
                        "Error range!", "Value of matrix is digit", Integer.MIN_VALUE,
                        Integer.MAX_VALUE);
            }
        }
    }
}