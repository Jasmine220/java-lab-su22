/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managegeopraphic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validate {

    public static boolean checkDuplication(ArrayList<EastAsiaCountries> list, String countryCode) {
        //loop use to access from first element to last element of list
        for (int i = 0; i < list.size(); i++) {
            //compare countryCode variable with countryCode of current element in list
            if (countryCode.equals(list.get(i).getCountryCode())) {
                return true;
            }
        }
        return false;
    }
    

}
