package org.example.Practica2;

import lombok.Getter;
import lombok.Setter;

import java.util.InputMismatchException;

@Getter
@Setter
public class Player extends MutxamelFC implements DeportiveActions{

    private Teams category;
    private Positions positions;
    private int dorsal;

    public Player(String name, int age, Teams category, Positions positions , int dorsal) {


        super(name, age);
        this.category = category;
        this.positions = positions;
        this.dorsal = dorsal;


    }

    public void train() {


        System.out.println("El jugador " + getName() + " con dorsal " + getDorsal() + " esta entrenando...");


    }

    public void playMatch(String rival) {


        System.out.println("El jugador " + getName() + " tiene un partido en contra de " + rival);


    }

    public void focus() {


        System.out.println("El jugador " + getName() + " con dorsal " + getDorsal() + " se esta concentrando...");


    }

    public void travel(String city) {


        System.out.println("El jugador " + getName() + " con dorsal " + getDorsal() + " va a viajar a " + city);


    }

    public void celebrateGol() {


        System.out.println("El jugador " + getName() + "celebra el gol, GOOOOOOOLASOOO");


    }

    public void warmUp(){


        System.out.println("El jugador " + getName() + " con el dorsal " + getDorsal() + " esta calentando para entrar al partido.");


    }

    public void rest(){


        System.out.println(" El jugador " + getName() + " con el dorsal " + getDorsal() + " va a salir al banquillo a descansar.");


    }

    public void scoreGol(){


        System.out.println("El jugador " + getName() + " ha marcado un golasoo!");


    }

}
