package com.example.androidapp.Model;

import java.io.PrintWriter;

public class Task implements Runnable{

    private String task;
    private double val;
    private PrintWriter out;
    public Task(String my_task, double my_val, PrintWriter my_out){
        task = my_task;
        val = my_val;
        out = my_out;
    }
    @Override
    public void run() {
        out.print("set/controls/flight/" + task + val + "\r\n");
        out.flush();

    }
}
