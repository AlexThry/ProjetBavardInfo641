package fr.proj;

import fr.proj.event.OnLineBavardEvent;
import fr.proj.interfaces.IsOnLineListener;
import fr.proj.interfaces.PapotageListener;

import java.util.ArrayList;

public class Batiment {
    private ArrayList<Bavard> bavards = new ArrayList<>();
    private Concierge concierge;
    private ArrayList<IsOnLineListener> bavardsConnectés = new ArrayList<>();

    public Batiment(String nomConcierge) {
        this.concierge = new Concierge(nomConcierge);
    }

    public String createBavard(String nom, String prenom, String dateDeNaissance,ArrayList<String> themesBavard) {
        boolean res = true;
        int i = 0;
        Bavard newBavard = new Bavard(nom, prenom, dateDeNaissance,themesBavard);
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




    public void connectBavard(Bavard bavard, Boolean value) {
        for (Bavard bavard1: this.bavards) {
            if (bavard.equals(bavard1)) {
                bavard.setConnected(value);
                OnLineBavardEvent onLineBavardEvent = new OnLineBavardEvent(bavard, value);
                for (Bavard bavard2: this.bavards) {
                    bavard2.isOnlineAlert(onLineBavardEvent, value);
                }
                this.bavardsConnectés = bavard.getBavardsOnLine();
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

    public void sendMessage(Bavard sender, String subject, String content, String theme) {
        for (PapotageListener bavard: this.concierge.getBavardsListeners()) {
            if (sender.equals(bavard)) {
                bavard.emitMessage(subject, content, theme);
            }
        }
    }

    public ArrayList<Bavard> getBavards() {
        return bavards;
    }

    public Concierge getConcierge() {
        return concierge;
    }

    public ArrayList<IsOnLineListener> getBavardsConnectés() {
        return bavardsConnectés;
    }
    public void setBavardsConnectés(ArrayList<IsOnLineListener> bavardsConnectés) {
        this.bavardsConnectés = bavardsConnectés;
    }
}
