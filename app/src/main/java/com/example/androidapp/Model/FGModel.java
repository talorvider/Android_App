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
    //send elevator value to server
    public void calcElevator(double e, float yCen, float bRad){
        String task_str = "elevator";
        if(out != null) {
            pool.execute(new Task(task_str, e, out, yCen, bRad));
        }
    }
    //send aileron value to server
    public void calcAileron(double a, float xCen, float bRad) {
        String task_str = "aileron";
        if(out != null) {
            pool.execute(new Task(task_str, a, out, xCen, bRad));
        }
    }
    public void setOut(PrintWriter out) {
        this.out = out;
    }
    //send rudder value to server
    public void updateRudder(int rudder) {
        String task_str = "rudder";
        if(out != null) {
            pool.execute(new Task(task_str, rudder, out, 0, 0));
        }
    }
    //send throttle value to server
    public void updateThrottle(int throttle) {
        String task_str = "throttle";
        if(out != null) {
            pool.execute(new Task(task_str, throttle, out,0,0));
        }
    }
}

