package controller;

import javafx.scene.control.Cell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by benji on 31/01/2018.
 */
public class Plateau {

    public static Plateau instance;

    private List<Cellule> cellules;

    Plateau(int nbJoueurs){
        cellules = new ArrayList<Cellule>(nbJoueurs*nbJoueurs);
        for(int i=0; i<cellules.size(); i++){
            cellules.add(new Cellule());
        }
    }

    public Cellule getCellule(int index){
        return cellules.get(index);
    }

    public static Plateau getInstance(){
        if (instance == null){
            instance = new Plateau(GameMode.getInstance().getNbJoueurs());
        }
        return instance;
    }
}
