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

        }
    }
}
