package fr.ensim.Devoir;

import java.util.ArrayList;
import java.util.List;

public class ContratMRH extends Contrat{

	public ContratMRH(String num, boolean valide) {
		super(num, valide);
	}
	
	@Override
	public Contrat creationContrat(String num, boolean valide) {
		return new ContratMRH(num, valide);
	}

	@Override
	public List<String> determinerGaranties() {
		List<String> garanties = new ArrayList<String>();
		garanties.add("Incendies");
		garanties.add("Vitres");
		garanties.add("Inondation");
		garanties.add("Responsabilité Civile");	
		return garanties;
	}

	@Override
	public double determinerCotisation() {
		return 100;
	}

}
