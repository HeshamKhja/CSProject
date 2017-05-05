package core;

import interfaces.Color;
import interfaces.GrayColor;

public class GrayColorImpl implements GrayColor{
    
    private byte color;
    private double dColor;
    
    public GrayColorImpl(byte color){
        setColor(color);
    }
    public GrayColorImpl(double color){
        setColor(color);
    }
    
    public GrayColorImpl(GrayColor gp){
        this(gp.getColor());
    }

    public byte getColor() {
        return color;
    }
    
    public double getDColor() {
        return dColor;
    }

    public void setColor(byte color) {
        this.color = color;
    }
    public void setColor(double color) {
        this.dColor = color;
    }
    
    public String toString(){
        return String.format("%d",color);
    }

    @Override
    public int compareTo(Color color) {
        if (color instanceof GrayColor){
            GrayColor gray = (GrayColor)color;
            return (this.getColor()-gray.getColor());
        }
        return -9999;        
    }
}
