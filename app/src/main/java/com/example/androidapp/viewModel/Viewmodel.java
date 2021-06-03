package com.example.androidapp.viewModel;

import com.example.androidapp.Model.FGModel;
import com.example.androidapp.views.Joystick;

import java.io.IOException;

public class Viewmodel {
    private double aileron;
    public String ip;
    public int port;
    private FGModel model;
    private Joystick js;
    public Viewmodel() {
        //this.js = js1;
    }

    public void serverConn() {
        try {
            //get port and ip from user
            model.connectFG(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAileron(double a){
        aileron = a;
    }

}
