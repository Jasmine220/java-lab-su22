/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorprogram;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validate {

    public static int checkInt(String s, int flag) {
        int num;
        Scanner sc = new Scanner(System.in);
        //loop until valid input
        while (true) {
            try {
                System.out.print(s);
                num = Integer.parseInt(sc.nextLine());
                //compare flag with 0
                if (flag == 1) {
                    if (num > 0) {
                        break;
                    } else {
                        System.out.println("Input a positive number");
                    }
                } else {
                    break;
                }

            } catch (Exception e) {
                if (flag == 0) {
                    System.out.println("Value of matrix is digit");
                } else {
                    System.out.println("Input a positive number");
                }
            }
        }
        return num;
    }

    public static boolean checkMatchSize(int row1, int col1, int row2, int col2) {
        //check if row1 equals row2 and col1 equals row2
        if (row1 == row2 && col1 == col2) {
            return true;
        }
        return false;
    }
}
