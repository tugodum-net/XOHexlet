package game_XO.controller;

import game_XO.model.Board;
import game_XO.model.Player;
import game_XO.model.Figure;

public class GameController {

    public static final int MIN_CORDINATE = 0;

    public static final int MAX_CORDINATE = 2;

    private final String gameName;

    private final Board board;

    private final Player[] players;

    public GameController(final String gameName, Player[] players, Board board){
        this.board = board;
        this.players = players;
        if (gameName == null || gameName.isEmpty() ) {
            this.gameName = gameName;
        } else {
            this.gameName = gameName;
        }
    }

    public Board getBoard() {
        return board;
    }

    public Player[] getPlayers(){
        return players;
    }

    public String getGameName () {
        return gameName;
    }

    public Player currentPlayer(){ //выводит знак Х или О чей сейчас ход
        if (board.checkQantityFigureInBoard(players[0].getFigure()) > board.checkQantityFigureInBoard(players[1].getFigure())){
            System.out.println("Ходит " + players[1].getName()+ " фигура = "+ players[1].getFigure().getFigure());
        } else {
            System.out.println("Ходит " + players[0].getName() + " фигура = " + players[0].getFigure().getFigure());
        }
        return null;
    }

    public boolean checkWin(Figure figure){
        if (checkToWinLines(figure) || checkToWinDiags(figure)){
            System.out.println("figure -" + figure.getFigure() + " WIN!");
            return true;
        }
        return false;
    }

    public boolean checkToWinDiags(Figure figure){
        int count = 0;
        int j = 0;
        for (int i = 0; i<=MAX_CORDINATE; i++){
            if (checkEqualsFigire(i, j, figure)) {
                count++;
            }
            j++;
        }
        if (count == 3) {
            return true;
        }
        count = 0;
        j = MAX_CORDINATE;
        for (int i = 0; i <=MAX_CORDINATE; i++){
            if (checkEqualsFigire(j, i, figure)) {
                count++;
            }
            j--;
        }
        if (count == 3) {
            return true;
        }
        return false;
    }

    public boolean checkToWinLines(Figure figure) {
        int countRow = 0;
        int countCol = 0;
        for (int j = 0; j<=MAX_CORDINATE; j++) {
            for (int i = 0; i <= MAX_CORDINATE; i++) {
                if (checkEqualsFigire(i, j, figure)) {      //проверяем по строкам
                    countRow++;
                }
                if (checkEqualsFigire(j, i, figure)) {      //проверяем по столбцам
                    countCol++;
                }
                if (countRow == 3 || countCol == 3) {
                    return true;
                }
            }
            countRow = 0;
            countCol = 0;
        }
        return false;
    }

    public boolean checkEqualsFigire (int x, int y, Figure figure){
        if (board.getFigure()[x][y] == figure)
            return true;
        else return false;
    }

    public boolean move(final int x, int y, Figure figure){

        assert x >=0;
        assert y >=0;
        if (!checkCord(x) || !checkCord(y)){
            return false;
        }
        board.setFigure(x , y, figure);

        return true;
    }

    private static boolean checkCord (final int coordinate){
        if (coordinate < MIN_CORDINATE || coordinate > MAX_CORDINATE){
            return false;
        }
        return true;
    }
}
