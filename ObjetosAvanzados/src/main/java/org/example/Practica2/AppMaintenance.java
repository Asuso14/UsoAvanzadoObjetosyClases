package org.example.Practica2;

import java.util.Scanner;

public class AppMaintenance {

    static Scanner entry = new Scanner(System.in);


    public static void main(String[] args) {

        Player player1 = new Player("Nacho", 21, Teams.SENIOR, Positions.DELANTERO, 8);
        Player player2 = new Player("Jose", 25, Teams.SENIOR, Positions.DELANTERO, 2);
        Player player3 = new Player("Sergio", 18, Teams.SENIOR, Positions.DELANTERO, 10);
        Player player4 = new Player("Pedro", 20, Teams.SENIOR, Positions.DELANTERO, 18);

        selectMenu(generalMenu());

    }


    public static String generalMenu() {

        System.out.println("=== App de mantenimiento del MUTXAMEL FC ===");
        System.out.println("\n");
        System.out.println("[1]. Mantenimiento de jugadores");
        System.out.println("[2]. Mantenimiento de entrenadores TODO");
        System.out.println("[3]. Mantenimiento masajistas TODO");
        System.out.println("[4]. Consultar equipos TODO");
        System.out.println("[X]. Salir");
        System.out.println("\n");
        System.out.println("================================================================");
        System.out.println("\n");
        System.out.println("Selecciona una opcion -->");
        return entry.next();
    }

    public static void selectMenu(String option) throws InvalidElecctionException {
        switch (option) {

            case "0":
                generalMenu();

            case "1":
                playersMenuOption(playersMenu());
                break;

            case "2":
                System.out.println("Todavia no esta desarrollado...");
                generalMenu();
                break;

            case "3":
                System.out.println("Todavia no esta desarrollado...");
                break;

            case "4":
                System.out.println("Todavia no esta desarrollado...");
                break;

            case "X", "x":
                System.exit(0);

            default:
                throw new InvalidElecctionException();

        }
    }

    public static String playersMenu() {
        System.out.println("=== Mantenimiento de Jugadores ===");
        System.out.println("\n");
        System.out.println("[1]. Añadir nuevo jugador");
        System.out.println("[2]. Modificar datos de jugar existente");
        System.out.println("[3]. Mostrar jugadores");
        System.out.println("[X]. Volver al menu principal");
        System.out.println("\n");
        System.out.println("================================================================");
        System.out.println("\n");
        System.out.println("Selecciona una opcion -->");
        return entry.next();
    }

    public static void playersMenuOption(String option) {

        switch (option) {

            case "1":

                addNewPlayer();
                playersMenuOption(playersMenu());
                break;

            case "2":

                modifyPlayer();
                playersMenuOption(playersMenu());
                break;

            case "3":

                showPlayers();
                playersMenuOption(playersMenu());
                break;

            case "X", "x":

                selectMenu(generalMenu());

            default:
                throw new InvalidElecctionException();

        }
    }

    public static void addNewPlayer() {

        System.out.println("=== Mantenimiento de Jugadores. Añadir nuevo jugador. ===");
        System.out.println("\n");
        System.out.print("Introduce el nombre del jugador: ");
        String name = entry.next();
        System.out.print("Introduce la edad del jugador: ");
        int age = checkNumericFormat(entry.next());
        System.out.print("Introduce el dorsal: ");
        int dorsal = checkNumericFormat(entry.next());
        System.out.print("Introduce la posición (PORTERO, DEFENSA, CENTROCAMPISTA, DELANTERO): ");
        Positions position = Positions.valueOf(entry.next().toUpperCase());
        System.out.print("Introduce la categoría (BENJAMIN, ALEVIN, INFANTIL, CADETE, JUVENIL, SENIOR): ");
        Teams category = Teams.valueOf(entry.next().toUpperCase());

        new Player(name, age, category, position, dorsal);
        System.out.println("Jugador añadido correctamente.");

    }

    public static void modifyPlayer() {

        int pos = -1;
        System.out.println("=== Mantenimiento de Jugadores. Modificar datos de jugador existente. ===");
        System.out.println("\n");
        System.out.println("De que jugador quieres hacer cambios?");
        System.out.println("\n");
        showPlayersList();
        System.out.println("========================================");
        System.out.println("\n");
        System.out.println("Selecciona una opcion --> ");
        System.out.println("\n");
        pos = checkNumericFormat(entry.next());

        System.out.println("\n");
        System.out.println("=== Mantenimiento de Jugadores. Modificar datos de jugador existente. ===");
        System.out.println("\n");
        System.out.println("Modificando jugador: " + specificPlayer(pos).toString());
        System.out.println("Que quieres modificar? [nombre,edad,categoria,dorsal,posicion]?");
        System.out.println("\n");
        System.out.println("========================================");
        System.out.println("\n");
        System.out.println("Selecciona una opcion --> ");
        modifyOption(entry.next(), specificPlayer(pos));

    }

    public static void showPlayers() {

        System.out.println("=== Mantenimiento de Jugadores. Mostrar jugadores existentes. ===");
        System.out.println("\n");
        if (Player.playerList.isEmpty()) {

            System.out.println("No hay jugadores registrados.");

        } else {

            System.out.println("=== Lista de Jugadores ===");
            showPlayersList();

        }

    }

    public static void showPlayersList() {

        for (int i = 0; i < Player.playerList.size(); i++) {

            System.out.println("[" + i +
                    ", Nombre: " +
                    Player.playerList.get(i).getName() +
                    ", Edad: " + Player.playerList.get(i).getAge() +
                    ", Equipo: " + Player.playerList.get(i).getCategory() +
                    ", Dorsal: " + Player.playerList.get(i).getDorsal() +
                    ", Posicion: " + Player.playerList.get(i).getPositions() + "]");

        }

    }

    public static Player specificPlayer(int index) {

        try {

            return Player.playerList.get(index);

        }catch (IndexOutOfBoundsException error){

            System.out.println("Error: " + error.getMessage());
            System.exit(1);

        }
        return null;
    }

    public static void modifyOption(String choose, Player player) {
        System.out.println("=== Mantenimiento de Jugadores. Mostrar jugadores existentes. ===");
        System.out.println("\n");
        System.out.println("Modificando jugador: " + player.toString());
        System.out.println("\n");
        System.out.println("========================================");
        System.out.println("\n");

        choose = choose.toLowerCase();
        switch (choose) {
            case "nombre":
                System.out.print("Nuevo nombre --> ");
                player.setName(entry.next());
                break;

            case "edad":
                System.out.print("Nueva edad --> ");
                player.setAge(checkNumericFormat(entry.next()));
                break;
            case "posicion":
                System.out.print("Nueva posición (PORTERO, DEFENSA, CENTROCAMPISTA, DELANTERO) --> ");
                player.setPositions(Positions.valueOf(entry.next().toUpperCase()));
                break;
            case "categoria":
                System.out.print("Nueva categoría (BENJAMIN, ALEVIN, INFANTIL, CADETE, JUVENIL, SENIOR) --> ");
                player.setCategory(Teams.valueOf(entry.next().toUpperCase()));
                break;
            case "dorsal":
                System.out.println("Nuevo dorsal --> ");
                player.setDorsal(checkNumericFormat(entry.next()));
            default:
                System.out.println("Opción no válida.");
                System.exit(1);
        }
        System.out.println(choose + ", modificado con exito.");

    }

    public static int checkNumericFormat(String checkData) {

        try {

            return Integer.parseInt(checkData);


        } catch (NumberFormatException error) {

            System.out.println("Error: " + error.getMessage());
            System.exit(1);

        }
        return 0;
    }

}
