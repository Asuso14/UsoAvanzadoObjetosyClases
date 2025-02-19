package org.example.DispositivosInteligentes;

public class AirConditioning extends Devices implements RemoteControl{

    public AirConditioning(String name) {
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

    public void Sync() {

        System.out.println("Sincronizando aire acondicionado con control remoto...");

    }
}
