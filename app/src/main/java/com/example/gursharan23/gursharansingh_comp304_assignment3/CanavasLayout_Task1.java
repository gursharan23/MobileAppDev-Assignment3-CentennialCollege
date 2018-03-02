package com.example.gursharan23.gursharansingh_comp304_assignment3;
/*
* Date : February 28, 2018
* Author : Gursharan Singh
* Description : This class handles all the events of the canvas layout activity
* Version : 0.4 - Refactored canvas activity class
* GitHub Info: https://github.com/iamgursharan
 */

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class CanavasLayout_Task1 extends Activity implements AdapterView.OnItemSelectedListener {

    //Declaring  canvas objects
    Paint paint;
    ImageView canvasImageView;
    Bitmap bitmap;
    Canvas canvas;
    // Declaring  coordinates of the line
    int startX;
    int startY;
    int endX;
    int endY;
    // Declaring color value
    int color;
    // Declaring the thickness variable
    int thickness;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canavas_layout__task1);

        // Instantiating canvas objects
        paint=new Paint();
        bitmap=Bitmap.createBitmap((int)getWindowManager().getDefaultDisplay().getWidth(),
                (int)getWindowManager().getDefaultDisplay().getHeight(),Bitmap.Config.ARGB_8888);
        canvas=new Canvas(bitmap);
        canvasImageView=findViewById(R.id.drawingCanvas);
        canvasImageView.setImageBitmap(bitmap);
        // Setting the background color of canvas
        canvas.drawColor(Color.BLACK);
        // Declaring spinner
        Spinner spinner=findViewById(R.id.thicknessSpinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.thickness_array,
                android.R.layout.simple_spinner_item);
        // Specify layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Applying adapter
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        // Setting coordinates starts
         EditText X=findViewById(R.id.inputX);
         String x= X.getText().toString();
         startX=Integer.parseInt(x);
         EditText Y=findViewById(R.id.inputY);
         String y= Y.getText().toString();
         startY=Integer.parseInt(y);
       // Setting coordinates ends

    }

    // This method draws line on the canvas. It accepts one parameter- canvas(Canvas)
    public void drawLine(Canvas canvas)
    {
        canvas.drawLine(startX,startY,endX,endY,paint);
        startX=endX;
        startY=endY;
    }

    // Overloaded method
    public void drawLine(int keyCode,Canvas canvas)
    {
        canvas.drawLine(startX,startY,endX,endY,paint);
        startX=endX;
        startY=endY;
    }
    //This method handles the click events of all the arrow buttons. It accepts one parameter -
    // view (View)
    public void Click(View view)
    {

        switch(view.getId()) {
            case R.id.leftArrowBtn:
                endX=endX-10;
                drawLine(canvas);
                break;
            case R.id.rightArrowBtn:
                endX=endX+10;
                drawLine(canvas);
                break;
            case R.id.upArrowBtn:
                endY=endY-10;
                drawLine(canvas);
                break;
            case R.id.downArrowBtn:
                endY=endY+10;
                drawLine(canvas);
                break;
        }
    }

    // This is the onItemSelected that triggers for every item selected in a spinner.
    // It sets strokewidth of the paint object
    public void onItemSelected(AdapterView<?> parent,View view, int pos, long id)
    {
        switch((String)parent.getItemAtPosition(pos))
        {
            case "20": thickness=20;
                Toast.makeText(this,"20 selected",Toast.LENGTH_SHORT).show();
                break;
            case "40": thickness=40;
                Toast.makeText(this,"40 selected",Toast.LENGTH_SHORT).show();
                break;
            case "60": thickness=60;
                Toast.makeText(this,"60 selected",Toast.LENGTH_SHORT).show();
                break;
            case "80": thickness=80;
                Toast.makeText(this,"80 selected",Toast.LENGTH_SHORT).show();
                break;
            case "100": thickness=100;
                Toast.makeText(this,"100 selected",Toast.LENGTH_SHORT).show();
                break;
        }
        paint.setStrokeWidth(thickness);
    }

    // This method sets the color of the paint object with respect to the radio button seleted
    public void onRadioItemSelected(View view)
    {
        boolean checked= ((RadioButton)view).isChecked();
        switch(view.getId())
        {
            case R.id.redLineRadioBtn:
                if(checked)
                    color=Color.RED;
                break;
            case R.id.yellowLineRadioBtn:
                if(checked)
                    color=Color.YELLOW;
                break;
            case R.id.greenLineRadioBtn:
                if(checked)
                    color=Color.GREEN;
                break;
        }
        paint.setColor(color);
    }

    //This method clears the canvas
    public void clearButtonClicked(View view)
    {
        if(view.isClickable())
        {
            canvas.drawColor(Color.BLACK);
        }
    }

    // This method handles the keystrokes for drawing line on the canvas
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        switch (keyCode)
        {
            case KeyEvent.KEYCODE_DPAD_LEFT:
            endX=endX-5;
            drawLine(keyCode,canvas);
            return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                endX=endX+5;
                drawLine(keyCode,canvas);
                return true;
            case KeyEvent.KEYCODE_DPAD_UP:
                endY=endY-5;
                drawLine(keyCode,canvas);
                return true;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                endY=endY+5;
                drawLine(keyCode,canvas);
                return true;
        }
        return false;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
