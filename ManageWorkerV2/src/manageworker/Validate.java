/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageworker;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validate {

    public static boolean checkDuplicate(String id, List<Worker> list) {
        //loop use to access from first element to last element
        for (int i = 0; i < list.size(); i++) {
            //compare id variable with code of current element
            if (list.get(i).getId().compareTo(id) == 0) {
                return true;
            }
        }
        return false;
    }
}
