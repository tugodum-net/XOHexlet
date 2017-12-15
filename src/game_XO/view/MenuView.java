package game_XO.view;

import game_XO.controller.Game;
import game_XO.controller.GameController;
import game_XO.controller.GameStarter;
import game_XO.model.Board;
import game_XO.model.Figure;
import game_XO.model.Player;
import game_XO.model.exceptions.AlreadyOccupaiedException;
import game_XO.model.exceptions.InvalidPointException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {

    private static final int START_CODE = 1;

    private static final int LOAD_CODE = 2;

    private static final int SETTINGS_CODE = 3;

    private static final int EXIT_CODE = 4;

    public static void showMenuWithResult() throws AlreadyOccupaiedException, InvalidPointException {

        System.out.println("++++  XO Magic  ++++");
        System.out.println(START_CODE + " - Play");
        System.out.println(LOAD_CODE + " - Load");
        System.out.println(SETTINGS_CODE + " - Set up and play");
        System.out.println(EXIT_CODE + " - Exit");
        System.out.print("> ");

        final Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();



        try {
            switch (choice) {                                   //choice входящее зачение
                case START_CODE:                                        // case выбирается на основании входящего значения
                    System.out.println("New game is Started");
                    GameStarter.defaultStart().startGame();
                    break;
                case LOAD_CODE:
                    System.out.println("load");
                    break;
                case SETTINGS_CODE:
                    System.out.println("Setting");
                    break;
                case EXIT_CODE:
                    System.out.println("EXIT");
                    break;
                default:                                        //
                    System.out.println("Realy");
                    break;
            }
        } catch (final InputMismatchException e ){
            showMenuWithResult();
        }

    }
}
