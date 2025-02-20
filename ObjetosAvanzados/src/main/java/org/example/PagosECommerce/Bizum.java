package org.example.PagosECommerce;

import lombok.Getter;
import lombok.Setter;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

@Getter @Setter
public class Bizum extends PayMethod{

    private Exception InputMismatchException;
    static Scanner entry = new Scanner(System.in);
    static Random random = new Random();
    private String phoneNumber;
    private int code;

    public Bizum(String phoneNumber){

        this.phoneNumber = phoneNumber;
        this.code = random.nextInt(900000 ) + 100000;

    }

    private boolean validateBizum(String phoneNumber){

        boolean status = true;

        try {

            if (phoneNumber.length() != 9){

                throw new InputMismatchException();

            }

            int temp = Integer.parseInt(phoneNumber);

        }catch (InputMismatchException error){

            return false;

        }
        return getUserCode(status);
    }

    private boolean getUserCode(boolean status){

        System.out.println(getCode());
        System.out.println("Introduce el código, para aceptar el pago:");
        return getCode() == entry.nextInt();

    }

    void paymentProcess(double totalImport) {

        System.out.println("Procesando pago de importe " + totalImport + "€ con Bizum");
        System.out.println("Pago aceptado. Muchas gracias.");

    }

    boolean validatePayMethod() {

        if (validateBizum(getPhoneNumber())){

            return true;

        }else{

            System.out.println("Formato de Bizum incorrecto");
            return false;

        }

    }

}

