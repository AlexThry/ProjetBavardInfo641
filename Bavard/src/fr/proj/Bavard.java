package fr.proj;

import java.util.ArrayList;

public class Bavard implements PapotageListener {
    private String nom;
    private String prenom;
    private String dateDeNaissance;
    private ArrayList<PapotageListener> concierges = new ArrayList<>();
    private boolean connected = false;


    public Bavard(String nom, String prenom, String dateDeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
    }

    public boolean isConnected() {
        return connected;
    }

    public void connect() {
        this.connected = true;
    }

    public void disconnect() {
        this.connected = false;
    }

    @Override
    public String toString() {
        return "Bavard{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateDeNaissance='" + dateDeNaissance + '\'' +
                ", connected=" + connected +
                '}';
    }

    public void emitMessage(String sujet, String corps) {
        PapotageEvent papotageEvent = new PapotageEvent(this, sujet, corps);
        for (PapotageListener concierge: concierges) {
            concierge.nouveauPapotage(papotageEvent);
        }
    }

    @Override
    public void nouveauPapotage(PapotageEvent papotageEvent) {
        Bavard source = (Bavard) papotageEvent.getSource();
        System.out.println("####################\nNouveau message pour : " + this.prenom + "\n De la part de : " + source.prenom + "\n--------------------");
        System.out.println(papotageEvent.getSujet());
        System.out.println(papotageEvent.getCorps());
        System.out.println("####################");
    }



    public void addListener(Concierge concierge) {
        this.concierges.add(concierge);
    }

    public void souscrire(Concierge concierge) {
        concierge.addListener(this);
    }
}
