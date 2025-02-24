package org.example.Excepcion;

import java.util.InputMismatchException;
import java.util.zip.DataFormatException;

public class main {

    public static void main(String[] args) throws NivelValidException {

        int lvl = 150;
        if (lvl > 100){

            throw new NivelValidException();

        }

    }
}
