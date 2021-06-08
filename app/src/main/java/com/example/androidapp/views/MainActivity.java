package com.example.androidapp.views;

import android.util.DisplayMetrics;
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
    private Joystick js;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        js = new Joystick(this);
        vm = new Viewmodel();
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewmodel(vm);
        final View view = findViewById(R.id.joystick);

        view.post(new Runnable() {
            @Override
            public void run() {
                // initialize x and y center
                vm.setxCen( view.getWidth()/2);
                vm.setyCen( view.getHeight()/2);
                vm.setbRad( Math.min(view.getWidth(), view.getHeight()) / 3);
            }
        });
    }


    @Override
    public void onChange(double a, double e) {
        //update x,y center and radius

        vm.setAileron(a);
        vm.setElevator(e);
    }

}