package com.example.gursharan23.gursharansingh_comp304_assignment3;

/*
Date: February 28th, 2018
Author: Gursharan Singh
ID: 300931676
Description: This is the main activity class that handles the events for the ' main screen ' activity
Version: 0.1 - Created the listview item control
*/
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
}
