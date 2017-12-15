package game_XO.controller;

import game_XO.model.Figure;
import game_XO.model.Point;
import game_XO.model.exceptions.AlreadyOccupaiedException;
import game_XO.model.exceptions.InvalidPointException;
import game_XO.view.ConsoleView;

import java.util.Scanner;

public class Game {

    final private ConsoleView consoleView;
    final private GameController gameController;


    public Game(ConsoleView consoleView) {
        this.consoleView = consoleView;
        this.gameController = consoleView.getGameController();

    }

    public void startGame() throws AlreadyOccupaiedException, InvalidPointException {
        while (gameController.getNextTurn())
            try {
                Figure currentFigure = gameController.currentPlayer().getFigure();
                System.out.println();
                System.out.println("Ходит " + gameController.currentPlayer().getName()+ " фигура = "+ currentFigure);
                gameController.getBoard().printBoard();
                gameController.move(gameController.nextTurn(), gameController.currentPlayer().getFigure());

                if (gameController.checkWin(currentFigure)) {

                    System.out.println("figure -" + currentFigure + " WIN!");
                    gameController.getBoard().printBoard();
                    //todo anotherGame
                }
            }catch (InvalidPointException e){}
    }
}
