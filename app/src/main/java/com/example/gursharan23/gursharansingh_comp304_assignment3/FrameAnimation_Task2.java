package com.example.gursharan23.gursharansingh_comp304_assignment3;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/*
 Date : March 2, 2018
 Author: Gursharan Singh
 Description: This is the frame animation class that animates the set of images with
 animation drawable object
 Version: 0.2 - Added the StartAnimation and StopAnumation method to start or stop the animation
 GitHub: https://github.com/iamgursharan
 */
public class FrameAnimation_Task2 extends AppCompatActivity {

    AnimationDrawable frameAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation__task2);
    }

    // This is the add frames method that assigns frames to the imageview
    public void AddFrames()
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

        // Assigning duration
        int duration=200;
        frameAnimation=new AnimationDrawable();
        frameAnimation.setOneShot(true);
        frameAnimation.addFrame(frame1,duration);
        frameAnimation.addFrame(frame2,duration);
        frameAnimation.addFrame(frame3,duration);
        frameAnimation.addFrame(frame4,duration);
        frameAnimation.addFrame(frame5,duration);
        frameAnimation.addFrame(frame6,duration);
        frameAnimation.addFrame(frame7,duration);
        frameAnimation.addFrame(frame8,duration);
        frameAnimation.addFrame(frame9,duration);
        frameAnimation.addFrame(frame10,duration);
        // Setting drawable to the imageview
        animationImgView.setBackgroundDrawable(frameAnimation);
        frameAnimation.setVisible(true,true);
    }

    // This method starts  animation
    public void StartAnimation(View view)
    {
      frameAnimation.start();
    }

    // This method stops the animation
    public void StopAnimation(View view)
    {
        frameAnimation.stop();
    }

}
