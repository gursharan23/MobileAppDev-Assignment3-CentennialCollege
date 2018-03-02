package com.example.gursharan23.gursharansingh_comp304_assignment3;

/*
Date: February 28th, 2018
Author: Gursharan Singh
ID: 300931676
Description: This is the main activity class that handles the events for the ' main screen ' activity
Version: 0.2 - Added the onListItemClick method to handle the click events for listview item
*/

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adding a listview control to the main control
        ListView list=getListView();
        //Initializing the string array
        String[] tasks=getResources().getStringArray(R.array.tasks);

        //binds the listview with string array
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tasks));
    }

    //This is listview item click method that handles the click event for each item in the listview

    public void onListItemClick(ListView parent, View view, int position,long id)
    {
        Intent i=null;
        switch (position)
        {
            case 0:
                Toast.makeText(this,"Task 1 selected",Toast.LENGTH_SHORT).show();
                i=new Intent(this,CanavasLayout_Task1.class);
                break;
            case 1:
                Toast.makeText(this,"Task 2 selected",Toast.LENGTH_SHORT).show();
       //         i=new Intent(this,Task2_Activity.class);
                break;
            case 2:
                Toast.makeText(this,"Task 3 selected",Toast.LENGTH_SHORT).show();
      //          i=new Intent(this,Task3_Activity.class);
                break;
        }
        startActivity(i);
    }
}
