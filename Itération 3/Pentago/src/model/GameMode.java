package model;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

public class GameMode extends Thread{

    private long startTime;

    private long endTime=0;

    public static GameMode instance;

    public int nbJoueurs;
    public long time = 0;
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
    public void run(){

    		long t = System.currentTimeMillis();
    		long u =t - this.startTime;
    		this.time =u;
    		System.out.println(getTotalTime()+" seconde");

    }
    public long getTotalTime(){
        return  this.time/1000;
    };

    public List<Joueur> getJoueurs(){
        return joueurs;
    }

    public void addJoueur(Joueur joueur){
    	this.joueurs.add(joueur);
    }
}
