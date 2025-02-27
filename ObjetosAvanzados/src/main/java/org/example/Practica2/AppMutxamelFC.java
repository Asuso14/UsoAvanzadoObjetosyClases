package org.example.Practica2;

public class AppMutxamelFC {

    public static void main(String[] args) {

        Player player1 = new Player("Nacho",21, Teams.SENIOR, Positions.DELATERO, 8);
        Player player2 = new Player("Jose",25, Teams.SENIOR, Positions.DELATERO, 2);
        Player player3 = new Player("Sergio",18, Teams.SENIOR, Positions.DELATERO, 10);
        Player player4 = new Player("Pedro",20, Teams.SENIOR, Positions.DELATERO, 18);

        Trainer trainer = new Trainer("Xokas",30, Teams.SENIOR, "1-1-2");

        Masseur masseur = new Masseur("Raúl",18, "Experto de masaje de huevos",18);
        Masseur masseur2 = new Masseur("Josebas",22, "Avanzado",3);
        Masseur masseur3 = new Masseur("Manolo",40, "Avanzado",6);

        Partner partner = new Partner("Adrian", 10, player2, "Hermano menor");
        Partner partner2 = new Partner("Albert", 40, player2, "Padre");
        Partner partner3 = new Partner("Rober", 23, player1, "Amigo");

        player3.focus();
        player4.train();
        masseur.giveMassage(player1);
        trainer.travel("Madrid");
        trainer.trainingPlan();
        player2.train();
        player2.rest();
        player2.warmUp();
        player1.playMatch(player3.getName());
        partner2.encourageTeam();
        trainer.makeChanges(player4,player1);
        player1.scoreGol();
        partner3.celebrateGol();
        masseur2.giveMassage(player1);
        masseur3.giveMassage(player3);
        masseur3.giveMassage(player2);
        trainer.travel("Mutxamel");
        player1.rest();

    }

}
