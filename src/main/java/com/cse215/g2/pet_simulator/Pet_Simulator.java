package com.cse215.g2.pet_simulator;


public class Pet_Simulator {
//Background, Toys, Pet, Action, UI
//If action is going on and new action
// then cancel the current and start new
//Actions update variables after it is over
    public static void main(String[] args) {
        Validate();
        GUI.start();
        Animal a=new Animal();
        System.out.println("Hello World!"+a.age);
    }
    public static void Validate()
    {
        //
        
    }
}
