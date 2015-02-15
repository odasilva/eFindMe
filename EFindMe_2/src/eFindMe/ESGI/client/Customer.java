package eFindMe.ESGI.client;

import java.util.ArrayList;

public class Customer {
	
	private String name,surname,pseudo,facebook,twitter
	,LinkedIn,society,siret,googlePlus,viadeo,webPerso,webPro,email;
	
	private ArrayList<Reference> referencesList;
	
	public  Customer(String customerName,String customerFirstname)
	{
		name = customerName;
		surname = customerFirstname;
		setReferencesList(new ArrayList<Reference>());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getGooglePlus() {
		return googlePlus;
	}

	public void setGooglePlus(String googlePlus) {
		this.googlePlus = googlePlus;
	}

	public String getViadeo() {
		return viadeo;
	}

	public void setViadeo(String viadeo) {
		this.viadeo = viadeo;
	}

	public String getWebPerso() {
		return webPerso;
	}

	public void setWebPerso(String webPerso) {
		this.webPerso = webPerso;
	}

	public String getWebPro() {
		return webPro;
	}

	public void setWebPro(String webPro) {
		this.webPro = webPro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getLinkedIn() {
		return LinkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		LinkedIn = linkedIn;
	}

	public String getSociety() {
		return society;
	}

	public void setSociety(String society) {
		this.society = society;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public ArrayList<Reference> getReferencesList() {
		return referencesList;
	}

	public void setReferencesList(ArrayList<Reference> referencesList) {
		this.referencesList = referencesList;
	}

	
}
