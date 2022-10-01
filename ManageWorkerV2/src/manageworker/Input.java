/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageworker;

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
                System.out.println("======== Worker Management ========");
                System.out.println("1. Add Worker");
                System.out.println("2. Up salary");
                System.out.println("3. Down salary");
                System.out.println("4. Display Information salary");
                System.out.println("5. Exit");
                System.out.print("Your choice: ");
                choice = Integer.parseInt(sc.nextLine());
                //compare choice variable with 1, 2, 3, 4
                if (choice == 1 || choice == 2 || choice == 3 || choice == 4|| choice == 5) {
                    break;
                } else {
                    System.out.println("Only 1, 2, 3, 4, 5");
                }
            } catch (Exception e) {
                System.out.println("Only 1, 2, 3, 4, 5");
            }
        }
        return choice;
    }
}

