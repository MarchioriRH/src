package TP4.Ej_9;

public class Coordinate {
    int row, column;
    
    public Coordinate(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.column;
    }    

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (row != other.row)
            return false;
        if (column != other.column)
            return false;
        return true;
    }   

    @Override
    public String toString() {
        return "{" + row + ", " + column + "}";
    }        
}