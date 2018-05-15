package model;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

public class GameMode {

    private long startTime;

    private long endTime;

    public static GameMode instance;

    public int nbJoueurs;

    public List<Joueur> joueurs;

    GameMode(){
        startTimer();
        joueurs = new ArrayList<Joueur>();
    }

    public static GameMode getInstance(){
        if (instance == null)
            instance = new GameMode();
        return instance;
    }

    public int getNbJoueurs(){
        return nbJoueurs;
    }

    public void setNbJoueurs(int nbJoueurs){
        this.nbJoueurs = nbJoueurs;
    }

    public void startTimer(){
    	  this.startTime = System.currentTimeMillis();

    }
    public long getTotalTime(){
        return  (this.endTime-this.startTime);
    };

    public List<Joueur> getJoueurs(){
        return joueurs;
    }

    public void addJoueur(Joueur joueur){
    	this.joueurs.add(joueur);
    }
}
