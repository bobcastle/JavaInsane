package controller;


import java.util.List;

public class GameMode {

    private long startTime;

    private long endTime;

    public static GameMode instance;

    public int nbJoueurs;

    public List<Joueur> joueurs;

    GameMode(){
        startTimer();
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
        startTime = System.nanoTime();
    }

    public long getTotalTime(){
        return  (endTime - startTime);
    };

    public List<Joueur> getJoueurs(){
        return joueurs;
    }


}
