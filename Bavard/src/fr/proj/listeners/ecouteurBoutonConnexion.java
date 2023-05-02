package fr.proj.listeners;
import fr.proj.Bavard;
import fr.proj.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class ecouteurBoutonConnexion implements ActionListener {
    private JComboBox choixBavardCombo;
    private Fenetre fenetre;
    private JButton connexionBavard;
    public ecouteurBoutonConnexion(JComboBox choixBavardCombo, Fenetre fenetre, JButton connexionBavard) {
        this.choixBavardCombo=choixBavardCombo;
        this.fenetre= fenetre;
        this.connexionBavard = connexionBavard;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Récupérer les valeurs des champs nom, prénom et date de naissance
        String choixBavard = (String)choixBavardCombo.getSelectedItem();
        ArrayList<Bavard> bavards = fenetre.getBatiment().getBavards();
        Bavard choix = null;

        for (Bavard b : bavards) {
            if (b.getPrenom().equals(choixBavard)) {
                choix = b;
                break;
            }
        }

        // Modifier la connexion
        if (choix.getConnected()==true){
            choix.setConnected(false);
            connexionBavard.setText("Déconnecté");
        }else {
            choix.setConnected(true);
            connexionBavard.setText("Connecté");
        }
    }

}
