package com.example.androidapp.Model;

import java.io.PrintWriter;

public class Task implements Runnable{

    private String task;
    private double val;
    private PrintWriter out;
    private float x_y;
    private float radius;
    public Task(String my_task, double my_val, PrintWriter my_out, float my_x_y, float my_radius){
        task = my_task;
        val = my_val;
        out = my_out;
        x_y = my_x_y;
        radius = my_radius;
    }
    @Override
    public void run() {
        String s = "set /controls/flight/" + task + " " + val + "\r\n";
        if (task == "throttle") {
            double corr_throttle = val/200;
            s = "set /controls/engines/current-engine/throttle " + corr_throttle + "\r\n";
        }
        else if (task == "rudder") {
            double corr_rudder = val/100;
            s = "set /controls/flight/rudder " + corr_rudder + "\r\n";
        }
        else if (task == "aileron") {
            double corr_aileron = (val - x_y)/radius;

            s = "set /controls/flight/aileron  " + corr_aileron + "\r\n";
        }
        else if (task == "elevator") {
            double corr_elevator = (x_y - val)/radius;
            s = "set /controls/flight/elevator " + corr_elevator + "\r\n";
        }
        out.print(s);
        out.flush();

    }
}
