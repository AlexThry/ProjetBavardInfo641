package fr.proj.listeners;
import fr.proj.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class EcouteurBoutonAjoutBavard implements ActionListener {

    private JTextField nomTextField;
    private JTextField prenomTextField;
    private JTextField dateTextField;
    private Fenetre fenetre;

    public EcouteurBoutonAjoutBavard(JTextField nomTextField, JTextField prenomTextField, JTextField dateTextField, Fenetre fenetre) {
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
        fenetre.getBatiment().createBavard(nom, prenom, dateNaissance);

        // Ajouter des éléments au comboBox
        fenetre.addChoixBavardCombo(prenom);
        int size = fenetre.getBatiment().getBavards().size();
        fenetre.getChoixBavardComboMessage().addItem(fenetre.getBatiment().getBavards().get(size-1).getPrenom());

    }

}
