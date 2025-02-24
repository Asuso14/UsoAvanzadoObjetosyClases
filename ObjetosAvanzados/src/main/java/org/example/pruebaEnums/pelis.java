package org.example.pruebaEnums;

import java.util.Arrays;
import java.util.Scanner;

public class pelis {

    static Scanner entry = new Scanner(System.in);

    public static void main(String[] args) {

        SagasPelis peli = SagasPelis.SPIDERMAN;
        System.out.println(peli);

        for (SagasPelis pelis : SagasPelis.values()){

            System.out.println("Peli: " + pelis + " con " + pelis.getNumPelis() + " pelis en total");

        }

        System.out.println("introduce una saga " + Arrays.toString(SagasPelis.values()));
        String saga = entry.next();
        SagasPelis sagasPelis = SagasPelis.valueOf(saga);
        System.out.println("La saga escogida es " + sagasPelis + " con " + sagasPelis.getNumPelis() + " peliculas.");

        int posicion = sagasPelis.ordinal();
        System.out.println("La saga consultada esta en la posicion " + posicion);

        String saga_string = SagasPelis.CREPUSCULO.name();
        System.out.println(saga_string);



    }

}
