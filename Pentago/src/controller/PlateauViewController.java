package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.GameMode;
import model.Plateau;
import model.Joueur;
import model.Cellule;

public class PlateauViewController {
	Main main;
	GameMode gameMode;
	Plateau plateau;
	Joueur joueur;
	Joueur joueur2;
	Cellule cellule;
	@FXML
	Button BTMenu;
	@FXML
	Label LabTime;
	@FXML
	Label LabManche;
	@FXML
	Label LabScore;
	@FXML
	Label LabJ1;
	@FXML
	Label LabJ2;

		public void setMain(Main main) {
			this.main = main;
			this.gameMode = GameMode.getInstance();
            this.gameMode.getInstance().setNbJoueurs(2);
			this.plateau = Plateau.getInstance();
			this.joueur = new Joueur("Joueur 1 ", 1);
			this.joueur2 = new Joueur("Joueur 2", 2);
			gameMode.getJoueurs().add(joueur);
			gameMode.getJoueurs().add(joueur2);
			LabTime.setText(gameMode.getTotalTime()+"s");
			LabScore.setText(joueur.getScore() + " - " + joueur2.getScore());
			LabManche.setText("1");
			LabJ1.setText("J1: "+ joueur.getName());
			LabJ2.setText("J2: "+ joueur2.getName());
			initializeHandlers();

		}
		private void initializeHandlers(){
			/////Retour menu///
			BTMenu.setOnAction(actionEvent ->  {
			    main.showMainGUI();

			});

		}
}
