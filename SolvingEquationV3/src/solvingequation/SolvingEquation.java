/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solvingequation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SolvingEquation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice = 0;
        //loop until choice equals 3
        while (choice != 3) {
            //Display a menu and ask users to select an option.
            choice = Input.menu();
            switch (choice) {
                //Option  1: Calculate Superlative Equation                
                case 1:
                    //input coefficients A, B
                    float arrEquation[] = Manage.inputEquation();
                    //Calculate the solution x and display it on the screen
                    List<Float> listSol = Manage.calculateEquation(arrEquation[0], arrEquation[1]);
                    //Find and display even, odd and square numbers from inputted coefficients
                    Manage.display(listSol, arrEquation);
                    break;
                //Option  2: Calculate Quadratic Equation
                case 2:
                    //input coefficients A, B, C
                    float arrQuadraticEquation[] = Manage.inputQuadraticEquation();
                    //Calculate the solution x1, x2 and display them on the screen
                    List<Float> listQuadraSol = Manage.calculateQuadraticEquation(arrQuadraticEquation[0], arrQuadraticEquation[1], arrQuadraticEquation[2]);
                    //Find and display even, odd and square numbers from inputted coefficients
                    Manage.display(listQuadraSol, arrQuadraticEquation);
                    break;
            }
        }
    }
}
