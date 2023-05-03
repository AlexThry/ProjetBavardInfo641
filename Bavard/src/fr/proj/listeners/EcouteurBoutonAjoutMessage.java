package fr.proj.listeners;

import fr.proj.Bavard;
import fr.proj.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurBoutonAjoutMessage implements ActionListener {

    private JTextField sujet;
    private JTextArea corps;
    private JComboBox<String> comboBox;
    private Fenetre fenetre;

    public EcouteurBoutonAjoutMessage(JTextField sujet, JTextArea corps, JComboBox<String> comboBox, Fenetre fenetre) {
        this.sujet = sujet;
        this.corps = corps;
        this.fenetre= fenetre;
        this.comboBox = comboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Récupérer les valeurs des champs nom, prénom et date de naissance
        Bavard bavard = fenetre.getBatiment().getBavards().get(comboBox.getSelectedIndex());
        System.out.println(bavard.getMessagesList());
        fenetre.getBatiment().sendMessage(bavard, sujet.getText(), corps.getText());

    }

}
