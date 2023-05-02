package fr.proj;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ecouteurBoutonAjoutBavard implements ActionListener {

    private JTextField nomTextField;
    private JTextField prenomTextField;
    private JTextField dateTextField;

    public ecouteurBoutonAjoutBavard(JTextField nomTextField, JTextField prenomTextField, JTextField dateTextField) {
        this.nomTextField = nomTextField;
        this.prenomTextField = prenomTextField;
        this.dateTextField = dateTextField;
        System.out.println(1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Récupérer les valeurs des champs nom, prénom et date de naissance
        System.out.println(2);
        String nom = nomTextField.getText();
        String prenom = prenomTextField.getText();
        String dateNaissance = dateTextField.getText();

        // Créer un nouveau Bavard avec les valeurs récupérées
        Bavard nouveauBavard = new Bavard(nom, prenom, dateNaissance);
    }

}
