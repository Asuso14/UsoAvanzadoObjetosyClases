package org.example.Practica2;

public class Masseur extends MutxamelFC {

    private String degree;
    private int experienceYears;

    public Masseur(String name, int age, String degree, int experienceYears) {
        super(name, age);
        this.degree = degree;
        this.experienceYears = experienceYears;
    }

    public void focus() {}

    public void travel(String city) {}

    public void celebrateGol() {}

    public void giveMassage( Player player ){}
}
