package game_XO.controller;

import game_XO.model.Field;
import game_XO.model.Player;
import game_XO.model.Figure;
import game_XO.model.Point;
import game_XO.model.exceptions.AlreadyOccupaiedException;
import game_XO.model.exceptions.InvalidPointException;

public class GameController {

    public static final int MIN_CORDINATE = 0;

    public static final int MAX_CORDINATE = 2;

    private final String gameName;

    private final Field field;

    private final Player[] players;

    public GameController(final String gameName, Player[] players, Field field){
        this.field = field;
        this.players = players;
        if (gameName == null || gameName.isEmpty() ) {
            this.gameName = gameName;
        } else {
            this.gameName = gameName;
        }
    }

    public Field getField() {
        return field;
    }

    public Player[] getPlayers(){
        return players;
    }

    public String getGameName () {
        return gameName;
    }

    public Player currentPlayer(){ //выводит знак Х или О чей сейчас ход
        if (field.checkQantityFigureInBoard(players[0].getFigure()) > field.checkQantityFigureInBoard(players[1].getFigure())){
            System.out.println("Ходит " + players[1].getName()+ " фигура = "+ players[1].getFigure().getFigure());
        } else {
            System.out.println("Ходит " + players[0].getName() + " фигура = " + players[0].getFigure().getFigure());
        }
        return null;
    }


    public void move(Point point, Figure figure) throws AlreadyOccupaiedException, InvalidPointException {

        try{
            if (field.getFigure(point) != null){
                throw new AlreadyOccupaiedException ();
            } else
                try {
                    field.setFigure(point, figure);
                } catch (InvalidPointException e){
                    e.printStackTrace();
                }
        }catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    public void checkWin(Figure figure) throws InvalidPointException{
        if (checkToWinLines(figure) || checkToWinDiags(figure)){
            System.out.println("figure -" + figure.getFigure() + " WIN!");
        } //else next step();
    }

    private boolean checkToWinDiags(Figure figure) throws InvalidPointException{
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

    private boolean checkToWinLines(Figure figure) throws InvalidPointException{
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

    private boolean checkEqualsFigire (int x, int y, Figure figure) throws InvalidPointException{
        if (field.getFigure(new Point(x,y)) == figure)
            return true;
        else return false;
    }

    private static boolean checkCord (final int coordinate){
        if (coordinate < MIN_CORDINATE || coordinate > MAX_CORDINATE){
            return false;
        }
        return true;
    }
}
