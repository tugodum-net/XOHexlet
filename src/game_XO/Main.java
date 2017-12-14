package game_XO;

import game_XO.controller.GameController;
import game_XO.model.Field;
import game_XO.model.Figure;
import game_XO.model.Player;
import game_XO.model.Point;
import game_XO.view.*;

public class Main {
    public static void main(String[] args) throws Exception {

        final Field field = new Field();

        GameController gameController = new GameController("xo", new  Player[]{      new Player("Vova",  Figure.X),
                                                                                                new Player("Pavel",  Figure.O)} , field);
        new ConsoleView (gameController).showPlayers();

        field.printBoard();

        Point point = new Point(0,2);

        gameController.currentPlayer();

        gameController.move(new Point(0,2), gameController.getPlayers()[0].getFigure());

        gameController.move(new Point(1,1), gameController.getPlayers()[0].getFigure());

        gameController.move(new Point(2,0), gameController.getPlayers()[0].getFigure());

        field.printBoard();

        gameController.checkWin(gameController.getPlayers()[0].getFigure());








//        MenuView menuView = new MenuView();
//        menuView.showMenuWithResult();

    }

    private static void startGame(final ConsoleView advConsoleViev){
        advConsoleViev.showGameName();
    }
}
