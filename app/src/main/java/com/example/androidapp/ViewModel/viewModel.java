package com.example.androidapp.ViewModel;

import com.example.androidapp.Model.FGModel;
import com.example.androidapp.Views.MainActivity;
import com.example.androidapp.Views.joystick;

import java.io.IOException;

public class viewModel {
    private double aileron;
    public int port;
    public String ip;
    private FGModel model;
    private joystick js;
    public viewModel (joystick js1) {
        this.js = js1;
    }

    public void serverConn() throws IOException {
        //get port and ip from user
        model.connectFG(ip, port);
    }

    public void setAileron(double a){
        aileron = a;
    }

}
