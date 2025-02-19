package org.example.DispositivosInteligentes;


public class TV extends Devices implements RemoteControl {

    public TV(String name) {
        super(name);
    }

    @Override
    public void TurnOn() {

        if (super.isStatus()){

            System.out.println("El dispositivo ya esta encendido");

        }else {

            setStatus(true);
            System.out.println("Encendiendo dispositivo");

        }

    }

    @Override
    public void Sync() {

        System.out.println("Sincronizando Televisor con control remoto...");

    }
}
