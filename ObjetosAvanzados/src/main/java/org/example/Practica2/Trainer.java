package org.example.Practica2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Trainer extends MutxamelFC implements DeportiveActions{

    private final String FORMAT = "^\\d-\\d-\\d$";
    private Teams teams;
    private String soccerTraining;

    public Trainer(String name, int age, Teams teams, String soccerTraining) {


        super(name, age);
        this.teams = teams;
        this.soccerTraining = soccerTraining;


    }

    public void train() {


        System.out.println("El entrenador " + getName() + " esta realizando el entrenamiento.");


    }

    public void trainingPlan(){


        System.out.println("El entrenador " +  getName() + " del equipo de " + getTeams() + " esta planificando el entrenamiento.");


    }

    public void playMatch(String rival) {


        System.out.println("El entrenador " + getName() + " tiene un partido contra " + rival + " del equipo de los " + getTeams());


    }

    public void focus() {


        System.out.println("El entrenador " + getName() + " se esta concentrando.");


    }

    public void travel(String city) {


        System.out.println("El entrenador " + getName() + " se va de viaje a " + city);
    }

    public void celebrateGol() {


        System.out.println("GOLAAASOOOOO");


    }

    public void makeChanges(Player playerChanged , Player playerEntering){


        System.out.println("El jugador " + playerChanged.getName() + " con el dorsal " + playerChanged.getDorsal() + " y entra...");
        System.out.println("El jugador " + playerEntering.getName() + " con el dorsal " + playerEntering.getDorsal() + " entra al campoo!!");


    }

}
