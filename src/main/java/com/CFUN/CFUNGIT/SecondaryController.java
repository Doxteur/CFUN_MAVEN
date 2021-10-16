package com.CFUN.CFUNGIT;

import java.io.IOException;

import com.CFUN.app.Arrivee;
import com.CFUN.app.Complexe;

import javafx.fxml.FXML;

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

	@FXML
	private void switchToPrimary() throws IOException {

		Complexe leComplexe = new Complexe(nbMuscu, nbFit, nomComplexe);

		Operation = App.getOperation();
		typedeSport = App.gettypeDeSport();

		if (Operation == 'E') {
			Arrivee jArrive = new Arrivee(leComplexe, typedeSport);
			if (leComplexe.entreeUsager(jArrive)) {
				System.out.println(jArrive.afficheBillet());

			}
		}else {
			System.out.println("Vous etes sorties");
			
		}
		System.out.print(leComplexe.lesInfos());
	}
}