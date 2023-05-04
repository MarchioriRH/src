package TP3.Ej_2;

public class Vertice<T> {
    private String color;
    private T key;
    private int foundTime, endTime;

    public Vertice (T key){
        this.key = key;
        this.color = "";
        this.foundTime = 0;
        this.endTime = 0;
    }
    
    public Vertice(T key, String color, int foundTime){
        this.key = key;
        this.color = color;
        this.foundTime = foundTime;
        this.endTime = 0;
    }

    public T getKey(){
        return this.key;
    }

    public int getFoundTime(){
        return this.foundTime;
    }
    
    public void setFoundTime(int foudTime){
        this.foundTime = foudTime;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setEndTime(int endTime){
        this.endTime = endTime;
    }

    public int getEndTime(){
        return this.endTime;
    }

    @Override
    public String toString(){
        return "Key: " + this.key.toString() + ", color: " + this.getColor() + 
                ", TimeFound: " + getFoundTime() + ", TimeEnd: " + this.getEndTime();
    }
}
