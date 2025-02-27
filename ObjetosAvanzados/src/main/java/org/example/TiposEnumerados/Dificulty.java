package org.example.TiposEnumerados;

import lombok.Getter;

@Getter
public enum Dificulty {

    FACIL(2) , MEDIO(4) , DIFICIL(8) , EXPERTO(10);

    private int num;


    Dificulty(int num) {

        this.num = num;

    }
}
