/***
 Name: Ana Sanchez
 Class: CST: 135
 Date: 4/1/2020
 This is the script that is
 used to manipulate and describe
 the MainActivity view.

 This is my own work as influenced
 by Shad Sluiter's Videos.

 **/


package com.example.peoplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    //Declare properties
    Button btn_add, btn_sortABC, btn_sortAGE;

    //Make an instance of the PersonAdapater object
    PersonAdapter adapter;

    MyFriends myFriends;

    ListView lv_friendsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect properties to reference
        btn_add = findViewById(R.id.btn_add);
        btn_sortABC = findViewById(R.id.btn_sortABC);
        btn_sortAGE = findViewById(R.id.btn_sortAGE);
        lv_friendsList = findViewById(R.id.lv_listOfNames);

        myFriends = ((MyApplication) this.getApplication()).getMyFriends();
        adapter = new PersonAdapter(MainActivity.this, myFriends);

        lv_friendsList.setAdapter(adapter);

        //listen for incoming messages
        Bundle incomingMessages = getIntent().getExtras();
        if (incomingMessages != null) {
            //capture incoming data
            String name = incomingMessages.getString("name");
            int age = Integer.parseInt(incomingMessages.getString("age"));
            int picturenumber = Integer.parseInt(incomingMessages.getString("picturenumber"));
            int positionEdited = incomingMessages.getInt("edit");

            //create a new person object
            Person p = new Person(name, age, picturenumber);

            if(positionEdited > -1){
                myFriends.getMyFriendList().remove(positionEdited);
            }
            //add person to the list and update adapter
            myFriends.getMyFriendList().add(p);

            adapter.notifyDataSetChanged();

        }

        //Button event handler for the add button
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to open another activity, starts at this activity and the destination is the new person form class
                //Explicit Intent
                Intent i = new Intent(v.getContext(), NewPersonForm.class );
                startActivity(i);
            }
        });

        //Button event handler for the sort by age button
        btn_sortAGE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(myFriends.myFriendList, new Comparator<Person>() {
                    @Override
                    public int compare(Person p1, Person p2) {
                        return p1.getAge() - p2.getAge();
                    }
                });
                adapter.notifyDataSetChanged();
            }
        });

        //Button event handler for the sort by name button
        btn_sortABC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(myFriends.myFriendList);
                adapter.notifyDataSetChanged();
            }
        });

        //Click listener for clicking on a listview object
        lv_friendsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editPerson(position);
            }
        });

    }

    //Method to edit a person/ object in the list view
    public void editPerson(int position){
        Intent i = new Intent(getApplication(), NewPersonForm.class);

        //get the contentsm of the person that was clicked
        Person p = myFriends.getMyFriendList().get(position);

        i.putExtra("edit", position);
        i.putExtra("name", p.getName());
        i.putExtra("age", p.getAge());
        i.putExtra("picturenumber", p.getPictureNumber());

        startActivity(i);
    }
}
