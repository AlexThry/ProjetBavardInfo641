package fr.proj;

import fr.proj.listeners.EcouteurBoutonAjoutMessage;
import fr.proj.listeners.EcouteurBoutonValiderMessagerie;
import fr.proj.listeners.EcouteurBoutonAjoutBavard;
import fr.proj.listeners.EcouteurBoutonConnexion;
import fr.proj.listeners.EcouteurValideBavard;
import fr.proj.window.MessagePanel;

import java.awt.*;

import javax.swing.*;
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
		setMinimumSize(new Dimension(500, 350));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));


		// Ajout des onglets
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setPreferredSize(new Dimension(600, 350));
		contentPane.add(tabbedPane);

		/********* Onglet gestion batiment *********/


		JPanel gestionBatiment = new JPanel();
		tabbedPane.addTab("Gestion Batiment", null, gestionBatiment, null);
		gestionBatiment.setLayout(new BorderLayout(0, 0));

		/********* Création de bavard *********/

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
		EcouteurBoutonAjoutBavard creerBavardListener = new EcouteurBoutonAjoutBavard(nomTextField, prenomTextField, dateTextField, this);
		creerBavardButton.addActionListener(creerBavardListener);

		/********* Gestion de bavard *********/


		JPanel gestionBavardPanel = new JPanel();
		gestionBatiment.add(gestionBavardPanel, BorderLayout.SOUTH);
		gestionBavardPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		gestionBavardPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		/********* Section pour choisir parmis les bavards existants *********/

		this.choixBavardCombo = new JComboBox();
		panel.add(choixBavardCombo);
		JButton validerChoixBavard = new JButton("Valider");
		panel.add(validerChoixBavard);


		/********* Connexion du bavard *********/

		JLabel connexion= new JLabel("Connecté:");
		panel.add(connexion);

		JButton connexionBavard = new JButton("Connexion concierge");
		panel.add(connexionBavard);
		EcouteurBoutonConnexion creerConnexion = new EcouteurBoutonConnexion(choixBavardCombo,this,connexionBavard);
		connexionBavard.addActionListener(creerConnexion);
		EcouteurValideBavard validerBavard = new EcouteurValideBavard(this,connexionBavard,choixBavardCombo);
		validerChoixBavard.addActionListener(validerBavard);

		/********* Création de message *********/

		JLabel sujetLabel = new JLabel("Sujet : ");
		panel.add(sujetLabel);

		
		sujetTextField = new JTextField();
		sujetTextField.setColumns(10);
		panel.add(sujetTextField);
		
		JLabel corpsLabel = new JLabel("Corps : ");
		panel.add(corpsLabel);
		
		JTextArea corpsTextArea = new JTextArea();
		corpsTextArea.setLineWrap(true);
		panel.add(corpsTextArea);

		JButton sendMessageButton = new JButton("Envoyer");
		EcouteurBoutonAjoutMessage ecouteurBoutonAjoutMessage = new EcouteurBoutonAjoutMessage(sujetTextField, corpsTextArea, choixBavardCombo, this);
		sendMessageButton.addActionListener(ecouteurBoutonAjoutMessage);
		gestionBavardPanel.add(sendMessageButton, BorderLayout.SOUTH);

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
		// récupération des noms et prenoms des bavards



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

//<<<<<<< HEAD
//=======
	public String getPrenomBavardSelectionne() {
		return (String) this.choixBavardCombo.getSelectedItem();
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
