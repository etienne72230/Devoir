package fr.ensim.Devoir;

import java.util.ArrayList;
import java.util.List;

public class ContratPrevoyance extends Contrat{

	public ContratPrevoyance(String num, boolean valide) {
		super(num, valide);
	}
	
	@Override
	public Contrat creationContrat(String num, boolean valide) {
		return new ContratPrevoyance(num, valide);
	}

	@Override
	public List<String> determinerGaranties() {
		List<String> garanties = new ArrayList<String>();
		garanties.add("Accidents de la vie");
		garanties.add("Maladie");
		garanties.add("Mutuelle");
		return garanties;
	}

	@Override
	public double determinerCotisation() {
		return 75;
	}

}
