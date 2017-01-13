package codice.fiscale;

public abstract class GeneratoreCodice {
	protected GeneratoreCodice nextHandler;
	abstract void generaCodice(final Persona pers, StringBuilder soFar);
	public void nextHandler(GeneratoreCodice next){
		this.nextHandler = next;
	}
}
