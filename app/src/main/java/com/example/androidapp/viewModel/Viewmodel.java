package com.example.androidapp.viewModel;

import com.example.androidapp.Model.FGModel;
import com.example.androidapp.views.Joystick;

import java.io.IOException;

public class Viewmodel {
    private double aileron;
    private FGModel model;
    private Joystick js;
    public Viewmodel() {
        //this.js = js1;
    }

    public void serverConn() {
        try {
            //String ip,String port
            String ip = "1.1.1.1";
            String port = "4600";
            //get port and ip from user
            model.connectFG(ip, Integer.parseInt(port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAileron(double a){
        aileron = a;
    }

}
