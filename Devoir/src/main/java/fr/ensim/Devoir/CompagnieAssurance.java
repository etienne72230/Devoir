package fr.ensim.Devoir;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompagnieAssurance {
	private String nom;
	private List<Personne> contacts;
	
	public CompagnieAssurance(String nom) {
		this.nom = nom;
		contacts = new ArrayList<Personne>();
	}
	
	public void addContact(Personne p) {
		contacts.add(p);
	}
	
	public List<Personne> getContacts(){
		return contacts;
	}
	
	public int obtenirNombreDeClients() {
		int nbClients=0;
		for(Personne p : contacts) {
			if(p.estClient()) nbClients++;
		}
		return nbClients;
	}
	
	public int obtenirNombreDeProspects() {
		int nbProspects=0;
		for(Personne p : contacts) {
			if(p.estClient() == false) nbProspects++;
		}
		return nbProspects;
	}
	
	public int obtenirNombreDeContrats() {
		int nbContrats = 0;
		for(Personne p : contacts) {
			nbContrats+= p.obtenirContrats().size();
		}
		return nbContrats;
	}
	
	public Personne obtenirPlusGrosClient() {
		Collections.sort(contacts);
		return contacts.get(0);
	}
}
