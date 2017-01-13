package codice.fiscale;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static GestoreHandler handler;

	public static void main(String[] args) throws Exception {
		String cognome, nome, sesso, luogoNascita, dataNascista;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			System.out.println("Calcolo codice fiscale");
			System.out.println("Inserire il cognome: ");
			cognome = br.readLine();
			System.out.println("Inserire il nome: ");
			nome = br.readLine();
			System.out.println("Inserire il sesso: ");
			sesso = br.readLine();
			System.out.println("Inserire il luogo di nascita: ");
			luogoNascita = br.readLine();
			System.out.println("Inserire data nascita formato(giorno mese anno ex : 26 8 1986): ");
			dataNascista = br.readLine();
			if(dataNascista != null){
				Persona persona = new Persona(cognome, nome, dataNascista, sesso, luogoNascita);
				handler =  new GestoreHandler(Main.class.newInstance());
				handler.generaCodice(persona, new StringBuilder());
			}
			
		};
		
	}

	public void print(StringBuilder codiceFiscale) {
		System.out.println(codiceFiscale.toString());
	}

}
