
package core;

import interfaces.Color;
import interfaces.RGBColor;


public class RGBColorImpl implements RGBColor{
 
    public Number Red;
    public Number Green;
    public Number Blue;
    

    public RGBColorImpl(Number R, Number G, Number B) {
        setBlue(B);
        setGreen(G);
        setRed(R);
    }
    
    public Number getRed() {
        return Red;
    }

    public void setRed(Number R) {
        this.Red = R;
    }

    public Number getGreen() {
        return Green;
    }

    public void setGreen(Number G) {
        this.Green = G;
    }

    public Number getBlue() {
        return Blue;
    }

    public void setBlue(Number B) {
        this.Blue = B;
    }
    
    public String toString(){
        return String.format("(%d,%d,%d)",Red,Green,Blue);
    }

    @Override
    public int compareTo(Color color) {
        if (color instanceof RGBColor){
            RGBColor rgb = (RGBColor)color;
            if (rgb.getBlue() instanceof Byte)
                return ((Integer)(this.getBlue())+(Integer)(this.getGreen())+((Integer)this.getRed())) -
                        ((Integer)(rgb.getBlue())+(Integer)(rgb.getGreen())+(Integer)(rgb.getRed()));
            else if (rgb.getBlue() instanceof Double){
                if(((Double)(this.getBlue())+(Double)(this.getGreen())+((Double)this.getRed())) -
                        ((Double)(rgb.getBlue())+(Double)(rgb.getGreen())+(Double)(rgb.getRed())) > 0)
                    return 1;
                else if(((Double)(this.getBlue())+(Double)(this.getGreen())+((Double)this.getRed())) -
                        ((Double)(rgb.getBlue())+(Double)(rgb.getGreen())+(Double)(rgb.getRed())) < 0)
                    return -1;
                return 0;
            }
        }
        return -9999;
    }
}
