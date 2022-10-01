/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorprogram;

/**
 *
 * @author Admin
 */
public class CalculatorProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;

        //loop until choice equals 4
        do {
            //Display a menu and ask users to select an option
            choice = Input.menu();
            Manage.displayChoice(choice);
            //Input number of row, number of column and values of  matrix 1 
            int matrix1[][] = Manage.inputMatrix1();
            int row1 = matrix1.length;
            int col1 = matrix1[0].length;

            //Input number of row, number of column and values of  matrix 2.
            int matrix2[][] = Manage.inputMatrix2(col1, row1, choice);
            //Perform function based on the selected option  
//        int matrix1[][] = {{2, 3, 4, 5},
//        {1, 1, 1, 5},
//        {1, 1, 1, 5}};
//        int matrix2[][] = {{0, 1000}, {0, 100}, {0, 10}, {0, 10}};

            switch (choice) {
                //Option 1: Addition matrixes
                case 1:
                    int matrixAdd[][] = Manage.additionMatrix(matrix1, matrix2);
                    Manage.displayCalculation("+", matrix1, matrix2, matrixAdd);
                    break;
                case 2:
                    int matrixSub[][] = Manage.subtractionMatrix(matrix1, matrix2);
                    Manage.displayCalculation("-", matrix1, matrix2, matrixSub);
                    break;
                case 3:
                    int matrixMul[][] = Manage.multiplicationMatrix(matrix1, matrix2);
                    Manage.displayCalculation("*", matrix1, matrix2, matrixMul);
                    break;
                case 4:
                    return;
            }
        }while(choice != 4);

    }
}
