package fr.proj;

import java.util.ArrayList;

public class Batiment {
    private String nom;
    private ArrayList<Bavard> bavards = new ArrayList<>();
    private Concierge concierge;

    public Batiment(String nomConcierge) {
        this.concierge = new Concierge(nomConcierge);
    }

    public void createBavard(String nom, String prenom, String dateDeNaissance) {
        bavards.add(new Bavard(nom, prenom, dateDeNaissance));
    }


    public void deleteBavard(Bavard bavard) {
        for (Bavard bavard1: this.bavards) {
            if (bavard.toString() == bavard1.toString()){
                this.bavards.remove(bavard);
            }
        }
    }

    public void connectBavard(Bavard bavard) {
        for (Bavard bavard1: this.bavards) {
            if (bavard.toString() == bavard1.toString())
        }
    }
}
