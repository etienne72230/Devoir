package fr.ensim.Devoir;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CompagnieAssurance assurance = new CompagnieAssurance("Axa");
		Personne p1 = new Personne("Cayon", "Etienne", new Date(96,00,07), true);
		p1.creerContrat("ContratPrevoyance", "E15A35", true);
		
		Personne p2 = new Personne("Halliday", "Johnny", new Date(43,05,15), false);
		
		Personne p3 = new Personne("Cayon", "Thomas", new Date(91,03,04), false);
		p3.creerContrat("ContratAuto", "A18E21", true);
		p3.creerContrat("ContratMRH", "M9455E23", true);
		
		p3.addMembreFamille(p1);
		p1.addMembreFamille(p3);
		
		assurance.addContact(p1);
		assurance.addContact(p2);
		assurance.addContact(p3);
		
		System.out.println("Meilleur Client : "+assurance.obentirPlusGrosClient());
    }
}
