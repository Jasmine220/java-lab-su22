
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Task> listTask = new ArrayList<>();
        FileHandling.readFromFile(listTask);
        int choice = 0;
        int id = 1;
        //loop until valid input
        while (choice != 4) {
            //Display a menu and ask users to select an option
            choice = Input.menu();
            Manage.displayOption(choice);
            //Perform function based on the selected option
            switch(choice){
                //Option 1: Add Task
                case 1:
                    //Input the information requested Task
                    Task task = Manage.inputTask(id, listTask);
                    //Add a Task on the program
                    Manage.addTask(listTask, task);
//                    Manage.displayTask(listTask);
                    id ++;
                    break;
                //Option 2: Delete Task
                case 2:
                    //Request input the ID of the task to delete
                    int idSearch = Manage.inputID();
                    //Delete the task
                    Task taskSearch = Manage.searchByID(idSearch, listTask);
                    Manage.deleteTask(taskSearch, listTask);
//                    Manage.displayTask(listTask);
                    break;
                case 3:    
                //Option 3: Show task
                    Manage.showTask(listTask);
                    break;           
            }
        }

    }

}
