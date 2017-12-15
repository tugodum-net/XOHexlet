package game_XO.model;

import game_XO.model.exceptions.InvalidPointException;
import game_XO.model.exceptions.LowerZeroException;

public class Board {
    private static final String DEFAULT_STATIC_FIND = " ";

    private static final int DEFAULT_FIELD_SIZE = 3;

    private static final int MIN_CORDINATE = 0;

    private final int fieldSize;

    private final Figure [][] figure;

    public Board() throws LowerZeroException{
        this(DEFAULT_FIELD_SIZE);
    }

    public Board(int size) throws LowerZeroException{
        if (size < DEFAULT_FIELD_SIZE) {
            this.figure = new Figure[DEFAULT_FIELD_SIZE][DEFAULT_FIELD_SIZE];
            System.out.println("Размер поля недопустим, минимальный размер поля =" + DEFAULT_FIELD_SIZE);
            System.out.println("Создано поле "+DEFAULT_FIELD_SIZE +"*"+ DEFAULT_FIELD_SIZE);
            throw new LowerZeroException();
        } else{
            fieldSize = size;
            figure = new Figure[fieldSize][fieldSize];
        }
    }

    public Figure[][] getFiguresArray() {
        return figure;
    }

    public void printBoard()throws InvalidPointException{
        for (int i = 0; i < fieldSize; i++){
            showLine(i);
            System.out.println();
        }

    }

    public int getFieldSize(){
        return fieldSize;
    }

    public int checkQantityFigureInBoard(Figure figure){     //возвращает количество переданных в метод символов в массиве figure
        int count = 0;
        for (Figure x[] : this.figure){
            for (Figure y : x){
                if (y == figure)
                count++;
            }
        }
        return count;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        boolean b = !checkPoint(point);
        if (!checkPoint(point)){
            throw new InvalidPointException();
        }
        return this.figure[point.getX()][point.getY()];
    }

    public void setFigure (Point point, Figure figure) throws InvalidPointException {
        if (!checkPoint(point)){
            throw new InvalidPointException();
        }
        this.figure[point.getX()][point.getY()] = figure;
    }

    private boolean checkPoint (Point point) throws InvalidPointException {
        return (checkCordinate(point.getX()) && checkCordinate(point.getY()));
    }

    private boolean checkCordinate (final int coordinate) throws InvalidPointException {
        return (coordinate < this.fieldSize && coordinate >= MIN_CORDINATE);
    }

    private void showLine(int lineNumber)throws InvalidPointException{
        for (int i = 0; i<fieldSize; i++){
            showCell(i,lineNumber);
        }
    }

    private void showCell (int x, int y) throws InvalidPointException{
        if (this.figure[x][y] == null){
            System.out.print("[" + DEFAULT_STATIC_FIND + "]");
        } else {
            System.out.print("[" + this.getFigure(new Point(x,y)) + "]");
        }
    }


}
