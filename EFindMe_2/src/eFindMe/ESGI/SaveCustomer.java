package eFindMe.ESGI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.parsers.*; 
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;

public class SaveCustomer extends JFrame implements ActionListener
{
	private DocumentBuilderFactory fabrique;
	private DocumentBuilder constructeur;
	private Document doc;
	private Element root;
	
	//Interface
	private JPanel container = new JPanel();
	private Font police = new Font("Arial", Font.BOLD, 14);
	private JPanel top = new JPanel();
	private JButton b = new JButton ("Enregistrer");
	 
	//JTextField & JLabel
	private JTextField jtf_name = new JTextField();
	private JLabel label_name = new JLabel("Nom * : ");
	private JTextField jtf_first_name = new JTextField();
	private JLabel label_first_name = new JLabel("Prénom * : ");
	private JTextField jtf_pseudo = new JTextField();
	private JLabel label_pseudo = new JLabel("Pseudo : ");
	private JTextField jtf_society = new JTextField();
	private JLabel label_society = new JLabel("Société * : ");
	private JTextField jtf_siret = new JTextField();
	private JLabel label_siret = new JLabel("Siret * : ");
	private JTextField jtf_facebook = new JTextField();
	private JLabel label_facebook = new JLabel("Facebook : ");
	private JTextField jtf_twitter = new JTextField();
	private JLabel label_twitter = new JLabel("Twitter : ");
	private JTextField jtf_google_plus = new JTextField();
	private JLabel label_google_plus = new JLabel("Google + : ");
	private JTextField jtf_linkedin = new JTextField();
	private JLabel label_linkedin = new JLabel("Linkedin : ");
	private JTextField jtf_viadeo = new JTextField();
	private JLabel label_viadeo = new JLabel("Viadeo : ");
	private JTextField jtf_web_perso = new JTextField();
	private JLabel label_web_perso = new JLabel("Web Perso : ");
	private JTextField jtf_web_pro = new JTextField();
	private JLabel label_web_pro = new JLabel("Web Pro : ");
	private JTextField jtf_email = new JTextField();
	private JLabel label_email = new JLabel("Email * : ");
  
	public SaveCustomer(){
		
		fabrique = DocumentBuilderFactory.newInstance();
	
		try {
			constructeur = fabrique.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		doc = constructeur.newDocument();
				
		//Interface
		this.setTitle("Créer un Client");
		this.setSize(640, 540);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		top.setLayout(new GridLayout(14,1));
		
		addLabel_Text(jtf_name,label_name);
		addLabel_Text(jtf_first_name,label_first_name);
		addLabel_Text(jtf_pseudo,label_pseudo);
		addLabel_Text(jtf_society,label_society);
		addLabel_Text(jtf_siret,label_siret);
		addLabel_Text(jtf_facebook,label_facebook);
		addLabel_Text(jtf_twitter,label_twitter);
		addLabel_Text(jtf_google_plus,label_google_plus);
		addLabel_Text(jtf_linkedin,label_linkedin);
		addLabel_Text(jtf_viadeo,label_viadeo);
		addLabel_Text(jtf_web_perso,label_web_perso);
		addLabel_Text(jtf_web_pro,label_web_pro);
		addLabel_Text(jtf_email,label_email);
		b.addActionListener(this);
		top.add(b);
		
		container.add(top, BorderLayout.CENTER);
		this.setContentPane(container);
		this.setVisible(true);
	
	}
	
	public void addLabel_Text(JTextField jtf, JLabel jl){
		
		jtf.setFont(police);
		jtf.setPreferredSize(new Dimension(150, 30));
		jtf.setForeground(Color.BLUE);
		top.add(jl);
		top.add(jtf);	
	}
	
	
	public void funcSave(){
		
		root = doc.createElement("customer");
		String dialog = "Vous devez renseigner : ";
		
		if(!jtf_name.getText().equals("")){
			jtf_name.setBackground(Color.WHITE);
			Element name = doc.createElement("name");
			name.appendChild(doc.createTextNode(jtf_name.getText()));
			root.appendChild(name);
		}else{
			jtf_name.setBackground(Color.red);
			dialog += "le nom, ";
		}
		
		if(!jtf_first_name.getText().equals("")){
			jtf_first_name.setBackground(Color.WHITE);
			Element first_name = doc.createElement("first_name");
			first_name.appendChild(doc.createTextNode(jtf_first_name.getText()));
			root.appendChild(first_name);
		}else{
			jtf_first_name.setBackground(Color.red);
			dialog += "le prénom, ";
		}
		
		if(!jtf_pseudo.getText().equals("")){
			Element pseudo = doc.createElement("pseudo");
			pseudo.appendChild(doc.createTextNode(jtf_pseudo.getText()));
			root.appendChild(pseudo);
		}
		
		if(!jtf_society.getText().equals("")){
			jtf_society.setBackground(Color.WHITE);
		  	Element society = doc.createElement("society");
			society.appendChild(doc.createTextNode(jtf_society.getText()));
			root.appendChild(society);
		}else{
			jtf_society.setBackground(Color.red);
			dialog += "le nom de la société, ";
		}
		
		if(!jtf_siret.getText().equals("")){
			jtf_siret.setBackground(Color.WHITE);
		  	Element siret = doc.createElement("siret");
			siret.appendChild(doc.createTextNode(jtf_siret.getText()));
			root.appendChild(siret);
		}else{
			jtf_siret.setBackground(Color.red);
			dialog += "le Siret, ";
		}
		
		if(!jtf_facebook.getText().equals("")){
		  	Element facebook = doc.createElement("facebook");
			facebook.appendChild(doc.createTextNode(jtf_facebook.getText()));
			root.appendChild(facebook);
		}
		
		if(!jtf_twitter.getText().equals("")){
		  	Element twitter = doc.createElement("twitter");
			twitter.appendChild(doc.createTextNode(jtf_twitter.getText()));
			root.appendChild(twitter);
		}
		
		if(!jtf_google_plus.getText().equals("")){
		  	Element google_plus = doc.createElement("google_plus");
			google_plus.appendChild(doc.createTextNode(jtf_google_plus.getText()));
			root.appendChild(google_plus);
		}
		
		if(!jtf_linkedin.getText().equals("")){
			Element linkedin = doc.createElement("linkedin");
			linkedin.appendChild(doc.createTextNode(jtf_linkedin.getText()));
			root.appendChild(linkedin);
		}
		
		if(!jtf_viadeo.getText().equals("")){
		  	Element viadeo = doc.createElement("viadeo");
			viadeo.appendChild(doc.createTextNode(jtf_viadeo.getText()));
			root.appendChild(viadeo);
		}
		
		if(!jtf_web_perso.getText().equals("")){
		  	Element web_perso = doc.createElement("web_perso");
			web_perso.appendChild(doc.createTextNode(jtf_web_perso.getText()));
			root.appendChild(web_perso);
		}
		
		if(!jtf_web_pro.getText().equals("")){
		  	Element web_pro = doc.createElement("web_pro");
			web_pro.appendChild(doc.createTextNode(jtf_web_pro.getText()));
			root.appendChild(web_pro);
		}
		
		if(!jtf_email.getText().equals("")){
			jtf_email.setBackground(Color.WHITE);
		  	Element email = doc.createElement("email");
			email.appendChild(doc.createTextNode(jtf_email.getText()));
			root.appendChild(email);
		}else{
			jtf_email.setBackground(Color.red);
			dialog += "l'adresse email ";
		}
		
		if(!jtf_name.getText().equals("") && !jtf_first_name.getText().equals("") && !jtf_society.getText().equals("") && !jtf_siret.getText().equals("") && !jtf_email.getText().equals("")){
			doc.appendChild(root);
			saveXml("customer_"+jtf_name.getText()+"_"+jtf_first_name.getText()+".xml");
		}else{
			JOptionPane.showMessageDialog(this, dialog, "Attention", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	public void saveXml(String nameFile){

		File fichierXML = new File(nameFile);
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter(fichierXML));
			generateXMLFile(doc,fichierXML);
			out.close();
			JOptionPane.showMessageDialog(this, "Le client a bien été enregistrer.");
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	static private void generateXMLFile(Document doc, File file){
        Source s=new DOMSource(doc);
        // le résultat de cette transformation sera un flux d'écriture dans
        // un fichier
        Result resultat = new StreamResult(file);
         
        // création du transformateur XML
        Transformer transfo = null;
        try {
            transfo = TransformerFactory.newInstance().newTransformer();
        } catch(TransformerConfigurationException e) {
            System.err.println("Impossible de créer un transformateur XML.");
            System.exit(1);
        }
         
        // configuration du transformateur
         
        // sortie en XML
        transfo.setOutputProperty(OutputKeys.METHOD, "xml");
         
        // inclut une déclaration XML (recommandé)
        transfo.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
         
        // codage des caractères : UTF-8. Ce pourrait être également ISO-8859-1
        transfo.setOutputProperty(OutputKeys.ENCODING, "utf-8");
         
        // idente le fichier XML
        transfo.setOutputProperty(OutputKeys.INDENT, "yes");
         
        try {
            transfo.transform(s, resultat);
        } catch(TransformerException e) {
            System.err.println("La transformation a échoué : " + e);
            System.exit(1);
        }

}
	
	public static void main(String[] args) {
		
		SaveCustomer saveCustomer = new SaveCustomer();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		funcSave();
	}

}
