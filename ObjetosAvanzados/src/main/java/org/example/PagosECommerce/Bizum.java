package org.example.PagosECommerce;

import lombok.Getter;
import lombok.Setter;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Nacho Gamallo
 * @version 1.0
 * Este objeto tipo PayMethod tiene 2 atributos los cuales debe ingresar el usuario, un número de teléfono el cual debe ser númerico,
 * y un código de verificación que se le solicita al usuario, tiene que coincidir con el código generado automaticamente. Tambien tiene
 * las 2 erencias de PayMethod definidas.
 */

@Getter @Setter
public class Bizum extends PayMethod{

    private Exception InputMismatchException;
    static Scanner entry = new Scanner(System.in);
    static Random random = new Random();
    private String phoneNumber;
    private int code;

    /**
     * Constructor del objeto Bizum. El codigo es generado de manera aleatoria.
     * @param phoneNumber atributo que representa el número de teléfono del usuario.
     */
    public Bizum(String phoneNumber){

        this.phoneNumber = phoneNumber;
        this.code = random.nextInt(900000 ) + 100000;

    }

    /**
     * Esta funcion booleana lo que va a hacer es comprobar que tanto el número es
     * correcto como que el codigo que pone el usuario es el código que se ha generado.
     * @param phoneNumber Pasaremos el número del objeto Bizum
     * @return Dependiendo de si esta el número con formato correcto o el código es correcto, nos dara true/false.
     */
    private boolean validateBizum(String phoneNumber){

        try {

            if (phoneNumber.length() != 9){

                throw new NumberFormatException();

            }

            int temp = Integer.parseInt(phoneNumber);

        }catch (NumberFormatException error){

            return false;

        }
        return getUserCode();
    }

    /**
     * Esta funcion booleana se usa para verificar el código que ingresa el usuario.
     * @return Dependiendo de si es el mismo o no nos devolvera true/false.
     */
    private boolean getUserCode(){

        System.out.println(getCode());
        System.out.println("Introduce el código, para aceptar el pago:");
        return getCode() == entry.nextInt();

    }

    /**
     * Si todas las comprobaciónes previamente hechas han dado que el formato esta bien, realizamos la operación imprimiendo por pantalla.
     * @param totalImport imporete ingresado por el usuario para la operación. Este método es heredado de PayMethod.
     */
    void paymentProcess(double totalImport) {

        System.out.println("Procesando pago de importe " + totalImport + "€ con Bizum");
        System.out.println("Pago aceptado. Muchas gracias.");

    }

    /**
     * Función heredada de PayMethod, la cual indica si el formato de los atributos es correcto o no.
     * @return dependiendo de si validateBizum() nos da true o false, enviaremos el resultado a quien llame a esta función.
     */
    boolean validatePayMethod() {

        if (validateBizum(getPhoneNumber())){

            return true;

        }else{

            System.out.println("Formato de Bizum incorrecto");
            return false;

        }

    }

}

