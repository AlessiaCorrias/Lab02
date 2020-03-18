package it.polito.tdp.alien;

import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnTranslate;
    
    @FXML
    private Button btnReset;
    
    @FXML
    private TextField txtInput;
    
    @FXML
    private TextArea txtResult;



    @FXML
    void doTranslate(ActionEvent event) {
    	// controlli input
    	String s = txtInput.getText();
    	try {
    	if(s.contains(" ")) {
    		model.addWord(s);
    	} else {
    		txtResult.clear();
    		txtResult.appendText(model.getTranslation(s));
    	}
    	}
    	catch (InvalidParameterException pe){
    		txtResult.clear();
    		txtResult.appendText(pe.getMessage());
    	}
    	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    }
    
    
    @FXML
    void initialize() {
    	 assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
         assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
         assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
         assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model=model;
    }
}