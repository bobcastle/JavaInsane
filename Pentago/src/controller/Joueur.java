package controller;

public class Joueur {

    private String name;

    private int numero;

    private int score;

    public Joueur(String name, int numero){
        this.name = name;
        this.numero = numero;
        this.score = 0;
    }

    public String getName(){
        return name;
    }

    public int getNumero(){
        return numero;
    }

    public int getScore(){
        return score;
    }

}
