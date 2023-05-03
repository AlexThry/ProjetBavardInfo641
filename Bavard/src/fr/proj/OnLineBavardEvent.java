package fr.proj;

import java.awt.event.ActionEvent;
import java.util.EventObject;

public class OnLineBavardEvent extends EventObject {

    private boolean connected;

    public OnLineBavardEvent(Object source, boolean connected) {
        super(source);
        this.connected = connected;
    }

}
