package controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *@author Romtaro
 *
 */
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
	public static Joueur joueur;
	public static Joueur joueur2;
	private Joueur tourEnCour;
	public ObservableList<Button> listButton = FXCollections.observableArrayList();;
	Cellule cellule;

	@FXML
	Button BTMenu;
	//Button du plateau///

	//haut Gauche///
	@FXML
	Button BT00;

	@FXML
	Button BT01;
	@FXML
	Button BT02;
	@FXML
	Button BT03;
	@FXML
	Button BT04;
	@FXML
	Button BT05;
	@FXML
	Button BT06;
	@FXML
	Button BT07;
	@FXML
	Button BT08;

	///Haut droite//
	@FXML
	Button BT10;
	@FXML
	Button BT11;
	@FXML
	Button BT12;
	@FXML
	Button BT13;
	@FXML
	Button BT14;
	@FXML
	Button BT15;
	@FXML
	Button BT16;
	@FXML
	Button BT17;
	@FXML
	Button BT18;

	//Bas gauche////
	@FXML
	Button BT20;
	@FXML
	Button BT21;
	@FXML
	Button BT22;
	@FXML
	Button BT23;
	@FXML
	Button BT24;
	@FXML
	Button BT25;
	@FXML
	Button BT26;
	@FXML
	Button BT27;
	@FXML
	Button BT28;

	//Haut droite//
	@FXML
	Button BT30;
	@FXML
	Button BT31;
	@FXML
	Button BT32;
	@FXML
	Button BT33;
	@FXML
	Button BT34;
	@FXML
	Button BT35;
	@FXML
	Button BT36;
	@FXML
	Button BT37;
	@FXML
	Button BT38;
	///Fin button ///
	//////
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
	@FXML
	Label LabTour;


		public void setMain(Main main) {
			//on initialise tout les models et controler qu'on a besoin///
			this.main = main;
			this.listButton.addAll(BT00,BT01,BT02,BT03,BT04,BT05,BT06,BT07,BT08,BT10,BT11,BT12,BT13,BT14,BT15,BT16,BT17,BT18,BT20,BT21,BT22,BT23,BT24,BT25,BT26,BT27,BT28,BT30,BT31,BT32,BT33,BT34,BT35,BT36,BT37,BT38);
			this.gameMode = GameMode.getInstance();
			/// on créer les joueur avec le nom des TextBox de la view Choix////
			this.joueur = new Joueur(main.getJ1(), 1);
			this.joueur2 = new Joueur(main.getJ2(), 2);

            this.gameMode.setNbJoueurs(2);
           //
			this.plateau = Plateau.getInstance();
			LabTime.setText(gameMode.getTotalTime()+"s"); // on récupére le time
			LabScore.setText(joueur.getScore() + " - " + joueur2.getScore()); // on récupére le score des joueur
			LabManche.setText("1");
			LabJ1.setText("J1: "+ joueur.getName()); // on affiche nom joueur
			LabJ2.setText("J2: "+ joueur2.getName());
			setTourEnCour(this.joueur);
			LabTour.setText("Au tour de : "+getTourEnCour().getName());
			initializeHandlers();

		}
		private void initializeHandlers(){
			/////Retour menu en ajoutant une action à notre boutton///

			BTMenu.setOnAction(actionEvent ->  {
			    main.showMainGUI();
			});



			 for(int i=0;i< listButton.size(); i++){
				 Button button = listButton.get(i);
				 button.setOnAction(actionEvent ->  {
						SelectButton(getTourEnCour(), button);
					});
				    }






		}
		private void game(){
while(plateau.checkWin() == null){

			}
		}

		public Joueur getTourEnCour() {
			return tourEnCour;
		}
		public void setTourEnCour(Joueur tourEnCour) {
			this.tourEnCour = tourEnCour;
		}
		private void SelectButton(Joueur joueur, Button bt){
			if(joueur == this.joueur){
				//System.out.println(LabTour.getText());
				bt.setStyle("-fx-background-color: #dc143c;");
				bt.setDisable(true);
				setTourEnCour(this.joueur2);
				LabTour.setText("Au tour de : " + getTourEnCour().getName());
				}else if(joueur == this.joueur2){
				bt.setStyle("-fx-background-color: #1e90ff;");
				bt.setDisable(true);
				setTourEnCour(this.joueur);
				LabTour.setText("Au tour de : " +getTourEnCour().getName());
				}
		}
}
