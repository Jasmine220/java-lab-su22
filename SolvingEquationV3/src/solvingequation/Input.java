/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solvingequation;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Input {

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        //loop until valid input
        while (true) {
            try {
                System.out.println("========= Equation Program =========");
                System.out.println("1. Calculate Superlative Equation");
                System.out.println("2. Calculate Quadratic Equation");
                System.out.println("3. Exit");
                System.out.println("Please choice one option:");
                choice = Integer.parseInt(sc.nextLine());
                //compare choice variable with 1, 2, 3
                if (choice == 1 || choice == 2 || choice == 3) {
                    break;
                } else {
                    System.out.println("Only 1, 2, 3");
                }
            } catch (Exception e) {
                System.out.println("Only 1, 2, 3");
            }
        }

        return choice;
    }

}
