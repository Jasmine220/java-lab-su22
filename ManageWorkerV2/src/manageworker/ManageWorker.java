/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageworker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ManageWorker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        int choice = 0;
       List<Worker> list = new ArrayList<>();
       FileHandling.readFromFileWorker(list);
       List<HistoryWorker> listHisworker = new ArrayList<>();
       FileHandling.readFromFileHisWorker(listHisworker);
        //loop until choice equals 5
        while (choice != 5) {
            //Display a menu and ask users to select an option
            choice = Input.menu();
            Manage.displayOption(choice);
            //Perform function based on the selected option
            switch (choice) {
                //Option 1: Add an worker
                case 1:
                    //Input task information (id, name,age, salary, work location)
                    Worker worker = Manage.inputInfor(list);
                    //Add Worker to DB.
                    Manage.addWorker(list, worker);
                    break;
                //Option 2: Increase salary
                case 2:                   
                    //Input Code and amount of money to raise
                    String idInc = Manage.inputId(list, 0);
                    float moneyInc = Manage.inputMoney(2);
                    //Add salary to worker and save salary history
                    Manage.increaseSalary(idInc, moneyInc, list, listHisworker);
                    break;
                //Option  3: Decrease salary
                case 3:
                    //Input Code and amount of money to cut
                    String idDec = Manage.inputId(list, 0);
                    float moneyDec = Manage.inputMoney(2);
                    //Add salary to worker and save salary history
                    Manage.decreaseSalary(idDec, moneyDec, list, listHisworker);
                    break;
                //Option  4: Display the list of adjusted salary workers    
                case 4:
                    Manage.displayHisWorkers(listHisworker);
                    break;

            }

        }
    }

}
