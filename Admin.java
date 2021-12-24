package mr.iscae.projetjavaee;

public class Admin {
	private String identifiant;
	private String motDePasse;
	
	Admin(){
		this.identifiant="admin";
		this.motDePasse="admin";
	}
	public String getIdentifiant() {
		return identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
}
