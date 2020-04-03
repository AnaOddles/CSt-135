/***
 Name: Ana Sanchez
 Class: CST: 135
 Date: 4/1/2020
 This is the class that is used
 to encapsulate and describe
 the person object.

 This is my own work as influenced
 by Shad Sluiter's Videos.

 **/




package com.example.peoplelist;

public class Person implements Comparable<Person>{
    //Properties
    private String name;
    private int age;
    private int pictureNumber;

    //Constructor
    public Person(String name, int age, int pictureNumber) {
        this.name = name;
        this.age = age;
        this.pictureNumber = pictureNumber;
    }

    //Getter and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPictureNumber() {
        return pictureNumber;
    }

    public void setPictureNumber(int pictureNumber) {
        this.pictureNumber = pictureNumber;
    }

    //compareTo for sorting
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
}
