package fr.proj;

import java.util.ArrayList;

public class Batiment {
    private ArrayList<Bavard> bavards = new ArrayList<>();
    private Concierge concierge;

    public Batiment(String nomConcierge) {
        this.concierge = new Concierge(nomConcierge);
    }

    public String createBavard(String nom, String prenom, String dateDeNaissance) {
        boolean res = true;
        int i = 0;
        Bavard newBavard = new Bavard(nom, prenom, dateDeNaissance);
        while (res == true && i < this.bavards.size()) {
            if (newBavard.equals(this.bavards.get(i))) {
                res = false;
            }
            i++;
        }
        if (res) {
            newBavard.addListener(this.concierge);
            bavards.add(newBavard);
            newBavard.souscrire(this.concierge);

            return "Le Bavard à été ajouté";
        } else {
            return "Le Bavard existe déjà";
        }
    }


    public void deleteBavard(Bavard bavard) {
        for (Bavard bavard1: this.bavards) {
            if (bavard.equals(bavard1)) {
                this.bavards.remove(bavard);
            }
        }
    }

    public void connectBavard(Bavard bavard) {
        for (Bavard bavard1: this.bavards) {
            if (bavard.equals(bavard1)) {
                bavard.connect();
            }
        }
    }

    public void addInteret(PapotageListener bavard) {
        boolean res = true;
         for (PapotageListener bavard1: this.concierge.getBavardsListeners()) {
             if (bavard1.equals(bavard)) {
                 res = false;
             }
         }
         if (res) {
             this.concierge.addListener(bavard);
         }
    }

    public void sendMessage(String senderLastName, String senderFirstName, String senderBirthDate, String subject, String content) {
        Bavard sender = new Bavard(senderLastName, senderFirstName, senderBirthDate);
        for (PapotageListener bavard: this.concierge.getBavardsListeners()) {
            if (sender.equals(bavard)) {
                bavard.emitMessage(subject, content);
            }
        }
    }

    public ArrayList<Bavard> getBavards() {
        return bavards;
    }

    public Concierge getConcierge() {
        return concierge;
    }
}
