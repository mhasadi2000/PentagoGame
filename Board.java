package com.company;

public class Board {
    public  int ROW=6;
    public  int COLUMN=6;
    public Cell[][] cells;

    /**assign the coordinate of each cell and call initMap and gamePlan.
     * **/
    public Board() {
        cells=new Cell[ROW][COLUMN];
        for (int r=0;r<ROW;r++){
            for (int c=0;c<COLUMN;c++){
                cells[r][c]=new Cell(r,c);
            }
        }
        gamePlan();
    }


    /**draw the game plan and clear the console at first.**/
    public void gamePlan() {

        for(int clear = 0; clear < 1000; clear++)
        {
            System.out.println("\b") ;
        }

        System.out.print(" ");
        System.out.print(Color.MAGENTA);
        System.out.println(" 0  1  2     3  4  5");
        System.out.print(Color.RESET);
        for (int row=0;row<ROW;row++){
            System.out.print(Color.MAGENTA);
            System.out.print(row);
            System.out.print(Color.RESET);
            for (int column=0;column<COLUMN;column++){
                cells[row][column].draw();
                if (column == 2) {
                    System.out.print(" | ");
                }
            }
            if (row==2){
                System.out.println();
                System.out.println("  -------------------");
            }else {
                System.out.println();
            }
        }
        System.out.print(Color.RESET);
    }

}
