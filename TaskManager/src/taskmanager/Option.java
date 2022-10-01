/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Option {

    public void getDataTask(ArrayList<Task> list) {
        for (Task o : list) {
            System.out.println(o);
        }
    }

    public void addTask(ArrayList<Task> list, int id, String name, int typeId,
            String date, double from, double to, String assginee, String reviewer) {
        Task t = new Task(id, name, typeId, date, from, to, assginee, reviewer);
        list.add(t);
    }

    public void delete(ArrayList<Task> list, int id) {
        boolean check = true;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).getId()) {
                list.remove(i);
                check = false;
                index = i;
                System.out.println("Delete a task succelfully");
                break;
            }
        }
        if (check) {
            System.out.println("Delete a task fail");
        }
    }
}
