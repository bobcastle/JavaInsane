package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PlateauViewController {
	Main main;
	@FXML
	Button BTMenu;


		public void setMain(Main main) {
			this.main = main;
			initializeHandlers();
		}
		private void initializeHandlers(){
			/////Retour menu///
			BTMenu.setOnAction(actionEvent ->  {
			    main.showMainGUI();
			});

		}
}
