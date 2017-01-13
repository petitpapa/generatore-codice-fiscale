package codice.fiscale;

public class GeneratoreCodiceNome extends GeneratoreNome {

	@Override
	String getName(Persona pers) {
		return pers.getNome();
	}

	@Override
	boolean checkLentgh(StringBuilder sb) {
		return sb.length() < 6;
	}

	@Override
	boolean upperLimit(StringBuilder sb) {
		return sb.length() == 6;
	}
	
	
}
