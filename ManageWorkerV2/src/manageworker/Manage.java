/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageworker;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;

/**
 *
 * @author Admin
 */
public class Manage {

    public static void displayOption(int choice) {
        //compare choice with 1
        switch (choice) {
            //compare choice with 2, 3
            case 1:
                System.out.println("----------- Add Worker -----------");
                break;
            //compare choice with 4
            case 2:
            case 3:
                System.out.println("--------- Up/Down Salary ----------");
                break;
            case 4:
                System.out.println("---------------------------------Display Information Salary----------------------------------");
                break;
            default:
                break;
        }

    }

    public static String inputId(List<Worker> list, int flag) {
        Scanner sc = new Scanner(System.in);
        String id;
        //loop until valid input
        while (true) {
            System.out.print("Enter Code: ");
            id = sc.nextLine().trim();
            //compare flag variable with 1
            if (flag == 1) {
                //check dupplication of id
                if (Validate.checkDuplicate(id, list)) {
                    System.out.println("Dupplicated !");
                } else if (id.isEmpty()) {
                    System.out.println("Id can't be null !");
                } else {
                    break;
                }
            } else {
                //check if id is empty
                if (id.isEmpty()) {
                    System.out.println("Id can't be null !");
                } else {
                    break;
                }
            }

        }
        return id;
    }

    public static int inputAge() {
        int age;
        Scanner sc = new Scanner(System.in);
        //loop until valid input
        while (true) {
            try {
                System.out.print("Enter Age: ");
                age = Integer.parseInt(sc.nextLine());
                //age must be range 18 to 50
                if (age >= 18 && age <= 50) {
                    break;
                } else {
                    System.out.println("Age must be in range 18 to 50 !");
                }

            } catch (Exception e) {
                System.out.println("Age must be in range 18 to 50 !");
            }
        }
        return age;
    }

    public static float inputMoney(int flag) {
        float money;
        Scanner sc = new Scanner(System.in);
        //loop until valid input
        while (true) {
            try {
                if (flag == 1) {
                    System.out.print("Enter Salary: ");
                } else {
                    System.out.print("Enter amount of money: ");
                }

                money = Float.parseFloat(sc.nextLine());
                //salary must be greater than 0
                if (money > 0) {
                    break;
                } else if (flag == 1) {

                    System.out.println("Salary must be greater than 0");
                } else {
                    System.out.println("Amount of money must be > 0");
                }

            } catch (Exception e) {
                if (flag == 1) {
                    System.out.println("Salary must be a positive number");
                } else {
                    System.out.println("Amount of money must be a positive number");
                }
            }
        }
        return money;
    }

    public static Worker inputInfor(List<Worker> list) {
        Scanner sc = new Scanner(System.in);
        String id = inputId(list, 1);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        int age = inputAge();
        float salary = inputMoney(1);
        System.out.print("Enter work location: ");
        String workLocation = sc.nextLine();
        Worker worker = new Worker(id, name, age, salary, workLocation);
        return worker;
    }

    public static void addWorker(List<Worker> list, Worker worker) throws FileNotFoundException {
        list.add(worker);
        FileHandling.writeToFileWorker(list);
    }

    public static void displayWorker(List<Worker> list) {
        System.out.printf("%-10s%-25s%-5s%-20.0s%-20s\n",
                "Code", "Name", "Age", "Salary", "Work Location");
//        loop use to access from first element to last element of list
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            list.get(i).display();
        }
    }

    public static Worker searchById(String id, List<Worker> list) {
        //loop use to access from first element to last element of list
        for (int i = 0; i < list.size(); i++) {
            //compare id variable with id of current element of list
            if (id.compareTo(list.get(i).getId()) == 0) {
                return list.get(i);
            }
        }
        return null;
    }

    public static void increaseSalary(String id, float money, List<Worker> list, List<HistoryWorker> listHisWorker) throws FileNotFoundException {

        Worker workerSearch = searchById(id, list);
        //compare workerSearch with null
        if (workerSearch != null) {
            float moneyNew = (float) (workerSearch.getSalary() + money);
            workerSearch.setSalary(moneyNew);
            String status = "UP";
            //create workerUpdate object with moneynew
            Worker workerUpdate = new Worker(workerSearch.getId(), workerSearch.getName(),
                    workerSearch.getAge(), moneyNew, workerSearch.getWorkLocation());
            //get current date, after formatting follow pattern
            String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            //create a object HistoryWorker class
            HistoryWorker hisWorker = new HistoryWorker(workerUpdate, status, date);
            //add to listHisWorker
            listHisWorker.add(hisWorker);
            //Write to file
            FileHandling.writeToFileHisWorker(listHisWorker);
        } else {
            System.out.println("Not found !");
        }

    }

    public static void decreaseSalary(String id, float money, List<Worker> list, List<HistoryWorker> listHisWorker) throws FileNotFoundException {
        Worker workerSearch = searchById(id, list);
        //compare workerSearch with null
        if (workerSearch != null) {
            //compare money with salary
            if (money >= workerSearch.getSalary()) {
                System.out.println("Amount of money must be less than salary");
                return;
            }
            float moneyNew = (float) (workerSearch.getSalary() - money);
            workerSearch.setSalary(moneyNew);
            String status = "DOWN";
            Worker workerUpdate = new Worker(workerSearch.getId(), workerSearch.getName(),
                    workerSearch.getAge(), moneyNew, status);
            String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            HistoryWorker hisWorker = new HistoryWorker(workerUpdate, status, date);
            listHisWorker.add(hisWorker);
            FileHandling.writeToFileHisWorker(listHisWorker);
        } else {
            System.out.println("Not found !");
        }

    }

    public static void displayHisWorkers(List<HistoryWorker> list) {
        //compare size of list with 0
        if (list.size() == 0) {
            System.out.println("Don't have any worker");
            return;
        }
        System.out.printf("%-10s%-20s%-15s%-20s%-15s%-20s\n",
                "Code", "Name", "Age", "Salary", "Status", "Date");
        //loop use to access from first element to last element of list
        for (int i = 0; i < list.size(); i++) {
            list.get(i).display();
        }
    }
}
