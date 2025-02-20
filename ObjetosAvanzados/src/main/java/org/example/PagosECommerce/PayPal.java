package org.example.PagosECommerce;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Nacho Gamallo
 * @version 1.0
 * Este objeto, que hereda de PayMethod, tiene 2 atributos. El email del usuario y el saldo de la cuenta de PayPal que tiene. También usaremos una constante para
 * poder verificar que el correo que ingrese el usuario tenga el formato de correo correcto.
 */

@Getter @Setter
public class PayPal extends PayMethod{

    private final String MAIL_FORMAT = "^[^@/!#~+=\\s]+@[^@\\s]+\\.com$";
    private String account;
    private double balance;

    /**
     * Contructor básico del objeto PayPal, en el cual no pasamos el importe de la cuenta y definimos uno por defecto.
     * @param account correo que nos ha pasado el usuario para crear el objeto.
     */
    public PayPal(String account){

        this.account = account;
        this.balance = 23;

    }

    /**
     * Constructor completo del objeto PayPal, en el cual vamos a pasar ambos de los atributos de la clase.
     * @param account correo que nos ha pasado el usuario para crear el objeto.
     * @param balance Importe total de la cuenta del usuario, pasado por este mismo.
     */
    public PayPal(String account, double balance){

        this.account = account;
        this.balance = balance;

    }

    /**
     * En esta funcion booleana lo que vamos a hacer es comprobar que el formato del correo es correcto o no, usando la constante MAIL_FORMAT.
     * @param account le pasaremos la cuenta que ha ingresado el usuario.
     * @return Dependiendo de si el formato es correcto o no devuelve true o false.
     */
    private boolean checkMailFormat(String account){

        return account.matches(MAIL_FORMAT);

    }

    /**
     * Aqui lo que vamos a hacer distinto de los otros objetos es que si el importe del movimiento que quiere realizar es superior al dinero de la cuenta.
     * Vamos a enviarle un mensaje de que no tiene saldo suficiente.
     * @param totalImport imporete ingresado por el usuario para la operación. Este método es heredado de PayMethod.
     */
    void paymentProcess(double totalImport) {

        System.out.println("Procesando pago de " + totalImport + "€ con PayPal.");
        if (totalImport > getBalance()){

            System.out.println("Saldo insuficiente, pago cancelado.");

        }else {

            System.out.println("Pago aceptado. Muchas gracias.");

        }

    }

    /**
     * En esta funcion booleana que hemos heredado de PayMethod, vamose a comprobar que el correo tiene el formato correcto llamando a la función checkMailFormat().
     * @return si el formato es correcto devolveremos true sino false.
     */
    boolean validatePayMethod() {

        if (checkMailFormat(getAccount())){

            return true;

        }else {

            System.out.println("Formato del PayPal incorrecto.");
            return false;

        }
    }
}
