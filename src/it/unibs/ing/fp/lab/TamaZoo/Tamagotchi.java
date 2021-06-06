package it.unibs.ing.fp.lab.TamaZoo;

import it.unibs.ing.fp.lab.mylib.BelleStringhe;
import it.unibs.ing.fp.lab.mylib.EstrazioniCasuali;

/**
 * <p>
 * La classe <strong>Tamagotchi</strong> contiene tute le informazioni del
 * tamagotchi al suo interno si trovano i metodi per modificare lo stato del
 * tamagotchi
 * </p>
 * 
 * @version 1.0
 */

public class Tamagotchi {

	private static final int MAX_SAZIETA = 100;
	private static final int MIN_SAZIETA = 0;
	private static final int MAX_SODDISFAZIONE = 100;
	private static final int MIN_SODDISFAZIONE = 0;

	private static final String FELICE = ":)";
	private static final String INDIFFERENTE = ":|";
	private static final String TRISTE = ":(";

	private static final int TRISTEZZA_SAZIETA = 30;
	private static final int TRISTEZZA_SODDISFAZIONE = 30;
	private static final int TRISTEZZA_SAZIETA_MAX = 90;

	private static final int MAX_AZIONE = 10;
	private static final int MIN_AZIONE = 5;

	/**
	 * Indica il <strong>grado di soddisfazione</strong> costantemente aggiornato
	 * del Tamagotchi
	 */
	private double gradoAffettivo;
	/**
	 * Indica il <strong>grado di sazietà</strong> costantemente aggiornato del
	 * Tamagotchi
	 */
	private double gradoSazieta;
	/**
	 * Indica il <strong>nome</strong> del Tamagotchi
	 */
	private String nome;

	/**
	 * Crea un oggetto della classe <strong>Tamagotchi</strong> specificando il
	 * <em>nome</em>, la <em>sazietà</em> e la <em>soddisfazione</em> ricevuti dalla
	 * classe <a href="TamaMain.html">TamaMain</a>.
	 * 
	 * @param nome          Indica il <em>nome</em> del Tamagotchi
	 * @param sazieta       Indica il grado iniziale di <em>sazietà</em> del
	 *                      Tamagotchi
	 * @param soddisfazione Indica il grado iniziale di <em>soddisfazione</em> del
	 *                      Tamagotchi
	 */
	public Tamagotchi(String nome, double soddisfazione, double sazieta) {

		this.nome = nome;
		this.gradoAffettivo = soddisfazione;
		this.gradoSazieta = sazieta;

		if (!controlloValori()) {

			throw new IllegalArgumentException();
		}
	}

	/**
	 * Restituisce il <strong>nome</strong> del <em>Tamagotchi</em>
	 * 
	 * @return Una <code>String</code> rappresentante il <strong>nome</strong> del
	 *         <em>Tamagotchi</em>
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Restituisce un <strong>numero casuale</strong> compreso tra
	 * <em>MIN_AZIONE</em> e <em>MAX_AZIONE</em>
	 * 
	 * @return Il numero casuale di tipo <code>int</code> estratto dalla funzione
	 *         <em>EstrazioniCasuali.estraiIntero</em>
	 */
	private static int getRandomInt() {

		return EstrazioniCasuali.estraiIntero(MIN_AZIONE, MAX_AZIONE);
	}

	/**
	 * Esegue il return del <strong>numero minimo</strong> dei due passati come
	 * parametri, usando la funzione <em>Math.min()</em>
	 * 
	 * @param aumentato   Il primo parametro passato alla funzione
	 *                    <strong>Math.min()</strong>
	 * @param riferimento Il secndo parametro passato alla funzione
	 *                    <strong>Math.min()</strong>
	 * @return Il numero di tipo <code>double</code> estratto dalla funzione
	 *         <em>Math.min()</em>
	 */
	private double maxPunteggio(double aumentato, double riferimento) {

		return Math.min(aumentato, riferimento);
	}

	/**
	 * Esegue il return del <strong>numero massimo</strong> dei due passati come
	 * parametri, usando la funzione <em>Math.max()</em>
	 * 
	 * @param diminuito   Il primo parametro passato alla funzione
	 *                    <strong>Math.max()</strong>
	 * @param riferimento Il secndo parametro passato alla funzione
	 *                    <strong>Math.max()</strong>
	 * @return Il numero di tipo <code>double</code> estratto dalla funzione
	 *         <em>Math.max()</em>
	 */
	private double minPunteggio(double diminuito, double riferimento) {

		return Math.max(diminuito, riferimento);
	}

	/**
	 * Questo metodo controlla che i valori (sazietà e soddisfazione) impostati
	 * durante la creazione del tamagotchi siano accettabili
	 * 
	 * @return ritorna un valore di tipo <code>boolean</code> che è <em>vero</em> se
	 *         i valori sono accettabili, <em>falso</em> altrimenti.
	 */
	private boolean controlloValori() {

		return this.gradoSazieta >= MIN_SAZIETA && this.gradoAffettivo >= MIN_SODDISFAZIONE
				&& this.gradoSazieta <= MAX_SAZIETA && this.gradoAffettivo <= MAX_SODDISFAZIONE;
	}

	/**
	 * Questo metodo viene richiamato dalla classe
	 * <a href="TamaMain.html">TamaMain</a> quando l'utente vuole dare delle carezze
	 * al <em>Tamagotchi</em>
	 */
	public void riceviCarezze() {

		int n = getRandomInt();

		this.gradoAffettivo += n;

		decrementaSazieta(n);

		this.gradoAffettivo = maxPunteggio(this.gradoAffettivo, MAX_SODDISFAZIONE);
		this.gradoSazieta = minPunteggio(this.gradoSazieta, MIN_SAZIETA);
	}

	/**
	 * Questo metodo viene richiamato dalla classe
	 * <a href="TamaMain.html">TamaMain</a> quando l'utente vuole dare delle carezze
	 * al <em>Tamagotchi</em>
	 * 
	 * @param n Questo paramentro indica il numero di carezze che l'utente vuole
	 *          dare al proprio <em>Tamagotchi</em>
	 */
	public void riceviCarezze(int n) {

		this.gradoAffettivo += n;

		decrementaSazieta(n);

		this.gradoAffettivo = maxPunteggio(this.gradoAffettivo, MAX_SODDISFAZIONE);
		this.gradoSazieta = minPunteggio(this.gradoSazieta, MIN_SAZIETA);
	}

	/**
	 * Questo metodo viene richiamato dalla classe
	 * <a href="TamaMain.html">TamaMain</a> quando l'utente vuole nutrire il
	 * <em>Tamagotchi</em>
	 */
	public void riceviBiscotti() {

		int n = getRandomInt();

		for (int i = 0; i < n; i++) {

			this.gradoSazieta += (this.gradoSazieta * 0.1);
		}

		decrementaSoddisfazione(n);

		this.gradoSazieta = maxPunteggio(this.gradoSazieta, MAX_SAZIETA);
		this.gradoAffettivo = minPunteggio(this.gradoAffettivo, MIN_SODDISFAZIONE);
	}

	/**
	 * Questo metodo viene richiamato dalla classe
	 * <a href="TamaMain.html">TamaMain</a> quando l'utente vuole nutrire il
	 * <em>Tamagotchi</em>
	 * 
	 * @param n Questo paramentro indica il numero di biscotti che l'utente vuole
	 *          dare al proprio <em>Tamagotchi</em>
	 */
	public void riceviBiscotti(int n) {

		for (int i = 0; i < n; i++) {

			this.gradoSazieta += (this.gradoSazieta * 0.1);
		}

		decrementaSoddisfazione(n);

		this.gradoSazieta = maxPunteggio(this.gradoSazieta, MAX_SAZIETA);
		this.gradoAffettivo = minPunteggio(this.gradoAffettivo, MIN_SODDISFAZIONE);
	}

	/**
	 * Metodo per decrementare la sazietà
	 * 
	 * @param n tirona il nuovo valore di sazietà decrementato
	 */
	public void decrementaSazieta(int n) {

		this.gradoSazieta -= (n / 2);
	}

	/**
	 * Metodo per decrementare la soddisfazione
	 * 
	 * @param n tirona il nuovo valore di soddisfazione decrementato
	 */
	public void decrementaSoddisfazione(int n) {

		this.gradoAffettivo -= (n / 4);
	}

	/**
	 * Questa funzione viene utilizzate per controllare se il <em>Tamagotchi</em>
	 * felice o triste.
	 * 
	 * @return Esegue un return di tipo <code>boolean</code> che sarà <em>vero</em>
	 *         se il <em>Tamagotchi</em> risulta triste, <em>falso</em> se felice.
	 */
	public boolean sonoTriste() {

		if (this.gradoSazieta <= TRISTEZZA_SAZIETA || this.gradoAffettivo <= TRISTEZZA_SODDISFAZIONE) {

			return true;
		}

		if (this.gradoSazieta >= TRISTEZZA_SAZIETA_MAX) {

			return true;
		}

		return false;
	}

	/**
	 * Questa funzione viene utilizzate per controllare se il <em>Tamagotchi</em> è
	 * morto.
	 * 
	 * @return Esegue un return di tipo <code>boolean</code> che sarà <em>vero</em>
	 *         se il <em>Tamagotchi</em> risulta morto, <em>falso</em> se vivo.
	 */
	public boolean sonoMorto() {

		if (this.gradoAffettivo == 0 || this.gradoSazieta == 0 || this.gradoSazieta == MAX_SAZIETA) {

			return true;
		}

		return false;
	}

	/**
	 * Questo metodo produce una stringa che rappresenta lo stato del tamagotchi in
	 * funzione del grado di benessere generale
	 * 
	 * @return ritorna la stringa che visualizza l'espressione
	 */
	public String felicita() {

		if (this.gradoSazieta < TRISTEZZA_SAZIETA_MAX && this.gradoSazieta > TRISTEZZA_SAZIETA
				&& this.gradoAffettivo > TRISTEZZA_SODDISFAZIONE) {

			return FELICE;
		} else if (this.gradoSazieta < TRISTEZZA_SAZIETA_MAX && this.gradoSazieta > TRISTEZZA_SAZIETA
				&& this.gradoAffettivo > TRISTEZZA_SODDISFAZIONE) {

			return INDIFFERENTE;
		} else {

			return TRISTE;
		}
	}

	/**
	 * Metodo per ottenere il grado affettivo di un tamagotchi
	 * 
	 * @return ritorna il grado affettivo del tamagotchi
	 */
	public double getGradoAffettivo() {
		return gradoAffettivo;
	}

	/**
	 * Metodo per modificare il grado affettivo di un tamagotchi
	 * 
	 * @param gradoAffettivo nuovo grado affettivo del tamagotchi
	 */
	public void setGradoAffettivo(double gradoAffettivo) {
		this.gradoAffettivo = gradoAffettivo;
	}

	/**
	 * Metodo per ottenere il grado di sazietà di un tamagotchi
	 * 
	 * @return ritorna il grado di sazietà del tamagotchi
	 */
	public double getGradoSazieta() {
		return gradoSazieta;
	}

	/**
	 * Metodo per modificare il grado di sazietà
	 * 
	 * @param gradoSazieta nuovo grado di sazietà
	 */
	public void setGradoSazieta(double gradoSazieta) {
		this.gradoSazieta = gradoSazieta;
	}

	/**
	 * Restituisce una rappresentazione leggibile di un oggetto della classe
	 * <strong>Tamagotchi</strong>
	 * 
	 * @return Una <code>String</co de> che rappresenta un
	 *         <strong>Tamagotchi</strong>
	 */
	public String toString() {

		String s0 = this.getNome();
		String s1 = String.format("Sazietà: %.2f Soddisfazione: %.2f", this.gradoSazieta, this.gradoAffettivo);
		String s2 = String.format(felicita());

		return BelleStringhe.centrata(s0) + '\n' + BelleStringhe.incorniciaECentra(s1) + BelleStringhe.centrata(s2);
	}

}
