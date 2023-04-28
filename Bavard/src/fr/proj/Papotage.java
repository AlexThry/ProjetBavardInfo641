package fr.proj;

public class Papotage {
    private String sujet;
    private String corps;

    public Papotage(String sujet, String corps) {
        /*
        * Création d'un ragot
        * Param:
        *   sujet : String
        *   corps : String
         */
        this.sujet = sujet;
        this.corps = corps;
    }

    public String getSujet() {
        return this.sujet;
    }

    public String getCorps() {
        return this.corps;
    }


}
