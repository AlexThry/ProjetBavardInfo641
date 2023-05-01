package fr.proj;

import java.util.ArrayList;

public class Batiment {
    private String nom;
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
        }
        if (res) {
            bavards.add(new Bavard(nom, prenom, dateDeNaissance));
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
}
