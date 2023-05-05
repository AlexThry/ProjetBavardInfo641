package fr.proj;

import fr.proj.listeners.EcouteurBoutonAjoutMessage;
import fr.proj.listeners.EcouteurBoutonValiderMessagerie;
import fr.proj.listeners.EcouteurBoutonAjoutBavard;
import fr.proj.listeners.EcouteurBoutonConnexion;
import fr.proj.listeners.EcouteurValideBavard;
import fr.proj.window.MessagePanel;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


import java.util.ArrayList;

public class Fenetre extends JFrame {
	private Batiment bat;
	private JPanel contentPane;
	private JPanel contentPaneMessage = new JPanel();
	private JComboBox<String> choixBavardMessagerieComboBox;
	private JTextField nomConciergeTextField;
	private JTextField nomTextField;
	private JTextField prenomTextField;
	private JTextField dateTextField;
	private JTextField sujetTextField;
	private JComboBox choixBavardCombo;
	private String prenomBavardSelectionne;
	private ArrayList<String> prenomBavards = new ArrayList<>();
	private JList<String> bavardsConnectés;
	private ArrayList<IsOnLineListener> listeBavardsConnectes;


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

		// Création du batiment associé à la fenetre
		this.bat = new Batiment("Concierge");
		this.listeBavardsConnectes = this.getBatiment().getBavardsConnectés();

		/********* Création de la fenêtre *********/
		setMinimumSize(new Dimension(500, 580));	contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);

		// Centre la fenêtre sur l'écran
		setLocationRelativeTo(null);

		// Ajout des onglets
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		tabbedPane.setBackground(new Color(0, 0, 255));
		tabbedPane.setForeground(Color.white);

		/********* Onglet gestion bavard *********/

		JPanel gestionBavard = new JPanel();
		tabbedPane.addTab("Gestion Batiment", null, gestionBavard, null);
		gestionBavard.setLayout(new BorderLayout(0, 0));

		/********* Création de bavard *********/

		JPanel creationBavardPanel = new JPanel();
		gestionBavard.add(creationBavardPanel, BorderLayout.NORTH);
		creationBavardPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(135, 113, 183, 255)), "Création Bavard"));
		creationBavardPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;

		JLabel nomLabel = new JLabel("Nom :");
		gbc.gridx = 0;
		gbc.gridy = 0;
		creationBavardPanel.add(nomLabel, gbc);

		JTextField nomTextField = new JTextField("");
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		creationBavardPanel.add(nomTextField, gbc);

		JLabel prenomLabel = new JLabel("Prénom :");
		gbc.gridx = 0;
		gbc.gridy = 1;
		creationBavardPanel.add(prenomLabel, gbc);

		JTextField prenomTextField = new JTextField("");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		creationBavardPanel.add(prenomTextField, gbc);

		JLabel dateLabel = new JLabel("Date de naissance :");
		gbc.gridx = 0;
		gbc.gridy = 2;
		creationBavardPanel.add(dateLabel, gbc);

		JTextField dateTextField = new JTextField();
		dateTextField.setText("jj/mm/aaaa");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		creationBavardPanel.add(dateTextField, gbc);

		JButton creerBavardButton = new JButton("Valider");
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.NONE;
		creationBavardPanel.add(creerBavardButton, gbc);
		EcouteurBoutonAjoutBavard creerBavardListener = new EcouteurBoutonAjoutBavard(nomTextField, prenomTextField, dateTextField, this);
		creerBavardButton.addActionListener(creerBavardListener);

		/********* Gestion de bavard *********/

		JPanel gestionBavardPanel = new JPanel();
		gestionBavard.add(gestionBavardPanel, BorderLayout.CENTER);
		gestionBavardPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(135, 113, 183, 255)), "Gestion Bavard"));
		gestionBavardPanel.setLayout(new BorderLayout(0, 0));

		/********* Section pour choisir parmi les bavards existants *********/

		JPanel choixBavardPanel = new JPanel(new GridLayout(0, 1, 5, 5));
		gestionBavardPanel.add(choixBavardPanel, BorderLayout.NORTH);

		JLabel choixBavardLabel = new JLabel("Choisir un bavard : ");
		choixBavardPanel.add(choixBavardLabel);

		this.choixBavardCombo= new JComboBox<>();
		choixBavardPanel.add(choixBavardCombo);

		JButton validerChoixBavard = new JButton("Valider");
		choixBavardPanel.add(validerChoixBavard);

		/********* Connexion du bavard *********/

		JLabel connexionLabel = new JLabel("Connexion/Deconnexion au concierge : ");
		choixBavardPanel.add(connexionLabel);

		JButton connexionBavardButton = new JButton("Se connecter");
		choixBavardPanel.add(connexionBavardButton);

		EcouteurBoutonConnexion creerConnexion = new EcouteurBoutonConnexion(choixBavardCombo, this, connexionBavardButton);
		connexionBavardButton.addActionListener(creerConnexion);

		EcouteurValideBavard validerBavard = new EcouteurValideBavard(this, connexionBavardButton, choixBavardCombo);
		validerChoixBavard.addActionListener(validerBavard);

		/********* Création de message *********/

		JPanel creationMessagePanel = new JPanel();
		gestionBavard.add(creationMessagePanel, BorderLayout.SOUTH);
		creationMessagePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(135, 113, 183, 255)), "Création de message"));
		creationMessagePanel.setLayout(new BorderLayout());

		JPanel messageInputsPanel = new JPanel();
		messageInputsPanel.setLayout(new GridLayout(2, 2, 10, 10));
		creationMessagePanel.add(messageInputsPanel, BorderLayout.CENTER);

		JLabel sujetLabel = new JLabel("Sujet : ");
		messageInputsPanel.add(sujetLabel);

		sujetTextField = new JTextField();
		sujetTextField.setColumns(10);
		messageInputsPanel.add(sujetTextField);

		JLabel corpsLabel = new JLabel("Corps : ");
		messageInputsPanel.add(corpsLabel);

		JTextArea corpsTextArea = new JTextArea();
		corpsTextArea.setLineWrap(true);
		corpsTextArea.setRows(2);
		JScrollPane scrollPaneCorps = new JScrollPane(corpsTextArea);
		messageInputsPanel.add(scrollPaneCorps);

		JButton sendMessageButton = new JButton("Envoyer");
		EcouteurBoutonAjoutMessage ecouteurBoutonAjoutMessage = new EcouteurBoutonAjoutMessage(sujetTextField, corpsTextArea, choixBavardCombo, this);
		sendMessageButton.addActionListener(ecouteurBoutonAjoutMessage);
		creationMessagePanel.add(sendMessageButton, BorderLayout.SOUTH);


		/********* Onglet messagerie *********/

		JPanel messagerieTab = new JPanel();
		tabbedPane.addTab("Messagerie", null, messagerieTab, null);
		messagerieTab.setLayout(new BorderLayout(0, 0));

		/********* Choix du bavard *********/

		JPanel choixBavard = new JPanel();
		messagerieTab.add(choixBavard, BorderLayout.NORTH);

		JLabel choixBavardMessagerieLabel = new JLabel("Choix bavard : ");
		choixBavard.add(choixBavardMessagerieLabel);
		
		this.choixBavardMessagerieComboBox = new JComboBox();
		this.choixBavardMessagerieComboBox.setPreferredSize(new Dimension(150, 30));
		choixBavard.add(choixBavardMessagerieComboBox);

		JButton validerMessagerie = new JButton("Valider");
		EcouteurBoutonValiderMessagerie ecouteurBoutonValiderMessagerie = new EcouteurBoutonValiderMessagerie(choixBavardMessagerieComboBox, this);
		validerMessagerie.addActionListener(ecouteurBoutonValiderMessagerie);
		choixBavard.add(validerMessagerie);

        contentPaneMessage.setLayout(new BoxLayout(contentPaneMessage, BoxLayout.Y_AXIS));

		/********* Section qui montre les messages *********/

		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(contentPaneMessage);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(350, 200));
		messagerieTab.add(scrollPane, BorderLayout.CENTER);


		/********* Section qui montre les bavards connectés *********/
		JPanel panelConnectes = new JPanel();
		tabbedPane.addTab("Bavards connectés", panelConnectes);
		this.bavardsConnectés = new JList<>(new DefaultListModel<>());
		panelConnectes.add(this.bavardsConnectés);

	}


	public void addMessage(String subject, String sender, String content) {
		MessagePanel message = new MessagePanel(subject, sender, content);
		this.contentPaneMessage.add(message);
		this.contentPaneMessage.revalidate();
	}

	public void removeMessages() {
		this.contentPaneMessage.removeAll();
		this.contentPaneMessage.revalidate();

	}

	public Batiment getBatiment() {
		return this.bat;
	}

	public void addChoixBavardCombo(String prenomBavard){
		this.choixBavardCombo.addItem(prenomBavard);
		this.prenomBavards.add(prenomBavard);
	}

	public JComboBox<String> getChoixBavardComboMessage() {
		return this.choixBavardMessagerieComboBox;
	}

	public JList<String> getBavardsConnectés() {
		return bavardsConnectés;
	}

	public void addBavardConnecte(String prenom) {
		DefaultListModel<String> model = (DefaultListModel<String>) this.bavardsConnectés.getModel();
		model.addElement(prenom);
	}

	public void removeBavardConnecte(String prenom) {
		DefaultListModel<String> model = (DefaultListModel<String>) this.bavardsConnectés.getModel();
		model.removeElement(prenom);
	}
}
