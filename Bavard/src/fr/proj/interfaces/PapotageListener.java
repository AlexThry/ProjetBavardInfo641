package fr.proj.interfaces;

import fr.proj.event.PapotageEvent;

public interface PapotageListener {
    public void nouveauPapotage(PapotageEvent papotageEvent);

    public void emitMessage(String sujet, String corps, String theme);

    public boolean isConnected();

}
