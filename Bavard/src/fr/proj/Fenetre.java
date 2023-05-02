package fr.proj;

import fr.proj.listeners.ecouteurBoutonAjoutBavard;
import fr.proj.window.MessagePanel;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fenetre extends JFrame {
	private Batiment bat;
	private JPanel contentPane;
	private JPanel contentPaneMessage = new JPanel();

	private JTextField nomConciergeTextField;
	private JTextField nomTextField;
	private JTextField prenomTextField;
	private JTextField dateTextField;
	private JTextField textField_1;


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

		// Création d'un objet GridBagConstraints pour centrer le bouton
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;



		JButton creerBavardButton = new JButton("Valider");
		creationBavardPanel.add(creerBavardButton);
		ecouteurBoutonAjoutBavard creerBavardListener = new ecouteurBoutonAjoutBavard(nomTextField, prenomTextField, dateTextField);
		creerBavardButton.addActionListener(creerBavardListener);
		
		JPanel gestionBavardPanel = new JPanel();
		gestionBatiment.add(gestionBavardPanel, BorderLayout.SOUTH);
		gestionBavardPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		gestionBavardPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		// Section pour choisir parmis les bavards existants
		JLabel choixBavardLabel = new JLabel("Choix bavard :");
		panel.add(choixBavardLabel);
		
		JComboBox choixBavardCombo = new JComboBox();
		//String[] options = bat.getBavards().;
		//JComboBox<String> comboBox = new JComboBox<String>(options);
		panel.add(choixBavardCombo);

		// Section pour établir la connection entre un bavard et le concierge
		JLabel estConnecte = new JLabel("Est Connecté :");
		panel.add(estConnecte);
		
		JLabel varEstConnecteLabel = new JLabel("Oui");
		varEstConnecteLabel.setForeground(Color.RED);
		panel.add(varEstConnecteLabel);
		
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
		choixBavardMessagerieComboBox.setModel(new DefaultComboBoxModel(new String[] {"Alex", "Carlyne", "Andres"}));
		choixBavard.add(choixBavardMessagerieComboBox);
		
		JButton validerMessagerie = new JButton("Valider");
		validerMessagerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
	}

	public void setBatiment(Batiment bat) {
		this.bat = bat;
	}

}
