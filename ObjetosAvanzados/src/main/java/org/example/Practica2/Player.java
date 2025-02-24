package org.example.Practica2;

public class Player extends MutxamelFC implements DeportiveActions{

    private Teams category;
    private Positions positions;
    private int dorsal;

    public Player(String name, int age) {
        super(name, age);
    }

    public void train() {}

    public void playMatch(String rival) {}

    public void focus() {}

    public void travel(String city) {}

    public void celebrateGol() {}

    public void warmUp(){}

    public void rest(){}

    public void scoreGol(){}

}
