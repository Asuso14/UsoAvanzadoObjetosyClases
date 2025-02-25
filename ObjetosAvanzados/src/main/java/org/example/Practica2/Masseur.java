package org.example.Practica2;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Masseur extends MutxamelFC {

    private String degree;
    private int experienceYears;

    public Masseur(String name, int age, String degree, int experienceYears) {
        super(name, age);
        this.degree = degree;
        this.experienceYears = experienceYears;
    }

    public void focus() {


        System.out.println("El masajista " + getName() + " con el grado de " + getDegree() + " esta concentrado");


    }

    public void travel(String city) {


        System.out.println("El masajista " + getName() + " se va a ir de viaje a " + city);


    }

    public void celebrateGol() {


        System.out.println("GOLAAASOOOO!!!");


    }

    public void giveMassage( Player player ){


        System.out.println("El masajista " + getName() + " esta dandole un rico masaje al jugador " + player.getName() + " del equipo " + player.getCategory());


    }
}
