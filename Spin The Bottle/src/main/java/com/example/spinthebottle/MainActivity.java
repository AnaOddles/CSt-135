package com.example.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Declare the views of our app
    Button btn_spin;
    ImageView iv_bottle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect the views to their ids from resources
        btn_spin = (Button) findViewById(R.id.btn_spin);
        iv_bottle = (ImageView) findViewById(R.id.iv_bottle);

        //Make a event handler when button is clicked
        btn_spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create a random number
                final int theSpinDegree;

                //Random object
                Random r = new Random();

                theSpinDegree = r.nextInt(3600);

                //Rotation animation object
                RotateAnimation rotateBottle = new RotateAnimation(0,
                        theSpinDegree, Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f
                        );

                //Rotate for 2 seconds
                rotateBottle.setDuration((2000));
                //Set the position to stay the same after rotation
                rotateBottle.setFillAfter(true);
                //Set the rotate bottle to accelerate and then decelerate
                rotateBottle.setInterpolator(new AccelerateDecelerateInterpolator());

                //Delay the message
                //Animation listener
                rotateBottle.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //Make a message
                        if((theSpinDegree % 360 >= 0) && (theSpinDegree % 360 <= 90)){
                            Toast.makeText(MainActivity.this, "The person to the upper right has been chosen ",
                                    Toast.LENGTH_SHORT).show();
                        }else if ((theSpinDegree % 360 >= 91) && (theSpinDegree % 360 <= 180)){
                            Toast.makeText(MainActivity.this, "The person to the lower right has been chosen ",
                                    Toast.LENGTH_SHORT).show();
                        }else if ((theSpinDegree % 360 >= 181) && (theSpinDegree % 360 <= 270)){
                            Toast.makeText(MainActivity.this, "The person to the lower left has been chosen ",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "The person to the upper left has been chosen ",
                                    Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                //Rotate the bottle object
                iv_bottle.startAnimation(rotateBottle);





            }
        });
    }
}
