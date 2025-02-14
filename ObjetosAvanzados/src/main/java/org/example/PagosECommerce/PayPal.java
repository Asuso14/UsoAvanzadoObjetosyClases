package org.example.PagosECommerce;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PayPal extends PayMethod{

    private final String MAIL_FORMAT = "^[^@\\s]+@[^@\\s]+\\.com$";
    private String account;
    private double balance;

    public PayPal(String account){
        assignMail(account);
        this.balance = 23;
    }

    public PayPal(String account, double balance){

        this.balance = balance;
    }

    public void assignMail(String account){
        if (checkMailFormat(account)){
            this.account = account;
        }else {
            System.out.println("Formato del correo incorrecto...");
            this.account = null;
        }
    }

    public boolean checkMailFormat(String account){
        return account.matches(MAIL_FORMAT);
    }
    @Override
    void paymentProcess(double totalImport) {
        System.out.println("Procesando pago de " + totalImport + "€ con PayPal.");
    }
}
