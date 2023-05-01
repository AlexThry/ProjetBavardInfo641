package fr.proj;

public class Tests {
    public static void main(String[] args) {
//        Bavard alex = new Bavard("Thierry", "Alexis", "18/03/2002");
//        Bavard carlyne = new Bavard("Barrachin", "Carlyne", "18/03/2002");
//        Bavard fred = new Bavard("hb", "Fred", "189830");
//        Concierge manuel = new Concierge("Manuel");
//        manuel.addListener(carlyne);
//        manuel.addListener(fred);
//        manuel.addListener(alex);
//        fred.addListener(manuel);
//        alex.addListener(manuel);
//        alex.connect();
//        carlyne.connect();
//        alex.emitMessage("Hello", "Je suis alex");
//        fred.emitMessage("Je me presente", "Fred");

        Batiment bat = new Batiment("Manuel");
        bat.createBavard("Thierry", "Alexis", "18/03/2002");
        bat.createBavard("Barrachin", "Carlyne", "19/02/2002");
        bat.connectBavard(bat.getBavards().get(0));
        bat.connectBavard(bat.getBavards().get(1));
        bat.addInteret(bat.getBavards().get(0));
        bat.addInteret(bat.getBavards().get(1));
        bat.sendMessage("Thierry", "Alexis", "18/03/2002", "Td de Maths", "Salut Carlyne, aurais-tu l'obligence de m'envoyer le td de maths STP ? n");
    }

}
