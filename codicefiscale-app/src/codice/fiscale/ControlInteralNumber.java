package codice.fiscale;

import java.util.Map;

public class ControlInteralNumber extends GeneratoreCodice {

	private final Map<String, String> oddCharMap;
	private final Map<String, String> evenCharMap;
	private final Map<String, String> remainingMap;

	public ControlInteralNumber(Map<String, String> oddDigitMap, Map<String, String> even_digit,
			Map<String, String> resto_map) {
		this.oddCharMap = oddDigitMap;
		this.evenCharMap = even_digit;
		this.remainingMap = resto_map;
	}

	@Override
	void generaCodice(Persona pers, StringBuilder soFar) {
		int somma = 0;
		if(soFar.length() < 16){
			for(int i = 0; i < soFar.length(); i++){
				String c = Character.toString(soFar. charAt(i)).toUpperCase();
				if((i+1) % 2 == 0){
					somma += Integer.parseInt(evenCharMap.get(c));
				}
				else {
					somma += Integer.parseInt(oddCharMap.get(c));
				}
			}
			int resto = somma % 26;
			String letter = remainingMap.get(Integer.toString(resto));
			soFar.append(letter);
		}
		if(nextHandler != null)
			nextHandler.generaCodice(pers, soFar);
	}

}
