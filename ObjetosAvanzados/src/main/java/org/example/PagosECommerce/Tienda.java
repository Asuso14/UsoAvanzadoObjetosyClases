package org.example.PagosECommerce;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Tienda {

    static Scanner entry = new Scanner(System.in);

    static void processPayment( PayMethod payMethod){

        System.out.println("Introduce el importe a pagar");
        int totalImport = entry.nextInt();
        payMethod.paymentProcess(totalImport);

    }


    public static PayMethod  UserChoose( String choose){

        switch (choose){

            case "Bizum" :

                System.out.println("Introduce tus datos Bizum:");
                System.out.println("Numero de telefono:");
                String phoneNumber = entry.next();
                return new Bizum(phoneNumber);

            case "PayPal" :

                System.out.println("Introduce tus datos PayPal:");
                System.out.println("Introduce tu correo:");
                String mail = entry.next();
                System.out.println("Tienes cargo en la cuenta?");
                System.out.println("1. Si");
                System.out.println("2. No");
                try {

                    return PayPalMaker(entry.nextInt(),mail);

                }catch (InputMismatchException error){

                    System.out.println("Formato incorrecto.");
                    return null;

                }

            case "Tarjeta" :

                System.out.println("Introduce tus datos de tarjeta:");
                System.out.println("Numero (16 digitos):");
                String cardNum = entry.next();
                System.out.println("Tipo (VISA o MASTERCARD): ");
                String type = entry.next();
                return new CreditCard(type,cardNum);

            default:

                System.out.println("Metodo de pago no aceptado.");
                return null;
        }

    }

    public static boolean validatePayMethod(PayMethod payMethod){

        return payMethod.validatePayMethod();

    }

    public static PayMethod PayPalMaker(int choose, String mail){

        return switch (choose) {
            case 1 -> {

                System.out.println("Introduce saldo de la cuenta");
                yield new PayPal(mail, entry.nextInt());
            }
            case 2 -> new PayPal(mail);
            default -> null;
        };

    }

    public static void startPayment(){

        System.out.println("Que metodo de pago quieres usar? [Bizum,PayPal,Tarjeta]: ");
        String choose = entry.next();
        PayMethod payMethod = UserChoose(choose);
        System.out.println("Validando " +  choose + "...");

        if((payMethod != null && validatePayMethod(payMethod))){

            processPayment(payMethod);

        }

    }

}
