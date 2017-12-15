package game_XO.controller;

import game_XO.model.Board;
import game_XO.model.Player;
import game_XO.model.Figure;
import game_XO.model.Point;
import game_XO.model.exceptions.AlreadyOccupaiedException;
import game_XO.model.exceptions.InvalidPointException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameController {

    public static final int MIN_CORDINATE = 0;

    public static int MAX_CORDINATE = 2;

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

    public Point nextTurn()throws InvalidPointException{
        System.out.println("Следующий ход:");
        Point point = new Point(checkCord(), checkCord());
        while (this.board.getFigure(point) != null){
            System.out.println("Указанная координата уже занята, повторите ввод");
            point = new Point(checkCord(), checkCord());
            System.out.println();
        }
        return point;
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

    public Player currentPlayer(){
        if (board.checkQantityFigureInBoard(players[0].getFigure()) > board.checkQantityFigureInBoard(players[1].getFigure())){
            return players[1];
        } else { return players[0];
        }
    }

    public void move(Point point, Figure figure) throws AlreadyOccupaiedException, InvalidPointException {

        try{
            if (board.getFigure(point) != null){
                throw new AlreadyOccupaiedException ();
            } else
                try {
                    board.setFigure(point, figure);
                } catch (InvalidPointException e){
                    e.printStackTrace();
                }
        }catch (InvalidPointException e) {
            e.printStackTrace();
            throw new InvalidPointException ();

        }
    }

    public boolean getNextTurn() throws InvalidPointException{
        final Figure[][] figures = getBoard().getFiguresArray();
        if (checkWin(Figure.X) || checkWin(Figure.O))  {
            return false;
        }
        for (Figure[] figureArray : figures) {
            for (Figure figureValue : figureArray) {
                if (figureValue == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWin(Figure figure) throws InvalidPointException{
        if (checkToWinLines(figure) || checkToWinDiags(figure)){
            return true;
        } else return false;
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
        if (board.getFigure(new Point(x,y)) == figure)
            return true;
        else return false;
    }

    private static int checkCord (){
        while (true){
            System.out.printf("Введите координату");
            try {
                Scanner input = new Scanner(System.in);
                int coordinate= input.nextInt();
                if (coordinate >= MIN_CORDINATE && coordinate <= MAX_CORDINATE){
                    return coordinate;
                } else {
                    System.out.println("Введите корректное значение");
                }
            } catch (InputMismatchException e){
                System.out.println("Введите корректное значение");
            }
        }
    }
}
