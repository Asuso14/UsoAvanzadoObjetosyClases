package org.example.PagosECommerce;

public class Tienda {

    static void makePayment( PayMethod payMethod , double totalImport){

        payMethod.paymentProcess(totalImport);

    }

    public void startPayment(){

        

    }

}
