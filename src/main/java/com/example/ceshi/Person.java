package com.example.ceshi;

/**
 * Created by 石磊 on 2018/7/15.
 */
public class Person {
    public Animal animal;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void shout(){
        System.out.println("nihao!");
        this.animal.shout();
    }

}
