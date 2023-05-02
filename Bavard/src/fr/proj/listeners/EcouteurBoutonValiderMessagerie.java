package fr.proj.listeners;

import fr.proj.Bavard;
import fr.proj.Fenetre;
import fr.proj.Message;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurBoutonValiderMessagerie implements ActionListener {
    private JComboBox<Bavard> comboBox;
    private Bavard selected;
    private Fenetre fenetre;

    public EcouteurBoutonValiderMessagerie(JComboBox<Bavard> bavardJComboBox, Fenetre fenetre) {
        this.comboBox = bavardJComboBox;
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.selected = fenetre.getBatiment().getBavards().get(this.comboBox.getSelectedIndex());
        System.out.println(selected);
        this.fenetre.removeMessages();
        System.out.println(2);
        for (Message message: selected.getMessagesList()) {
            System.out.println(message);
            fenetre.addMessage(message.getSubject(), message.getSender(), message.getContent());
        }
    }
}
