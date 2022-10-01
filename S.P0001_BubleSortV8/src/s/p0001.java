/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import java.util.Scanner;

public class p0001 {

    public static void main(String[] args) {
        //1.Input size of array
        int size = inputSize();
        //2.Generate random integer in number range for each array element
       // int arr[] = generateElement(size);
        //int arr[] = {2, 6, 3, 6, 8, 6, 1, 2, 9, 8};
        int arr[] = {5, 1, 12, -5, 16};
       boolean check = true;
        //3.Display array before sorting
        display(arr, "Unsorted array: ");
        //4.Bubble sort
         BubbleSort(arr, check);
        //5.Display array after sorting
        display(arr, "Sorted array: ");

    }
    //1.Input size of array
    public static int inputSize() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of array: ");
        int size = 0;
        //loop until input correct
        while (true) {
            try {
                size = Integer.parseInt(sc.nextLine());
                //check size of array must be a positive number
                if (size > 0) {
                    break;
                } else {
                    System.out.println("Enter a positive decimal number !");
                }
            } catch (NumberFormatException exception) {
                System.out.println("You entered the string. Enter an positive integer");
            }

        }

        return size;
    }

    //2. Generate random integer in number range for each array element
    public static int[] generateElement(int size) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[size];

        /*loop used to random each element of array
        from first element to last element of array*/
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * size + 1);
        }
        return arr;
    }

    //Bubble sort
    public static int[] BubbleSort(int arr[], boolean check) {
        System.out.println("");
        /*loop used to access from first element to last element of array
        after each loop, 1 element is sorted*/
        for (int i = 0; i < arr.length - 1; i++) {
            /*loop used to access from first unsorted element to
            the last unsorted element of array*/
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //compare check variable with true 
                if (check == true) {
                    display(arr, "");
                }
                //compare each pair adjacent elements 
                if (arr[j] > arr[j + 1]) {
                     //compare check variable with true
                    if (check == true) {
                        System.out.print("\t" + arr[j] + " > " + arr[j + 1] + ", swap");
                        System.out.println("");
                    }
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } else {
                    //compare check variable with true to display each step in sorting process
                    if (check == true) {
                        System.out.print("\t" + arr[j] + " < " + arr[j + 1] + ", oke");
                        System.out.println("");
                    }
                }
            }
        }
        return arr;
    }
    //Display array 
    public static void display(int arr[], String s) {
        System.out.print(s + "[");
        //loop used to access from first element to last element of array 
        for (int i = 0; i < arr.length; i++) {
            //compare index of current element with last element 
            if (i == arr.length - 1) {
                System.out.print(arr[arr.length - 1] + "]");
                break;
            }
            System.out.print(arr[i] + ", ");

        }
    }

}
