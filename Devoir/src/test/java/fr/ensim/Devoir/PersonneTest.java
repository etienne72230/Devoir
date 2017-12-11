package fr.ensim.Devoir;


import java.util.Date;

import junit.framework.TestCase;

public class PersonneTest extends TestCase {

	public void testPersonne() {
		Personne p = new Personne("Cayon", "Etienne", new Date(96,00,07), true);
		assertEquals("Obtenir nom complet", "Etienne Cayon", p.obtenirNomComplet());
		
		assertEquals("Obtenir nombre de contrat", 0, p.obtenirContrats().size());
		p.creerContrat("ContratAuto", "E15A35", true);
		assertEquals("Obtenir nombre de contrat", 1, p.obtenirContrats().size());
		assertEquals("Obtenir nombre de contrat MRH", 0, p.obtenirContratsMRH().size());
		assertEquals("Obtenir nombre de contrat Auto", 1, p.obtenirContratsAuto().size());
		p.resilierContrat("E15A35");
		assertEquals("Obtenir nombre de contrat Auto", 0, p.obtenirContratsAuto().size());
		
		
		
	}

}
