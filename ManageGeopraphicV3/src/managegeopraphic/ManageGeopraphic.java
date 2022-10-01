/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managegeopraphic;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ManageGeopraphic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<EastAsiaCountries> list = new ArrayList<>();
//       list = ManageEastAsiaCountries.test(list);
        //loop until choice equals 5
        while (true) {
            //Display a menu and select an option
            int choice = Input.menu();
            switch (choice) {
                case 1:
                    //1. Input the information of 11 countries in East Asia
                    ManageEastAsiaCountries.input11Countries(list);
                    break;
                case 2:
                    //2. Display information of countries just input
                    ManageEastAsiaCountries.displayInformation(list);
                    break;
                case 3:
                    //3. Search information of countries by user-entered name
                    ManageEastAsiaCountries.searchByName(list);
                    break;
                case 4:
                    //4. Display information of countries sorted name in ascending order
                    ManageEastAsiaCountries.sortByNameAscendingOrder(list);
                    ManageEastAsiaCountries.displayInformation(list);
                    break;
                    //5.exit
                case 5:
                    return;
            }
        }
    }
}
