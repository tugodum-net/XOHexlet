package game_XO.view;

import game_XO.controller.GameController;
import game_XO.model.*;

public class ConsoleView {

    protected final GameController gameController;

    public ConsoleView(GameController gameController) {
        this.gameController = gameController;
    }


    public void showGameName(){
        System.out.println(gameController.getGameName());
    }

    public void showPlayers(){
        for (Player player : gameController.getPlayers()){
            System.out.println(player.getName());
        }
    }

    public void showBoard(){

    }

}
