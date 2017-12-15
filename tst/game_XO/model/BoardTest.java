package game_XO.model;

import game_XO.model.exceptions.InvalidPointException;
import game_XO.model.exceptions.LowerZeroException;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testGetSize() throws Exception{
        Board field = new Board();
        final int exceptionValue = field.getFieldSize();

        assertEquals(3, exceptionValue);

    }

    @Test
    public void testGetSizeLowerZero() throws Exception{
        try {
            Board field = new Board(-1);
            fail();
        }catch (LowerZeroException e){}
    }

//    @Test
//    public void testGetSizeNoInt() throws Exception{
//        try {
//            Board field = new Board(1.5);
//            fail();
//        }catch (LowerZeroException e){}
//    }

    @Test
    public void testSetFigure() throws Exception{
        Board field = new Board();
        Point inputPoint = new Point(0,0);
        Figure inputFigure = Figure.X;
        field.setFigure(inputPoint,inputFigure);
        Figure actualFugure = field.getFigure(inputPoint);
        assertEquals(inputFigure, actualFugure);
    }

    @Test
    public void testGetFigureWenFigureIsNotSet() throws Exception{
        Board field = new Board();
        Point inputPoint = new Point(0,0);
        Figure actualFugure = field.getFigure(inputPoint);
        assertNull (actualFugure);
    }

    @Test
    public void testGetFigureWenXIsLessThenZero() throws Exception{
        Board field = new Board();
        Point inputPoint = new Point(field.getFieldSize(),0);
        try {
            field.getFigure(inputPoint);
            fail();
        }catch (InvalidPointException e){}
    }

    @Test
    public void testGetFigureWenYIsLessThenZero() throws Exception{
        Board field = new Board();
        Point inputPoint = new Point(0,-1);

        try {
            field.getFigure(inputPoint);
            fail();
        }catch (InvalidPointException e){}
    }



}