package com.example.androidapp.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import androidx.annotation.NonNull;

public class Joystick extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener {

    //joystick interface
     interface IJoystik {
         void onChange(double a, double e);
    }
    public IJoystik call_back;
    private float xCen;
    private float yCen;
    private float radiusBase;
    private float radiusH;

    //constructor for joystick
    public Joystick(Context context) {
        super(context);
        getHolder().addCallback(this);
        setOnTouchListener(this);
        if(context instanceof IJoystik){
            call_back = (IJoystik) context;
        }
    }
    public Joystick(Context context, AttributeSet att, int style) {
        super(context, att, style);
        getHolder().addCallback(this);
        setOnTouchListener(this);
        if(context instanceof IJoystik){
            call_back = (IJoystik) context;
        }

    }

    public Joystick(Context context, AttributeSet att) {
        super(context, att);
        getHolder().addCallback(this);
        setOnTouchListener(this);
        if(context instanceof IJoystik){
            call_back = (IJoystik) context;
        }

    }

    private void setupPosition(){
        xCen = getWidth() / 2;
        yCen = getHeight() / 2;
        radiusBase = Math.min(getWidth(), getHeight()) / 3;
        radiusH = Math.min(getWidth(), getHeight()) / 5;
    }
    private void drawJoystick(float x, float y){
        if(getHolder().getSurface().isValid()){
            // create canvas object for drawing
            Canvas can = this.getHolder().lockCanvas();
            Paint paint_color = new Paint();
            //clear canvas
            can.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            paint_color.setARGB(255, 50, 50, 50);
            //draw the circle
            can.drawCircle(xCen, yCen, radiusBase, paint_color);
            //draw the knob
            paint_color.setARGB(250, 18, 108, 179);
            can.drawCircle(x, y, radiusH, paint_color);
            //show the drawing to user
            getHolder().unlockCanvasAndPost(can);
        }
    }
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        setupPosition();
        drawJoystick(xCen, yCen);
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent e) {
        if(v.equals(this)){
            if(e.getAction() != e.ACTION_UP){
                float disPlace = (float) Math.sqrt(Math.pow(e.getX() - xCen, 2) + Math.pow(e.getY() - yCen, 2));
                //if the touch is in the joystick bounds
                if(disPlace < radiusBase){
                    // move the joystick to the new location
                    drawJoystick(e.getX(), e.getY());
                    call_back.onChange(e.getX(), e.getY());

                }
                //if the touch is out of the joystick bounds
                else {
                    // calculate the new values
                    float proportion = radiusBase / disPlace;
                    float newX = xCen + (e.getX() - xCen) * proportion;
                    float newY = yCen + (e.getY() - yCen) * proportion;
                    drawJoystick(newX, newY);
                    call_back.onChange(newX, newY);

                }
            }
            else {
                //return the joystick to center
                drawJoystick(xCen, yCen);
                call_back.onChange(xCen, yCen);

            }
        }
        return true;
    }

    public float getxCen() {
        return xCen;
    }

    public float getyCen() {
        return yCen;
    }

    public float getRadiusBase() {
        return radiusBase;
    }
}
