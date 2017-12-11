package fr.ensim.Devoir;

import java.util.ArrayList;
import java.util.List;

public class ContratAuto extends Contrat{
	
	public ContratAuto(String num, boolean valide) {
		super(num, valide);
	}

	@Override
	public Contrat creationContrat(String num, boolean valide){
		return new ContratAuto(num, valide);
	}

	@Override
	public List<String> determinerGaranties() {
		List<String> garanties = new ArrayList<String>();
		garanties.add("Accidents");
		garanties.add("Bris de glace");
		garanties.add("Responsabilité Civile");
		return garanties;
	}

	@Override
	public double determinerCotisation() {
		return 150;
	}

}
