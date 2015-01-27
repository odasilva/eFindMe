package eFindMe.fr.client;

public class Customer {
	
	private String name,surname,facebook,LinkedIn,society,siret;
	
	public void Customer(String customerName,String customerSurname,String FB, String LK,String societyName, String sirett)
	{
		name = customerName;
		surname = customerSurname;
		facebook = FB;
		LinkedIn = LK;
		society = societyName;
		siret = sirett;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	
}
