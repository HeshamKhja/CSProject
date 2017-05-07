package core;

import interfaces.Color;
import interfaces.GrayColor;

public class GrayColorImpl implements GrayColor{
    
    private Number color;
    
    public GrayColorImpl(Number color){
        setColor(color);
    }
    
    public GrayColorImpl(GrayColor gp){
        this(gp.getColor());
    }

    public Number getColor() {
        return color;
    }
    

    public void setColor(Number color) {
        this.color = color;
    }
    
    public String toString(){
        return String.format("%d",color);
    }

    @Override
    public int compareTo(Color color) {
        if (color instanceof GrayColor){
            GrayColor gray = (GrayColor)color;
            if (gray.getColor() instanceof Integer)
                return (Integer)(this.getColor())-(Integer)(gray.getColor());
            else if (gray.getColor() instanceof Double){
                if((Double)(this.getColor())-(Double)(gray.getColor())>0)
                    return 1;
                else if((Double)(this.getColor())-(Double)(gray.getColor())<0)
                    return -1;
                return 0;
            }
        }
        return -9999;        
    }
}
