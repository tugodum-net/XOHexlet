package game_XO.controller;

import game_XO.model.Board;
import game_XO.model.Figure;
import game_XO.model.Player;
import game_XO.view.ConsoleView;
import game_XO.model.exceptions.LowerZeroException;

public class GameStarter {
    public static Game defaultStart(){
        final int boardSize = 3;
        final String gameName = "XO";
        final String playerOneName = "PLAYER X";
        final String playerTwoName = "PLAYER O";
        return advancedStart(boardSize, playerOneName, playerTwoName, gameName);
    }

    public static Game advancedStart (int boardSize, String playerOneName, String playerTwoName, String gameName){
        Board board = null;
        try {
            board = new Board(boardSize);
        } catch (LowerZeroException e){ }
        Player player[] = new Player[2];
        player[0] = new Player(playerOneName, Figure.X);
        player[1] = new Player(playerTwoName, Figure.O);
        GameController gameController = new GameController(gameName, player, board);
        ConsoleView consoleView = new ConsoleView(gameController);
        Game game = new Game(consoleView);
        return game;

    }
}
