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
public class Input {

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        //loop until valid input
        while (true) {
            try {
                System.out.println("=======Calculator program=======");
                System.out.println("1. Addition Matrix");
                System.out.println("2. Subtraction Matrix");
                System.out.println("3. Multiplication Matrix");
                System.out.println("4. Quit");
                System.out.print("Your choice:");
                choice = Integer.parseInt(sc.nextLine());
                //compare choice variable with 1, 2, 3, 4
                if (choice == 1 || choice == 2 || choice == 3 || choice == 4) {
                    break;
                } else {
                    System.out.println("Only 1, 2, 3, 4");
                }
            } catch (Exception e) {
                System.out.println("Only 1, 2, 3, 4");
            }
        }
        return choice;    
    }
}
