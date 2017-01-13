package codice.fiscale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class GestoreHandler {
	private GeneratoreCodiceCognome genCognome;

	Map<String, String> codeStateMap = new HashMap<>();
	Map<String, String> oddDigitMap = new HashMap<>();
	Map<String, String> even_digit = new HashMap<>();
	Map<String, String> resto_map = new HashMap<>();
	Map<String, String> codice_uguale = new HashMap<>();

	private Main main;

	public GestoreHandler(Main main) throws Exception {
		getStateCode(codeStateMap, "comune_nascita.txt");
		getStateCode(oddDigitMap, "file_controllo_dispari.txt");
		getStateCode(even_digit, "file_controllo_pari.txt");
		getStateCode(resto_map, "file_resto.txt");
		getStateCode(codice_uguale, "file_codFis_uguali.txt");

		genCognome = new GeneratoreCodiceCognome();
		GeneratoreNome genNome = new GeneratoreCodiceNome();
		GeneratoreCodice gen_data_nascista_sesso = new GeneratoreCodiceNascitaSesso();
		GeneratoreCodice gen_CodiceStato = new GeneratoreCodiceStato(codeStateMap);
		GeneratoreCodice cin = new ControlInteralNumber(oddDigitMap, even_digit, resto_map);

		genCognome.nextHandler(genNome);
		genNome.nextHandler(gen_data_nascista_sesso);
		gen_data_nascista_sesso.nextHandler(gen_CodiceStato);
		gen_CodiceStato.nextHandler(cin);
		this.main = main;
		
	}

	private void getStateCode(Map<String, String> map, String fileName) throws Exception {
		URL loader = GestoreHandler.class.getResource(fileName);
		int i, j;
		if (fileName.equals("comune_nascita.txt")) {
			i = 1;
			j = 0;
		} else {
			i = 0;
			j = 1;
		}
		String line = null;
		try (BufferedReader br = new BufferedReader(new FileReader(loader.getFile()))) {
			while ((line = br.readLine()) != null) {
				String[] codesState;
				codesState = line.split("\\s+");
				if(codesState.length > 2)
					codesState[1] += codesState[2];
				map.put(codesState[i], codesState[j]);

			}

		}

	}

	public void generaCodice(Persona pers, StringBuilder codiceFiscale) {
		genCognome.generaCodice(pers, codiceFiscale);
		format(pers, codiceFiscale);
		main.print(codiceFiscale);
	}

	private void format(Persona pers, StringBuilder codiceFiscale) {
		String result = "";
		result += "###########CODICE_FISCALE_CALCOLATO########\n";
		result += "\t cognome: " + pers.getCognome() +  "   " + "nome: " + pers.getNome() +"\n";
		result += "\t codice fiscale: " + codiceFiscale.toString().toUpperCase();
		codiceFiscale.delete(0, codiceFiscale.length());
		codiceFiscale.append(result);
;	}
}
