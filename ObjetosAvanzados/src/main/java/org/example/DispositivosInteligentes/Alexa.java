package org.example.DispositivosInteligentes;

public class Alexa extends Devices{

    public Alexa(String name) {
        super(name);
    }

    public void TurnOn() {

        if (super.isStatus()){

            System.out.println("El dispositivo ya esta encendido");

        }else {

            setStatus(true);
            System.out.println("Encendiendo dispositivo");

        }

    }
}
