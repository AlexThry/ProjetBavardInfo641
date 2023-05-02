package fr.proj.listeners;

import fr.proj.Bavard;
import fr.proj.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ecouteurCheckBoxConnection implements ActionListener {

    public Fenetre fenetre;

    public ecouteurCheckBoxConnection(Fenetre fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Bavard> bavards = fenetre.getBatiment().getBavards();
        String prenom = fenetre.getPrenomBavardSelectionne();
        Bavard bav = null;

        for (Bavard b : bavards) {
            if (b.getPrenom().equals(prenom)) {
                bav = b;
                break;
            }
        }

        if (bav != null) {
            boolean etatConnexion = fenetre.getEstConnecteCheckBox().isSelected();
            bav.setConnected(etatConnexion);
            fenetre.mettreAJourEtatCheckbox(bav);
            System.out.println(bav);
        }
    }


}


