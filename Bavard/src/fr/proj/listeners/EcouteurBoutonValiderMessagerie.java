package fr.proj.listeners;

import fr.proj.Bavard;
import fr.proj.Fenetre;
import fr.proj.Message;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurBoutonValiderMessagerie implements ActionListener {
    private JComboBox<String> comboBox;
    private Bavard selected;
    private Fenetre fenetre;

    public EcouteurBoutonValiderMessagerie(JComboBox<String> bavardJComboBox, Fenetre fenetre) {
        this.comboBox = bavardJComboBox;
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.fenetre.removeMessages();
        this.selected = fenetre.getBatiment().getBavards().get(this.comboBox.getSelectedIndex());
        if (selected.getMessagesList().size() > 0) {
            for (Message message: selected.getMessagesList()) {
                System.out.println(message);
                fenetre.addMessage(message.getSubject(), message.getSender(), message.getContent());
            }
        }
    }
}
