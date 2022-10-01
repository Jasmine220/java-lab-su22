/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changebasev4;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Input {

    public static int menu(String s) {
        Scanner sc = new Scanner(System.in);
        int choice;
        //loop until valid input
        while (true) {
            try {
                System.out.println(s);
                System.out.println("1. Binary");
                System.out.println("2. Decimal");
                System.out.println("3. Hexadecimal");
                choice = Integer.parseInt(sc.nextLine());
                //compare choice variable with 1, 2, 3
                if (choice == 1 || choice == 2 || choice == 3) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Only 1, 2 or 3");
            }
        }

        return choice;
    }

    public static String inputValue(int inputBase) {
        Scanner sc = new Scanner(System.in);
        String value;
        //loop until input valid
        while (true) {
            try {
                System.out.print("Input value need to convert: ");
                value = sc.nextLine();
                //compare inputBase variable with 1
                if (inputBase == 1) {
                    if (Validate.checkBinary(value)) {
                        break;
                    } else {
                        System.out.println("Value number must be contain 0 or 1 only");
                    }
                }
                //compare inputBase variable with 2
                if (inputBase == 2) {
                    //check valid value by checkDecimal method
                    if (Validate.checkDecimal(value)) {
                        break;
                    } else {
                        System.out.println("Value number must be contain 0-9 only");
                    }
                }
                //compare inputBase variable with 3
                if (inputBase == 3) {
                    //check valid value by checkHexadecimal method
                    if (Validate.checkHexadecimal(value)) {
                        break;
                    } else {
                        System.out.println("Value number must be contain 0-9 or A-F only");
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid ! Re-enter");
            }
        }

        return value;
    }
}
