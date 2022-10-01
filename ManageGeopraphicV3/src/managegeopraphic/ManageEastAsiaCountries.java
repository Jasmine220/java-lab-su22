/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managegeopraphic;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ManageEastAsiaCountries {

    public static void inputACountry(ArrayList<EastAsiaCountries> list) {
        Scanner sc = new Scanner(System.in);
        String countryCode;
        //loop until valid input
        while (true) {
            System.out.print("Enter code of country: ");
            countryCode = sc.nextLine();
            boolean check = Validate.checkDuplication(list, countryCode);
            if (!check) {
                break;
            }
            System.out.println("Duplicate !");
        }
        System.out.print("Enter name of country: ");
        String countryName = sc.nextLine();
        float totalArea;
        //loop until valid input
        while (true) {
            try {
                System.out.print("Enter total Area: ");
                totalArea = Float.parseFloat(sc.nextLine());
                //compare totalArea variable with 0
                if (totalArea > 0) {
                    break;
                } else {
                    System.out.println("Total area must be greater than 0");
                }
            } catch (Exception e) {
                System.out.println("Invalid ! Input a positive number");
            }
        }
        System.out.print("Enter terrain of country: ");
        String countryTerrain = sc.nextLine();
        EastAsiaCountries country = new EastAsiaCountries(countryCode, countryName, totalArea, countryTerrain);

        list.add(country);
        System.out.println("Add successful !");
    }

    public static void input11Countries(ArrayList<EastAsiaCountries> list) {
        //compare size of list with 11
        if (list.size() < 11) {
            inputACountry(list);
        } else {
            System.out.println("Full 11 countries. Can't add !");
        }
    }

    public static void displayInformation(ArrayList<EastAsiaCountries> list) {
        System.out.printf("%-10s%-25s%-20s%-25s\n",
                "ID", "Name", "Total Area", "Terrain");
        //loop use to access from first element to last element of list
        for (int i = 0; i < list.size(); i++) {
            list.get(i).display();
        }
    }

    public static void searchByName(ArrayList<EastAsiaCountries> list) {
        int flag = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name you want to search for: ");
        String nameCountry = sc.nextLine();
        //loop use to access from first element to last element
        for (int i = 0; i < list.size(); i++) {
            //check if countryName of current element matches nameCountry variable
            if (list.get(i).getCountryName().matches(nameCountry)) {
                flag = 1;
                list.get(i).display();
            }
        }
        //compare flag variable with 0
        if (flag == 0) {
            System.out.println("Not found");
        }
    }

    public static ArrayList sortByNameAscendingOrder(ArrayList<EastAsiaCountries> list) {
        //loop use to access from first element to element before last element of list
        for (int i = 0; i < list.size() - 1; i++) {
            //loop use to access from (i + 1)th element to last element of list
            for (int j = i + 1; j < list.size(); j++) {
                //compare countryName of a pair adjacent element
                if (list.get(i).getCountryName().compareTo(list.get(j).getCountryName()) > 0) {
                    EastAsiaCountries temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }

    public static ArrayList test(ArrayList<EastAsiaCountries> list) {
        EastAsiaCountries c1 = new EastAsiaCountries("1", "AAAAAAAAA", 11, ".aaaaaaaaaaa");
        EastAsiaCountries c2 = new EastAsiaCountries("2", "BBBBBBBBB", 12, ".baaaaaaaaaa");
        EastAsiaCountries c3 = new EastAsiaCountries("3", "CCCCCCCCCCC", 13, ".caaaaaaaaaaa");
        EastAsiaCountries c4 = new EastAsiaCountries("4", "D", 14, ".daaaaaaaaaaaaa");
        EastAsiaCountries c5 = new EastAsiaCountries("5", "E", 15, ".e");
        EastAsiaCountries c6 = new EastAsiaCountries("6", "F", 16, ".f");
        EastAsiaCountries c7 = new EastAsiaCountries("7", "G", 17, ".g");
        EastAsiaCountries c8 = new EastAsiaCountries("8", "H", 18, ".h");
        EastAsiaCountries c9 = new EastAsiaCountries("9", "I", 19, ".i");
        EastAsiaCountries c10 = new EastAsiaCountries("10", "K", 20, ".k");
        list.add(c1);
        list.add(c3);
        list.add(c9);
        list.add(c2);
        list.add(c4);
        list.add(c6);
        list.add(c7);
        list.add(c8);
        list.add(c5);
//        list.add(c10);
        return list;
    }
}
