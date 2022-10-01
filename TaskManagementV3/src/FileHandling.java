
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class FileHandling {
    public static void writeToFile(List<Task> listTask){
        try {
            File file = new File("Tasks.dat");
            //check if file exists
            if(!file.exists()){
               file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //loop use to access from first element to last element
            for (int i = 0; i < listTask.size(); i++) {
                oos.writeObject(listTask.get(i));
            }
            oos.close();
            fos.close();
        } catch (Exception e) {
        }
    }
    public static void readFromFile(List<Task> listTask){
        try {
            FileInputStream fis = new FileInputStream("Tasks.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            //loop use to access from first element to last element of list
            for (int i = 0; i < listTask.size(); i++) {
                Task task = (Task)ois.readObject();
                listTask.add(task);
            }
            ois.close();
            fis.close();
        } catch (Exception e) {
        }
    }
}
