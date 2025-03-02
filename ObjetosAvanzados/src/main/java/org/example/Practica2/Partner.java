package org.example.Practica2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Partner extends MutxamelFC {

    private Player member;
    private String relationShip;

    public Partner(String name, int age, Player member, String relationShip) {


        super(name, age);
        this.member = member;
        this.relationShip = relationShip;


    }

    public void focus() {


        System.out.println("El Compañero " + getName() + " se esta concentrando.");


    }

    public void travel(String city) {


        System.out.println("El Compañero " + getName() + " que acompaña al jugador " + member.getName() + ", " + member.getDorsal() + " se va de viaje a " + city);


    }

    public void celebrateGol() {


        System.out.println("El compañero " + getName() + " esta celebrando el gol.");


    }

    public void encourageTeam(){


        System.out.println("El compañero " + getName() + " grita: VAMOOOS EQUIIPOOO " + member.getCategory() + " !");


    }
}
