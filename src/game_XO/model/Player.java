package game_XO.model;

import game_XO.model.Figure;

public class Player {

    private final String name;

    private final Figure figure;

    public Player(final String name, Figure figure){
        this.name = name;
        this.figure = figure;
    }



    public String getName() {
        return name;
    }

    public Figure getFigure() {
        return figure;
    }
}
