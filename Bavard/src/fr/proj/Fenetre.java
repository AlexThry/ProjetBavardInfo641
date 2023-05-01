package fr.proj;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import java.awt.Point;
import java.awt.Label;
import java.awt.Rectangle;

public class Fenetre extends JFrame {

	private JPanel contentPane;
	private JTextField nomConciergeTextField;
	private JTextField nomTextField;
	private JTextField prenomTextField;
	private JTextField dateTextField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Fenetre() {
		setMinimumSize(new Dimension(500, 350));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel creationBatiment = new JPanel();
		tabbedPane.addTab("Création Batiment", null, creationBatiment, null);
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		creationBatiment.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Nom Concierge : ");
		creationBatiment.add(lblNewLabel);
		
		nomConciergeTextField = new JTextField();
		creationBatiment.add(nomConciergeTextField);
		nomConciergeTextField.setColumns(20);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		creationBatiment.add(btnNewButton);
		
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
		dateTextField.setText("jj/mm/aaa");
		dateTextField.setColumns(10);
		creationBavardPanel.add(dateTextField);
		
		JButton creerBavardButton = new JButton("Valider");
		creationBavardPanel.add(creerBavardButton);
		
		JPanel gestionBavardPanel = new JPanel();
		gestionBatiment.add(gestionBavardPanel, BorderLayout.SOUTH);
		gestionBavardPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		gestionBavardPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel choixBavardLabel = new JLabel("Choix bavard :");
		panel.add(choixBavardLabel);
		
		JComboBox choixBavardCombo = new JComboBox();
		panel.add(choixBavardCombo);
		
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
		
		JPanel message1 = new JPanel();
		// messagerieTab.add(message1, BorderLayout.CENTER);
		message1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel senderLabel = new JLabel("Sender");
		message1.add(senderLabel);
		
		JLabel varSenderLabel = new JLabel("Alexis");
		varSenderLabel.setForeground(Color.RED);
		message1.add(varSenderLabel);
		
		JLabel subjectLabel = new JLabel("Subject");
		message1.add(subjectLabel);
		
		JLabel varSubjectLabel = new JLabel("Subject");
		varSubjectLabel.setForeground(Color.RED);
		message1.add(varSubjectLabel);
		message1.setPreferredSize(new Dimension(350, 150));
		
		JPanel message2 = new JPanel();
		// messagerieTab.add(message2, BorderLayout.SOUTH);
		message2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel senderLabel_1 = new JLabel("Sender");
		message2.add(senderLabel_1);
		
		JLabel varSenderLabel_1 = new JLabel("Alexis");
		varSenderLabel_1.setForeground(Color.RED);
		message2.add(varSenderLabel_1);
		
		JLabel subjectLabel_1 = new JLabel("Subject");
		message2.add(subjectLabel_1);
		
		JLabel varSubjectLabel_1 = new JLabel("Subject");
		varSubjectLabel_1.setForeground(Color.RED);
		message2.add(varSubjectLabel_1);
		message2.setPreferredSize(new Dimension(350, 150));
		
		
		JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(message1);
        
        Label contentLabel = new Label("Content");
        message1.add(contentLabel);
        
        JTextArea varContentTextArea = new JTextArea();
        varContentTextArea.setWrapStyleWord(true);
        varContentTextArea.setText("eycgvuieo yé&eboiyb aciybeapoic aeciyhbaeipo aeiuybhzaepiç aipudcbyxapiu");
        varContentTextArea.setLineWrap(true);
        message1.add(varContentTextArea);
        contentPane.add(message2);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(contentPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(350, 200));
		messagerieTab.add(scrollPane, BorderLayout.CENTER);
	}

}
