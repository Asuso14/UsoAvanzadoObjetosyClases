package org.example.PagosECommerce;

import java.util.Objects;
import java.util.Scanner;

public class Tienda {

    static Scanner entry = new Scanner(System.in);

    static void processPayment( PayMethod payMethod , double totalImport){

        if(){

            System.out.println("Validando metodo de pago...");
            payMethod.paymentProcess(totalImport);

        }
    }


    public static PayMethod  UserChoose( String choose){

        switch (choose){

            case "Bizum" :

                System.out.println("Introduce tu numero de telefono:");
                String phoneNumber = entry.next();
                return new Bizum(phoneNumber);

            case "PayPal" :
                System.out.println("Introduce tu correo de PayPal");
                String mail = entry.next();
                System.out.println("Tienes cargo en la cuenta?");
                System.out.println("1. Si");
                System.out.println("2. No");
                return PayPalMaker(entry.nextInt(),mail);

            case "Tarjeta" :

                break;

            default:

                System.out.println("Metodo de pago no aceptado.");
                return null;
                break;
        }

    }

    public static boolean validatePayMethod(){



    }

    public static PayMethod PayPalMaker(int choose, String mail){

        switch (choose){

            case 1 :

                System.out.println("Introduce saldo de la cuenta");
                return new PayPal(mail,entry.nextInt());

            case 2:

                return new PayPal(mail);

            default:

                return null;
        }

    }

    public void startPayment(){

        System.out.println("Que metodo de pago quieres usar? [Bizum,Paypal,Tarjeta]: ");
        PayMethod payMethod = UserChoose(entry.next());

        if(){



        }


    }

}
