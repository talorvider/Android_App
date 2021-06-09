package com.example.androidapp.Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FGModel {
    private ExecutorService pool;
    private Socket fg;
    private PrintWriter out;

    public FGModel() {
        //initialize the thread pool
        pool = Executors.newSingleThreadExecutor();

    }

    //content to server
    public void connectFG(String ip, int port) throws IOException {
        Connect c = new Connect(ip, port,fg, out, this);
        pool.execute(c);

    }

    public void calcElevator(double e, float yCen, float bRad){
        String task_str = "elevator";
        double corr_elevator = (yCen - e)/bRad;
        pool.execute(new Task(task_str, corr_elevator, out));
    }

    public void calcAileron(double a, float xCen, float bRad) {
        String task_str = "aileron";
        double corr_aileron = (a - xCen)/bRad;
        pool.execute(new Task(task_str, corr_aileron, out));
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }
}

