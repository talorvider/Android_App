package com.example.androidapp.Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Connect implements Runnable
{
    private String ip;
    private int port;
    private Socket fg;
    private PrintWriter outi;
    private FGModel model;

    public Connect(String my_ip, int my_port, Socket my_fg, PrintWriter my_out, FGModel my_model){
        port = my_port;
        ip = my_ip;
        fg = my_fg;
        outi = my_out;
        model = my_model;
    }
    @Override
    public void run() {
        try {
            //connect to sever
            fg=new Socket(this.ip,this.port);
            //wrap the OutputStream
            outi=new PrintWriter(fg.getOutputStream(),true);
            model.setOut(outi);
            System.out.println("shani snd talor\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
