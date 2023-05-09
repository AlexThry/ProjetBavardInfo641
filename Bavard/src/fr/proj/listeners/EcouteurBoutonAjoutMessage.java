package fr.proj.listeners;

import fr.proj.Bavard;
import fr.proj.window.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurBoutonAjoutMessage implements ActionListener {

    private JTextField sujet;
    private JTextArea corps;
    private JComboBox<String> comboBox;
    private Fenetre fenetre;
    private JComboBox comboThemeBox;

    public EcouteurBoutonAjoutMessage(JTextField sujet, JTextArea corps, JComboBox<String> comboBox, Fenetre fenetre, JComboBox comboThemeBox) {
        this.sujet = sujet;
        this.corps = corps;
        this.fenetre= fenetre;
        this.comboBox = comboBox;
        this.comboThemeBox = comboThemeBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Bavard bavard = fenetre.getBatiment().getBavards().get(comboBox.getSelectedIndex());

        // Récupérer les valeurs des champs nom, prénom et date de naissance
        if ((fenetre.getBatiment().getBavards()).size() == 0){
            JOptionPane.showMessageDialog(fenetre, "Vous devez créer un bavard pour pouvoir envoyer un message...", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        else if (bavard.getConnected() == false){
            JOptionPane.showMessageDialog(fenetre, "Vous devez connecter le bavard sélectionné...", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        else {
            fenetre.getBatiment().sendMessage(bavard, sujet.getText(), corps.getText(), (String) comboThemeBox.getSelectedItem());
            sujet.setText("");
            corps.setText("");
        }
    }
}
