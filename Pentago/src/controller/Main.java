package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;




public class Main extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
    private MenuViewController menuController;
    public GameMode gameMode;

  public Main() throws IOException {

    }



	public static void main(String[] args) {

		launch(args);
	}


	// Mettre en place le primary Stage pour l'application
	@Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Projet Pentago");
        Image image = new Image("file:logo.png");
        System.out.println(image);
        primaryStage.getIcons().add(image);

      // this.dataHandler = new DataHandler();

        initRootLayout();

    }
//////////////////////////////////////////////GENERAL/////////////////////////////////////////////////////////
/////////////////////////Afficher la base des vues/////////////////////////
	public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/RootView.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

            //Launch the main view
            showMainGUI();
           // showSauvVariable();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/////////////////////////Afficher la vue Menu/////////////////////////
	public void showMainGUI(){
    	try {
            // Load GUI overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/MenuView.fxml"));


            AnchorPane mainGUI = (AnchorPane) loader.load();
            // Set overview into the center of root layout.
            rootLayout.setCenter(mainGUI);

         // Give the controller access to the main app.

            menuController = loader.getController();
            menuController.setMain(this);




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/////////////////////////Afficher la vue PLatforme/////////////////////////
	public void showPlat(){
    	try {
            gameMode = GameMode.getInstance();
            gameMode.getInstance().setNbJoueurs(2); // Provisoire
            // Load GUI overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/PlateauView.fxml"));


            AnchorPane mainGUI = (AnchorPane) loader.load();
            // Set overview into the center of root layout.
            rootLayout.setCenter(mainGUI);

         // Give the controller access to the main app.

            PlateauViewController controller = loader.getController();
            controller.setMain(this);




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/////////////////////////Afficher la vue About/////////////////////////
	public void showAbout(){
    	try {
            // Load GUI overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/AboutView.fxml"));


            AnchorPane mainGUI = (AnchorPane) loader.load();
            // Set overview into the center of root layout.
            rootLayout.setCenter(mainGUI);


            AboutViewController controller = loader.getController();
            controller.setMain(this);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/////////////////////////Afficher la vue Regle/////////////////////////
	public void showRegle(){
    	try {
            // Load GUI overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/RegleView.fxml"));


            AnchorPane mainGUI = (AnchorPane) loader.load();
            // Set overview into the center of root layout.
            rootLayout.setCenter(mainGUI);


           RegleViewController controller = loader.getController();
            controller.setMain(this);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }


	}