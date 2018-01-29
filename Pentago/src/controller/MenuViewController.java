package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuViewController {

	Main main;

@FXML
Button BT1;
@FXML
Button Regle;
@FXML
Button About;

	public void setMain(Main main) {
		this.main = main;
		initializeHandlers();
	}
	private void initializeHandlers(){
		//////Start Game go vu platforme////
		BT1.setOnAction(actionEvent ->  {
		    main.showPlat();
		});
		////go vu regle///
		Regle.setOnAction(actionEvent -> {
			main.showRegle();
		});
		///// go vu About////
		About.setOnAction(actionEvent -> {
			main.showAbout();
		});

	}
}
