package org.example.DispositivosInteligentes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Devices {

    private String name;
    private boolean status; //ON-OFF
    public Devices(String name){
        this.name = name;
        this.status = false;
    }

    public void TurnOff(){

        if (status){

            status = false;
            System.out.println(getName() + " Apagado");

        }else {

            System.out.println(getName() + " Ya esta apagado");

        }
    }

    public abstract void TurnOn();

    public void getActualStatus(){

        if (status){

            System.out.println(getName() + " Encendido");

        }else {

            System.out.println(getName() + " Apagado");

        }

    }

}
