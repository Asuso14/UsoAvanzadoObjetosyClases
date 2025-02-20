package org.example.DispositivosInteligentes;

import java.util.ArrayList;

public class AppDispositivos {
    public static void main(String[] args) {

        ArrayList<Devices> devicesList = new ArrayList<>();

        devicesList.add(new TV("LG SMART"));
        devicesList.add(new Alexa("Alexa"));
        devicesList.add(new AirConditioning("Haier Inverter"));
        devicesList.add(new TV("Samsung Chill"));

        for (Devices dev : devicesList){

            dev.TurnOn();
            if (dev instanceof RemoteControl){
                ((RemoteControl) dev).Sync();
            }
            dev.getActualStatus();
            dev.TurnOff();

            System.out.println("------------------");

        }
        Devices proyector = new Devices("Optoma") {
            @Override
            public void TurnOn() {
                if (isStatus()){

                    System.out.println("El proyector ya esta encendido...");

                }else {

                    System.out.println("Encendiendo proyector con ajuste automático de brillo...");
                    setStatus(true);

                }
            }
        };

        RemoteControl control_proyector = new RemoteControl() {
            @Override
            public void Sync() {
                System.out.println("Sincronizando proyector con control remoto de presentación...");
            }
        };

        Devices horno = new Devices("BALAY hot") {
            @Override
            public void TurnOn() {
                if (isStatus()){

                    System.out.println("El horno ya está encendido.");

                }else {

                    System.out.println("Calentando horno con ajuste automático de temperatura...");
                    setStatus(true);

                }
            }
        };
        devicesList.add(horno);
        devicesList.add(proyector);

        for (Devices dev : devicesList){

            dev.TurnOn();

            if (dev instanceof RemoteControl){

                ((RemoteControl) dev).Sync();

            } else if (dev.getName().equalsIgnoreCase("Optoma")) {

                control_proyector.Sync();

            }

            dev.getActualStatus();
            dev.TurnOff();

            System.out.println("------------------");

        }
    }
}
