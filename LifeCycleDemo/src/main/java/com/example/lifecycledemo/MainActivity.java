package com.example.lifecycledemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declare the views that we are going to manipualte
    Button btn_clicker;
    TextView tv_counter;

    int clicks = 0;

    //Method to save any values before the app is destroyed
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Accessing the bundle to keep track of the click value
        outState.putInt("clickervalue", clicks);
    }

    //Capture that temporary values
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        clicks = savedInstanceState.getInt("clickervalue");
        tv_counter = findViewById(R.id.tv_counter);
        tv_counter.setText(Integer.toString(clicks));

    }

    //Lifecycle methods
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecyclefilter", "The app is paused.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecyclefilter", "The app is resumed.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecyclefilter", "The app is restarted.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecyclefilter", "The app is started.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecyclefilter", "The app is stopped.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecyclefilter", "The app is destroyed.");
    }

    //Life cycle method for when the app is opened
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecyclefilter", "The app is created.");

        //Connect each view with its id value
        btn_clicker = findViewById(R.id.btn_clicker);
        tv_counter = findViewById(R.id.tv_counter);

        //event handler for the button
        btn_clicker.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clicks++;
                tv_counter.setText(Integer.toString(clicks));
            }
        });
    }
}
