package core;

import interfaces.Color;
import interfaces.Pixel;
import interfaces.RGBColor;

public class RGBPixelImpl implements Pixel{
    
    public RGBColor rgb;

    public RGBPixelImpl(RGBColor rgb) {
        super();
        setColor(rgb);
    }
    
    public RGBPixelImpl(RGBPixelImpl cp) {
        this((RGBColor)(cp.getColor()));
    }
       
    @Override
    public String toString(){
        return String.format("(%d)",rgb);
    }

    @Override
    public Color getColor() {
        return rgb;
    }

    @Override
    public void setColor(Color color) {
       if (color instanceof RGBColor)
        rgb = (RGBColor)color;
    }

    @Override
    public int compareTo(Pixel pixel) {
        return this.getColor().compareTo(pixel.getColor());
    }
}
