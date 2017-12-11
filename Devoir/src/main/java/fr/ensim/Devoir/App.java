package fr.ensim.Devoir;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
		
		System.out.println("Meilleur Client : "+assurance.obtenirPlusGrosClient());
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("Taper Client ou Contrat pour en créer un nouveau");
			String str = sc.nextLine();
			switch(str) {
			case "Client": nouveauClient(assurance);break;
			case "Contrat": nouveauContrat(assurance);break;
			default: System.out.println("Erreur, saisie incorrecte");
			}
		}
    }
    
    private static void nouveauClient(CompagnieAssurance assurance){
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Saisir [Prénom] [Nom] [Date Naissance (mm/jj/aaaa)]");
    	String str = sc.nextLine();
    	String[] arg = str.split(" ");
    	Personne p = new Personne(arg[1], arg[0], new Date(arg[2]), true);
    	assurance.addContact(p);
    	System.out.println(p+ "a été ajouté !");
    }
    
    private static void nouveauContrat(CompagnieAssurance assurance) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Numéro du client bénéfissiare du nouveau contrat :");
    	int i=0;
    	int index=0;
    	for(Personne p : assurance.getContacts()) {
    		System.out.println("("+i+")"+p.obtenirNomComplet());
    		i++;
    	}
    	index = Integer.valueOf(sc.nextLine());
    	System.out.println("Saisir : [Type de contrat(ContratAuto,ContratMRH,ContratPrevoyance)] [numéro]");
    	String str = sc.nextLine();
    	String[] arg = str.split(" ");
    	assurance.getContacts().get(index).creerContrat(arg[0], arg[1], true);
    	System.out.println("Création d'un contrat "+arg[0]+" numéro "+ arg[1]+"  pour "+assurance.getContacts().get(index));
    }
    
}
