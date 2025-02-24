package org.example.TiposEnumerados;

public enum Semaforo {

    ROJO , VERDE , AMARILLO;


    public Semaforo siguiente(Semaforo pos){

        switch (pos){

            case ROJO:
                return Semaforo.VERDE;

            case VERDE:

                return Semaforo.AMARILLO;

            case AMARILLO:

                return Semaforo.ROJO;
        }
        return ROJO;
    }

    public static void main(String [] orgs){

        Semaforo pos = Semaforo.AMARILLO;

        for ( int i = 0; i <= 10 ; i++ ){

            pos = pos.siguiente(pos);
            System.out.println(pos);

        }

    }

}
