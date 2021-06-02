package com.example.androidapp.Model;

import com.example.androidapp.Views.joystick;

public class FGModel {
    private int port;
    private int ip;
    public FGModel () {
        }
        //connecnt to server
    private void connectFG(){
        fg=new Socket(ip,port);
        out=new PrintWriter(fg.getOutputStream(),true);

    }
}
