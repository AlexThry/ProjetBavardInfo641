package fr.proj;

import fr.proj.event.OnLineBavardEvent;
import fr.proj.event.PapotageEvent;
import fr.proj.interfaces.IsOnLineListener;
import fr.proj.interfaces.PapotageListener;

import java.util.ArrayList;

public class Bavard implements PapotageListener, IsOnLineListener {
    private String nom;
    private String prenom;
    private String dateDeNaissance;
    private ArrayList<PapotageListener> concierges = new ArrayList<>();
    private ArrayList<Message> messagesList = new ArrayList<>();
    private boolean connected = false;
    private ArrayList<IsOnLineListener> bavardsOnLine = new ArrayList<>();
    private ArrayList<String> themesChoisis = new ArrayList<>();

    public Bavard(String nom, String prenom, String dateDeNaissance, ArrayList<String> themesChoisis) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.themesChoisis = themesChoisis;
    }

    public boolean isConnected() {
        return connected;
    }

    @Override
    public String toString() {
        return "Bavard{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateDeNaissance='" + dateDeNaissance + '\'' +
                ", concierges=" + concierges +
                ", messagesList=" + messagesList +
                ", connected=" + connected +
                ", themes=" + themesChoisis +
                '}';
    }

    @Override
    public void nouveauPapotage(PapotageEvent papotageEvent) {
        /*
         * Permet à un bavard de recevoir un message de la part d'un concierge
         */

        Bavard source = (Bavard) papotageEvent.getSource();
        Message message = new Message(source.prenom, papotageEvent.getSujet(), papotageEvent.getCorps(),papotageEvent.getTheme());
        if (this.themesChoisis.contains(message.getTheme())) {
            this.messagesList.add(message);
        }
    }

    @Override
    public boolean equals(Object o) {
        Bavard bavard = (Bavard) o;
        if (this.nom == bavard.nom && this.prenom == bavard.prenom && this.dateDeNaissance == bavard.dateDeNaissance) {
            return true;
        } else {
            return false;
        }
    }

    public void emitMessage(String sujet, String corps,String theme) {
        /*
        * Permet à un bavard d'envoyer un message qui sera reçu par un concierge
         */
        PapotageEvent papotageEvent = new PapotageEvent(this, sujet, corps, theme);
        for (PapotageListener concierge: concierges) {
            concierge.nouveauPapotage(papotageEvent);
        }
        this.messagesList.add(new Message(this.prenom, sujet, corps,theme));
    }
    @Override
    public void isOnlineAlert(OnLineBavardEvent onLineBavardEvent, Boolean connected) {
        if (connected) {
            this.bavardsOnLine.add((IsOnLineListener) onLineBavardEvent.getSource());
        } else {
            IsOnLineListener res = null;
            for (IsOnLineListener isOnLineListener: this.bavardsOnLine) {
                if (isOnLineListener.equals(onLineBavardEvent.getSource())) {
                    res = isOnLineListener;
                }
            }
            if (res != null) {
                this.bavardsOnLine.remove(res);
            }
        }
    }

    public void addListener(PapotageListener concierge) {
        /*
        * Permet d'ajouter un concierge dans la liste des listeners
         */
        this.concierges.add(concierge);
    }

    public void souscrire(Concierge concierge) {
        /*
        * Permet de s'ajouter dans la liste des listeners d'un concierge
         */
        concierge.addListener(this);
    }

    public String getPrenom() {
        return prenom;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
        if (connected == true) {

        }
    }
    public boolean getConnected() {
        return connected;
    }

    public ArrayList<Message> getMessagesList() {
        return messagesList;
    }

    public String getNom() {
        return nom;
    }


    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public ArrayList<IsOnLineListener> getBavardsOnLine() {
        return bavardsOnLine;
    }

}
