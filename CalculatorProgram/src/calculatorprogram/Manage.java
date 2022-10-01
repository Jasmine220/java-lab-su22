package calculatorprogram;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Manage {

    public static void displayChoice(int choice) {
        //compare choice variable with 1, 2, 3
        if (choice == 1) {
            System.out.println("-------- Adddition --------");
        } else if (choice == 2) {
            System.out.println("----- Subtraction -----");
        } else if (choice == 3) {
            System.out.println("-------- Multiplication --------");
        }
    }

    public static int[][] inputMatrix1() {
        int row1 = Validate.checkInt("Enter Row Matrix 1:", 1);
        int col1 = Validate.checkInt("Enter Column Matrix 1:", 1);
        int matrix1[][] = new int[row1][col1];
        //loop use to access from first element to last element
        for (int i = 0; i < row1; i++) {
            //loop use to access from first element to last element
            for (int j = 0; j < col1; j++) {
                String s = "Enter Matrix1" + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:";
                matrix1[i][j] = Validate.checkInt(s, 0);
            }
        }
        return matrix1;

    }

    public static int[][] inputMatrix2(int col1, int row1, int choice) {
        int row2, col2;
        //loop until valid input
        while (true) {
            row2 = Validate.checkInt("Enter Row Matrix 2:", 1);
            //compare choice with 1 and 2
            if (choice == 1 || choice == 2) {
                if (row2 == row1) {
                    break;
                } else {
                    System.out.println("Row matrix 2 must be equal row matrix 1");
                }
            } else {
                if (row2 == col1) {
                    break;
                } else {
                    System.out.println("Row matrix 2 must be col matrix 1");
                }
            }

        }
        //loop until valid input
        while (true) {
            col2 = Validate.checkInt("Enter Column Matrix 2:", 1);
            //compare choice with 1 and 2
            if (choice == 1 || choice == 2) {
                if (col2 == col1) {
                    break;
                } else {
                    System.out.println("Col matrix 2 must be equal col matrix 1");
                }
            } else {
                break;
            }

        }
        int matrix2[][] = new int[row2][col2];
        //loop use to access from first element to last element
        for (int i = 0; i < row2; i++) {
            //loop use to access from first element to last element
            for (int j = 0; j < col2; j++) {
                String s = "Enter Matrix2" + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:";
                matrix2[i][j] = Validate.checkInt(s, 0);
            }
        }
        return matrix2;

    }

    public static int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int matrix[][] = new int[row][col];
        //check if size of matrix1 matches size of matrix2
        if (Validate.checkMatchSize(matrix1.length, matrix1[0].length, matrix2.length, matrix2[0].length)) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = matrix1[i][j] + matrix2[i][j];
//                    System.out.println(matrix[i][j]);
                }
            }
            return matrix;
        } else {
            return null;
        }
    }

    public static int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int matrix[][] = new int[row][col];
        //check if size of matrix1 matches size of matrix2
        if (Validate.checkMatchSize(matrix1.length, matrix1[0].length, matrix2.length, matrix2[0].length)) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }
            return matrix;
        } else {
            return null;
        }
    }

    public static int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int col1 = matrix1[0].length;
        int row1 = matrix1.length;
        int col2 = matrix2[0].length;
        int row2 = matrix2.length;
        int matrix[][] = new int[row1][col2];
        int sum = 0;
        //loop use to access from first element to last element of row of matrix 1
        for (int i = 0; i < row1; i++) {
            //loop use to access from first element to last element of col of matrix 2
            for (int j = 0; j < col2; j++) {
                //loop use to access from first element to last element of row of matrix 2
                for (int k = 0; k < row2; k++) {
                    sum = sum + matrix2[k][j] * matrix1[i][k];
                }
                matrix[i][j] = sum;
                sum = 0;               
            }
        }       
        return matrix;
    }


    public static void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public static void displayCalculation(String s, int[][] matrix1, int[][] matrix2, int[][] matrix) {
        //compare matrix with null
        if (matrix == null) {
            System.out.println("");
        }
        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        System.out.println(s);
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(matrix);
    }
}
