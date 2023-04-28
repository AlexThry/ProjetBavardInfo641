package fr.proj;

import java.util.EventObject;

public class PapotageEvent extends EventObject {
    private Papotage papotage;

    public PapotageEvent(Object source, String sujet, String corps) {
        /*
        * Un évènement de papotage
        * Params:
        *   source : Object
        *   sujet : String
        *   corps : String
         */
        super(source);
        this.papotage = new Papotage(sujet, corps);
    }

    public String getSujet() {
        return this.papotage.getSujet();
    }

    public String getCorps() {
        return this.papotage.getCorps();
    }

    public Object getSource() {
        return this.source;
    }
}
