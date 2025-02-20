package org.example.PagosECommerce;

import lombok.Getter;
import lombok.Setter;

import java.util.InputMismatchException;

@Getter @Setter
public class CreditCard extends PayMethod{

    private final String[] POSSIBLE_TYPE = {"VISA","MASTERCARD"};
    private String type;
    private String cardNumber;

    public CreditCard(String type, String cardNumber){

        this.type = type;
        this.cardNumber = cardNumber;

    }

    private boolean cardFormat(String cardNumber){

        try {

            long temp = Long.parseLong((cardNumber));

        }catch (InputMismatchException error){

            return false;

        }

        return true;

    }

    private boolean checkType(String type){

        for (String i : POSSIBLE_TYPE){

            if (i.equalsIgnoreCase(type)){

                return true;

            }

        }
        return false;
    }

    private boolean checkCardNumber(String cardNumber){

        return cardNumber.length() == 16 && cardFormat(cardNumber);

    }


    void paymentProcess(double totalImport) {

        System.out.println("Procesando pago de " + totalImport + "€ con tarjeta de crédito " + getType());
        System.out.println("Pago aceptado. Muchas gracias.");

    }

    boolean validatePayMethod() {

        if (checkCardNumber(getCardNumber()) && checkType(getType())){

            return true;

        }else {

            System.out.println("Formato de la tarjeta erroneo.");
            return false;
        }

    }

}
