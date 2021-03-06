package controller;

import javafx.scene.control.Cell;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by benji on 31/01/2018.
 */
public class Plateau {

    public static Plateau instance;

    private int[][] megaTableau;

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

    public void initMegaTableau(){
        int taille = (int) Math.sqrt(cellules.size());

        megaTableau = new int[taille*3][taille*3];

        for(int i = 0; i<cellules.size(); i++){
            Cellule currentCellule = cellules.get(i);

            int x = 0;
            int y = 0;

            int pos = i;
            while (pos-taille >= 0){
                pos = pos-taille;
            }
            x = pos*3;


            if (i < taille){
                y = 0;
            }
            else {
                for (int j = 1; j<=taille; j++){
                    if (i>=taille*j && i< taille*(j+1)){
                        y=j*3;
                        break;
                    }
                }
            }

            for (int iCell = 0; iCell < currentCellule.getCellule().length; iCell++){
                for (int jCell =0; jCell < currentCellule.getCellule().length; jCell++){
                    megaTableau[iCell+y][jCell+x] = currentCellule.getCellule()[iCell][jCell];
                }
            }

        }
    }

    public Collection<Joueur> checkWin(){
        HashSet<Joueur> gagnants = new HashSet<>();

        initMegaTableau();

        for (int x=0; x<megaTableau.length; x++){
            for (int y=0; y<megaTableau.length; y++){
                if(megaTableau[y][x] != 0) {
                    if (x >= 2 && x < megaTableau.length - 2) {
                        if (y < 2 || y >= megaTableau.length - 2) {
                            if(checkHorizontal(x, y) != null){
                                gagnants.add(checkHorizontal(x, y));
                            }
                        } else {
                            if(checkHorizontal(x, y) != null){
                                gagnants.add(checkHorizontal(x, y));
                            }
                            if(checkVerticale(x, y) != null){
                                gagnants.add(checkVerticale(x, y));
                            }
                            if(checkDiagonale(x, y) != null){
                                gagnants.add(checkDiagonale(x, y));
                            }
                        }
                    } else if (x < 2 || x >= megaTableau.length - 2) {
                        if (y >= 2 && y < megaTableau.length - 2) {
                            if(checkVerticale(x, y) != null){
                                gagnants.add(checkVerticale(x, y));
                            }
                        }
                    }
                }
            }
        }
        return gagnants;
    }

    private Joueur checkHorizontal(int x, int y){
        boolean victoire = true;
        int currentVar = megaTableau[y][x];
        for (int i=x-2; i<=x+2; i++){
            if(megaTableau[y][i] != currentVar){
                victoire = false;
            }
        }
        if (victoire == true){
            return GameMode.getInstance().getJoueurs().get(currentVar);
        }
        return null;
    }

    private Joueur checkVerticale(int x, int y){
        boolean victoire = true;
        int currentVar = megaTableau[y][x];
        for (int i=y-2; i<=y+2; i++){
            if(megaTableau[i][x] != currentVar){
                victoire = false;
            }
        }
        if (victoire == true){
            return GameMode.getInstance().getJoueurs().get(currentVar);
        }
        return null;
    }

    private Joueur checkDiagonale(int x, int y){
        boolean victoire = true;
        int currentVar = megaTableau[y][x];
        for (int i=0; i<5; i++){
            if(megaTableau[y-2+i][x-2+i] != currentVar){
                victoire = false;
            }
        }
        if (victoire == true){
            return GameMode.getInstance().getJoueurs().get(currentVar);
        }
        return null;
    }
}
