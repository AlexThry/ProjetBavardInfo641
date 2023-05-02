package fr.proj.listeners;

import fr.proj.Bavard;
import fr.proj.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ecouteurValideBavard implements ActionListener {
    private Fenetre fenetre;
    private JComboBox choixBavardCombo;
    private JButton connexionBavard;
    public ecouteurValideBavard(Fenetre fenetre,JButton connexionBavard, JComboBox choixBavardCombo) {
        this.fenetre= fenetre;
        this.connexionBavard = connexionBavard;
        this.choixBavardCombo = choixBavardCombo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Récupérer les valeurs des champs nom, prénom et date de naissance
        String choixBavard = (String) choixBavardCombo.getSelectedItem();
        ArrayList<Bavard> bavards = fenetre.getBatiment().getBavards();
        Bavard choix = null;

        for (Bavard b : bavards) {
            if (b.getPrenom().equals(choixBavard)) {
                choix = b;
                break;
            }
        }

        // Modifier la connexion
        if (choix.getConnected() == true) {
            connexionBavard.setText("Connecté");
        } else {
            connexionBavard.setText("Déconnecté");
        }
    }
}

