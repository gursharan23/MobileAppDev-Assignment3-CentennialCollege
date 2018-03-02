package com.example.gursharan23.gursharansingh_comp304_assignment3;
/*
* Date : February 28, 2018
* Author : Gursharan Singh
* Description : This class handles all the events of the canvas layout activity
* Version : 0.2 - Added the onItemSelected for spinner
* GitHub Info: https://github.com/iamgursharan
 */

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class CanavasLayout_Task1 extends Activity implements AdapterView.OnItemSelectedListener {

    //Declaring  canvas objects
    Paint paint;
    ImageView canvasImageView;
    Bitmap bitmap;
    Canvas canvas;
    // Decalaring the position of the line
    int startX=50;
    int startY=50;
    int endX=50;
    int endY=50;
    // Declaring the thickness variable
    int thickness;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canavas_layout__task1);

        // Instantiating canvas objects
        paint=new Paint();
        paint.setColor(Color.RED);
      //  paint.setStrokeWidth(thickness);
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

    }

    // This method draws line on the canvas. It accepts one paramenter- canvas(Canvas)
    public void drawLine(Canvas canvas)
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
                endX=endX-5;
                drawLine(canvas);
                break;
            case R.id.rightArrowBtn:
                endX=endX+5;
                drawLine(canvas);
                break;
            case R.id.upArrowBtn:
                endY=endY-5;
                drawLine(canvas);
                break;
            case R.id.downArrowBtn:
                endY=endY+5;
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

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
