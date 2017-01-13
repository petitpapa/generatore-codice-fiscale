package codice.fiscale;

public class Persona {
	private String cognome;
	private String nome;
	private String dataNascita;
	//private enum Sesso{M,F};
	private String sesso;
	private String Luogo_nascita;
	public Persona(String cognome, String nome) {
		this(cognome, nome, null, null, null);
	}
	
	
	public Persona(String cognome, String nome, String dataNascita, String sesso, String luogo_nascita) {
		super();
		this.cognome = cognome;
		this.nome = nome;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
		Luogo_nascita = luogo_nascita;
	}


	public Persona() {
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDataNascita() {
		return dataNascita;
	}


	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}


	public String getSesso() {
		return sesso;
	}


	public void setSesso(String sesso) {
		this.sesso = sesso;
	}


	public String getLuogo_nascita() {
		return Luogo_nascita;
	}


	public void setLuogo_nascita(String luogo_nascita) {
		Luogo_nascita = luogo_nascita;
	}

	
}
