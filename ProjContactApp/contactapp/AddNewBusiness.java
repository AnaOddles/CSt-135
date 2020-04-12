package com.example.contactapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddNewBusiness extends AppCompatActivity {

    //Declare reference to the buttons and edit texts
    Button btn_CreateBusiness, btn_CancelCreateBusiness, btn_DeleteBusiness;
    EditText et_FirstName, et_LastName, et_DOB, et_Email, et_Street, et_City, et_State, et_ZipCode,
            et_Country, et_OpeningTime, et_ClosingTime, et_DaysOpen, et_Website;
    TextView tv_Business;
    int positionToEdit = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnewbusinesscontact);

        //Set the reference to views by ids
        btn_CreateBusiness  = findViewById(R.id.btn_DoneCreateBusiness);
        btn_CancelCreateBusiness = findViewById(R.id.btn_CancelCreateBusiness);
        btn_DeleteBusiness = findViewById(R.id.btn_DeleteBusiness);
        et_FirstName = findViewById(R.id.et_FirstName);
        et_LastName = findViewById(R.id.et_LastName);
        et_Email = findViewById(R.id.et_Email);
        et_Street = findViewById(R.id.et_Street);
        et_City = findViewById(R.id.et_City);
        et_State = findViewById(R.id.et_State);
        et_ZipCode = findViewById(R.id.et_ZipCode);
        et_Country = findViewById(R.id.et_Country);
        et_OpeningTime = findViewById(R.id.et_OpeningTime);
        et_ClosingTime = findViewById(R.id.et_ClosingTime);
        et_DaysOpen = findViewById(R.id.et_DaysOpen);
        et_Website = findViewById(R.id.et_Website);
        tv_Business = findViewById(R.id.tv_Business);

        //listen for incoming data
        Bundle incomingMessages = getIntent().getExtras();
        if(incomingMessages != null){
            //capture incoming data
            String firstName = incomingMessages.getString("firstName");
            String lastName = incomingMessages.getString("lastName");
            String email = incomingMessages.getString("email");
            String street = incomingMessages.getString("street");
            String city = incomingMessages.getString("city");
            String state = incomingMessages.getString("state");
            int zipCode = incomingMessages.getInt("zipCode");
            String country = incomingMessages.getString("country");
            String openingTime = incomingMessages.getString("openingTime");
            String closingTime = incomingMessages.getString("closingTime");
            String daysOpen = incomingMessages.getString("daysOpen");
            String website = incomingMessages.getString("website");
            positionToEdit = incomingMessages.getInt("edit");


            //fill in the form
            et_FirstName.setText(firstName);
            et_LastName.setText(lastName);
            et_Email.setText(email);
            et_Street.setText(street);
            et_City.setText(city);
            et_State.setText(state);
            et_ZipCode.setText(Integer.toString(zipCode));
            et_Country.setText(country);
            et_ClosingTime.setText(closingTime);
            et_OpeningTime.setText(openingTime);
            et_DaysOpen.setText(daysOpen);
            et_Website.setText(website);
        }



        //Click listener for create person button
        btn_CreateBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get strings from the ets
                String firstName = et_FirstName.getText().toString();
                String lastName = et_LastName.getText().toString();
                String email = et_Email.getText().toString();
                String street = et_Street.getText().toString();
                String city = et_City.getText().toString();
                String state = et_State.getText().toString();
                String zipCode = et_ZipCode.getText().toString();
                String country= et_Country.getText().toString();
                String openingTime = et_OpeningTime.getText().toString();
                String closingTime = et_ClosingTime.getText().toString();
                String daysOpen = et_DaysOpen.getText().toString();
                String website = et_Website.getText().toString();
                String business = tv_Business.getText().toString();





                //start the main activity
                Intent i = new Intent(v.getContext(), MainActivity.class);

                //put strings into the message for main activity
                i.putExtra("edit", positionToEdit);
                i.putExtra("firstName", firstName);
                i.putExtra("lastName", lastName);
                i.putExtra("email", email);
                i.putExtra("street", street);
                i.putExtra("city", city);
                i.putExtra("state", state);
                i.putExtra("zipCode", zipCode);
                i.putExtra("country", country);
                i.putExtra("openingTime", openingTime);
                i.putExtra("closingTime", closingTime);
                i.putExtra("daysOpen", daysOpen);
                i.putExtra("website", website);
                i.putExtra("contactType", business);


                startActivity(i);
            }
        });

        //Click listener for cancel
        btn_CancelCreateBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start the intent for the main activity
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });

        //Click listener for deleting business contact
        btn_DeleteBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.deleteContact(positionToEdit);
                Intent i = new Intent (getApplicationContext(), MainActivity.class);
                startActivity(i);

            }
        });
    }

}
