public class Adresse {
	private int numero;
	private String nomRue;
	private int codePostal;
	private String ville;
	
	public int getNum() {
		return this.numero;
	}
	
	public String getNomRue() {
		return this.nomRue;
	}
	
	public int getCodeP() {
		return this.codePostal;
	}
	
	public String getVille() {
		return this.ville;
	}
	
	public void setNum(int nNum) {
		if (nNum > 0) {
			this.numero = nNum;
		}
	}
	
	public void setNomRue(String nRue) {
		if (nRue != "") {
			this.nomRue = nRue;
		}
	}
	
	public void setCodeP(int nCodeP) {
		if (nCodeP > 1000 && nCodeP < 100000) {
			this.codePostal = nCodeP;
		}
	}
	
	public void setVille(String nVille) {
		if (nVille != "") {
			this.ville = nVille;
		}
	}
	
	public String toString() {
		return "Adresse {\nNumero : " + this.numero + "\nNom rue : " + this.nomRue + "\nCode postal : "
			+ this.codePostal + "\nVille : " + this.ville + "\n}"
		;
	}
	
	public Adresse(int nNum, String nRue, int nCodeP, String nVille) {
		if (nNum > 0 && nRue != "" && nCodeP > 1000 && nCodeP < 100000 && nVille != "") {
			this.numero = nNum;
			this.nomRue = nRue;
			this.codePostal = nCodeP;
			this.ville = nVille;
		}
	}
}
