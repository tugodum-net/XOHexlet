package game_XO.model;

public class Board {
    private static final String DEFAULT_STATIC_FIND = " ";

    private static final int DEFAULT_FIELD_SIZE = 3;

    private final int fieldSize;

    private final Figure [][] figure;

    public Board(){
        this(DEFAULT_FIELD_SIZE);
    }

    public Board(int size){
        fieldSize = size;
        figure = new Figure [fieldSize][fieldSize];
    }

    public void printBoard(){                       //выводит доску
        System.out.println();
        for (int i = 0; i < fieldSize; i++){
            showLine(i);
            System.out.println();
        }

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

    public Figure[][] getFigure() {
        return figure;
    }

    public void setFigure (int  x, int y, Figure figure){
        this.figure[x][y] = figure;
    }

    private void showLine(int lineNumber){
        for (int i = 0; i<fieldSize; i++){
            showCell(i,lineNumber);
        }
    }

    private void showCell (int x, int y){
        if (this.figure[x][y] == null){
            System.out.print("[" + DEFAULT_STATIC_FIND + "]");
        } else {
            System.out.print("[" + this.figure[x][y].getFigure() + "]");
        }
    }


}
