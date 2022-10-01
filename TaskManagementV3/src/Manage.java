
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Manage {

    public static void displayOption(int choice) {
        //compare choice variable with 1
        if (choice == 1) {
            System.out.println("---------------Add Task---------------");
        } //compare choice variable with 2
        else if (choice == 2) {
            System.out.println("--------------Delete Task--------------");
        } else {
            System.out.println("----------------------------------------- Task -----------------------------------------");
        }
    }

    public static String inputRequirementName() {
        Scanner sc = new Scanner(System.in);
        String name;
        //loop until valid input
        while (true) {
            System.out.print("Requirement Name: ");
            name = sc.nextLine();
            //check if Requirement Name is empty
            if (!name.isEmpty()) {
                break;
            } else {
                System.out.println("Requirement Name can't be empty");
            }
        }

        return name;
    }

    public static int inputTaskTypeID() {
        Scanner sc = new Scanner(System.in);
        int taskTypeID;
        //loop until valid input
        while (true) {
            try {
                System.out.print("Task Type: ");
                taskTypeID = Integer.parseInt(sc.nextLine());
                //taskTypeId must be 1, 2, 3 or 4
                if (taskTypeID == 1 || taskTypeID == 2 || taskTypeID == 3 || taskTypeID == 4) {
                    break;
                } else {
                    System.out.println("Only 1, 2, 3, 4");
                }

            } catch (Exception e) {
                System.out.println("Only 1, 2, 3, 4");
            }
        }
        return taskTypeID;
    }

    public static String taskType(int taskTypeID) {
        String taskType = null;
        switch (taskTypeID) {
            case 1:
                taskType = "Code";
                break;
            case 2:
                taskType = "Test";
                break;
            case 3:
                taskType = "Design";
                break;
            case 4:
                taskType = "Review";
                break;
        }
        return taskType;
    }

    public static String inputDate() {
        Scanner sc = new Scanner(System.in);
        String date;
        //loop until valid input
        while (true) {
            try {
                System.out.print("Date: ");
                date = sc.nextLine();
                //check valid date
                if (Validate.checkFormatDate(date)) {
                    break;
                } else {
                    System.out.println("Invalid date !");
                }

            } catch (Exception e) {
                System.out.println("Invalid date !");
            }
        }
        return date;

    }

    public static float inputPlanFrom() {
        Scanner sc = new Scanner(System.in);
        float planFrom;
        //loop until valid input
        while (true) {
            try {
                System.out.print("From: ");
                planFrom = Float.parseFloat(sc.nextLine());
                //plan divide 0.5 must have remainders equals 0 and within from 8.0 to 17.5
                if (planFrom % 0.5 == 0 && planFrom >= 8 && planFrom <= 17.5) {
                    break;
                } else {
                    System.out.println("Plan must be within from 8.0 to 17.5");
                }
            } catch (Exception e) {
                System.out.println("Plan must be within from 8.0 to 17.5");
            }
        }
        return planFrom;
    }

    public static float inputPlanTo(float planFrom) {
        Scanner sc = new Scanner(System.in);
        float planTo;
        //loop until valid input
        while (true) {
            try {
                System.out.print("To: ");
                planTo = Float.parseFloat(sc.nextLine());
                //plan divide 0.5 must have remainders equals 0 and within from 8.0 to 17.5
                if (planTo % 0.5 == 0 && planTo >= 8 && planTo <= 17.5) {
                    //planTo must be greater planFrom
                    if (planTo > planFrom) {
                        break;
                    } else {
                        System.out.println("Plan to must be greater plan from");
                    }
                } else {
                    System.out.println("Plan must be within from 8.0 to 17.5");
                }
            } catch (Exception e) {
                System.out.println("Plan must be within from 8.0 to 17.5");
            }
        }
        return planTo;
    }

    public static String inputAssignee() {
        Scanner sc = new Scanner(System.in);
        String assignee;
        //loop until valid input
        while (true) {
            System.out.print("Assignee: ");
            assignee = sc.nextLine();
            //check if assignee is empty
            if (!assignee.isEmpty()) {
                break;
            } else {
                System.out.println("Assignee can't be empty");
            }
        }
        return assignee;
    }

    public static String inputReviewer() {
        Scanner sc = new Scanner(System.in);
        String reviewer;
        //loop until valid input
        while (true) {
            System.out.print("Reviewer: ");
            reviewer = sc.nextLine();
            //check if reviewer is empty
            if (!reviewer.isEmpty()) {
                break;
            } else {
                System.out.println("Reviewer can't be empty");
            }
        }
        return reviewer;
    }

    public static Task inputTask(int id, List<Task> listTask) {
        String requirementName = inputRequirementName();
        int taskType = inputTaskTypeID();
        String date = inputDate();
        float planFrom = inputPlanFrom();
        float planTo = inputPlanTo(planFrom);
        String assignee = inputAssignee();
        String reviewer;
        Task task = new Task();
        //loop until valid input
        while (true) {
            //check dupplication
            if (Validate.checkIntersectionTime(date, assignee, planFrom, planTo, listTask)) {
                System.out.println("Have intersection of 2 time intervals of 2 tasks");
                System.out.println("---------------Add Task---------------");
                requirementName = inputRequirementName();
                taskType = inputTaskTypeID();
                date = inputDate();
                planFrom = inputPlanFrom();
                planTo = inputPlanTo(planFrom);                
                assignee = inputAssignee();
            } else {
                reviewer = inputReviewer();
                break;
            }

        }
        task = new Task(id, taskType, requirementName, date, planFrom, planTo, assignee, reviewer);
        return task;
    }
    public static void displayTask(List<Task> listTask) {
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        //loop use to access from first element to last element
        for (int i = 0; i < listTask.size(); i++) {
            listTask.get(i).display();
        }
    }

    public static void addTask(List<Task> listTask, Task task) {
        listTask.add(task);
        FileHandling.writeToFile(listTask);
    }

    public static int inputID() {
        Scanner sc = new Scanner(System.in);
        int id = 0;
        try {
            System.out.print("Enter id: ");
            id = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
        }
        return id;
    }

    public static Task searchByID(int id, List<Task> listTask) {
        //loop use to access from first element to last element of list
        for (int i = 0; i < listTask.size(); i++) {
            //compare id with id of current element
            if (id == listTask.get(i).getId()) {
                return listTask.get(i);
            }
        }
        return null;
    }

    public static void deleteTask(Task task, List<Task> listTask) {
        //compare size of listTask with 0
        if (listTask.size() == 0) {
            System.out.println("Empty list ! Please enter task");
            return;
        } else {
            //check if task is null
            if (task == null) {
                System.out.println("Not found");
                return;
            }
            listTask.remove(task);
        }
        FileHandling.writeToFile(listTask);
    }

    public static void showATask(Task taskShow) {
        float time = taskShow.getPlanTo() - taskShow.getPlanFrom();
        System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                taskShow.getId(),
                taskShow.getRequirementName(),
                taskType(taskShow.getTaskTypeID()),
                taskShow.getDate(),
                time,
                taskShow.getAssignee(),
                taskShow.getReviewer());
    }

    public static void showTask(List<Task> listTask) {
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        //compare size of listTask with 0
        if (listTask.size() == 0) {
            System.out.println("Don't have any task !");
            return;
        }
        //loop use to access from first element to last element
        for (int i = 0; i < listTask.size(); i++) {
            showATask(listTask.get(i));
        }
    }

}
