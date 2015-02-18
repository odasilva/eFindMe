package eFindMe.ESGI.client;

import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


public class SearchRelation extends JFrame {
	private Customer client;
	private  Document document;
	private Document doc;
	private Element root;
	private Element root_Cust;
	private Element root_Reference;
	private ArrayList<String> ListRef;
	private ArrayList<String> ListUrlClient;
	
	public SearchRelation(String xml){
		
		ListUrlClient = new ArrayList<String>();
		DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();
		DocumentBuilder constructeur;
		
		try {
			constructeur = fabrique.newDocumentBuilder();
			document = constructeur.parse(xml);
			doc = constructeur.newDocument();
			
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		client = LoadClient();
		
		root = doc.createElement("EfindMe");
		
		root_Cust = doc.createElement("customer");
		
		Element name = doc.createElement("name");
		name.appendChild(doc.createTextNode(client.getName()));
		root_Cust.appendChild(name);
		
		
		Element first_name = doc.createElement("first_name");
		first_name.appendChild(doc.createTextNode(client.getSurname()));
		root_Cust.appendChild(first_name);

		Element pseudo = doc.createElement("pseudo");
		pseudo.appendChild(doc.createTextNode(client.getPseudo()));
		root_Cust.appendChild(pseudo);

		Element society = doc.createElement("society");
		society.appendChild(doc.createTextNode(client.getSociety()));
		root_Cust.appendChild(society);

		Element siret = doc.createElement("siret");
		siret.appendChild(doc.createTextNode(client.getSiret()));
		root_Cust.appendChild(siret);
	
		Element facebook = doc.createElement("facebook");
		facebook.appendChild(doc.createTextNode(client.getFacebook()));
		root_Cust.appendChild(facebook);

		Element twitter = doc.createElement("twitter");
		twitter.appendChild(doc.createTextNode(client.getTwitter()));
		root_Cust.appendChild(twitter);

		Element google_plus = doc.createElement("google_plus");
		google_plus.appendChild(doc.createTextNode(client.getGooglePlus()));
		root_Cust.appendChild(google_plus);

		Element linkedin = doc.createElement("linkedin");
		linkedin.appendChild(doc.createTextNode(client.getLinkedIn()));
		root_Cust.appendChild(linkedin);
	
		Element viadeo = doc.createElement("viadeo");
		viadeo.appendChild(doc.createTextNode(client.getViadeo()));
		root_Cust.appendChild(viadeo);
	
		Element web_perso = doc.createElement("web_perso");
		web_perso.appendChild(doc.createTextNode(client.getWebPerso()));
		root_Cust.appendChild(web_perso);
	
		Element web_pro = doc.createElement("web_pro");
		web_pro.appendChild(doc.createTextNode(client.getWebPro()));
		root_Cust.appendChild(web_pro);
		
		Element email = doc.createElement("email");
		email.appendChild(doc.createTextNode(client.getEmail()));
		root_Cust.appendChild(email);

		root.appendChild(root_Cust);
		
		//Reference
		root_Reference = doc.createElement("reference");
	
		fillUrlClient(client);
		
			if(client.getSurname() != "" && client.getName()!= "")
				fillReference(client.getSurname()+" "+client.getName(), "name_firstname_reference", client);
		
			if(client.getPseudo() != "")
				fillReference(client.getPseudo(), "pseudo", client);
			
			if(client.getSociety() != "")
				fillReference(client.getSociety(), "society", client);
			
			if(client.getSiret() != "")
				fillReference(client.getSiret(), "siret", client);
			
			if(client.getFacebook() != "")
				fillReference(client.getFacebook(), "facebook", client);
			
			if(client.getTwitter() != "")
				fillReference(client.getTwitter(), "twitter", client);
			
			if(client.getGooglePlus() != "")
				fillReference(client.getGooglePlus(), "google_plus", client);
			
			if(client.getLinkedIn() != "")
				fillReference(client.getLinkedIn(), "linkedin", client);
			
			if(client.getViadeo() != "")
				fillReference(client.getViadeo(), "viadeo", client);
			
			if(client.getWebPerso() != "")
				fillReference(client.getWebPerso(), "web_perso", client);
			
			if(client.getWebPro() != "")
				fillReference(client.getWebPro(), "web_pro", client);
			
			if(client.getEmail() != "")
				fillReference(client.getEmail(), "email", client);
			
		
		
		
		root.appendChild(root_Reference);
		
		doc.appendChild(root);

		saveXml("customer_"+client.getSurname()+"_"+client.getName()+".xml");
		
		
		
	}
	
	private void fillReference(String s, String element, Customer client){

		Element ref = doc.createElement(element);
						
		
		
		ListRef = new ArrayList<String>();
		
		ListRef = (ArrayList<String>) GoogleSearch.search(s);

		
		for (String string : ListRef) {
			Element url = doc.createElement("url");
			url.setAttribute("Positive", isPositive(string, client));
			url.appendChild(doc.createTextNode(string));
			ref.appendChild(url);
			
		}
		root_Reference.appendChild(ref);
		
	}
	
	private String isPositive(String url, Customer client){
		String s = "";
		
		if(url.equals(client.getFacebook()) 
		|| url.equals(client.getTwitter()) 
		|| url.equals(client.getGooglePlus())  
		|| url.equals(client.getLinkedIn())
		|| url.equals(client.getWebPerso())
		|| url.equals(client.getWebPro())
		|| GoogleSearch.searchReference(ListUrlClient,url))
		s = "true";
					
		return s;
		
	}
	
	private void fillUrlClient(Customer client) {
		
		ListUrlClient.add(client.getFacebook());
		ListUrlClient.add(client.getTwitter());
		ListUrlClient.add(client.getGooglePlus());  
		ListUrlClient.add(client.getLinkedIn());
		ListUrlClient.add(client.getWebPerso());
		ListUrlClient.add(client.getWebPro());
		
	}
	
	private Customer LoadClient() {
		
		String clientName = document.getElementsByTagName("name").item(0).getTextContent();
		String clientFirstName = document.getElementsByTagName("name").item(0).getTextContent();
		Customer c = new Customer(clientName,clientFirstName);
		
		if(document.getElementsByTagName("pseudo").item(0) != null)
			c.setPseudo(document.getElementsByTagName("pseudo").item(0).getTextContent());

		if(document.getElementsByTagName("facebook").item(0) != null)
			c.setFacebook(document.getElementsByTagName("facebook").item(0).getTextContent());

		if(document.getElementsByTagName("email").item(0) != null)
			c.setEmail(document.getElementsByTagName("email").item(0).getTextContent());

		if(document.getElementsByTagName("linkedin").item(0) != null)
			c.setLinkedIn(document.getElementsByTagName("linkedin").item(0).getTextContent());
		
		if(document.getElementsByTagName("google_plus").item(0) != null)
			c.setGooglePlus(document.getElementsByTagName("google_plus").item(0).getTextContent());

		if(document.getElementsByTagName("twitter").item(0) != null)
			c.setTwitter(document.getElementsByTagName("twitter").item(0).getTextContent());

		if(document.getElementsByTagName("viadeo").item(0) != null)
			c.setViadeo(document.getElementsByTagName("viadeo").item(0).getTextContent());

		if(document.getElementsByTagName("web_perso").item(0) != null)
			c.setWebPerso(document.getElementsByTagName("web_perso").item(0).getTextContent());

		if(document.getElementsByTagName("web_pro").item(0) != null)
			c.setWebPro(document.getElementsByTagName("web_pro").item(0).getTextContent());

		if(document.getElementsByTagName("society").item(0) != null)
			c.setSociety(document.getElementsByTagName("society").item(0).getTextContent());

		if(document.getElementsByTagName("siret").item(0) != null)
			c.setSiret(document.getElementsByTagName("siret").item(0).getTextContent());
			
		return c;
	}
	
	public void saveXml(String nameFile){

		File fichierXML = new File("src/Graph/"+nameFile);
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter(fichierXML));
			generateXMLFile(doc,fichierXML);
			out.close();
			JOptionPane.showMessageDialog(this, "Le client a bien été enregistré.");
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
}
