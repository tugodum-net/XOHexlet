package game_XO.controller;

import game_XO.model.Board;
import game_XO.model.Figure;
import game_XO.model.Player;
import game_XO.model.Point;
import game_XO.model.exceptions.AlreadyOccupaiedException;
import game_XO.model.exceptions.InvalidPointException;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameControllerTest {

    @Test
    public void currentPlayer() throws Exception{
    }

    @Test
    public void moveTestWithFigure()  throws Exception{
        Board field = new Board();
        Point currentPoint = new Point(2,2);
        Figure currentFigure = Figure.X;
        GameController controller = new GameController(null,new Player[]{      new Player("Vova",  Figure.X),
                                                                                            new Player("Pavel",  Figure.O)} , field);
        controller.move(currentPoint,currentFigure);
        Figure actualFigure = controller.getBoard().getFigure(currentPoint);
        assertEquals(currentFigure,actualFigure);

    }

    @Test
    public void moveTestWithIllegalPoint()  throws Exception{

        Board field = new Board();
        Point currentPoint = new Point(2, -1);
        Figure currentFigure = Figure.X;
        GameController controller = new GameController("xo", new Player[]{new Player("Vova", Figure.X),
                new Player("Pavel", Figure.O)}, field);
        try {
            controller.move(currentPoint, currentFigure);
            fail();
        } catch (InvalidPointException e){}

    }

    @Test
    public void moveTestWithIllegalPointBigeer()  throws Exception{

        Board field = new Board();
        Point currentPoint = new Point(2, field.getFieldSize());
        Figure currentFigure = Figure.X;
        GameController controller = new GameController("xo", new Player[]{new Player("Vova", Figure.X),
                new Player("Pavel", Figure.O)}, field);
        try {
            controller.move(currentPoint, currentFigure);
            fail();
        } catch (InvalidPointException e){}

    }

    @Test
    public void moveTestAllreadeOccupaied()  throws Exception{

        Board field = new Board();
        Point currentPoint = new Point(0, 0);
        Figure currentFigure = Figure.X;
        GameController controller = new GameController("xo", new Player[]{new Player("Vova", Figure.X),
                new Player("Pavel", Figure.O)}, field);
        try {
            controller.move(new Point(0, 0), currentFigure);
            controller.move(new Point(0, 0), currentFigure);
            fail();
        } catch (AlreadyOccupaiedException e){}

    }

    @Test
    public void testNextTurn() throws Exception{

    }

    @Test
    public void testCheckWin()throws Exception {
        Board board = new Board();
        Figure currentFigure = Figure.X;
        GameController controller = new GameController("xo", new Player[]{new Player("Vova", Figure.X),
                new Player("Pavel", Figure.O)}, board);
        controller.move(new Point(0, 0), currentFigure);
        controller.move(new Point(0, 1), currentFigure);
        controller.move(new Point(0, 2), currentFigure);
        assertEquals(true, controller.checkWin(currentFigure));
    }
}