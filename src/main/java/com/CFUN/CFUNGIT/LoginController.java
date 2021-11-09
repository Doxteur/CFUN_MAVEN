package com.CFUN.CFUNGIT;


import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController {

	public TextField UsernameInput = null;
	public PasswordField PasswordInput = null;
	public JFXButton LoginButton = null;
	public AnchorPane LoginAnchor = null;
	//public AnchorPane RegisterAnchor = null;
	
	@FXML
	public void CheckingLogin() {
		System.out.println(UsernameInput.getText());
		System.out.println(PasswordInput.getText());
		
		System.out.println("Bouton login Marche");	
	}
	
	// TO DO DATABASE LOGIN AND CHECK

	public void RegisterForm() {
		System.out.println("RegisterForm");
		LoginAnchor.setVisible(false);;
		
	}
}
