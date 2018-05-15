package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AboutViewController {

	Main main;

@FXML
Button BT1;


	public void setMain(Main main) {
		this.main = main;
		initializeHandlers();
	}
	
	private void initializeHandlers(){
	/////Retour menu///
		BT1.setOnAction(actionEvent ->  {
		    main.showMainGUI();
		});


	}
}
