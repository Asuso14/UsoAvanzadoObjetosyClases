package org.example.PagosECommerce;

import lombok.Getter;
import lombok.Setter;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

@Getter @Setter
public class Bizum extends PayMethod{

    static Scanner entry = new Scanner(System.in);
    static Random random = new Random();
    private String phoneNumber;
    private int code;
    private Exception InputMismatchException;

    public Bizum(String phoneNumber){
        this.phoneNumber = phoneNumber;
        this.code = random.nextInt(900000 ) + 100000;
    }

    public boolean validateBizum(String phoneNumber){
        boolean status = true;
        try {

            if (phoneNumber.length() != 9){

                throw new InputMismatchException();

            }
            int temp = Integer.parseInt(phoneNumber);

        }catch (InputMismatchException error){

            System.out.println("No has introducido el formato de número correcto...");
            return false;

        }
        return getUserCode(status);
    }

    private boolean getUserCode(boolean status){

        System.out.println(getCode());
        System.out.println("Introduce el código, para aceptar el pago:");
        return getCode() == entry.nextInt();

    }

    @Override
    void paymentProcess(double totalImport) {
        System.out.println("Procesando pago de importe " + totalImport + "€ con Bizum");
    }
}

