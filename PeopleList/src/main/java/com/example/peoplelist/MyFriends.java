/***
 Name: Ana Sanchez
 Class: CST: 135
 Date: 4/1/2020
 This is the class that is used
 to encapsulate and describe
 the MyFriends object.

 This is my own work as influenced
 by Shad Sluiter's Videos.

 **/

package com.example.peoplelist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyFriends {

    //Properties
    List<Person> myFriendList;

    //Constructor
    public MyFriends(List<Person> myFriendList) {
        this.myFriendList = myFriendList;
    }

    //Default constructor that generates a new array with names
    public MyFriends(){
        String[] startingNames = {"Anselm", "Beatrice", "Carlisle"};
        Random rng = new Random();
        this.myFriendList = new ArrayList<>();
        for(int i = 0; i <startingNames.length; i++){
            Person p = new Person(startingNames[i], rng.nextInt(50) + 15, rng.nextInt(30));
            myFriendList.add(p);
        }
    }

    //Getter and setters
    public List<Person> getMyFriendList() {
        return myFriendList;
    }

    public void setMyFriendList(List<Person> myFriendList) {
        this.myFriendList = myFriendList;
    }
}
