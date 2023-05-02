package fr.proj.listeners;

import fr.proj.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ecouteurBoutonAjoutMessage implements ActionListener {

    private JLabel sujetLabel;
    private JLabel corpsLabel;
    private Fenetre fenetre;

    public ecouteurBoutonAjoutMessage(JLabel sujetLabel, JLabel corpsLabel, Fenetre fenetre) {
        this.sujetLabel = sujetLabel;
        this.corpsLabel = corpsLabel;
        this.fenetre= fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Récupérer les valeurs des champs nom, prénom et date de naissance
        String sujet = sujetLabel.getText();
        String corps = corpsLabel.getText();
    }

}
