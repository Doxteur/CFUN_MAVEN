package com.CFUN.CFUNGIT;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import com.jfoenix.controls.JFXComboBox;

/**
 * JavaFX App Merging Fix on master
 */

public class App extends Application {

	private static Scene scene;

	@FXML
	private JFXComboBox<String> comboBox;

	@Override
    public void start(Stage stage) throws IOException {
    	
        scene = new Scene(loadFXML("primary"), 991, 565);
        stage.setScene(scene);
        comboBox = (JFXComboBox) scene.lookup("#comboEntre");
        comboBox.setItems(FXCollections.observableArrayList("Dog","Chat","Bear"));

        stage.show();
           
    }

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public static void main(String[] args) {
		launch();
	}

}