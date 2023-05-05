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
        this.setLayout(grid);
        this.add(new JLabel("Sujet : "));
        varSubjectLabel.setText(subject);
        this.add(varSubjectLabel);
        this.add(new JLabel("Thème :"));
        this.varThemeLabel.setText(theme);
        this.add(varThemeLabel);
        this.add(new JLabel("Envoyeur"));
        varSenderLabel.setText(sender);
        this.add(varSenderLabel);
        this.add(new JLabel("Contenu"));
        varContentTextArea.setText(content);
        varContentTextArea.setLineWrap(true);
        this.add(varContentTextArea);

    }

}
