package org.example.Practica2;

public class AppMutxamelFC {

    public static void main(String[] args) {

        Player player1 = new Player("Nacho",21, Teams.SENIOR, Positions.DELANTERO, 8);//Definimos los jugadores.
        Player player2 = new Player("Jose",25, Teams.SENIOR, Positions.DELANTERO, 2);
        Player player3 = new Player("Sergio",18, Teams.SENIOR, Positions.DELANTERO, 10);
        Player player4 = new Player("Pedro",20, Teams.SENIOR, Positions.DELANTERO, 18);

        Trainer trainer = new Trainer("Xokas",30, Teams.SENIOR, "1-1-2");//Vamos a definir un entrenador con una formacion correcta.

        Masseur masseur = new Masseur("Raúl",18, "Experto de masajes",18);//Aqui vamos a definir distintos masajistas.
        Masseur masseur2 = new Masseur("Josebas",22, "Avanzado",3);
        Masseur masseur3 = new Masseur("Manolo",40, "Avanzado",6);

        Partner partner = new Partner("Adrian", 10, player2, "Hermano menor");//Aqui vamos a definir los compañeros de los jugadores.
        Partner partner2 = new Partner("Albert", 40, player2, "Padre");
        Partner partner3 = new Partner("Rober", 23, player1, "Amigo");

        player3.focus();//jugador 3 se concentran.
        player4.train();//jugador 4 se pone a entrenar.
        masseur.giveMassage(player1);//El primer masajita le da un masaje a jugador 1
        trainer.travel("Madrid");//Se van a madrid.
        trainer.trainingPlan();//El entrenador planea el entrenamiento.
        player2.train();//El jugador 2 entrena
        player2.rest();//Despue de entrenar va a descansar
        player2.warmUp();//Y una vez descanse va a calentar
        player1.playMatch(player3.getName());//El jugador 1 juega contra el jugador 3
        partner2.encourageTeam();//El comapañero 2 anima al equipo.
        trainer.makeChanges(player4,player1);//El entrenador hara un cambio del jugador 4 al 1
        player1.scoreGol();//jugador 1 marca gol, buen cambio
        partner3.celebrateGol();//Su amigo celebra el gol
        masseur2.giveMassage(player1);//Le dan un masaje a jugador 1, esta hecho por masajista 2
        masseur3.giveMassage(player3);//Le dan un masaje a jugador 3, esta hecho por masajista 3
        masseur3.giveMassage(player2);//Le dan un masaje a jugador 2, esta hecho por masajista 3
        trainer.travel("Mutxamel");//Se vuelven para Mutxamel
        player1.rest();//Descansa el jugador 1. 

    }

}
