package org.example.PagosECommerce;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Nacho Gamallo
 * @version 1.0
 * Esta clase se ocupara de generar los objetos Paymethod, y llamara a ambos metodos referentes de PayMethod. Por decirlo de una
 * forma mas simplificada, esta clase interactua como intermediario entre el main y los objetos extendidos de PayMethod,
 * validara y enviara los datos al usuario.
 *
 */
public class Tienda {

    static Scanner entry = new Scanner(System.in);

    /**
     * Este método se encarga de enviar al metodo el importe de la operacion realizada a paymentProcess()
     * @param payMethod objeto al cual debe enviarle el importe, ya que cada uno de las extensiones de PayMethod interactuan de una
     *                  forma distinta.
     */
    static void processPayment( PayMethod payMethod){

        System.out.println("Introduce el importe a pagar");
        int totalImport = entry.nextInt();
        payMethod.paymentProcess(totalImport);

    }

    /**
     * Funcion la cual , diferencia entre la eleccion del usuario (tipo de metodo de pago que quiere usar) y genera el
     * objeto que se espera. Por ende en cada tipo de objeto solicita los parametros necesarios para estos mismos. Y por ultimo devuelve
     * el objeto que hemos generado.
     * @param choose Eleccion previa que el usuario a escrito en el método startPayment()
     * @return Nos devuelve el objeto tipo PayMethod que haya elegido el usuario (bizum, paypal o tarjeta).
     *
     * pd: Se prodria haber hecho métodos individuales con el contenido de los case, para factorizar mejor el código.
     */
    public static PayMethod  UserChoose( String choose){

        switch (choose){

            case "Bizum" :

                System.out.println("Introduce tus datos Bizum:");
                System.out.println("Numero de telefono:");
                String phoneNumber = entry.next();
                try {

                    return new Bizum(phoneNumber);

                }catch (InputMismatchException error){

                    System.out.println("Formato incorrecto.");
                    return null;
                }

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

    /**
     * Esta funcion buleana lo que va a hacer es validar que todos los parametros que se han dado son correctos,
     * llamando a la funcion predefinida en PayMethod.
     * @param payMethod Le vamos a dar el objeto que queremos validar.
     * @return Como he dicho, llamamos al metodo interno del objeto para validar sus datos y nos
     * devuelve un booleano dependiendo si es correcto o no.
     */
    public static boolean validatePayMethod(PayMethod payMethod){

        return payMethod.validatePayMethod();

    }

    /**
     * Este método esta orientado a uno de los tipos de objetos PayMethod,
     * ya que al tener 2 constructores el usuario indica si quiere o no ingresar
     * saldo en su cuenta PayPal en la funcion UserChoose(), y dependiendo lo que el usuario haya indicado, vamos a
     * llamar a uno de los dos constructores.
     * @param choose Este parametro hace referencia a la eleccion que haya hecho el usuario (constructor que quiere usar).
     * @param mail Este es uno de los atributos del objeto el cual si o si tiene que estar (no tiene valor default).
     * @return En el return hago un switch , con las opciones que tiene el usuario, el 1 llama al constructor con todos los
     * atributos el cual le solicita al usuario el importe de la cuenta, y genera el objeto. El 2 es solo con el correo, con saldo default.
     * Por ultimo si pone algo que no sea ninguna de estas dos opciones, va a devolver un null.
     */
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

    /**
     * Método que solicita al usuario que ingrese el tipo de MetododePago que quiere usar, una vez lo indique se lo envia a
     * UserChoose() que es nuestra funcion que construye los objetos, despues llama a la funcion que válida los datos que se han ingresado.
     * Si los datos no son nulos o se han  enviado correctamente. Realiza la operacion.
     */
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