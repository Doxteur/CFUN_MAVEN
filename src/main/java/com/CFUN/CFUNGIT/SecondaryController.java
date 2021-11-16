package com.CFUN.CFUNGIT;

import java.io.IOException;
import java.net.URL;

import com.CFUN.app.Arrivee;
import com.CFUN.app.Complexe;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SecondaryController {
	private char Operation;
	private char typedeSport;

	private static int nbMuscu = 4;
	private static int nbFit = 5;
	private static final String nomComplexe = "C Fun";
	private static final String TYPE = "Type opération (E)ntrée ou (S)ortie : ";
	private static final String SORTIE = "N° d'entrée à sortir : ";
	private static final String CHOIX = "(M)usculation, (F)itness : ";
	private static final String AUTRE = "Autre opération (O/N) : ";
	
	//FXML
	public TextField valueOfTicket = null;
	public AnchorPane TicketNumberSortie = null;
	
	Complexe leComplexe = new Complexe(nbMuscu, nbFit, nomComplexe);
	
	@FXML
	public void initialize() {


		Operation = App.getOperation();
		typedeSport = App.gettypeDeSport();
		
		
		if (Operation == 'E') {
			Arrivee jArrive = new Arrivee(leComplexe, typedeSport);
			if (leComplexe.entreeUsager(jArrive)) {
				String[] monBillet = jArrive.GetBilletInfo();
				System.out.println(monBillet[2]);
			}
		}else {
			
			TicketNumberSortie.setVisible(true);
			
		}
		System.out.print(leComplexe.lesInfos());
	}
	
	@FXML
	private void ValidateTicket() {
		
		int TicketNumber = valueOfTicket.getText().equals("")?0:Integer.parseInt(valueOfTicket.getText());
		if(TicketNumber < 1) {
			System.out.println("Vous n'avez pas pris de ticket.");
		}else {
		System.out.println(leComplexe.sortieUsager(TicketNumber).afficheTicket());
		}
	}

	
}