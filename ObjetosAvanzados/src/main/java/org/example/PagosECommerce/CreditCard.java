package org.example.PagosECommerce;

import lombok.Getter;
import lombok.Setter;

import java.util.InputMismatchException;

/**
 * @author Nacho Gamallo
 * @version 1.0
 * Este objeto tipo PayMethod tiene 2 atributos los cuales debe ingresar el usuario, tambien tiene una constante la cual usaremos para
 * hacer conprobaciones de lo que nos ingrese el usuario. Es un objeto que hereda de Paymethod, para realizar pagos por tarjeta bancaria.
 */
@Getter @Setter
public class CreditCard extends PayMethod{

    private final String[] POSSIBLE_TYPE = {"VISA","MASTERCARD"};
    private String type;
    private String cardNumber;

    /**
     * Contructor del objeto Tarjeta, el cual asocia los valores que le pasa el usuario.
     * @param type Este parametro el tipo de tarjeta que es.
     * @param cardNumber Este parametro nos dara el número de tarjeta del usuario.
     */
    public CreditCard(String type, String cardNumber){

        this.type = type;
        this.cardNumber = cardNumber;

    }

    /**
     * Esta funcion booleana, va a  verificar que el número de tarjeta tiene el formato correcto. Comprueba la longitud
     * y que sea númerico.
     * @param cardNumber Le pasaremos el valor de la tarjeta del usuario.
     * @return Nos devuelve el resultado de las comprobaciónes realizadas. Si no es correcto false.
     */
    private boolean cardFormat(String cardNumber){

        try {

            long temp = Long.parseLong((cardNumber));

        }catch (InputMismatchException error){

            return false;

        }

        return true;

    }

    /**
     * Función booleana la cual va a comprobar que el tipo que ha ingresado el usuario es uno que tengamos en nuestra constante.
     * @param type Tipo de tarjeta que ha ingresado el usuario.
     * @return Dependiendo de si encuentra en la constante o no lo que ha ingresado el usuario, nos devolvera true-false.
     */
    private boolean checkType(String type){

        for (String i : POSSIBLE_TYPE){

            if (i.equalsIgnoreCase(type)){

                return true;

            }

        }
        return false;
    }

    /**
     * Función booleana que comprueba que tanto la longitud de la tarjeta sea de 16 como que sean todos números , llamando a cardFormat()
     * @param cardNumber Le vamos a pasar el número de tarjeta dado por el usuario.
     * @return Dependiendo del valor de cardNumber nos devolvera true o false.
     */
    private boolean checkCardNumber(String cardNumber){

        return cardNumber.length() == 16 && cardFormat(cardNumber);

    }

    /**
     * Si todas las comprobaciónes previamente hechas han dado que el formato esta bien, realizamos la operación imprimiendo por pantalla.
     * @param totalImport imporete ingresado por el usuario para la operación. Este método es heredado de PayMethod.
     */
    void paymentProcess(double totalImport) {

        System.out.println("Procesando pago de " + totalImport + "€ con tarjeta de crédito " + getType());
        System.out.println("Pago aceptado. Muchas gracias.");

    }

    /**
     * Esta función booleana heredada de PayMethod la hemos definido para que compruebe tanto el tipo de tarjeta
     * llamando a checkType() como la longitud y formato de esta, llamando a checkCardNumber()
     * @return Si las dos funciones que se llaman nos devuelven true, estara bien el formato sino devolvemos false.
     */
    boolean validatePayMethod() {

        if (checkCardNumber(getCardNumber()) && checkType(getType())){

            return true;

        }else {

            System.out.println("Formato de la tarjeta erroneo.");
            return false;
        }

    }

}
