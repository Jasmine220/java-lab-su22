/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearsearch;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class LinearSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Enter a size of array 
        int size = inputNumber("Enter number of array: ");
        //Enter a search number
        int searchNum = inputNumber("Enter search value: ");
        //Generate random integer in number range for each array element
//         int arr[] = generateElement(size);
//        int arr[] = {2, 2, 5, 2, 6, 9, 9, 8, 9, 8};
        int arr[] = {2, 2, 5, 2, 5, 9, 9, 8, 9, 8};
        //Display the array
        display(arr);
        //Linear Seach
        ArrayList list = linearSearch(arr, searchNum);
        //Display the index of search number in array
        displayIndex(list, searchNum);
    }

    //Enter a posive number
    public static int inputNumber(String s) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        //loop until input valid
        while (true) {
            try {
                System.out.println(s);
                num = Integer.parseInt(sc.nextLine());
                if (num > 0) {
                    break;
                } else {
                    System.out.println("Input a positive decimal number !");
                }
            } catch (Exception e) {
                System.out.println("Input a positive decimal number");
            }
        }
        return num;
    }

    //Generate random integer in number range for each array element
    public static int[] generateElement(int size) {
        int arr[] = new int[size];
        /*loop use to generate each element,
         from first element to last element of array*/
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * size + 1);
            // System.out.print(arr[i]);
        }
        return arr;
    }

    //Display the array
    public static void display(int arr[]) {
        System.out.print("The array: [");
        /*loop use to access each element of array,
          from first element to last element*/
        for (int i = 0; i < arr.length; i++) {
            /*compare index of current element with 
            index of last element*/
            if (i == arr.length - 1) {
                System.out.println(arr[i] + "]");
                break;
            }
            System.out.print(arr[i] + ", ");
        }
    }

    //Linear Search
    public static ArrayList linearSearch(int arr[], int searchNum) {
        ArrayList<Integer> list = new ArrayList<>();
        /*loop use to access each element of array,
          from first element to last element*/
        for (int i = 0; i < arr.length; i++) {
            /*compare searchNum variable with one element of array
            and compare index of current element with index of last element*/
            if (searchNum == arr[i] && i != arr.length - 1) {
                list.add(i);
            }
        }
        return list;
    }

    //Display the index of search number in array
    public static void displayIndex(ArrayList list, int searchNum) {
        //compare size of list with 0
        if (list.size() == 0) {
            System.out.println("Not found");
        } else {
            //compare size of list with 1
            if (list.size() == 1) {
                System.out.print("Found " + searchNum + " at index: " + list.get(0));
            } else {
                System.out.print("Found " + searchNum + " at indexs: ");
                //loop use to access from first element to last element of list
                for (int i = 0; i < list.size(); i++) {
                    //compare index of current element with index of last element
                    if (i == list.size() - 1) {
                        System.out.println(list.get(i));
                        break;
                    }
                    System.out.print(list.get(i) + ", ");
                }
            }

        }
    }

}
