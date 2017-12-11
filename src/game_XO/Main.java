package game_XO;

import game_XO.controller.GameController;
import game_XO.model.Board;
import game_XO.model.Figure;
import game_XO.model.Player;
import game_XO.view.*;

public class Main {
    public static void main(String[] args) {

        final Board board = new Board();

        GameController gameController = new GameController("xo", new  Player[]{      new Player("Vova",  Figure.X),
                                                                                                new Player("Pavel",  Figure.O)} , board);
        new ConsoleView (gameController).showPlayers();

        board.printBoard();

        gameController.currentPlayer();

        gameController.move(0,2, gameController.getPlayers()[0].getFigure());

        gameController.move(1,2, gameController.getPlayers()[0].getFigure());

        gameController.move(2,0, gameController.getPlayers()[0].getFigure());

        gameController.move(1,1, gameController.getPlayers()[0].getFigure());

        board.printBoard();

        gameController.checkWin(gameController.getPlayers()[0].getFigure());








//        MenuView menuView = new MenuView();
//        menuView.showMenuWithResult();

    }

    private static void startGame(final ConsoleView advConsoleViev){
        advConsoleViev.showGameName();
    }
}
