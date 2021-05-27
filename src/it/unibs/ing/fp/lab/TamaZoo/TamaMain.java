package it.unibs.ing.fp.lab.TamaZoo;

import java.util.ArrayList;
import it.unibs.ing.fp.lab.mylib.EstrazioniCasuali;
import it.unibs.ing.fp.lab.mylib.MyInputDati;

/**
 * Classe main di TamaZoo
 *
 */
public class TamaMain {
	
	private static final String SALUTO = "Benvenuto nel Tamazoo\n\n";
	private static final String NUMERO_TAMAGOTCHI = "Quanti tamagotchi vuoi aggiungere? ";
	private static final String INSERIMENTO_TAMAGOTCHI = "Inserisci il nome del tuo tamagotchi: ";
	
	private static final int MINIMO_NUM_TAMAGOTCHI = 1;
	private static final int MINIMO_ESTRAZIONE = 0;
	private static final int MASSIMO_ESTRAZIONE = 2;
	private static final int MINIMO_LIVELLO = 20;
	private static final int MASSIMO_LIVELLO = 80;
	
	private static void saluta() {
		
		System.out.println(SALUTO);
	}
	
	/**
	 * Metodo per la creazione di un nuovo Tamagotchi con scelta casuale del tipo e determinazione 
	 * casuale dei valori di sazietà e soddisfazione
	 * @param nome nome del tamagotchi
	 * @return ritorna il nuovo tamagotchi
	 */
	private static Tamagotchi creaTamagotchi(String nome) {
		
		Tamagotchi t = null;
		int num, sazieta, soddisfazione;
		
		num = EstrazioniCasuali.estraiIntero(MINIMO_ESTRAZIONE, MASSIMO_ESTRAZIONE);
		sazieta = EstrazioniCasuali.estraiIntero(MINIMO_LIVELLO, MASSIMO_LIVELLO);
		soddisfazione = EstrazioniCasuali.estraiIntero(MINIMO_LIVELLO, MASSIMO_LIVELLO);
		
		switch(num) {
			case 0:
				t = new Tamagotchi(nome, soddisfazione, sazieta);
				break;
			case 1:
				t = new TamaGordo(nome, sazieta);
				break;
			case 2:
				t = new TamaTriste(nome, soddisfazione);
				break;
		}
		
		return t;
	}
	
	/**
	 * Metodo per popolare le lista di Tamagotchi, a partire dal numero di tamagotchi
	 * li aggiunge alla lista con il nome scelto dall'utente
	 * @param tamazoo
	 */
	private static void popolaLista( ArrayList<Tamagotchi> tamazoo) {
		
		String nome;
		int num;
		num = MyInputDati.leggiInteroConMinimo(NUMERO_TAMAGOTCHI, MINIMO_NUM_TAMAGOTCHI);
		
		for( int i = 0; i < num; i++ ) {
			
			nome = MyInputDati.leggiStringa(INSERIMENTO_TAMAGOTCHI);
			tamazoo.add( creaTamagotchi(nome) );
		}
	}

	public static void main(String[] args) {
		
		ArrayList<Tamagotchi> tamaZoo = new ArrayList<Tamagotchi>();
		int num;
		String nome;
		
		saluta();
		popolaLista(tamaZoo);
		
		
		
	}

}
