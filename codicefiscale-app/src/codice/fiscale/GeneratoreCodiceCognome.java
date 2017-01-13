package codice.fiscale;

public class GeneratoreCodiceCognome extends GeneratoreNome {
	
	@Override
	String getName(Persona pers) {
		return pers.getCognome();
	}

	@Override
	boolean checkLentgh(StringBuilder sb) {
		return sb.length() < 3;
	}

	@Override
	boolean upperLimit(StringBuilder sb) {
		return sb.length() == 3;
	}
	
	
}
