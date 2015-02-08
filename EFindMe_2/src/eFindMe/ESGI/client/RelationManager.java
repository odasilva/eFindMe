package eFindMe.ESGI.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;




public class RelationManager extends JFrame implements ActionListener{
	
	private Customer client;
	private  Document document;
	private ClientRelationGraph clientGraph;
	
	private JLabel sourceLabel,linkLabel,appreciationLabel;
	
	
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
			southPanel.setLayout(null);
			
			JButton btnSupprimer = new JButton("Supprimer");
			btnSupprimer.addActionListener(new ActionListener()
			{
				  public void actionPerformed(ActionEvent e)
				  {
					 clientGraph.deleteSelectedReference();
				  }
				});
			
			btnSupprimer.setBounds(172, 71, 97, 25);
			southPanel.add(btnSupprimer);
			
			
			JPanel eastPanel = new JPanel();
			eastPanel.setBorder(BorderFactory.createTitledBorder("Description"));
			eastPanel.setBackground(Color.WHITE);
			
			eastPanel.setPreferredSize(new Dimension(250, 250));
			getContentPane().add(eastPanel, BorderLayout.EAST);
			BoxLayout eastPanelLayout = new BoxLayout(eastPanel, BoxLayout.Y_AXIS);
			eastPanel.setLayout(eastPanelLayout);
			
			eastPanel.add(Box.createRigidArea(new Dimension(50,120)));
			sourceLabel = new JLabel("");
			eastPanel.add(sourceLabel);
			eastPanel.add(Box.createRigidArea(new Dimension(50,120)));
			linkLabel = new JLabel("");
			eastPanel.add(linkLabel);
			eastPanel.add(Box.createRigidArea(new Dimension(50,120)));
			appreciationLabel = new JLabel("");
			eastPanel.add(appreciationLabel);
			eastPanel.add(Box.createRigidArea(new Dimension(50,120)));
			
			JButton btnVerifierLien = new JButton("V�rifier");
			btnVerifierLien.addActionListener(new ActionListener()
			{
				  public void actionPerformed(ActionEvent e)
				  {
					  try {
						Reference selectedReference = (Reference)clientGraph.selectedCell.getValue();
						Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + selectedReference.getUrl());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				  }
				});
			
			eastPanel.add(btnVerifierLien);
			
			JPanel centerPanel = new JPanel();
			centerPanel.setBorder(BorderFactory.createTitledBorder("Relations de " + client.getSociety()));
			centerPanel.setPreferredSize(new Dimension(400,400));
			centerPanel.setLayout(new BorderLayout());
			clientGraph = new ClientRelationGraph(this,client,document);
			centerPanel.add(clientGraph,BorderLayout.CENTER);
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
			setExtendedState( getExtendedState()|JFrame.MAXIMIZED_BOTH );
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private Customer LoadClient() {
		
		String clientName = document.getElementsByTagName("name").item(0).getTextContent();
		String clientFirstName = document.getElementsByTagName("name").item(0).getTextContent();
		Customer c = new Customer(clientName,clientFirstName);
		c.setPseudo(document.getElementsByTagName("pseudo").item(0).getTextContent());
		c.setFacebook(document.getElementsByTagName("facebook").item(0).getTextContent());
		c.setEmail(document.getElementsByTagName("email").item(0).getTextContent());
		c.setLinkedIn(document.getElementsByTagName("linkedin").item(0).getTextContent());
		c.setGooglePlus(document.getElementsByTagName("google_plus").item(0).getTextContent());
		c.setTwitter(document.getElementsByTagName("twitter").item(0).getTextContent());
		c.setViadeo(document.getElementsByTagName("viadeo").item(0).getTextContent());
		c.setWebPerso(document.getElementsByTagName("web_perso").item(0).getTextContent());
		c.setWebPro(document.getElementsByTagName("web_pro").item(0).getTextContent());
		c.setSociety(document.getElementsByTagName("society").item(0).getTextContent());
		c.setSiret(document.getElementsByTagName("siret").item(0).getTextContent());
		
		NodeList xmlClientReferences = document.getElementsByTagName("reference").item(0).getChildNodes();
		
		for(int i = 1; i < xmlClientReferences.getLength(); i ++)
		{
			String source = xmlClientReferences.item(i).getNodeName();
			
			for(int j = 1; j < xmlClientReferences.item(i).getChildNodes().getLength();j++)
			{
				if(xmlClientReferences.item(i).getChildNodes().item(j).getNodeName() == "url")
				{
					String url = xmlClientReferences.item(i).getChildNodes().item(j).getTextContent();
					String positive="";
					if(xmlClientReferences.item(i).getChildNodes().item(j).hasAttributes())
					{
						NamedNodeMap test = xmlClientReferences.item(i).getChildNodes().item(j).getAttributes();
						Node positiveAttr = xmlClientReferences.item(i).getChildNodes().item(j).getAttributes().getNamedItem("positive");
						if(positiveAttr != null)
						positive = xmlClientReferences.item(i).getChildNodes().item(j).getAttributes().getNamedItem("positive").getTextContent();
					}
				
					Reference r = new Reference(source, url, positive);
					c.getReferencesList().add(r);
				}
			}
		}
		
		return c;
	}
	
	public void setDescription(Reference ref)
	{
		sourceLabel.setText("Source: " + ref.getSource());
		linkLabel.setText("Lien: " + ref.getUrl());
		if(ref.getIsPositive() == "")
			appreciationLabel.setText("Appreciation: A v�rifier");
		else
			if(ref.getIsPositive().equals("true"))
				appreciationLabel.setText("Appreciation: positive");
			else
				if(ref.getIsPositive().equals("false"))
					appreciationLabel.setText("Appreciation: n�gative");
			
	}
    

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		clientGraph = null;
		super.dispose();
	}
}
