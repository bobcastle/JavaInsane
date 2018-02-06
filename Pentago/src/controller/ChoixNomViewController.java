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
	@FXML
	Button BTMenu;

	public void setMain(Main main) {
		this.main = main;
		initializeHandlers();
	}
	private void initializeHandlers(){
		BT1.setOnAction(actionEvent ->  {
		    start();
		});
		BTMenu.setOnAction(actionEvent ->  {
		    main.showMainGUI();
		});
		TB1.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.matches("\\²[^A-Za-z0-9]")) {
                TB1.setText(newValue.replaceAll("[^A-Za-z0-9]", ""));
            }
			if(newValue.length()>12){
				TB1.setText(newValue.replace(newValue, oldValue));
			}
    	});

		TB2.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.matches("\\²[^A-Za-z0-9]")) {
                TB2.setText(newValue.replaceAll("[^A-Za-z0-9]", ""));
            }
			if(newValue.length()>12){
				TB2.setText(newValue.replace(newValue, oldValue));
			}
    	});
	}
	private void start() {
		// TODO Auto-generated method stub
		if(!TB1.getText().isEmpty() && !TB2.getText().isEmpty()){
			if(TB1.getText().length()>3 && TB2.getText().length()>3){
			main.setJ1(TB1.getText().toString());
			main.setJ2(TB2.getText().toString());
			main.showPlat();
			} else{
				main.boxAlert("Attention","Veuillez rentrer au minimum 4 caractères");
			}
		}
		else{
			main.boxAlert("Attention", "Veuillez renseigner les deux noms");
		}
	}
}
