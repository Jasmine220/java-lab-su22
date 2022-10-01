/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managegeopraphic;

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
                System.out.println("MENU");
                System.out.println("===================================================================");
                System.out.println("1. Input the information for 11 countries in East Asia");
                System.out.println("2. Display the information of country you've just input");
                System.out.println("3. Search the information of country by user-entered name");
                System.out.println("4. Display the information of countries sorted name in ascending order");
                System.out.println("5. Exit");
                 System.out.println("===================================================================");
                choice = Integer.parseInt(sc.nextLine());
                //compare choice variable with 1, 2, 3, 4, 5
                if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5) {
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
