package it.unibs.ing.fp.lab.TamaZoo;

public class TamaGordo extends Tamagotchi{
	
	private static final int SODDISFAZIONE = 100;

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
}
