package game_XO.view;

import game_XO.controller.GameController;

public class AdvConsoleView extends ConsoleView{

    public AdvConsoleView(GameController gameController) {
        super(gameController);
    }

    @Override
    public void showGameName(){
        System.out.println("***");
        System.out.println(gameController.getGameName());
    }

}
