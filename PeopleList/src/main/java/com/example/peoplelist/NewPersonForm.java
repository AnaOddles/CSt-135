package com.example.peoplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class NewPersonForm extends AppCompatActivity {
    //Declare the views on vars that we will manipulate
    Button btn_ok, btn_cancel;
    EditText et_name, et_age, et_picturenumber;

    int positionToEdit = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_person_form);

        //Assign resource to button
        btn_ok = findViewById(R.id.btn_ok);

        //Define vars
        et_age = findViewById(R.id.et_age);
        et_name = findViewById(R.id.et_name);
        et_picturenumber = findViewById(R.id.et_piecturenumber);

        //listen for incoming data
        Bundle incomingIntent = getIntent().getExtras();

        if(incomingIntent != null){
            String name = incomingIntent.getString("name");
            int age = incomingIntent.getInt("age");
            int pictureNumber = incomingIntent.getInt("picturenumber");
            positionToEdit = incomingIntent.getInt("edit");

            //fill in the edit form
            et_name.setText(name);
            et_age.setText(Integer.toString(age));
            et_picturenumber.setText(Integer.toString(pictureNumber));
        }

        //Click listener
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get strings from et_view objects
                String newName = et_name.getText().toString();
                String newAge = et_age.getText().toString();
                String newPictureNumber = et_picturenumber.getText().toString();

                //put the strings into a message for MainActivity

                //start main Activity again

                Intent i = new Intent(v.getContext(), MainActivity.class);

                i.putExtra("edit", positionToEdit);
                i.putExtra("name", newName);
                i.putExtra("age", newAge);
                i.putExtra("picturenumber", newPictureNumber);

                startActivity(i);
            }
        });

    }
}
