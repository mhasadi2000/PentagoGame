package com.company;

import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.setOut;

public class Pentago {

    public Board board;
    private Turn turn;
    Scanner input=new Scanner(System.in);

    public Pentago(){
        this.board=new Board();
        startTheGame();
        boolean m;
        do {
            m =move();
            changeTurn();
        }while (m);
    }
    /**set that which color starts the game.**/
    public void startTheGame(){
        System.out.println("which one should start the game? (b/r)");
        String first= input.nextLine();
        if(first.equalsIgnoreCase("r")){
            turn=Turn.RED;
        }if (first.equalsIgnoreCase("w")){
            turn=Turn.WHITE;
        }
    }

    public boolean validInput(int r,int c){
        if(r>=0 && r<board.ROW && c>=0 && c<board.COLUMN && board.cells[r][c].getValue()=='e'){
            return true;
        }
        System.out.println("invalid input");
        return false;
    }

    public void changeTurn(){
        this.turn=(turn==Turn.WHITE)?turn.WHITE:turn.RED;
        String colorOfTurn=(this.turn==Turn.WHITE)?"WHITE":"RED";
        if (colorOfTurn.equals("WHITE")){
            System.out.print(Color.WHITE_BOLD);
            System.out.println("it is "+colorOfTurn+" turn");
        }else {
            System.out.print(Color.RED_BOLD);
            System.out.println("it is "+colorOfTurn+" turn");
        }
        System.out.print(Color.RESET);
    }

    public boolean move(){
        findWinner();
        System.out.println("enter the ROW and COLUMN to put a disc.");
        int r=input.nextInt();
        int c=input.nextInt();

        if (validInput(r,c)){

        }else{
            move();
        }

        return true;
    }

    public void putTow(int r, int c){

    }

    public void findWinner(){
        for (int r=0;r<board.ROW;r++){
            for (int c=0;c<board.COLUMN;c++){
                if (fiveTow(r,c)){
                    System.out.print(Color.GREEN);
                    System.out.println("********"+turn+" has win the game."+"********");
                    exit(-1);
                }
            }
        }
    }

    public boolean fiveTow(int r,int c){
        char curr=(turn==Turn.RED)?'r':'w';
        if (board.cells[r][c].getValue()=='e'){
            return false;
        }

        if (r>1 && board.cells[r-1][c].getValue()==curr){
            int counter=0;
            int rTemp=r;
            while (rTemp>1 && board.cells[rTemp][c].getValue()==curr){
                counter++;
                rTemp--;
            }
            if (counter==5){
                return true;
            }
        }

        if (r<board.ROW-1 && board.cells[r+1][c].getValue()==curr){
            int counter=0;
            int rTemp=r;
            while (rTemp<board.ROW && board.cells[rTemp][c].getValue()==curr){
                counter++;
                rTemp++;
            }
            if (counter==5){
                return true;
            }
        }

        if (c>1 && board.cells[r][c-1].getValue()==curr){
            int counter=0;
            int cTemp=c;
            while (cTemp>1 && board.cells[r][cTemp].getValue()==curr){
                counter++;
                cTemp--;
            }
            if (counter==5){
                return true;
            }
        }

        if (c<board.COLUMN-1 && board.cells[r][c+1].getValue()==curr){
            int counter=0;
            int cTemp=c;
            while (cTemp<board.COLUMN && board.cells[r][cTemp].getValue()==curr){
                counter++;
                cTemp++;
            }
            if (counter==5){
                return true;
            }
        }

        if (c>1 && r>1 && board.cells[r-1][c-1].getValue()==curr){
            int counter=0;
            int cTemp=c;
            int rTemp=r;
            while (cTemp>1 && rTemp>1 && board.cells[rTemp][cTemp].getValue()==curr){
                counter++;
                cTemp--;
                rTemp--;
            }
            if (counter==5){
                return true;
            }
        }

        if (c<board.COLUMN-1 && r<board.ROW-1 && board.cells[r+1][c+1].getValue()==curr){
            int counter=0;
            int cTemp=c;
            int rTemp=r;
            while (cTemp<board.COLUMN && rTemp<board.ROW && board.cells[rTemp][cTemp].getValue()==curr){
                counter++;
                cTemp++;
                rTemp++;
            }
            if (counter==5){
                return true;
            }
        }

        if (c<board.COLUMN-1 && r>1 && board.cells[r-1][c+1].getValue()==curr){
            int counter=0;
            int cTemp=c;
            int rTemp=r;
            while (cTemp<board.COLUMN && rTemp>1 && board.cells[rTemp][cTemp].getValue()==curr){
                counter++;
                cTemp++;
                rTemp--;
            }
            if (counter==5){
                return true;
            }
        }

        if (c>1 && r<board.ROW-1 && board.cells[r+1][c-1].getValue()==curr){
            int counter=0;
            int cTemp=c;
            int rTemp=r;
            while (cTemp>1 && rTemp<board.ROW && board.cells[rTemp][cTemp].getValue()==curr){
                counter++;
                cTemp--;
                rTemp++;
            }
            if (counter==5){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Pentago pentago=new Pentago();
        Board board=new Board();
    }
}
