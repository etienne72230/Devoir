package fr.ensim.Devoir;

import java.util.List;

abstract class Contrat {
	protected String numeroContrat;
	protected boolean contratValide;
	
	public Contrat(String num,boolean valide) {
		numeroContrat=num;
		contratValide = valide;
	}
	public abstract Contrat creationContrat(String num, boolean valide);
	
	public abstract List<String> determinerGaranties();
	
	public abstract double determinerCotisation();
}
