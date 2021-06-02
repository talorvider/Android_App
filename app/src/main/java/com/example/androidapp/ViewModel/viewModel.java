package com.example.androidapp.ViewModel;

import com.example.androidapp.Model.FGModel;
import com.example.androidapp.Views.joystick;

public class viewModel {
    private double aileron;
    private FGModel model;
    private joystick js;
    public void setAileron(double a){
        aileron = a;
    }

}
