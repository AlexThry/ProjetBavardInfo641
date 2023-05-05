package fr.proj;

import java.util.EventListener;

public interface PapotageListener {
    public void nouveauPapotage(PapotageEvent papotageEvent);

    public void emitMessage(String sujet, String corps, String theme);

    public boolean isConnected();

}
