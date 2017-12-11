package fr.ensim.Devoir;


import java.util.Date;

import junit.framework.TestCase;

public class CompagnieAssuranceTest extends TestCase {

	public void testAssurance() {
		CompagnieAssurance assurance = new CompagnieAssurance("Axa");
		Personne p1 = new Personne("Cayon", "Etienne", new Date(96,00,07), true);
		p1.creerContrat("ContratPrevoyance", "E15A35", true);
		
		Personne p2 = new Personne("Halliday", "Johnny", new Date(43,05,15), false);
		
		Personne p3 = new Personne("Cayon", "Thomas", new Date(91,03,04), true);
		p3.creerContrat("ContratAuto", "A18E21", true);
		p3.creerContrat("ContratMRH", "M9455E23", true);
		
		p3.addMembreFamille(p1);
		p1.addMembreFamille(p3);
		
		assurance.addContact(p1);
		assurance.addContact(p2);
		assurance.addContact(p3);
		
		assertEquals("Nombre de clients", 2, assurance.obtenirNombreDeClients());
		assertEquals("Nombre de contrat", 3, assurance.obtenirNombreDeContrats());
		assertEquals("Nombre de prospect", 1, assurance.obtenirNombreDeProspects());
		assertEquals("Nombre de clients", "Thomas Cayon", assurance.obtenirPlusGrosClient().obtenirNomComplet());
	}
}
