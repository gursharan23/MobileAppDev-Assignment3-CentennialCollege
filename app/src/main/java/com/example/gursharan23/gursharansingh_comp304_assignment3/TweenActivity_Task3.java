package com.example.gursharan23.gursharansingh_comp304_assignment3;

//Imported packages

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

/*
 Date : March 2, 2018
 Author: Gursharan Singh
 Description: This is the tween activity class that animates the two imageview objects
 animation drawable object
 Version: 0.1 - Added onClickListener for starting and stopping the animation
 GitHub: https://github.com/iamgursharan
 */

public class TweenActivity_Task3 extends AppCompatActivity {

    //TweenActivity class begins

    // Declaring objects to be used later
     ObjectAnimator animator;
     AnimatorSet animatorSet;
     AnimatorSet playAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween__task3);

        // Initializing the views
        Button start=findViewById(R.id.startButton);
        Button stop=findViewById(R.id.stopButton);
        final ImageView earth=findViewById(R.id.earthImage);
        final ImageView sun=findViewById(R.id.sunImage);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //drawCircle only works with devices with greater than API21+
             if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                 Path path = new Path();
                 path.addCircle(sun.getX(), sun.getY(), (sun.getY()-320), Path.Direction.CCW);
                 animator = ObjectAnimator.ofFloat(earth, View.X, View.Y, path);
                 animatorSet=(AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),R.animator.rotate);
                 animator.setDuration(6000).setRepeatCount(Animation.INFINITE);
                 playAnim=new AnimatorSet();
                 animatorSet.setTarget(earth);
                 playAnim.playTogether(animator,animatorSet);
                 playAnim.start();
                }
             }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             playAnim.end();
            }
        });
    }



}
