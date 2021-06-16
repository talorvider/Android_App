package com.example.androidapp.viewModel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.example.androidapp.BR;
import com.example.androidapp.Model.FGModel;
import com.example.androidapp.views.Joystick;
import com.example.androidapp.views.MainActivity;

import java.io.IOException;

public class Viewmodel extends BaseObservable {

    private float xCen;
    private float yCen;
    private float bRad;
    private String ip;
    private String port;
    private FGModel model;

    // the constructor.
    public Viewmodel() {
        model = new FGModel();
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

    // this function is called when the connect button is pressed.
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
        model.calcAileron(a, xCen, bRad);
    }

    public void setElevator(double e) {
        model.calcElevator(e,yCen, bRad);
    }

    public void setbRad(float bRad) {
        this.bRad = bRad;
    }

    public void setxCen(float xCen) {
        this.xCen = xCen;
    }

    public void setyCen(float yCen) {
        this.yCen = yCen;
    }

    public void setRudder(int rudder) {
        model.updateRudder(rudder);
    }

    public void setThrottle(int throttle) {
        model.updateThrottle(throttle);
    }


}
