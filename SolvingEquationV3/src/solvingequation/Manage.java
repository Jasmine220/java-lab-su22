/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solvingequation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manage {

    public static float[] inputEquation() {
        Scanner sc = new Scanner(System.in);
        float arrEquation[] = new float[2];
        System.out.println("----- Calculate Equation -----");
        //loop until valid input
        while (true) {
            try {
                System.out.print("Enter A: ");
                arrEquation[0] = Float.parseFloat(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please input number");
            }
        }
        //loop until valid input
        while (true) {
            try {
                System.out.print("Enter B: ");
                arrEquation[1] = Float.parseFloat(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please input number");
            }
        }

        return arrEquation;
    }

    public static List<Float> calculateEquation(float a, float b) {
        Scanner sc = new Scanner(System.in);
        List<Float> listSol = new ArrayList<>();
        float x;
        //compare a, b with 0
        if (a == 0 && b == 0) {
            List<Float> listEmpty = new ArrayList<>();
            System.out.println("infinitely many solutions");
            return listEmpty;
        } //compare a, b with 0
        else if (a == 0 && b != 0) {
            System.out.println("no solution");
            return null;
        } else {
            x = -b / a;
            System.out.printf("Solution: x = %.3f\n", x);
            listSol.add(x);
        }
        return listSol;
    }

    public static float[] inputQuadraticEquation() {
        Scanner sc = new Scanner(System.in);
        float arrQuadraticEquation[] = new float[3];
        //loop until valid input
        while (true) {
            try {
                System.out.print("Enter A: ");
                arrQuadraticEquation[0] = Float.parseFloat(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please input number");
            }
        }
        //loop until valid input
        while (true) {
            try {
                System.out.print("Enter B: ");
                arrQuadraticEquation[1] = Float.parseFloat(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please input number");
            }
        }
        //loop until valid input
        while (true) {
            try {
                System.out.print("Enter C: ");
                arrQuadraticEquation[2] = Float.parseFloat(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please input number");
            }
        }
        return arrQuadraticEquation;
    }
     public static void display(List<Float> listSol, float arrEquation[]) {
        List<Float> list = new ArrayList<>();
        //compare length of arrEquation with 2
        if (arrEquation.length == 2) {
            list.add(arrEquation[0]);
            list.add(arrEquation[1]);
        }
        else {
            list.add(arrEquation[0]);
            list.add(arrEquation[1]);
            list.add(arrEquation[2]);

        }
        //check if list is empty or null
        if (listSol != null) {
            //compare size of listSol with 1
            if (listSol.size() == 1) {
                list.add(listSol.get(0));
            }
            //compare size of listSol with 2
            if(listSol.size() == 2){
                list.add(listSol.get(0));
                list.add(listSol.get(1));
            }
        }

        //compare size of list with 3
        if (list.size() <= 3) {
            System.out.print("Number is Odd:");
        } else {
            System.out.print("Odd number(s):");
        }
        
        //loop use to access from first element to last element
        int flag = 0;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            //check if current is odd
            if (isOdd(list.get(i))) {
                count++;
                //compare flag with 1
                if (flag == 1) {
                    System.out.print(", " + list.get(i));
                } else {
                    System.out.print(list.get(i));
                }
                flag = 1;
            }
        }
        //compare countOdd with 0
        if(count == 0){
            System.out.print(" don't have any odd number");
        }
        System.out.println("");
        flag = 0;
        count = 0;
        System.out.print("Number is Even:");
        for (int i = 0; i < list.size(); i++) {
            //check if current is even
            if (isEven(list.get(i))) {
                count++;
                //compare flag with 1
                if (flag == 1) {
                    System.out.print(", " + list.get(i));
                } else {
                    System.out.print(list.get(i));
                }
                flag = 1;
            }
        }
        //compare count with 0
        if(count == 0){
            System.out.print(" don't have any even number");
        }
        System.out.println("");
        flag = 0;
        count = 0;
        System.out.print("Number is Perfect Square:");
        for (int i = 0; i < list.size(); i++) {
            //check if current is perfect square
            if (isPerfectSquare(list.get(i))) {
                count++;
                //compare flag with 1
                if (flag == 1) {
                    System.out.print(", " + list.get(i));
                } else {
                    System.out.print(list.get(i));
                }
                flag = 1;
            }
        }
        //compare count with 0
        if(count == 0){
            System.out.print(" don't have any perfect square number");
        }
        System.out.println("");
    }

    public static List<Float> calculateQuadraticEquation(float A, float B, float C) {
        Scanner sc = new Scanner(System.in);
        List<Float> listSol = new ArrayList<>();
        //compare A, B, C with 0
        if(A == 0){
            listSol = calculateEquation(B, C);
            return listSol;
        }
        float x;
        float delta = B * B - 4 * A * C;
        float x1, x2;
        //compare delta with 0
        if (delta > 0) {
            x1 = (-B + (float) Math.sqrt(delta)) / (2 * A);
            x2 = (-B - (float) Math.sqrt(delta)) / (2 * A);
            System.out.printf("Solution: x1 = %.3f ", x1);
            System.out.printf("and x2 = %.3f\n", x2);
            listSol.add(x1);
            listSol.add(x2);
        } else if (delta == 0) {
            x1 = x2 = -B / (2 * A);
            System.out.printf("Solution: x1 = %.3f ", x1);
            System.out.printf("and x2 = %.3f\n", x2);
            listSol.add(x1);
            listSol.add(x2);
        } else {
            System.out.println("no solution");
            return null;
        }
        return listSol;
    }

    public static boolean isOdd(double num) {
        if (num % 2 == 1) {
            return true;
        }
        return false;
    }

    public static boolean isEven(double num) {
        if (num % 2 == 0) {
            return true;
        }
        return false;
    }

    public static boolean isPerfectSquare(double num) {
        //compare product of square root of num with square root of num with num
        if ((int) (Math.sqrt(num)) * (int) (Math.sqrt(num)) == num) {
            return true;
        }
        return false;
    }
}
