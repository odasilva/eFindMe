package eFindMe.ESGI.client;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SearchRelation {
	private Customer client;
	private  Document document;
	
	public SearchRelation(String xml){
		
		DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();
		DocumentBuilder constructeur;
		
		try {
			constructeur = fabrique.newDocumentBuilder();
			document = constructeur.parse(xml);
			
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		client = LoadClient();
		
		
		
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
}