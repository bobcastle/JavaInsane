package model;

/**
 *@author Created by benji on 31/01/2018.
 *
 */
public class Cellule {

    int[][] cellule;

    Cellule(){
        cellule = new int[3][3];
    }

    public int[][] getCellule(){
        return cellule;
    }

    public void turnLeft(){
        int[][] cloneCellule = cellule;
        cellule[0][0] = cloneCellule[0][2];
        cellule[0][1] = cloneCellule[1][2];
        cellule[0][2] = cloneCellule[2][2];
        cellule[1][0] = cloneCellule[0][1];
        cellule[1][2] = cloneCellule[2][1];
        cellule[2][0] = cloneCellule[0][0];
        cellule[2][1] = cloneCellule[1][0];
        cellule[2][2] = cloneCellule[2][0];
    }

    public void turnRight(){
        int[][] cloneCellule = cellule;
        cellule[0][0] = cloneCellule[2][0];
        cellule[0][1] = cloneCellule[1][0];
        cellule[0][2] = cloneCellule[0][0];
        cellule[1][0] = cloneCellule[2][1];
        cellule[1][2] = cloneCellule[0][1];
        cellule[2][0] = cloneCellule[2][2];
        cellule[2][1] = cloneCellule[1][2];
        cellule[2][2] = cloneCellule[0][2];
    }

}
