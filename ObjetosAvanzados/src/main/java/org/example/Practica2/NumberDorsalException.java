package org.example.Practica2;

public class NumberDorsalException extends RuntimeException {

    public NumberDorsalException() {

        System.out.println("El número de dorsal debe ser único en un mismo equipo.");

    }
}
