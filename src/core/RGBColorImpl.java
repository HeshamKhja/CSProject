package core;

import interfaces.Color;
import interfaces.RGBColor;

public class RGBColorImpl implements RGBColor{
 
    public byte Red;
    public byte Green;
    public byte Blue;
    
    public double dRed;
    public double dGreen;
    public double dBlue;

    public RGBColorImpl(byte R, byte G, byte B) {
        setBlue(B);
        setGreen(G);
        setRed(R);
    }
    
    public RGBColorImpl(double R, double G, double B) {
        setBlue(B);
        setGreen(G);
        setRed(R);
    }
    
    public byte getRed() {
        return Red;
    }

    public void setRed(byte R) {
        this.Red = R;
    }

    public byte getGreen() {
        return Green;
    }

    public void setGreen(byte G) {
        this.Green = G;
    }

    public byte getBlue() {
        return Blue;
    }

    public void setBlue(byte B) {
        this.Blue = B;
    }
    
    public double getDRed() {
        return dRed;
    }

    public void setRed(double R) {
        this.dRed = R;
    }

    public double getDGreen() {
        return dGreen;
    }

    public void setGreen(double G) {
        this.dGreen = G;
    }

    public double getDBlue() {
        return dBlue;
    }

    public void setBlue(double B) {
        this.dBlue = B;
    }
    
    public String toString(){
        return String.format("(%d,%d,%d)",Red,Green,Blue);
    }

    @Override
    public int compareTo(Color color) {
        if (color instanceof RGBColor){
            RGBColor rgb = (RGBColor)color;
            return (this.getBlue()+this.getGreen()+this.getRed())-(rgb.getBlue()+rgb.getGreen()+rgb.getRed());
        }
        return -9999;
    }
}
