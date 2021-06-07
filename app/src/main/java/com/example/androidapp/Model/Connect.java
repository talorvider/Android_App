package com.example.androidapp.Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Connect implements Runnable
{
    private String ip;
    private int port;
    private Socket fg;
    private PrintWriter out;

    public Connect(String my_ip, int my_port, Socket my_fg, PrintWriter my_out){
        port = my_port;
        ip = my_ip;
        fg = my_fg;
        out = my_out;
    }
    @Override
    public void run() {
        try {
            //connect to sever
            fg=new Socket(this.ip,this.port);
            //wrap the OutputStream
            out=new PrintWriter(fg.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
