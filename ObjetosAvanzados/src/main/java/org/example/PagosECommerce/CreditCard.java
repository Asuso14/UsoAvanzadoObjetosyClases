package org.example.PagosECommerce;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreditCard extends PayMethod{

    private final String[] POSSIBLE_TYPE = {"VISA","MASTERCARD"};
    private String type;
    private String cardNumber;

    public CreditCard(String type, String cardNumber){

        assignType(type);
        assignCardNum(cardNumber);

    }

    private void assignCardNum(String cardNumber){

        if (checkCardNumber(cardNumber)){

            this.cardNumber = cardNumber;

        }else {

            System.out.println("El formato del número de la tarjeta no es válido...");
            this.cardNumber = null;

        }

    }

    private void assignType(String type){

        boolean status = true;

        for (String i : POSSIBLE_TYPE){

            if (i.equalsIgnoreCase(type)){

                this.type = type;
                status = false;
                break;

            }

        }

        if (!status){

            System.out.println("Tipo de Tarjeta no válido...");
            this.type = null;

        }
    }

    public boolean checkCardNumber(String cardNumber){

        return cardNumber.length() == 16;

    }


    void paymentProcess(double totalImport) {

        System.out.println("Procesando pago de " + totalImport + "€ con tarjeta de crédito " + getType());

    }

}
