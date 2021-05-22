package it.unibs.ing.fp.lab.TamaZoo;

public class TamaMain {

	public static void main(String[] args) {
		
		TamaGordo g = new TamaGordo("Paolo", 78);
		TamaGordo h = new TamaGordo("Paolo", 80);
		
		System.out.println(g);
		System.out.println(h);
		
		g.riceviCarezze(6);
		h.riceviBiscotti(2);
		
		System.out.println(g);
		System.out.println(h);

	}

}
