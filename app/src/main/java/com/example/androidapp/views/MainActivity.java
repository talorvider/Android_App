package com.example.androidapp.views;

import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import com.example.androidapp.Model.FGModel;
import com.example.androidapp.R;
import com.example.androidapp.viewModel.Viewmodel;
import com.example.androidapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Joystick.IJoystik {
    private Viewmodel vm;
    private FGModel model;
    private Joystick js;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        js = new Joystick(this);
        vm = new Viewmodel();
        ActivityMainBinding binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewmodel(new Viewmodel());
        setContentView(R.layout.activity_main);



        /*// insert to botom func
        EditText port_et = (EditText) findViewById(R.id.port);
        String port = port_et.getText().toString();
        vm.port = Integer.parseInt(port);
        EditText ip_et = (EditText) findViewById(R.id.ip);
        vm.ip = ip_et.getText().toString();*/

        //define on_change function
       // js.call_back =(a,e)->{
        //    vm.setAileron(a);
            //vm.setElevator(e);
        //};

    }


    @Override
    public void onChange(double a, double e) {
        vm.setAileron(a);
    }
    public void sendMessage(View view) {
        EditText port_et = (EditText) findViewById(R.id.port);
        String port = port_et.getText().toString();
        vm.port = Integer.parseInt(port);
        EditText ip_et = (EditText) findViewById(R.id.ip);
        vm.ip = ip_et.getText().toString();
        vm.serverConn();
        // Do something in response to button click
    }
}