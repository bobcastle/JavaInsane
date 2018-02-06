package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class ChoixNomViewController {
	Main main;


	@FXML
	TextField TB1;
	@FXML
	TextField TB2;
	@FXML
	Button BT1;

	public void setMain(Main main) {
		this.main = main;
		initializeHandlers();
	}
	private void initializeHandlers(){
		BT1.setOnAction(actionEvent ->  {
		    start();
		});
		TB1.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.matches("[^A-Za-z0-9]")) {
                TB1.setText(newValue.replaceAll("[^A-Za-z0-9]", ""));
            }
    	});

		TB2.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.matches("[^A-Za-z0-9]")) {
                TB2.setText(newValue.replaceAll("[^A-Za-z0-9]", ""));
            }
    	});
	}
	private void start() {
		// TODO Auto-generated method stub
		if(!TB1.getText().isEmpty() && !TB2.getText().isEmpty()){

			main.setJ1(TB1.getText().toString());
			main.setJ2(TB2.getText().toString());
			main.showPlat();
		}
		else{
			main.boxAlert("Attention", "Veuillez renseigner les deux noms");
		}
	}
}
