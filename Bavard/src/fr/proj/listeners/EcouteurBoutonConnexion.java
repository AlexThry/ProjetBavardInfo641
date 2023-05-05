package fr.proj.listeners;
import fr.proj.Bavard;
import fr.proj.Fenetre;
import fr.proj.IsOnLineListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class EcouteurBoutonConnexion implements ActionListener {
    private JComboBox choixBavardCombo;
    private Fenetre fenetre;
    private JButton connexionBavard;
    public EcouteurBoutonConnexion(JComboBox choixBavardCombo, Fenetre fenetre, JButton connexionBavard) {
        this.choixBavardCombo=choixBavardCombo;
        this.fenetre = fenetre;
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

        if (choix == null){
            JOptionPane.showMessageDialog(fenetre,"Vous devez créer un utilisateur !","Erreur",JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Modifier la connexion
        if (choix.getConnected()==true){
            fenetre.getBatiment().connectBavard(choix, false);
            ArrayList<IsOnLineListener> bavardsConnectés= fenetre.getBatiment().getBavardsConnectés();
            bavardsConnectés.remove(choix);
            fenetre.getBatiment().setBavardsConnectés(bavardsConnectés);
            connexionBavard.setText("Déconnecté");
            this.fenetre.removeBavardConnecte(choix);
        } else {
            fenetre.getBatiment().connectBavard(choix, true);
            ArrayList<IsOnLineListener> bavardsConnectés= fenetre.getBatiment().getBavardsConnectés();
            bavardsConnectés.add(choix);
            fenetre.getBatiment().setBavardsConnectés(bavardsConnectés);
            connexionBavard.setText("Connecté");
            this.fenetre.addBavardConnecte(choix);

        }
    }

}
