package com.example.androidapp.Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FGModel {
    private ExecutorService pool;
    private int port;
    private String ip;
    private Socket fg;
    private PrintWriter out;
    public FGModel () {
        //initialize the thread pool
        pool = Executors.newSingleThreadExecutor();
    }
        //content to server
    public void connectFG(String ip, int port) throws IOException {
        pool.execute(new Connect(ip, port,fg));
        //wrap the OutputStream
        out=new PrintWriter(fg.getOutputStream(),true);
    }
}

