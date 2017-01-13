package codice.fiscale;

import java.util.HashMap;
import java.util.Map;

public class GeneratoreCodiceNascitaSesso extends GeneratoreCodice {
	private Map<Integer, Character> mapMonth = new HashMap<>();

	public GeneratoreCodiceNascitaSesso() {
		initMap();
	}

	private void initMap() {
		mapMonth.put(1, 'A');
		mapMonth.put(2, 'B');
		mapMonth.put(3, 'C');
		mapMonth.put(4, 'D');
		mapMonth.put(5, 'E');
		mapMonth.put(6, 'H');
		mapMonth.put(7, 'L');
		mapMonth.put(8, 'M');
		mapMonth.put(9, 'P');
		mapMonth.put(10, 'R');
		mapMonth.put(11, 'S');
		mapMonth.put(12, 'T');
	}

	@Override
	void generaCodice(final Persona pers, StringBuilder soFar) {
		if (soFar.length() < 9) {
			String[] dati = pers.getDataNascita().split(" ");
			String lastTwoChar = dati[2].substring(dati[2].length() - 2);
			soFar.append(lastTwoChar);

			soFar.append(getLetterMapped(Integer.parseInt(dati[1])));
			int days_of_month = Integer.parseInt(dati[0]);
			if(pers.getSesso() == "F" || pers.getSesso() == "f")
				days_of_month += 40;
			if (days_of_month <= 9)
				soFar.append("0");
			soFar.append(days_of_month);
		}
		if (nextHandler != null)
			nextHandler.generaCodice(pers, soFar);

	}

	private char getLetterMapped(int month_of_birth) {
		if (mapMonth.containsKey(month_of_birth))
			return mapMonth.get(month_of_birth);
		throw new IllegalArgumentException("Errore nel mese di nascita");
	}

}
