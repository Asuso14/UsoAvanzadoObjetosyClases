package org.example.Excepcion;

public class NivelValidException extends Exception{

    public NivelValidException(){

        super("El nivel no puede ser mayor que 100");

    }

}
