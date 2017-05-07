package core;

import interfaces.Color;
import interfaces.GrayColor;
import interfaces.Pixel;

public class GrayPixelImpl implements Pixel{
    
    private GrayColor color;
    
    public GrayPixelImpl(Color color){
        super();
        setColor(color);
    }
    
    @Override
    public Color getColor() {
        return new GrayColorImpl(color);
    }

    @Override
    public void setColor(Color color) {
        if (color instanceof GrayColor)
            this.color = (GrayColor)color;
    }
    
    @Override
    public String toString(){
        return String.format("%d",color);
    }

    @Override
    public int compareTo(Pixel pixel) {
        return this.getColor().compareTo(pixel.getColor());
    }
    
}
