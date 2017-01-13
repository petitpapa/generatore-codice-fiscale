package codice.fiscale;

public abstract class GeneratoreNome extends GeneratoreCodice {
	private static final String INSUFFICIENT_CHAR = "X";
	protected String vowel = "aiueoyAIUEOY";
	protected int length = 0;

	protected void generaCodice(Persona pers, StringBuilder soFar) {
		String nome = getName(pers);
		boolean done = false;
		StringBuilder consonant = new StringBuilder();
		StringBuilder vocaliContenuti = new StringBuilder();
		divideConsonantFromVowel(nome, consonant, vocaliContenuti);

		if (checkLentgh(soFar)) {
			for (int i = 0; i < consonant.length() && !done; i++) {
				if (consonant.length() >= 4 && i == 1) 
						continue;
				soFar.append(consonant.charAt(i));
				if (upperLimit(soFar))
					done = true;
			}

			for (int i = 0; i < vocaliContenuti.length() && checkLentgh(soFar); i++)
				soFar.append(vocaliContenuti.charAt(i));

			while (checkLentgh(soFar))
				soFar.append(INSUFFICIENT_CHAR);
		}
		if (nextHandler != null)
			nextHandler.generaCodice(pers, soFar);

	}

	private void divideConsonantFromVowel(String nome, StringBuilder consonant, StringBuilder vowel) {

		for (int i = 0; i < nome.length(); i++) {
			if (isConsonant(nome, i)) {
				consonant.append(nome.charAt(i));
			} else
				vowel.append(nome.charAt(i));
		}
	}

	private boolean isConsonant(String nome, int i) {
		return vowel.indexOf(nome.charAt(i)) == -1;
	}

	protected int getLength() {
		return length;
	}

	abstract String getName(Persona pers);

	abstract boolean checkLentgh(StringBuilder sb);

	abstract boolean upperLimit(StringBuilder sb);
}
