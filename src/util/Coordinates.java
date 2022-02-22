package util;

public class Coordinates {
    private long x; //Максимальное значение поля: 927
    private double y; //Максимальное значение поля: 772

    public Coordinates(long x, double y){
        setX(x);
        setY(y);
    }

    public void setX(long x) throws IllegalArgumentException{
        if (x <= 927){
            this.x = x;
        } else {
            throw new IllegalArgumentException("Максимальное значение поля: 927");
        }
    }
    public void setY(double y) throws IllegalArgumentException{
        if (y <= 772){
            this.y = y;
        } else {
            throw new IllegalArgumentException("Максимальное значение поля: 772");
        }
    }
    public long getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    @Override
    public String toString(){
        return String.format("X - %d, Y - %.5f", x, y);
    }
}
