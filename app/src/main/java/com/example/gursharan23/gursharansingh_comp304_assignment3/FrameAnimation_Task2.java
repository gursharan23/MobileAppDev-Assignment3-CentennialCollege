package com.example.gursharan23.gursharansingh_comp304_assignment3;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/*
 Date : March 2, 2018
 Author: Gursharan Singh
 Description: This is the frame animation class that animates the set of images with
 animation drawable object
 Version: 0.3 - Added setDuration method
 GitHub: https://github.com/iamgursharan
 */
public class FrameAnimation_Task2 extends AppCompatActivity {

    AnimationDrawable frameAnimation=new AnimationDrawable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation__task2);
        setDuration();
        addFrames();
    }

    // This is the add frames method that assigns frames to the imageview
    public void addFrames()
    {

        ImageView animationImgView=findViewById(R.id.animationImageview);

        BitmapDrawable frame1=(BitmapDrawable)getResources().getDrawable(R.drawable.frame1);
        BitmapDrawable frame2=(BitmapDrawable)getResources().getDrawable(R.drawable.frame2);
        BitmapDrawable frame3=(BitmapDrawable)getResources().getDrawable(R.drawable.frame3);
        BitmapDrawable frame4=(BitmapDrawable)getResources().getDrawable(R.drawable.frame4);
        BitmapDrawable frame5=(BitmapDrawable)getResources().getDrawable(R.drawable.frame5);
        BitmapDrawable frame6=(BitmapDrawable)getResources().getDrawable(R.drawable.frame6);
        BitmapDrawable frame7=(BitmapDrawable)getResources().getDrawable(R.drawable.frame7);
        BitmapDrawable frame8=(BitmapDrawable)getResources().getDrawable(R.drawable.frame8);
        BitmapDrawable frame9=(BitmapDrawable)getResources().getDrawable(R.drawable.frame9);
        BitmapDrawable frame10=(BitmapDrawable)getResources().getDrawable(R.drawable.frame10);

        frameAnimation.setOneShot(true);
        // Adding frames and duration
        frameAnimation.addFrame(frame1,setDuration());
        frameAnimation.addFrame(frame2,setDuration());
        frameAnimation.addFrame(frame3,setDuration());
        frameAnimation.addFrame(frame4,setDuration());
        frameAnimation.addFrame(frame5,setDuration());
        frameAnimation.addFrame(frame6,setDuration());
        frameAnimation.addFrame(frame7,setDuration());
        frameAnimation.addFrame(frame8,setDuration());
        frameAnimation.addFrame(frame9,setDuration());
        frameAnimation.addFrame(frame10,setDuration());
        // Setting drawable to the imageview
        animationImgView.setBackgroundDrawable(frameAnimation);
        frameAnimation.setVisible(true,true);
    }

    // This method starts  animation
    public void startAnimation(View view)
    {
      frameAnimation.start();
      frameAnimation.setOneShot(false);
    }

    // This method stops the animation
    public void stopAnimation(View view)
    {
        frameAnimation.stop();
    }

    // This method is used for setting duration
    public int setDuration()
    {
        int duration;
        EditText timeET=findViewById(R.id.durationEditText);
        String durationText=timeET.getText().toString();
        duration=Integer.parseInt(durationText);

        return duration;
    }

}
