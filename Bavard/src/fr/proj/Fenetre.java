package fr.proj;

import fr.proj.listeners.EcouteurBoutonValiderMessagerie;
import fr.proj.listeners.ecouteurBoutonAjoutBavard;
import fr.proj.listeners.ecouteurCheckBoxConnection;
import fr.proj.window.MessagePanel;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

<<<<<<< HEAD
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

=======
>>>>>>> 0c5a9f4d3fca7cd6c8635341b98cca94b4ca350d
public class Fenetre extends JFrame {
	private Batiment bat;
	private JPanel contentPane;
	private JPanel contentPaneMessage = new JPanel();

	private JTextField nomConciergeTextField;
	private JTextField nomTextField;
	private JTextField prenomTextField;
	private JTextField dateTextField;
	private JTextField textField_1;
	private JComboBox choixBavardCombo;
	private JCheckBox estConnecteCheckBox;
	private String prenomBavardSelectionne;
	private ArrayList<String> prenomBavards = new ArrayList<>();


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre frame = new Fenetre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Fenetre() {
		this.bat = new Batiment("Concierge");
		this.bat.createBavard("Thierry", "Alexis", "18/03/2002");
		this.bat.createBavard("Thierry", "Alexis2", "18/03/2002");
//		this.bat.getBavards().get(1).connect();
		this.bat.getBavards().get(0).emitMessage("sujet", "corps");
		this.bat.getBavards().get(0).emitMessage("sujet2", "corps");
		this.bat.getBavards().get(1).emitMessage("sujet3", "corps");
		setMinimumSize(new Dimension(500, 350));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel gestionBatiment = new JPanel();
		tabbedPane.addTab("Gestion Batiment", null, gestionBatiment, null);
		gestionBatiment.setLayout(new BorderLayout(0, 0));
		
		JPanel creationBavardPanel = new JPanel();
		gestionBatiment.add(creationBavardPanel, BorderLayout.NORTH);
		creationBavardPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel creationBavardLabel = new JLabel("Création Bavard");
		creationBavardPanel.add(creationBavardLabel);
		
		JLabel label = new JLabel("");
		creationBavardPanel.add(label);
		
		JLabel dateLabel = new JLabel("Date de naissance");
		creationBavardPanel.add(dateLabel);
		
		nomTextField = new JTextField();
		nomTextField.setText("Nom");
		nomTextField.setColumns(10);
		creationBavardPanel.add(nomTextField);
		
		prenomTextField = new JTextField();
		prenomTextField.setText("Prenom");
		prenomTextField.setColumns(10);
		creationBavardPanel.add(prenomTextField);
		
		dateTextField = new JTextField();
		dateTextField.setText("jj/mm/aaaa");
		dateTextField.setColumns(10);
		creationBavardPanel.add(dateTextField);

		JButton creerBavardButton = new JButton("Valider");
		creationBavardPanel.add(creerBavardButton);
		ecouteurBoutonAjoutBavard creerBavardListener = new ecouteurBoutonAjoutBavard(nomTextField, prenomTextField, dateTextField, this);
		creerBavardButton.addActionListener(creerBavardListener);
		
		JPanel gestionBavardPanel = new JPanel();
		gestionBatiment.add(gestionBavardPanel, BorderLayout.SOUTH);
		gestionBavardPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		gestionBavardPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		/********* Section pour choisir parmis les bavards existants *********/
		JLabel choixBavardLabel = new JLabel("Choix bavard :");
		panel.add(choixBavardLabel);
		
		this.choixBavardCombo = new JComboBox();
		panel.add(choixBavardCombo);


		// Section pour établir la connection entre un bavard et le concierge
		/*JLabel estConnecte = new JLabel("Est Connecté :");
		panel.add(estConnecte);
		
		JLabel varEstConnecteLabel = new JLabel("Oui");
		varEstConnecteLabel.setForeground(Color.RED);
		panel.add(varEstConnecteLabel);*/

		JLabel varEstConnecteLabel = new JLabel();
		panel.add(varEstConnecteLabel);
		this.estConnecteCheckBox = new JCheckBox("Est Connecté");
		panel.add(estConnecteCheckBox);

		ecouteurCheckBoxConnection etatCheckBox = new ecouteurCheckBoxConnection(this);
		this.estConnecteCheckBox.addActionListener(etatCheckBox);
		
		JLabel sujetLabel = new JLabel("Sujet : ");
		panel.add(sujetLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		JLabel corpsLabel = new JLabel("Corps : ");
		panel.add(corpsLabel);
		
		JTextPane corpsTextPane = new JTextPane();
		panel.add(corpsTextPane);

		JButton sendMessageButton = new JButton("Envoyer");
		gestionBavardPanel.add(sendMessageButton, BorderLayout.SOUTH);
		
		JPanel messagerieTab = new JPanel();
		tabbedPane.addTab("Messagerie", null, messagerieTab, null);
		messagerieTab.setLayout(new BorderLayout(0, 0));
		
		JPanel choixBavard = new JPanel();
		messagerieTab.add(choixBavard, BorderLayout.NORTH);
		
		JLabel choixBavardMessagerieLabel = new JLabel("Choix bavard : ");
		choixBavard.add(choixBavardMessagerieLabel);
		
		JComboBox choixBavardMessagerieComboBox = new JComboBox();
		choixBavardMessagerieComboBox.setPreferredSize(new Dimension(150, 30));
		choixBavardMessagerieComboBox.setModel(new DefaultComboBoxModel(this.bat.getBavards().toArray(new Bavard[0])));
		choixBavard.add(choixBavardMessagerieComboBox);
		
		JButton validerMessagerie = new JButton("Valider");
		EcouteurBoutonValiderMessagerie ecouteurBoutonValiderMessagerie = new EcouteurBoutonValiderMessagerie(choixBavardMessagerieComboBox, this);
		validerMessagerie.addActionListener(ecouteurBoutonValiderMessagerie);
		choixBavard.add(validerMessagerie);

        contentPaneMessage.setLayout(new BoxLayout(contentPaneMessage, BoxLayout.Y_AXIS));


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(contentPaneMessage);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(350, 200));
		messagerieTab.add(scrollPane, BorderLayout.CENTER);


	}


	public void addMessage(String subject, String sender, String content) {
		MessagePanel message = new MessagePanel(subject, sender, content);
		this.contentPaneMessage.add(message);
		this.contentPaneMessage.revalidate();
//		this.contentPaneMessage.repaint();
	}

	public void removeMessages() {
		this.contentPaneMessage.removeAll();
		this.contentPaneMessage.revalidate();
//		this.contentPaneMessage.repaint();

	}

	public Batiment getBatiment() {
		return this.bat;
<<<<<<< HEAD
	}

	public JCheckBox getEstConnecteCheckBox() {
		return estConnecteCheckBox;
	}

	public void addChoixBavardCombo(String prenomBavard){
		this.choixBavardCombo.addItem(prenomBavard);
		this.prenomBavards.add(prenomBavard);
	}

	public String getPrenomBavardSelectionne() {
		return (String) this.choixBavardCombo.getSelectedItem();
	}


	public void mettreAJourEtatCheckbox(Bavard bavard) {
		if (bavard != null) {
			estConnecteCheckBox.setSelected(bavard.getConnected());
		}
=======
>>>>>>> 0c5a9f4d3fca7cd6c8635341b98cca94b4ca350d
	}

}
