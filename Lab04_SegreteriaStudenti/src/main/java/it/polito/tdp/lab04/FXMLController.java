package it.polito.tdp.lab04;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> menuCorsi;

    @FXML
    private Button btnIscrittiCorso;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnCheck;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIsctivi;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button btnReset;

    @FXML
    void autocompletamento(ActionEvent event) {
    	String matricolaString= txtMatricola.getText();
    	int matricola;
    		try {
    			matricola= Integer.parseInt(matricolaString);
    		}catch(NumberFormatException e) {
    		txtRisultato.setText("Devi inserire un numero");
    		return;
    	}
    	
    	List<Studente> studenti= this.model.getStudenti(matricola);
    	for(Studente s: studenti) {    
    		txtNome.appendText(s.getNome());
    		txtCognome.appendText(s.getCognome());
    	}
    	
    	
    }

    @FXML
    void cercaIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void iscrittiCorso(ActionEvent event) {

    }

    @FXML
    void stampaCorsi(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert menuCorsi != null : "fx:id=\"menuCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrittiCorso != null : "fx:id=\"btnIscrittiCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCheck != null : "fx:id=\"btnCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIsctivi != null : "fx:id=\"btnIsctivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model=model;
    	menuCorsi.getItems().addAll(this.model.getTuttiICorsi());
    	
    }
}
