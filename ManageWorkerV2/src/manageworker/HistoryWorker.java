/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageworker;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class HistoryWorker implements Serializable{
    private Worker worker;
    private String status;
    private String date;

    public HistoryWorker() {
    }

    public HistoryWorker(Worker worker, String status, String date) {
        this.worker = worker;
        this.status = status;
        this.date = date;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "HistoryWorker{" + "worker=" + worker + ", status=" + status + ", date=" + date + '}';
    }
    public void display(){
        System.out.printf("%-10s%-20s%-15d%-20.0f%-15s%-20s\n",
                worker.getId(), worker.getName(), worker.getAge(), worker.getSalary() ,status, date);
    }
    
}
