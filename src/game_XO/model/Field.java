package game_XO.model;

public class Field {
    private static final String DEFAULT_STATIC_FIND = " ";

    private static final int DEFAULT_FIELD_SIZE = 3;

    private final int fieldSize;

    private final Figure [][] figure;

    public Field(){
        this(DEFAULT_FIELD_SIZE);
    }

    public Field(int size){
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

    public Figure getFigure(final Point point) {
        return this.figure[point.getX()][point.getY()];
    }

    public void setFigure (Point point, Figure figure){
        this.figure[point.getX()][point.getY()] = figure;
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
            System.out.print("[" + this.getFigure(new Point(x,y)) + "]");
        }
    }


}
