package com.CFUN.CFUNGIT;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {

	private char operation;
	private char typeDeSport;
	public JFXButton operationButton = null;
	public JFXButton sortieButton = null;
	public JFXButton muscuButton = null;
	public JFXButton fitButton = null;

	@FXML
	private void EntreeButton() throws IOException {
		// App.setRoot("secondary");
		operation = 'E';
		operationButton.setStyle("-fx-background-color: #FF6F16");
		sortieButton.setStyle("-fx-background-color: grey");
	}

	@FXML
	private void SortieButton() throws IOException {
		// App.setRoot("secondary");
		operation = 'S';
		operationButton.setStyle("-fx-background-color: grey");
		sortieButton.setStyle("-fx-background-color: #FF6F16");
	}

	@FXML
	private void muscuButton() throws IOException {
		// App.setRoot("secondary");
		typeDeSport = 'M';
		muscuButton.setStyle("-fx-background-color: #FF6F16");
		fitButton.setStyle("-fx-background-color: grey");
	}

	@FXML
	private void fitButton() throws IOException {
		// App.setRoot("secondary");
		typeDeSport = 'F';
		muscuButton.setStyle("-fx-background-color: grey");
		fitButton.setStyle("-fx-background-color: #FF6F16");
	}

	@FXML
	private void valideButton() throws IOException {
		System.out.println("Operation :" + operation + " type de sport :" + typeDeSport);
		App.setOperation(operation);
		App.settypeDeSport(typeDeSport);
		App.setRoot("secondary");
	}
	
	

}
