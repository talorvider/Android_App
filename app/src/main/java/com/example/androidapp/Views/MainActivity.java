package com.example.androidapp.Views;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidapp.Model.FGModel;
import com.example.androidapp.R;
import com.example.androidapp.ViewModel.viewModel;

public class MainActivity extends AppCompatActivity {
    private viewModel vm;
    private FGModel model;
    private joystick js;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        js = new joystick(this);
        //define on_change function
        js.on_change =(a,e)->{
            vm.setAileron(a);
            //vm.setElevator(e);
        };
        setContentView(R.layout.activity_main);
    }

}