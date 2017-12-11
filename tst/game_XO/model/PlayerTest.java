package game_XO.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testGetName() throws Exception {
        final String testValue = "vova";
        final String exceptedvalue = "vova";
        final Player player = new Player(testValue, null);
        assertEquals(exceptedvalue, player.getName());
    }

    @Test
    public void testGetFigure() throws Exception {
        final Figure testValue = Figure.X;
        final Figure exceptedvalue = Figure.X;
        final Player player = new Player("Vova", testValue);
        assertEquals(exceptedvalue, player.getFigure());

    }
}