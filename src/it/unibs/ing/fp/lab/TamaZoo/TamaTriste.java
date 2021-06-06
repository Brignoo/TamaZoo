package it.unibs.ing.fp.lab.TamaZoo;

/**
 * Classe Tamatriste, Tamagotchi sempre tristi indipendentemente dai valori di soddifazione e sazietà.
 */
public class TamaTriste extends Tamagotchi{
	
	private static final int MAX_SAZIETA = 100;
	private static final String TRISTE = ":(";
	private static final int MIN_SODDISFAZIONE = 0;

	public TamaTriste(String nome, double sazieta) {
		super(nome, MIN_SODDISFAZIONE, sazieta);
		
	}
	
	
	/**
	 * Questa funzione viene utilizzate per controllare se il <em>TamaTriste</em>
	 *  felice o triste.
	 * 
	 * @return Esegue un return di tipo <code>boolean</code> che sarà
	 *  <em>vero</em> se il <em>TamaTriste</em> risulta triste,
	 *  <em>falso</em> se felice.
	 */
	@Override
	public boolean sonoTriste() {

		return true;
	}
	
	
	/**
	 * Questa funzione viene utilizzate per controllare se il <em>TamaTriste</em>
	 *  è morto.
	 * 
	 * @return Esegue un return di tipo <code>boolean</code> che sarà
	 *  <em>vero</em> se il <em>TamaTriste</em> risulta morto,
	 *  <em>falso</em> se vivo.
	 */
	@Override
	public boolean sonoMorto( ) {

		if(super.getGradoSazieta() == 0 || super.getGradoSazieta() == MAX_SAZIETA){

			return true;
		}

		return false;
	}
	
	
	/**
	 * Restituisce una rappresentazione leggibile di un oggetto della classe
	 * <strong>TamaTriste</strong>
	 * 
	 * @return Una <code>String</co de> che rappresenta un <strong>TamaTriste</strong>
	 */
	@Override
	public String felicita() {	
		return TRISTE;
		
	}
}