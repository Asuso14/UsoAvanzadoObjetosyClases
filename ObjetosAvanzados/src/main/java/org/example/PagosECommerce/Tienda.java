package org.example.PagosECommerce;

import java.util.Scanner;

public class Tienda {

    static Scanner entry = new Scanner(System.in);

    static void processPayment( PayMethod payMethod , double totalImport){

        payMethod.paymentProcess(totalImport);

    }


    private boolean UserChoose( String choose){

        switch (choose){

            case "Bizum" :
                
                break;

            case "PayPal" :

                break;

            case "Tarjeta" :

                break;

            default:

                System.out.println("Metodo de pago no aceptado.");
                return false;
                break;
        }

    }


    public void startPayment(){

        System.out.println("Que metodo de pago quieres usar? [Bizum,Paypal,Tarjeta]: ");


    }

}
