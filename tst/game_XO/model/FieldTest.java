package game_XO.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void testGetSize() throws Exception{
        Field field = new Field();
        final int exceptionValue = field.getFieldSize();

        assertEquals(3, exceptionValue);

    }

    @Test
    public void testSetFigure() {
        Field field = new Field();
        Point inputPoint = new Point(0,0);
        Figure inputFigure = Figure.X;
        field.setFigure(inputPoint,inputFigure);
        Figure actualFugure = field.getFigure(inputPoint);
        assertEquals(inputFigure, actualFugure);
    }
}