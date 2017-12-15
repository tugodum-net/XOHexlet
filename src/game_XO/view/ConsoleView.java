package game_XO.view;

import game_XO.controller.GameController;
import game_XO.model.*;

public class ConsoleView {

    protected final GameController gameController;

    public ConsoleView(GameController gameController) {
        this.gameController = gameController;
    }

    public GameController getGameController() {
        return gameController;
    }

}
