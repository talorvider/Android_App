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
    private float xCen;
    private float yCen;
    private float bRad;

    public FGModel() {
        //initialize the thread pool
        pool = Executors.newSingleThreadExecutor();
    }

    //content to server
    public void connectFG(String ip, int port) throws IOException {
        pool.execute(new Connect(ip, port,fg, out));

    }

    public void calcElevator(double e){
        String task_str = "elevator";
        double corr_elevator = e/bRad - yCen;
        pool.execute(new Task(task_str, corr_elevator, out));
    }

    public void calcAileron(double a, float xCen, float bRad) {
        String task_str = "aileron";
        double corr_aileron = a/bRad - xCen;
        pool.execute(new Task(task_str, corr_aileron, out));
    }
}

