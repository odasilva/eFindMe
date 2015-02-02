package eFindMe.ESGI.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;




public class RelationManager extends JFrame implements ActionListener{
	
	private Customer client;
	
	
	public RelationManager(Customer c) {
		
		client = c;
		
		setPreferredSize(new Dimension(1280, 760));
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel southPanel = new JPanel();
		southPanel.setBorder(BorderFactory.createTitledBorder("Commandes"));
		southPanel.setBackground(Color.WHITE);
		southPanel.setPreferredSize(new Dimension(150, 150));
		getContentPane().add(southPanel, BorderLayout.SOUTH);
		
		
		JPanel eastPanel = new JPanel();
		eastPanel.setBorder(BorderFactory.createTitledBorder("Description"));
		eastPanel.setBackground(Color.WHITE);
		
		eastPanel.setPreferredSize(new Dimension(250, 250));
		getContentPane().add(eastPanel, BorderLayout.EAST);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(BorderFactory.createTitledBorder("Relations de " + client.getSociety()));
		centerPanel.setPreferredSize(new Dimension(400,400));
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(new ClientRelationGraph(client, centerPanel),BorderLayout.CENTER);
		getContentPane().add(centerPanel,BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnClient = new JMenu("Fichier");
		menuBar.add(mnClient);
		
		JMenuItem mntmChoisir = new JMenuItem("Ouvrir");
		mnClient.add(mntmChoisir);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Enregistrer");
		mnClient.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Fermer");
		mnClient.add(mntmNewMenuItem_1);
		
		setSize(new Dimension(1280, 760));
		setTitle("eFindMe - " + client.getSociety());
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
