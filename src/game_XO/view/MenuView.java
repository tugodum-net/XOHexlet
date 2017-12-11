package game_XO.view;

import java.util.Scanner;

public class MenuView {

    public  int  showMenuWithResult() {

        final Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {                                   //choice входящее зачение
            case 1:                                        // case выбирается на основании входящего значения
                System.out.println("Start");
                break;
            case 2:
                System.out.println("load");
                break;
            case 3:
                System.out.println("Setting");
                break;
            case 4:
                System.out.println("EXIT");
                break;
            default:                                        //
                System.out.println("Realy");
                break;
        }

        return 0;
    }
}
