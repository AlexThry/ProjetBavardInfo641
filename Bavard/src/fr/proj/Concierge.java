package fr.proj;

import java.util.ArrayList;

public class Concierge implements PapotageListener {
    private String name;
    private ArrayList<PapotageListener> bavardsListeners = new ArrayList<>();

    public Concierge(String name) {
        this.name = name;
    }

    public void addListener(PapotageListener bavard) {
        this.bavardsListeners.add(bavard);
    }

    @Override
    public void nouveauPapotage(PapotageEvent papotageEvent) {
        for(PapotageListener bavard: this.bavardsListeners) {
            if (papotageEvent.getSource() != bavard && bavard.isConnected()) {
            bavard.nouveauPapotage(papotageEvent);
            }
        }
    }

    public void emitMessage(String sujet, String corps) {
        PapotageEvent papotageEvent = new PapotageEvent(this, sujet, corps);
        nouveauPapotage(papotageEvent);
    }

    @Override
    public boolean isConnected() {
        return true;
    }
}