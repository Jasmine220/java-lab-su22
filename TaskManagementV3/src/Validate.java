
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
public class Validate {

    public static boolean checkFormatDate(String date) {
        try {

            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            //get current date, after format following pattern
            String dateCurrent = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            //convert from String to Date
            Date dateDate = format.parse(date);
            Date dateCurrentDate = format.parse(dateCurrent);
            //convert from Date to String
            String dateString = format.format(dateDate);
            //compare date with dateString and compare dateDate with dateCurrentDate
            if (date.compareTo(dateString) == 0 && dateDate.compareTo(dateCurrentDate) > 0) {
                return true;

            }
        } catch (Exception e) {
        }
        return false;
    }
    public static boolean checkIntersectionTime(String date, String assignee, float planFrom, float planTo, List<Task> TaskList) {
        boolean isExist = false;
        //loop use to access each element of arraylist from begining to the end
        for (Task task : TaskList) {
            //compare date in list with date input and assignee in list and assignee input
            if (date.equals(task.getDate()) && assignee.equals(task.getAssignee())) {
                //compare planTo and planfrom with planFrom and planto in every task in list 
                //have date and assignee same with date, assignee input
                /*planto of object newtask must be lest than planFrom in list
                or planfrom of object newtask must be large than planto in list */
                if ((planTo <= task.getPlanFrom()) || (planFrom >= task.getPlanTo())) {
                    isExist = false;
                } else {
                    isExist = true;
                    break;
                }
            }
        }
        return isExist;
    }

//    public static boolean checkIntersectionTime(String date, String assignee, float planFrom, float planTo, 
//                                                List<Task> listTask) 
//    {
//        for (int i = 0; i < listTask.size(); i++) {
//            System.out.println("===============================================================");
//            //compare date with date of current element and assignee with assignee of current element
//            System.out.println("date: " + date);
//            System.out.println("list: " + listTask.get(i).getDate());
//            System.out.println("as: " + assignee);
//            System.out.println("asList: " + listTask.get(i).getAssignee());
//            System.out.println("from: " + planFrom);
//            System.out.println("to: " + planTo);
//            if (date.equalsIgnoreCase(listTask.get(i).getDate()) 
//                    && assignee.equalsIgnoreCase(listTask.get(i).getAssignee())) {
//                System.out.println("A");
//                float planFromCurrentElement = listTask.get(i).getPlanFrom();
//                float planToCurrentElement = listTask.get(i).getPlanTo();
//                //compare planFrom and planTo with planFrom of current element and
//                //compare planFrom and planTo with planTo of current element
//                if ((planTo < planFromCurrentElement)|| (planFrom > planToCurrentElement)) {
//                    System.out.println("B");
//                    System.out.println(planFrom);
//                    System.out.println(listTask.get(i).getPlanTo());
//                    System.out.println(planTo);
//                    System.out.println(listTask.get(i).getPlanFrom());
// 
//                    return false;
//                }
//            }
//        }
//            return true;
//                    
//    }
}
