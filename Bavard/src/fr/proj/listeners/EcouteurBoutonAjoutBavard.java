package fr.proj.listeners;
import fr.proj.Bavard;
import fr.proj.window.Fenetre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class EcouteurBoutonAjoutBavard implements ActionListener {

    private JTextField nomTextField;
    private JTextField prenomTextField;
    private JTextField dateTextField;
    private Fenetre fenetre;
    private JCheckBox themeCheckBox;

    public EcouteurBoutonAjoutBavard(JTextField nomTextField, JTextField prenomTextField, JTextField dateTextField, Fenetre fenetre, JCheckBox themeCheckBox) {
        this.nomTextField = nomTextField;
        this.prenomTextField = prenomTextField;
        this.dateTextField = dateTextField;
        this.fenetre= fenetre;
        this.themeCheckBox = themeCheckBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Récupérer les valeurs des champs nom, prénom et date de naissance
        String nom = nomTextField.getText();
        String prenom = prenomTextField.getText();
        String dateNaissance = dateTextField.getText();
        boolean dejaPresent = false;

        for (Bavard b:fenetre.getBatiment().getBavards()) {
            String p = b.getPrenom();
            String n = b.getNom();
            String d = b.getDateDeNaissance();
            if (p.equals(prenom) && n.equals(nom) && d.equals(dateNaissance)){
                dejaPresent = true;
            }
        }

        // Créer un nouveau Bavard avec les valeurs récupérées
        if (!nom.isEmpty() && !prenom.isEmpty() && !dateNaissance.equals("jj/mm/aaaa") && dejaPresent==false) {

            ArrayList<String> themesChoisis = new ArrayList<>();
            Component[] components = fenetre.getCreationBavardPanel().getComponents();
            for (Component component : components) {
                if (component instanceof JCheckBox) {
                    JCheckBox checkBox = (JCheckBox) component;
                    if (checkBox.isSelected()) {
                        JLabel label = (JLabel) components[fenetre.getCreationBavardPanel().getComponentZOrder(checkBox) - 1];
                        String theme = label.getText().replace(" :", "");
                        themesChoisis.add(theme);
                        checkBox.setSelected(false);
                    }
                }
            }

            fenetre.getBatiment().createBavard(nom, prenom, dateNaissance,themesChoisis);
            JOptionPane.showMessageDialog(fenetre, "Vous venez d'ajouter un bavard !", "Succès", JOptionPane.INFORMATION_MESSAGE);

            //etat initial remis
            nomTextField.setText("");
            prenomTextField.setText("");
            dateTextField.setText("jj/mm/aaaa");

            // Ajouter des éléments au comboBox
            fenetre.addChoixBavardCombo(nom,prenom);
            int size = fenetre.getBatiment().getBavards().size();
            fenetre.getChoixBavardComboMessage().addItem(fenetre.getBatiment().getBavards().get(size - 1).getPrenom());

        }else{
            JOptionPane.showMessageDialog(fenetre, "Veuillez renseigner tous les champs et faire attention à ne pas enregistrer deux fois le même utilisateur...", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

}
