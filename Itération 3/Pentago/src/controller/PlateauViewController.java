package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *@author Romtaro
 *
 */
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
	private int tour = 1;
	private boolean joueurPlayOk = false;
	private boolean joueur2PlayOk = false;

	@FXML
	TextArea History;
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
            this.gameMode.addJoueur(joueur);
            this.gameMode.addJoueur(joueur2);

			this.plateau = Plateau.getInstance();

			LabTime.setText(this.gameMode.getTotalTime()+"s"); // on récupére le time
			LabScore.setText(joueur.getScore() + " - " + joueur2.getScore()); // on récupére le score des joueur
			LabManche.setText(""+this.tour);
			LabJ1.setText("J1: "+ joueur.getName()); // on affiche nom joueur
			LabJ2.setText("J2: "+ joueur2.getName());
			setTourEnCour(this.joueur);
			LabTour.setText("Au tour de : "+getTourEnCour().getName());
			History.setStyle("background-color: #42AFA0;");
			History.setEditable(false);
			/* while(plateau.checkWin()!=this.joueur ||plateau.checkWin()!=joueur2 ){
					gameMode.run();
					LabTime.setText(""+gameMode.getTotalTime());
				}*/
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
						LabTime.setText(this.gameMode.getTotalTime()+"s");

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

		public void checkTour(){
			if(this.joueurPlayOk == true && this.joueur2PlayOk == true){
			this.tour++;
			this.LabManche.setText(""+this.tour);
			this.joueurPlayOk = false;
			this.joueur2PlayOk = false;

			}else{

			}
		}
		private void SelectButton(Joueur joueur, Button bt){

			System.out.println("win : " + plateau.checkWin());
			if(joueur == this.joueur){
				//System.out.println(LabTour.getText());
				bt.setStyle("-fx-background-color: #dc143c;");
				bt.setDisable(true);
				placeCellule(joueur, 1,listButton.indexOf(bt));
				setTourEnCour(this.joueur2);
				LabTour.setText("Au tour de : " + getTourEnCour().getName());

				//System.out.println(plateau.getCellule(0).cellule[1][1]);

				this.joueurPlayOk = true;

				}else if(joueur == this.joueur2){
				bt.setStyle("-fx-background-color: #1e90ff;");
				bt.setDisable(true);
				this.joueur2PlayOk = true;
				placeCellule(joueur, 2,listButton.indexOf(bt));
				checkTour();
				setTourEnCour(this.joueur);
				LabTour.setText("Au tour de : " +getTourEnCour().getName());

				}
		}

		public void history(Joueur joueur, int plat , int cell ,int cell2){
			plat +=1;
			this.History.setText(this.History.getText() + "\n"+ joueur.getName() + " joue plateau : "+plat+ ", Cellule ["+cell+"]"+"["+cell2+"]" );
		}

		private void placeCellule(Joueur joueurs, int joueur, int i){
			System.out.println("ok "+ joueur + " "+ i);
			System.out.println("Size : " + this.plateau.cellules.size());
			//System.out.println("dddd " +plateau.getCellule(0).toString());
			//System.out.println("dddd " +plateau.getInstance().getCellule(0).cellule[0][0]);
			if( i<=8){
				System.out.println(i);
				switch (i)
				{
				case 0:
					plateau.getCellule(0).getCellule()[0][0] = joueur;
					System.out.println("dddd " +plateau.getCellule(0).getCellule()[0][0]);
					history(joueurs,0,0,0);
					return;
				case 1:
					plateau.getCellule(0).cellule[0][1] = joueur;
					history(joueurs,0,0,1);
					return;
				case 2:
					plateau.getCellule(0).cellule[0][2] = joueur;
					history(joueurs,0,0,2);
					return;
				case 3:
					plateau.getCellule(0).cellule[1][0] = joueur;
					history(joueurs,0,1,0);
					return;
				case 4:
					plateau.getCellule(0).cellule[1][1] = joueur;
					history(joueurs,0,1,1);
					return;
				case 5:
					plateau.getCellule(0).cellule[1][2] = joueur;
					history(joueurs,0,1,2);
					return;
				case 6:
					plateau.getCellule(0).cellule[2][0] = joueur;
					history(joueurs,0,2,0);
					return;
				case 7:
					plateau.getCellule(0).cellule[2][1] = joueur;
					history(joueurs,0,2,1);
					return;
				case 8:
					plateau.getCellule(0).cellule[2][2] = joueur;
					history(joueurs,0,2,2);
					break;

			}

			}else if( i>8 && i<=17){
				switch (i)
				{
				case 9:
					plateau.getCellule(1).getCellule()[0][0] = joueur;
					history(joueurs,1,0,0);
					return;
				case 10:
					plateau.getCellule(1).cellule[0][1] = joueur;
					history(joueurs,1,0,1);
					return;
				case 11:
					plateau.getCellule(1).cellule[0][2] = joueur;
					history(joueurs,1,0,2);
					return;
				case 12:
					plateau.getCellule(1).cellule[1][0] = joueur;
					history(joueurs,1,1,0);
					return;
				case 13:
					plateau.getCellule(1).cellule[1][1] = joueur;
					history(joueurs,1,1,1);
					return;
				case 14:
					plateau.getCellule(1).cellule[1][2] = joueur;
					history(joueurs,1,1,2);
					return;
				case 15:
					plateau.getCellule(1).cellule[2][0] = joueur;
					history(joueurs,1,2,0);
					return;
				case 16:
					plateau.getCellule(1).cellule[2][1] = joueur;
					history(joueurs,1,2,1);
					return;
				case 17:
					plateau.getCellule(1).cellule[2][2] = joueur;
					history(joueurs,1,2,2);
				break;
			}

			}else if(i>17 && i<=26){
				switch (i)
				{
				case 18:
					plateau.getCellule(2).getCellule()[0][0] = joueur;
					history(joueurs,2,0,0);
					return;
				case 19:
					plateau.getCellule(2).cellule[0][1] = joueur;
					history(joueurs,2,0,1);
					return;
				case 20:
					plateau.getCellule(2).cellule[0][2] = joueur;
					history(joueurs,2,0,2);
					return;
				case 21:
					plateau.getCellule(2).cellule[1][0] = joueur;
					history(joueurs,2,1,0);
					return;
				case 22:
					plateau.getCellule(2).cellule[1][1] = joueur;
					history(joueurs,2,1,1);
					return;
				case 23:
					plateau.getCellule(2).cellule[1][2] = joueur;
					history(joueurs,2,1,2);
					return;
				case 24:
					plateau.getCellule(2).cellule[2][0] = joueur;
					history(joueurs,2,2,0);
					return;
				case 25:
					plateau.getCellule(2).cellule[2][1] = joueur;
					history(joueurs,2,2,1);
					return;
				case 26:
					plateau.getCellule(2).cellule[2][2] = joueur;
					history(joueurs,2,2,2);

				break;
			}
			}else if(i>26 && i<=35){
				switch (i)
				{
				case 27:
					plateau.getCellule(3).getCellule()[0][0] = joueur;
					history(joueurs,3,0,0);
					return;
				case 28:
					plateau.getCellule(3).cellule[0][1] = joueur;
					history(joueurs,3,0,1);
					return;
				case 29:
					plateau.getCellule(3).cellule[0][2] = joueur;
					history(joueurs,3,0,2);
					return;
				case 30:
					plateau.getCellule(3).cellule[1][0] = joueur;
					history(joueurs,3,1,0);
					return;
				case 31:
					plateau.getCellule(3).cellule[1][1] = joueur;
					history(joueurs,3,1,1);
					return;
				case 32:
					plateau.getCellule(3).cellule[1][2] = joueur;
					history(joueurs,3,1,2);
					return;
				case 33:
					plateau.getCellule(3).cellule[2][0] = joueur;
					history(joueurs,3,2,0);
					return;
				case 34:
					plateau.getCellule(3).cellule[2][1] = joueur;
					history(joueurs,3,2,1);
					return;
				case 35:
					plateau.getCellule(3).cellule[2][2] = joueur;
					history(joueurs,3,2,2);
				break;
			}
			}else {
				System.out.println("Error");
			}
		}
		public void Turn(){
		/*
		cellule[0][0] = cloneCellule[0][2];
	        cellule[0][1] = cloneCellule[1][2];
	        cellule[0][2] = cloneCellule[2][2];
	        cellule[1][0] = cloneCellule[0][1];
	        cellule[1][2] = cloneCellule[2][1];
	        cellule[2][0] = cloneCellule[0][0];
	        cellule[2][1] = cloneCellule[1][0];
	        cellule[2][2] = cloneCellule[2][0];
	        0=2
	        1=5
	        2=8
	        3=1
	        4=4
	        5=7
	        6=0
	        7=3
	        8=6

	        Button bt00 = listButton.get(0);
	        Button bt01 = listButton.get(1);*/
			//fonction changer button droite plateau 0
	        int j =2;


	        for(int i =0; i<8 ; i++){

	        	double x = listButton.get(j).getLayoutX();
				double y = listButton.get(j).getLayoutY();
				listButton.get(i).setLayoutX(x);
				listButton.get(i).setLayoutY(y);
				j +=3;
				if(j >= 10){

					j =- 10;

				}else{

				}

	        }
			double x = BT01.getLayoutX();
			double y = BT01.getLayoutY();
			//System.out.println("BT00.alignmentProperty().getValue() "+ BT00.alignmentProperty().getValue());
			BT01.setLayoutX(BT00.getLayoutX());
			BT01.setLayoutY(BT00.getLayoutY());
			BT00.setLayoutX(x);
			BT00.setLayoutY(y);
			Button t = listButton.get(1);
			listButton.set(1, BT00);
			listButton.set(0, t);
			//BT00 = stock;
			//BT00.setStyle(stock);

		}

}
