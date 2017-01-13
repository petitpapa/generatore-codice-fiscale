package codice.fiscale;

import java.util.Map;

public class GeneratoreCodiceStato extends GeneratoreCodice {
	
	private Map<String, String> stateCode;

	public GeneratoreCodiceStato(Map<String, String> codeStateMap) {
		this.stateCode = codeStateMap;
	}

	@Override
	void generaCodice(Persona pers, StringBuilder soFar) {
		if(soFar.length() < 15){
			String state = pers.getLuogo_nascita().toUpperCase();
			soFar.append(getStateCode(state));
		}
		if(nextHandler != null)
			nextHandler.generaCodice(pers, soFar);

	}

	private String getStateCode(String state) {
		if(stateCode.containsKey(state))
			return stateCode.get(state);
		throw new IllegalStateException("il codice stato non esiste");
	}

}
