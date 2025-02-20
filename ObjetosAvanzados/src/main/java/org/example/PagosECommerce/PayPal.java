package org.example.PagosECommerce;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PayPal extends PayMethod{

    private final String MAIL_FORMAT = "^[^@/!#~+=\\s]+@[^@\\s]+\\.com$";
    private String account;
    private double balance;

    public PayPal(String account){

        this.account = account;
        this.balance = 23;

    }

    public PayPal(String account, double balance){

        this.account = account;
        this.balance = balance;

    }

    private boolean checkMailFormat(String account){

        return account.matches(MAIL_FORMAT);

    }

    void paymentProcess(double totalImport) {

        System.out.println("Procesando pago de " + totalImport + "€ con PayPal.");
        if (totalImport > getBalance()){

            System.out.println("Saldo insuficiente, pago cancelado.");

        }else {

            System.out.println("Pago aceptado. Muchas gracias.");

        }

    }

    boolean validatePayMethod() {

        if (checkMailFormat(getAccount())){

            return true;

        }else {

            System.out.println("Formato del PayPal incorrecto.");
            return false;

        }
    }
}
