package game_XO.model;

public class Game {

    private final String name;

    private final Player[] player;

    private final Field field;

    public Game(String name, Player[] player, Field field) {
        this.name = name;
        this.player = player;
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public Player[] getPlayer() {
        return player;
    }

    public Field getField() {
        return field;
    }
}
