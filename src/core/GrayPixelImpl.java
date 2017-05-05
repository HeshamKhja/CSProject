package core;

import interfaces.*;

public class GrayPixelImpl implements Pixel{
    
    private GrayColor color;
    
    public GrayPixelImpl(Color color){
        super();
        setColor(color);
    }
    
    
    public Color getColor() {
        return new GrayColorImpl(color);
    }

    public void setColor(Color color) {
        if (color instanceof GrayColor)
            this.color = (GrayColor)color;
    }
    
    public String toString(){
        return String.format("%d",color);
    }

    

    @Override
    public int compareTo(Pixel pixel) {
        return this.getColor().compareTo(pixel.getColor());
    }
    
    
}
