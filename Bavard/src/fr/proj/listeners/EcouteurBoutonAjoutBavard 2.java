package fr.proj.listeners;
import fr.proj.Bavard;
import fr.proj.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

<<<<<<< HEAD:Bavard/src/fr/proj/listeners/EcouteurBoutonAjoutBavard 2.java
import javax.swing.JButton;
import javax.swing.JTextField;
=======
import javax.swing.*;
>>>>>>> 59525f6f0fef226bbb5ab819d81fe234b7e9b2cd:Bavard/src/fr/proj/listeners/EcouteurBoutonAjoutBavard.java

public class ecouteurBoutonAjoutBavard implements ActionListener {

    private JTextField nomTextField;
    private JTextField prenomTextField;
    private JTextField dateTextField;
    private Fenetre fenetre;

    public ecouteurBoutonAjoutBavard(JTextField nomTextField, JTextField prenomTextField, JTextField dateTextField, Fenetre fenetre) {
        this.nomTextField = nomTextField;
        this.prenomTextField = prenomTextField;
        this.dateTextField = dateTextField;
        this.fenetre= fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Récupérer les valeurs des champs nom, prénom et date de naissance
        String nom = nomTextField.getText();
        String prenom = prenomTextField.getText();
        String dateNaissance = dateTextField.getText();

        // Créer un nouveau Bavard avec les valeurs récupérées
        if (!nom.isEmpty() && !prenom.isEmpty() && !dateNaissance.equals("jj/mm/aaaa")) {
            fenetre.getBatiment().createBavard(nom, prenom, dateNaissance);
            JOptionPane.showMessageDialog(fenetre, "Vous venez d'ajouter un bavard !", "Succès", JOptionPane.INFORMATION_MESSAGE);

<<<<<<< HEAD:Bavard/src/fr/proj/listeners/EcouteurBoutonAjoutBavard 2.java
        // Ajouter des éléments au comboBox
        fenetre.addChoixBavardCombo(prenom);
        int size = fenetre.getBatiment().getBavards().size();
        fenetre.getChoixBavardComboMessage().addItem(fenetre.getBatiment().getBavards().get(size-1));
=======
            //etat initial remis
            nomTextField.setText("");
            prenomTextField.setText("");
            dateTextField.setText("jj/mm/aaaa");

            // Ajouter des éléments au comboBox
            fenetre.addChoixBavardCombo(prenom);
            int size = fenetre.getBatiment().getBavards().size();
            fenetre.getChoixBavardComboMessage().addItem(fenetre.getBatiment().getBavards().get(size - 1).getPrenom());

        }else{
            JOptionPane.showMessageDialog(fenetre, "Veuillez renseigner tous les champs...", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
>>>>>>> 59525f6f0fef226bbb5ab819d81fe234b7e9b2cd:Bavard/src/fr/proj/listeners/EcouteurBoutonAjoutBavard.java

    }

}
