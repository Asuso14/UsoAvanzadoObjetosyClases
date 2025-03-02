package org.example.Practica2;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

@Getter
@Setter
public class Player extends MutxamelFC implements DeportiveActions{

    private Teams category;
    private Positions positions;
    private int dorsal;
    public static ArrayList<Player> playerList = new ArrayList<>();

    public Player(String name, int age, Teams category, Positions positions , int dorsal) {

        super(name, age);
        checkDorsal(dorsal,category);
        this.category = category;
        this.positions = positions;
        this.dorsal = dorsal;
        playerList.add(this);

    }

    public void setDorsal(int dorsal){

        checkDorsal(dorsal,getCategory());
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


        System.out.println("El jugador " + getName() + " con el dorsal " + getDorsal() + " esta calentando.");


    }

    public void rest(){


        System.out.println(" El jugador " + getName() + " con el dorsal " + getDorsal() + " va a descansar.");


    }

    public void scoreGol(){


        System.out.println("El jugador " + getName() + " ha marcado un golasoo!");


    }

    private void checkDorsal(int dorsal, Teams category){

        for (Player p : playerList){

            try{

                if (p.getDorsal() == dorsal && p.getCategory() == category){

                    throw new NumberDorsalException();

                }

            }catch (NumberDorsalException error){

                System.out.println(error.getMessage());
                System.exit(1);

            }

        }

    }

    @Override
    public String toString() {
        return "[" +
                "Nombre: " + this.getName() +
                ", Edad: " + this.getAge() +
                ", Categoria: " + this.getCategory() +
                ", Dorsal: " + this.getDorsal() +
                ", Posicion: " + getPositions() +
                "]";
    }
}
