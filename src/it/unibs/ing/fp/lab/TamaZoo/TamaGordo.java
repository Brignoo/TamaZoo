package it.unibs.ing.fp.lab.TamaZoo;

public class TamaGordo extends Tamagotchi{
	
	private static final int SODDISFAZIONE = 100;
	private static final int TRISTEZZA_SAZIETA = 30;
	private static final int MIN_SAZIETA = 0;
	
	private static final String FELICE = ":)";
	private static final String TRISTE = ":(";

	public TamaGordo(String nome, double sazieta) {
		super(nome, SODDISFAZIONE, sazieta);
	}
	
	@Override
	public void decrementaSazieta( int n) {
		
		double q = super.getGradoSazieta();
		q -= n;
		
		super.setGradoSazieta( q );
	}
	
	@Override
	public void decrementaSoddisfazione( int n) {
		
	}
	
	@Override
	public boolean sonoTriste() {
		
		if( super.getGradoSazieta() <= TRISTEZZA_SAZIETA ) {
			
			return true;
		}

		return false;
	}
	
	@Override
	public String felicita() {
		
		if(super.getGradoSazieta() <= TRISTEZZA_SAZIETA ) {
			
			return TRISTE;
		}
		
		return FELICE;
	}
	
	@Override
	public boolean sonoMorto( ) {

		if( super.getGradoSazieta() == MIN_SAZIETA ){

			return true;
		}

		return false;
	}
}
