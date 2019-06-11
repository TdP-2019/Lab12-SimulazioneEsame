/**
 * Sample Skeleton for 'Crimes.fxml' Controller Class
 */

package it.polito.tdp.crimes;

import java.net.URL;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.model.Model;
import it.polito.tdp.model.Vicino;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CrimesController {

	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxAnno"
    private ComboBox<Integer> boxAnno; // Value injected by FXMLLoader

    @FXML // fx:id="boxMese"
    private ComboBox<Integer> boxMese; // Value injected by FXMLLoader

    @FXML // fx:id="boxGiorno"
    private ComboBox<Integer> boxGiorno; // Value injected by FXMLLoader

    @FXML // fx:id="btnCreaReteCittadina"
    private Button btnCreaReteCittadina; // Value injected by FXMLLoader

    @FXML // fx:id="btnSimula"
    private Button btnSimula; // Value injected by FXMLLoader

    @FXML // fx:id="txtN"
    private TextField txtN; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCreaReteCittadina(ActionEvent event) {
    	Integer anno;
    	anno = boxAnno.getValue();
    	if(anno == null) {
    		txtResult.appendText("Devi selezionare un anno");
    		return;
    	}
    	this.model.creaGrafo(anno);
    	
    	for(Integer d : this.model.getDistretti()) {
    		List<Vicino> vicini = this.model.getVicini(d);
    		txtResult.appendText("\nVICINI DI DISTRETTO " + d);
    		for(Vicino v : vicini) {
    			txtResult.appendText("\n" + v.getV() + " d = " + v.getDistanza());
    		}
    	}
    }

    @FXML
    void doSimula(ActionEvent event) {
    	Integer anno,mese,giorno,N;
    	txtResult.clear();
    	
    	try {
    		N = Integer.parseInt(txtN.getText());
    	} catch(NumberFormatException e) {
    		txtResult.clear();
    		txtResult.appendText("Devi inserire un numero N di agenti");
    		return;
    	}
    	
    	anno = boxAnno.getValue();
    	if(anno == null) {
    		txtResult.clear();
    		txtResult.appendText("Devi selezionare un anno");
    		return;
    	}
    	
    	mese = boxMese.getValue();
    	if(mese == null) {
    		txtResult.clear();
    		txtResult.appendText("Devi selezionare un mese");
    		return;
    	}
    	
    	giorno = boxGiorno.getValue();
    	if(giorno == null) {
    		txtResult.clear();
    		txtResult.appendText("Devi selezionare un giorno");
    		return;
    	}
    
        try
        {
            LocalDate.of(anno, mese, giorno);
        }
        catch(DateTimeException e)
        {
        	txtResult.clear();
    		txtResult.appendText("Data non corretta");
            return;
        }

        txtResult.clear();
        txtResult.appendText("SIMULO CON " + N + " agenti");
        txtResult.appendText("\nCRIMINI MAL GESTITI: " + this.model.simula(anno, mese, giorno, N));
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxAnno != null : "fx:id=\"boxAnno\" was not injected: check your FXML file 'Crimes.fxml'.";
        assert boxMese != null : "fx:id=\"boxMese\" was not injected: check your FXML file 'Crimes.fxml'.";
        assert boxGiorno != null : "fx:id=\"boxGiorno\" was not injected: check your FXML file 'Crimes.fxml'.";
        assert btnCreaReteCittadina != null : "fx:id=\"btnCreaReteCittadina\" was not injected: check your FXML file 'Crimes.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Crimes.fxml'.";
        assert txtN != null : "fx:id=\"txtN\" was not injected: check your FXML file 'Crimes.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Crimes.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	this.boxAnno.getItems().addAll(this.model.getAnni());
    	this.boxMese.getItems().addAll(this.model.getMesi());
    	this.boxGiorno.getItems().addAll(this.model.getGiorni());

    }
}
