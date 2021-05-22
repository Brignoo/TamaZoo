package it.unibs.ing.fp.lab.TamaZoo;

public class Tamatriste extends Tamagotchi{
	
	private static final int MAX_SAZIETA = 100;
	private static final String TRISTE = ":(";
	private static final int MIN_SODDISFAZIONE = 0;

	public Tamatriste(String nome, double sazieta) {
		super(nome, MIN_SODDISFAZIONE, sazieta);
		
	}
	
	@Override
	public boolean sonoTriste() {

		return true;
	}
	
	@Override
	public boolean sonoMorto( ) {

		if(super.getGradoSazieta() == 0 || super.getGradoSazieta() == MAX_SAZIETA){

			return true;
		}

		return false;
	}
	
	@Override
	public String felicita() {	
		return TRISTE;
		
	}
}