package fr.proj.event;

import java.awt.event.ActionEvent;
import java.util.EventObject;

public class OnLineBavardEvent extends EventObject {
    /*
    * Evenement utilisé pour annoncer si un bavard se connecte ou se déconnecte
     */

    private boolean connected;

    public OnLineBavardEvent(Object source, boolean connected) {
        /*
        * Permet à un bavard de prévenir s'il se connecte (connected = true) ou si il se déconnecte (connected = false)
         */
        super(source);
        this.connected = connected;
    }

}
