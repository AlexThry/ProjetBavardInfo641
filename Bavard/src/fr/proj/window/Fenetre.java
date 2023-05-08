package fr.proj.window;

import fr.proj.Batiment;
import fr.proj.Bavard;
import fr.proj.interfaces.IsOnLineListener;
import fr.proj.listeners.EcouteurBoutonAjoutMessage;
import fr.proj.listeners.EcouteurBoutonValiderMessagerie;
import fr.proj.listeners.EcouteurBoutonAjoutBavard;
import fr.proj.listeners.EcouteurBoutonConnexion;
import fr.proj.listeners.EcouteurValideBavard;

import java.awt.*;

import javax.swing.*;

import java.util.ArrayList;

public class Fenetre extends JFrame {
	private Batiment bat;
	private JPanel contentPaneMessage = new JPanel();
	private JComboBox<String> choixBavardMessagerieComboBox;
	private JTextField nomTextField;
	private JTextField prenomTextField;
	private JTextField dateTextField;
	private JTextField sujetTextField;
	private JComboBox choixBavardCombo;
	private ArrayList<String> prenomBavards = new ArrayList<>();
	private JList<Bavard> bavardsConnectés;
	private ArrayList<IsOnLineListener> listeBavardsConnectes;
	private JCheckBox themeCheckBox;
	private JPanel creationBavardPanel;
	private JComboBox comboThemes;


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
		setMinimumSize(new Dimension(500, 820));

		// Centre la fenêtre sur l'écran
		setLocationRelativeTo(null);

		// Ajout des onglets
		JTabbedPane tabbedPane = new JTabbedPane();
		this.add(tabbedPane);

		tabbedPane.setBackground(new Color(0, 0, 255));
		tabbedPane.setForeground(Color.white);

		/********************************************* Onglet gestion batiment *********************************************/

		JPanel gestionBatiment = new JPanel();
		tabbedPane.addTab("Gestion Batiment", null, gestionBatiment, null);
		gestionBatiment.setLayout(new BorderLayout(0, 0));

		/********* Section création de bavard *********/

		this.creationBavardPanel = new JPanel();
		gestionBatiment.add(creationBavardPanel, BorderLayout.NORTH);
		creationBavardPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(135, 113, 183, 255)), "Création Bavard"));
		creationBavardPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;

		JLabel nomLabel = new JLabel("Nom :");
		gbc.gridx = 0;
		gbc.gridy = 0;
		creationBavardPanel.add(nomLabel, gbc);

		this.nomTextField = new JTextField("");
		this.nomTextField.setColumns(15);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		creationBavardPanel.add(nomTextField, gbc);

		JLabel prenomLabel = new JLabel("Prénom :");
		gbc.gridx = 0;
		gbc.gridy = 1;
		creationBavardPanel.add(prenomLabel, gbc);

		this.prenomTextField = new JTextField("");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		creationBavardPanel.add(prenomTextField, gbc);

		JLabel dateLabel = new JLabel("Date de naissance :");
		gbc.gridx = 0;
		gbc.gridy = 2;
		creationBavardPanel.add(dateLabel, gbc);

		this.dateTextField = new JTextField();
		dateTextField.setText("jj/mm/aaaa");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		creationBavardPanel.add(dateTextField, gbc);

		ArrayList<String> themesDisponibles = new ArrayList<String>();
		themesDisponibles.add("Cinéma");
		themesDisponibles.add("Sport");
		themesDisponibles.add("Musique");
		themesDisponibles.add("Littérature");
		themesDisponibles.add("Cuisine");
		themesDisponibles.add("Informatique");

		int row = 4;
		for (String theme : themesDisponibles) {
			JLabel themeLabel = new JLabel(theme + " :");
			gbc.gridx = 0;
			gbc.gridy = row;
			creationBavardPanel.add(themeLabel, gbc);

			this.themeCheckBox = new JCheckBox();
			gbc.gridx = 1;
			gbc.gridy = row;
			creationBavardPanel.add(themeCheckBox, gbc);

			row++;
		}

		JButton creerBavardButton = new JButton("Valider");
		gbc.gridx = 1;
		gbc.gridy = row;
		gbc.fill = GridBagConstraints.NONE;
		creationBavardPanel.add(creerBavardButton, gbc);

		EcouteurBoutonAjoutBavard creerBavardListener = new EcouteurBoutonAjoutBavard(nomTextField, prenomTextField, dateTextField, this, themeCheckBox);
		creerBavardButton.addActionListener(creerBavardListener);


		/************ Section gestion connexion de bavard ************/

		JPanel gestionBavardPanel = new JPanel(new GridLayout(5,1));
		gestionBatiment.add(gestionBavardPanel, BorderLayout.CENTER);
		gestionBavardPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(135, 113, 183, 255)), "Gestion Bavard"));

		/***** Choisir parmi les bavards existants *****/

		JLabel choixBavardLabel = new JLabel("Choisir un bavard : ");
		gestionBavardPanel.add(choixBavardLabel);

		this.choixBavardCombo= new JComboBox<>();
		gestionBavardPanel.add(choixBavardCombo);

		JPanel panelBtnValider = new JPanel();
		panelBtnValider.setLayout(new FlowLayout());
		JButton validerChoixBavard = new JButton("Valider");
		panelBtnValider.add(validerChoixBavard);
		gestionBavardPanel.add(panelBtnValider);

		/***** Connexion du bavard *****/

		JLabel connexionLabel = new JLabel("Connexion/Deconnexion au concierge : ");
		gestionBavardPanel.add(connexionLabel);

		JPanel panelBtnCon = new JPanel();
		panelBtnCon.setLayout(new FlowLayout());
		JButton connexionBavardButton = new JButton("Se connecter");
		panelBtnCon.add(connexionBavardButton);
		gestionBavardPanel.add(panelBtnCon);

		EcouteurBoutonConnexion creerConnexion = new EcouteurBoutonConnexion(choixBavardCombo, this, connexionBavardButton);
		connexionBavardButton.addActionListener(creerConnexion);

		EcouteurValideBavard validerBavard = new EcouteurValideBavard(this, connexionBavardButton, choixBavardCombo);
		validerChoixBavard.addActionListener(validerBavard);

		/***************** Section création de message ****************/

		JPanel creationMessagePanel = new JPanel();
		gestionBatiment.add(creationMessagePanel, BorderLayout.SOUTH);
		creationMessagePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(135, 113, 183, 255)), "Création de message"));
		creationMessagePanel.setLayout(new BorderLayout());

		JPanel messageInputsPanel = new JPanel();
		messageInputsPanel.setLayout(new GridLayout(3, 2, 10, 10));
		creationMessagePanel.add(messageInputsPanel, BorderLayout.CENTER);

		JLabel sujetLabel = new JLabel("Sujet : ");
		messageInputsPanel.add(sujetLabel);

		sujetTextField = new JTextField();
		sujetTextField.setColumns(10);
		messageInputsPanel.add(sujetTextField);

		JLabel themeLabel = new JLabel("Thème : ");
		messageInputsPanel.add(themeLabel);

		this.comboThemes = new JComboBox<>();
		messageInputsPanel.add(comboThemes);
		for (String theme:themesDisponibles) {
			comboThemes.addItem(theme);
		}

		JLabel corpsLabel = new JLabel("Corps : ");
		messageInputsPanel.add(corpsLabel);

		JTextArea corpsTextArea = new JTextArea();
		corpsTextArea.setLineWrap(true);
		corpsTextArea.setRows(2);
		JScrollPane scrollPaneCorps = new JScrollPane(corpsTextArea);
		messageInputsPanel.add(scrollPaneCorps);

		JPanel panelBtn = new JPanel();
		panelBtn.setLayout(new FlowLayout());
		JButton sendMessageButton = new JButton("Envoyer");
		EcouteurBoutonAjoutMessage ecouteurBoutonAjoutMessage = new EcouteurBoutonAjoutMessage(sujetTextField, corpsTextArea, choixBavardCombo, this,comboThemes);
		sendMessageButton.addActionListener(ecouteurBoutonAjoutMessage);
		panelBtn.add(sendMessageButton);
		creationMessagePanel.add(panelBtn, BorderLayout.SOUTH);

		/********************************************* Onglet messagerie *********************************************/

		JPanel messagerieTab = new JPanel();
		tabbedPane.addTab("Messagerie", null, messagerieTab, null);
		messagerieTab.setLayout(new BorderLayout(10, 0));

		/********* Section choix du bavard *********/

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


		/********* Section qui montre les messages *********/

		contentPaneMessage.setLayout(new BoxLayout(contentPaneMessage, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(contentPaneMessage);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(350, 200));
		messagerieTab.add(scrollPane, BorderLayout.CENTER);

		/********************************************* Onglet bavards connectés *********************************************/

		JPanel panelConnectes = new JPanel();
		tabbedPane.addTab("Bavards connectés", panelConnectes);
		this.bavardsConnectés = new JList<>(new DefaultListModel<>());
		this.bavardsConnectés.setBackground(new Color(0xEEEEEE));
		this.bavardsConnectés.setFont(new Font("Arial", Font.PLAIN, 16));
		this.bavardsConnectés.setCellRenderer(new ListCellRenderer<Bavard>() {
			/*
			* Permet d'afficher des panels dans une JList (pour pouvoir ajouter une image)
			 */
			private JPanel panel = new JPanel(new FlowLayout());
			private JLabel prenomLabel = new JLabel();
			private JLabel nomLabel = new JLabel();
			private JLabel imageLabel = new JLabel();
			private ImageIcon imageIcon = new ImageIcon("Bavard/src/fr/proj/image/pastille-vert.png");

			@Override
			public Component getListCellRendererComponent(JList<? extends Bavard> list, Bavard value, int index, boolean isSelected, boolean cellHasFocus) {
				Image img = imageIcon.getImage();
				Image newImg = img.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(newImg);
				prenomLabel.setText(value.getPrenom());
				nomLabel.setText(value.getNom());
				// Affichage de l'image à côté du texte
				imageLabel.setIcon(imageIcon);
				// Ajout des composants à un panneau
				panel.add(imageLabel);
				panel.add(prenomLabel);
				panel.add(nomLabel);
				if (isSelected) {
					panel.setBackground(list.getSelectionBackground());
					prenomLabel.setForeground(list.getSelectionForeground());
					nomLabel.setForeground(list.getSelectionForeground());
				} else {
					panel.setBackground(list.getBackground());
					prenomLabel.setForeground(list.getForeground());
					nomLabel.setForeground(list.getForeground());
				}
				return panel;
			}
		});
		  panelConnectes.add(this.bavardsConnectés);
	}


	public void addMessage(String subject, String sender, String content, String theme) {
		/*
		* permet d'ajouter un MessagePanel dans l'onglet messagerie
		 */
		MessagePanel message = new MessagePanel(subject, sender, content, theme);
		this.contentPaneMessage.add(message);
		this.contentPaneMessage.revalidate();
	}

	public void removeMessages() {
		/*
		* Permet de nettoyer la fenetre messagerie
		 */
		this.contentPaneMessage.removeAll();
		this.contentPaneMessage.revalidate();

	}

	public Batiment getBatiment() {
		return this.bat;
	}

	public void addChoixBavardCombo(String nomBavard, String prenomBavard){
		this.choixBavardCombo.addItem(nomBavard + " " + prenomBavard);
		this.prenomBavards.add(prenomBavard);
	}

	public JComboBox<String> getChoixBavardComboMessage() {
		return this.choixBavardMessagerieComboBox;
	}

	public JList<Bavard> getBavardsConnectés() {
		return bavardsConnectés;
	}

	public void addBavardConnecte(Bavard bavard) {
		DefaultListModel<Bavard> model = (DefaultListModel<Bavard>) this.bavardsConnectés.getModel();
		model.addElement(bavard);
	}

	public void removeBavardConnecte(Bavard bavard) {
		DefaultListModel<Bavard> model = (DefaultListModel<Bavard>) this.bavardsConnectés.getModel();
		model.removeElement(bavard);
	}

	public JPanel getCreationBavardPanel() {
		return creationBavardPanel;
	}

	public JComboBox getComboThemes() {
		return comboThemes;
	}
}
