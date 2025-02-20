package org.example.PagosECommerce;

abstract class PayMethod {

    abstract void paymentProcess(double totalImport);

    abstract boolean validatePayMethod();

}
