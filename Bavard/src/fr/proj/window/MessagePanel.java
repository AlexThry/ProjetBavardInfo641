package fr.proj.window;

import javax.swing.*;
import java.awt.*;


public class MessagePanel extends JPanel {

    GridLayout grid = new GridLayout(0, 2, 0, 0);
    JLabel varSubjectLabel = new JLabel();
    JLabel varSenderLabel = new JLabel();
    JLabel varThemeLabel = new JLabel();
    JTextArea varContentTextArea = new JTextArea();

    public MessagePanel(String subject, String sender, String content, String theme) {
        /*
        * Création d'un message à insérer dans l'onglet messagerie
         */
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setLayout(grid);
        panel.setPreferredSize(new Dimension(430, 200)); // taille fixe du panneau
        panel.add(new JLabel("Envoyeur"));
        varSenderLabel.setText(sender);
        varSenderLabel.setForeground(Color.red);
        panel.add(varSenderLabel);
        panel.add(new JLabel("Sujet : "));
        varSubjectLabel.setText(subject);
        panel.add(varSubjectLabel);
        panel.add(new JLabel("Thème :"));
        varThemeLabel.setText(theme);
        panel.add(varThemeLabel);

        panel.add(new JLabel("Contenu"));
        varContentTextArea.setText(content);
        varContentTextArea.setEditable(false);
        varContentTextArea.setLineWrap(true);
        varContentTextArea.setPreferredSize(new Dimension(450, 250)); // taille fixe de la zone de texte
        varContentTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(varContentTextArea); // Ajout d'une barre de défilement
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scrollPane);
        this.add(panel);


    }

}
