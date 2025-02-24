package org.example.Practica2;

public class Trainer extends MutxamelFC implements DeportiveActions{

    private final String format = "'^[0-9]-[0-9]-[0-9]$'";
    private Teams teams;
    private String soccerTraining;

    public Trainer(String name, int age) {
        super(name, age);
    }

    public void train() {}

    public void playMatch(String rival) {}

    public void focus() {}

    public void travel(String city) {}

    public void celebrateGol() {}

    public void planTrain(){}

    public void makeChanges(){}

}
