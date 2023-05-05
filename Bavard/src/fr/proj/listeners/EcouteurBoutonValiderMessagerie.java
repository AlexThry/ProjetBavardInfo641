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
<<<<<<< HEAD
        this.fenetre.removeMessages();
        this.selected = fenetre.getBatiment().getBavards().get(this.comboBox.getSelectedIndex());
        if (selected.getMessagesList().size() > 0) {
            for (Message message: selected.getMessagesList()) {
                System.out.println(message);
                fenetre.addMessage(message.getSubject(), message.getSender(), message.getContent());
=======
        if (fenetre.getBatiment().getBavards().size() == 0){
            JOptionPane.showMessageDialog(fenetre, "Vous devez créer un utilisateur pour pouvoir consulter les messages...", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        else{
            this.selected = fenetre.getBatiment().getBavards().get(this.comboBox.getSelectedIndex());
            this.fenetre.removeMessages();
            if (selected.getMessagesList().size() > 0) {
                for (Message message: selected.getMessagesList()) {
                    fenetre.addMessage(message.getSubject(), message.getSender(), message.getContent());
                }
>>>>>>> 59525f6f0fef226bbb5ab819d81fe234b7e9b2cd
            }
        }
    }
}
