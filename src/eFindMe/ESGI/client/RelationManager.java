package eFindMe.ESGI.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;




public class RelationManager extends JFrame implements ActionListener{
	
	private Customer client;
	private  Document document;
	
	
	public RelationManager(String xml) {
		
		
		
		try {
			
			DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();
			DocumentBuilder constructeur;
			constructeur = fabrique.newDocumentBuilder();
			document = constructeur.parse(xml);
			
			client = LoadClient();
			
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
			centerPanel.add(new ClientRelationGraph(client, centerPanel,document),BorderLayout.CENTER);
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
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private Customer LoadClient() {
		String clientName = document.getElementsByTagName("name").item(0).getNodeValue();
		String clientFirstName = document.getElementsByTagName("name").item(0).getNodeValue();
		Customer c = new Customer(clientName,clientFirstName);
		c.setPseudo(document.getElementsByTagName("pseudo").item(0).getNodeValue());
		c.setFacebook(document.getElementsByTagName("facebook").item(0).getNodeValue());
		c.setEmail(document.getElementsByTagName("email").item(0).getNodeValue());
		c.setLinkedIn(document.getElementsByTagName("linkedin").item(0).getNodeValue());
		c.setGooglePlus(document.getElementsByTagName("google_plus").item(0).getNodeValue());
		c.setTwitter(document.getElementsByTagName("twitter").item(0).getNodeValue());
		c.setViadeo(document.getElementsByTagName("viadeo").item(0).getNodeValue());
		c.setWebPerso("web_perso");
		c.setWebPro(document.getElementsByTagName("web_pro").item(0).getNodeValue());
		c.setSociety(document.getElementsByTagName("society").item(0).getNodeValue());
		c.setSiret(document.getElementsByTagName("siret").item(0).getNodeValue());
		
		NodeList xmlLlientReferences = document.getElementsByTagName("reference");
		
		return c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
