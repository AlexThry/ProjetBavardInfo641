package fr.proj;

public class Papotage {
    private String sujet;
    private String corps;
    private String theme;

    public Papotage(String sujet, String corps, String theme) {
        /*
        * Création d'un ragot
        * Param:
        *   sujet : String
        *   corps : String
         */
        this.sujet = sujet;
        this.corps = corps;
        this.theme = theme;
    }

    public String getSujet() {
        return this.sujet;
    }

    public String getCorps() {
        return this.corps;
    }

    public String getTheme() {
        return theme;
    }
}
