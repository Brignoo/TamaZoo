package it.unibs.ing.fp.lab.TamaZoo;

public class TamaGordo extends Tamagotchi{
	
	private static final int SODDISFAZIONE = 100;
	private static final int TRISTEZZA_SAZIETA = 30;
	private static final int MIN_SAZIETA = 0;
	
	private static final String FELICE = ":)";
	private static final String TRISTE = ":(";

	/** Costruttore della classe TamaGordo
	 * @param nome il nome che avrà il <em>Tamagotchi</em> il nuovo aggetto
	 * @param sazieta il valore di sazietà iniziale che avrà questa istanza
	 */
	public TamaGordo(String nome, double sazieta) {
		super(nome, SODDISFAZIONE, sazieta);
	}
	
	
	/** Questo metodo decrementa la sazietà del <em>Tamagotchi</em>
	 * @param n parametro che viene utilizzato per decrementare l'attuale grado di sazietà
	 */
	@Override
	public void decrementaSazieta( int n) {
		
		double q = super.getGradoSazieta();
		q -= n;
		
		super.setGradoSazieta( q );
	}
	
	
	/** Viene fatto un'overraide di questo metodo per evitare di decrementare la soddisfazione
	 * @param n Questo parametro serve per effettuare l'override del metodo nella classe <em>Tamagotchi.java</em>
	 */
	@Override
	public void decrementaSoddisfazione( int n) {
		
	}
	
	
	/**
	 * Questa funzione viene utilizzate per controllare se il <em>Tamagotchi</em>
	 *  felice o triste.
	 * 
	 * @return Esegue un return di tipo <code>boolean</code> che sarà
	 *  <em>vero</em> se il <em>Tamagotchi</em> risulta triste,
	 *  <em>falso</em> se felice.
	 */
	@Override
	public boolean sonoTriste() {
		
		if( super.getGradoSazieta() <= TRISTEZZA_SAZIETA ) {
			
			return true;
		}

		return false;
	}
	
	
	/**
	 * Questo metodo produce una stringa che rappresenta lo stato del tamagotchi in funzione del grado di benessere generale
	 * @return String ritorna la stringa che visualizza l'espressione
	 */
	@Override
	public String felicita() {
		
		if(super.getGradoSazieta() <= TRISTEZZA_SAZIETA ) {
			
			return TRISTE;
		}
		
		return FELICE;
	}
	
	
	/**
	 * Restituisce una rappresentazione leggibile di un oggetto della classe
	 * <strong>TamaGordo</strong>
	 * 
	 * @return Una <code>String</co de> che rappresenta un <strong>TamaGordo</strong>
	 */
	@Override
	public boolean sonoMorto( ) {

		if( super.getGradoSazieta() == MIN_SAZIETA ){

			return true;
		}

		return false;
	}
}
