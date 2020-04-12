package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.contactapp.Models.AddressBook;

public class AddNewPerson extends AppCompatActivity {

    //Declare reference to the buttons and edit texts
    Button btn_CreatePerson, btn_CancelCreatePerson, btn_DeletePerson;
    EditText et_FirstName, et_LastName, et_DOB, et_Email, et_Street, et_City, et_State, et_ZipCode,
             et_Country, et_Description;
    TextView tv_Person;
    int positionToEdit  = -1;


    //Declare an address book object
    AddressBook addyBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnewpersoncontact);

        //Set the reference to views by ids
        btn_CreatePerson  = findViewById(R.id.btn_DoneCreatePerson);
        btn_CancelCreatePerson = findViewById(R.id.btn_CancelCreatePerson);
        btn_DeletePerson = findViewById(R.id.btn_DeletePerson);
        et_FirstName = findViewById(R.id.et_FirstName);
        et_LastName = findViewById(R.id.et_LastName);
        et_DOB = findViewById(R.id.et_DOB);
        et_Email = findViewById(R.id.et_Email);
        et_Street = findViewById(R.id.et_Street);
        et_City = findViewById(R.id.et_City);
        et_State = findViewById(R.id.et_State);
        et_ZipCode = findViewById(R.id.et_ZipCode);
        et_Country = findViewById(R.id.et_Country);
        et_Description = findViewById(R.id.et_Description);
        tv_Person = findViewById(R.id.tv_Person);

        //listen for incoming data
        Bundle incomingMessages = getIntent().getExtras();
        if(incomingMessages != null){
            //capture incoming data
            String firstName = incomingMessages.getString("firstName");
            String lastName = incomingMessages.getString("lastName");
            String DOB = incomingMessages.getString("DOB");
            String email = incomingMessages.getString("email");
            String street = incomingMessages.getString("street");
            String city = incomingMessages.getString("city");
            String state = incomingMessages.getString("state");
            int zipCode = incomingMessages.getInt("zipCode");
            String country = incomingMessages.getString("country");
            String description = incomingMessages.getString("description");
            positionToEdit = incomingMessages.getInt("edit");



            //fill in the form
            et_FirstName.setText(firstName);
            et_LastName.setText(lastName);
            et_DOB.setText(DOB);
            et_Email.setText(email);
            et_Street.setText(street);
            et_City.setText(city);
            et_State.setText(state);
            et_ZipCode.setText(Integer.toString(zipCode));
            et_Country.setText(country);
            et_Description.setText(description);

        }
        //Click listener for create person button
        btn_CreatePerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get strings from the ets
                String firstName = et_FirstName.getText().toString();
                String lastName = et_LastName.getText().toString();
                String DOB = et_DOB.getText().toString();
                String email = et_Email.getText().toString();
                String street = et_Street.getText().toString();
                String city = et_City.getText().toString();
                String state = et_State.getText().toString();
                String zipCode = et_ZipCode.getText().toString();
                String country= et_Country.getText().toString();
                String description = et_Description.getText().toString();
                String person = tv_Person.getText().toString();




                //start the main activity
                Intent i = new Intent(v.getContext(), MainActivity.class);

                //put strings into the message for main activity
                i.putExtra("edit", positionToEdit);
                i.putExtra("firstName", firstName);
                i.putExtra("lastName", lastName);
                i.putExtra("DOB", DOB);
                i.putExtra("email", email);
                i.putExtra("street", street);
                i.putExtra("city", city);
                i.putExtra("state", state);
                i.putExtra("zipCode", zipCode);
                i.putExtra("country", country);
                i.putExtra("description", description);
                i.putExtra("contactType", person);

                //start the activity
                startActivity(i);
            }
        });
        //Click listener for cancel
        btn_CancelCreatePerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start the intent for the main activity
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });

        //Click listener for deleting person contact
        btn_DeletePerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.deleteContact(positionToEdit);
                Intent i = new Intent (getApplicationContext(), MainActivity.class);
                startActivity(i);

            }
        });
    }
}
