package org.example.TiposEnumerados;

import java.util.Arrays;
import java.util.Scanner;

public class DificultyApp {
    public static void main(String[] args) {

        Scanner entry = new Scanner(System.in);

        Dificulty dificulty = null;

        System.out.println("Introduce la dificultad" + Arrays.toString(Dificulty.values()));
        try {
            dificulty = Dificulty.valueOf(entry.next());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        if (dificulty != null){
            System.out.println("Puntuacion obtenida=");
            int point = entry.nextInt();
            System.out.println("Puntuacion final=" + point*dificulty.getNum());
        }
    }
}
