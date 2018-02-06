package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PlateauViewController {
	Main main;
	GameMode gameMode;
	Plateau plateau;
	Joueur joueur;
	Joueur joueur2;
	@FXML
	Button BTMenu;
	@FXML
	Label LabTime;
	@FXML
	Label LabManche;
	@FXML
	Label LabScore;


		public void setMain(Main main) {
			this.main = main;
			this.gameMode = GameMode.getInstance();
			this.plateau = Plateau.getInstance();
			joueur = new Joueur("Joueur 1", 0);
			joueur2 = new Joueur("Joueur 2", 0);
			initializeHandlers();
			LabTime.setText(gameMode.getTotalTime()+"s");
			LabScore.setText(joueur.getScore() + " - " + joueur2.getScore());
			LabManche.setText("1");


		}
		private void initializeHandlers(){
			/////Retour menu///
			BTMenu.setOnAction(actionEvent ->  {
			    main.showMainGUI();

			});

		}
}
