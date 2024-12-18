package com.parkauto.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkauto.rest.entity.Commande;
import com.parkauto.rest.repository.ICommandeRepository;

@Service
public class CommandeService {
	@Autowired
	ICommandeRepository commandeRepository;
	
	//Liste des véhicules
	public List<Commande> getCommandes(){
		return commandeRepository.findAll();
		
	}
	
	//Save
	public Commande saveCommande(Commande commande) {
		return commandeRepository.save(commande);
		
	}
	
	//Get a commande
	public Commande getCommandeById(Long idcmde) {
		return commandeRepository.findById(idcmde).get();
		
	}
	
	//Delete a commande
	public void deleteCommande(Commande commande) {
		commandeRepository.delete(commande);
	}
	
	//Mise  à jour d'une commande
	public Commande updateCommande(Long idCommande, Commande commande) {
		
		Commande cmde = commandeRepository.findById(idCommande).get();
		cmde.setDateCmd(commande.getDateCmd());
		cmde.setDescription(commande.getDescription());
		cmde.setPrix(commande.getPrix());
		cmde.setPrixTotal(commande.getPrixTotal());
		cmde.setQte(commande.getQte());
		
		
		return commandeRepository.save(cmde);
	}
	
}
