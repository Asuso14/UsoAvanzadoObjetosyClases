package org.example.Practica2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class MutxamelFC implements IntegratesFunctions{

    private String name;
    private int age;

    public MutxamelFC(String name, int age){

        this.name = name;
        this.age = age;

    }

}