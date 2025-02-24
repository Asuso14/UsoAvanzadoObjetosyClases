package org.example.pruebaEnums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum SagasPelis {

    HARRYPOTTER(8),CREPUSCULO(4),SHREK(6),SPIDERMAN(7);

    private int numPelis;

    SagasPelis(int numPelis){
        this.numPelis = numPelis;
    }
}
