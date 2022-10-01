package taskmanager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Validate {

    Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display Task");
        System.out.println("4.Exit");
    }

    public int getChoice() {
        int choice = 0;
        while (true) {

            try {
                System.out.print("input your choice: ");
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= 4) {
                    break;
                }
            } catch (Exception e) {
                System.err.println("invalid choice, please input again!");
            }
        }
        return choice;
    }

    public int getIDtoAdd(ArrayList<Task> list) {
        int lastIndex = list.size() - 1;
        int lastId = list.get(lastIndex).getId();
        int newId = lastId + 1;
        return newId;

    }

    public String getName() {

        System.out.print("Input name: ");
        String name = sc.nextLine();
        return name;
    }

    public int getTypeId() {
        int id = 0;
        while (true) {

            try {
                System.out.print("input your id: ");
                id = Integer.parseInt(sc.nextLine());
                if (id >= 1 && id <= 4) {
                    break;
                }
            } catch (Exception e) {
                System.err.println("invalid choice, please input again!");
            }
        }
        return id;
    }

    public String getDate() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        ;
        df.setLenient(false);
        Date date;
        while (true) {
            try {
                System.out.print("input date: ");
                date = df.parse(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("invalid date,please inpur again!");
            }

        }
        return df.format(date);
    }

    public double getFrom() {
        double from = 0;
        while (true) {
            try {
                System.out.print("Input from: ");
                from = Double.parseDouble(sc.nextLine());
                if (from >= 8.0 && from <= 15.5) {
                    if (from % 0.5 == 0) {
                        break;
                    }
                }

            } catch (Exception e) {
                System.err.println("invalid from, please input again!");
            }
        }
        return from;
    }

    public double getTo(double from) {
        double to = 0;
        while (true) {
            try {
                System.out.print("Input to: ");
                to = Double.parseDouble(sc.nextLine());
                if (to >= 8.0 && to <= 15.5) {
                    if (to % 0.5 == 0) {
                        if (to > from) {
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                System.err.println("invalid to, please input again!");
            }
        }
        return from;
    }

    public String getAssign() {

        System.out.print("Input assign: ");
        String assignee = sc.nextLine();
        return assignee;
    }

    public String getReviewer() {

        System.out.print("Input reviewer: ");
        String reviewer = sc.nextLine();
        return reviewer;
    }

    public int getID() {
        int id = 0;
        while (true) {
            try {
                System.out.print("Input id: ");
                id = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("invalid id, please input again!");
            }
        }
        return id;
    }

}
