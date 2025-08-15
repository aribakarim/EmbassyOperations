package org.example.embassyoperations.HRManager;

import org.example.embassyoperations.AppendableObjectOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class Task implements Serializable {
    private String taskID, employeeID, taskDescription,status;
    private LocalDate dueDate;

    public Task(String employeeID, String taskDescription, LocalDate dueDate) {
        this.taskID = generateID();
        this.employeeID = employeeID;
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
        this.status = "Pending";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task Id : " + taskID + '\n' +
                "Assigned to employee : " + employeeID + '\n' +
                "Task Description : " + taskDescription + '\n' +
                "Status : " + status + '\n' +
                "Due Date : " + dueDate ;
    }

    private String generateID(){
        Random r = new Random();
        int num = r.nextInt(100000, 999999);
        String str = Integer.toString(num);
        return str;
    }

    public static void writeTaskInfo(Task task){
        File f = new File("TaskInfo.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            if(f.exists()){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(task);
            oos.close();
        }catch(Exception e){
            //
        }
    }
}
