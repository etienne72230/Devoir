package fr.ensim.Devoir;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Personne implements Comparable<Personne>{
	private boolean estUnClient;
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private List<Contrat> contrats;
	private List<Personne> membreFamille;
	
	public Personne(String nom, String prenom, Date naissance, boolean estClient) {
		this.nom = nom;
		this.prenom = prenom;
		dateDeNaissance = naissance;
		estUnClient = estClient;
		contrats = new ArrayList<Contrat>();
		membreFamille = new ArrayList<Personne>();
	}
	
	public boolean estClient() {
		return estUnClient;
	}
	
	public void addMembreFamille(Personne p) {
		membreFamille.add(p);
	}
	public String obtenirNomComplet() {
		return prenom+" "+nom;
	}
	
	public Date obtenirDateDeNaissance() {
		return dateDeNaissance;
	}
	
	public Contrat creerContrat(String typeContrat, String numeroContrat, boolean ContratValide) {
		Contrat contrat=null;
		switch(typeContrat) {
		case "ContratAuto": contrat=new ContratAuto(numeroContrat, ContratValide);break;
		case "ContratMRH": contrat=new ContratMRH(numeroContrat, ContratValide);break;
		case "ContratPrevoyance": contrat=new ContratPrevoyance(numeroContrat, ContratValide);break;
		default : System.out.println("Erreur : type de contrat inconnu");
		}
		return contrat;
	}
	
	public void resilierContrat(Contrat contrat) {
		contrats.remove(contrat);
	}
	
	public void resilierContrats(String numero) {
		for(Contrat contrat : contrats) {
			if(contrat.numeroContrat == numero) {
				contrats.remove(contrat);
				break;
			}
		}
	}
	
	public List<Contrat> obtenirContrats(){
		return contrats;
	}
	
	public List<Contrat> obtenirContratsAuto(){
		List<Contrat> contratsAuto = new ArrayList<Contrat>();
		for(Contrat contrat : contrats) {
			if(contrat.getClass().equals("ContratAuto")) {
				contratsAuto.add(contrat);
			}
		}
		return contratsAuto;
	}
	
	public List<Contrat> obtenirContratsMRH(){
		List<Contrat> contratsMRH = new ArrayList<Contrat>();
		for(Contrat contrat : contrats) {
			if(contrat.getClass().equals("ContratMRH")) {
				contratsMRH.add(contrat);
			}
		}
		return contratsMRH;
	}
	
	public String toString() {
		return obtenirNomComplet()+" née le "+dateDeNaissance;
	}

	@Override
	public int compareTo(Personne p) {
		return p.contrats.size()-this.contrats.size();
	}
}
