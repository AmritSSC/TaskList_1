package com.example.tasklist_1 ;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get db and StringBuilder objects
        TaskListDB db = new TaskListDB(this);
        StringBuilder sb = new StringBuilder();

        // insert a task
        Task task1 = new Task(1, "Make dentist appointment", "", "0", "0");
        long insertId = db.insertTask(task1);
        if (insertId > 0) {
            sb.append("Row inserted! Insert Id: " + insertId + "\n");
        }

        // insert a second task
        Task task2 = new Task(1, "Take car in for oil change", "", "0", "0");
        long insertId2 = db.insertTask(task2);
        if (insertId2 > 0) {
            sb.append("Row inserted! Insert Id: " + insertId2 + "\n");
        }

        // insert a third task
        Task task3 = new Task(1, "Mow the lawn", "", "0", "0");
        long insertId3 = db.insertTask(task3);
        if (insertId3 > 0) {
            sb.append("Row inserted! Insert Id: " + insertId2 + "\n");
        }

        // insert a fourth task
        Task task4 = new Task(1, "Vacuum the bottom floor", "", "0", "0");
        long insertId4 = db.insertTask(task4);
        if (insertId4 > 0) {
            sb.append("Row inserted! Insert Id: " + insertId4 + "\n");
        }


        // update a task ... task1
        task1.setId((int) insertId);
        task1.setName("Update test");
        int updateCount = db.updateTask(task1);
        if (updateCount == 1) {
            sb.append("Task updated! Update count: " + updateCount + "\n");
        }
/*
        // delete a task
        int deleteCount = db.deleteTask(insertId);
        if (deleteCount == 1) {
            sb.append("Task deleted! Delete count: " + deleteCount + "\n\n");
        }
*/
        // delete old tasks (this may vary from system to system)

        db.deleteTask(5);
        db.deleteTask(7);
        db.deleteTask(11);
        db.deleteTask(13);

        db.deleteTask(60);
        db.deleteTask(61);
        db.deleteTask(62);
        db.deleteTask(63);
        db.deleteTask(64);
        db.deleteTask(65);
        db.deleteTask(66);
        db.deleteTask(67);
        db.deleteTask(68);
        db.deleteTask(59);
        db.deleteTask(60);


        // display all tasks (id + name)
        ArrayList<Task> tasks = db.getTasks("Personal");
        for (Task t : tasks) {
            sb.append(t.getId() + "|" + t.getName() + "\n");
        }

        // display string on UI
        TextView taskListTextView = (TextView)
                findViewById (R.id.taskListTextView);
        taskListTextView.setText(sb.toString());
    }
}