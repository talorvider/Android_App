package com.example.androidapp.viewModel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.example.androidapp.Model.FGModel;
import com.example.androidapp.views.Joystick;

import java.io.IOException;

public class Viewmodel extends BaseObservable {
    private double aileron;
    private String ip;
    private String port;
    private FGModel model;
    private Joystick js;
    public Viewmodel() {
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    @Bindable
    public String getIp() {
        return ip;
    }

    public void setPort(String port) {
        this.port = port;
    }
    @Bindable
    public String getPort() {
        return port;
    }

    public void serverConn() {
        try {
            //get port and ip from user
            int portInt = Integer.parseInt(port);
            model.connectFG(ip, portInt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAileron(double a){
        aileron = a;
    }

}
