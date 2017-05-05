package core;


import interfaces.*;
import java.util.ArrayList;
import java.util.Collections;


public class ImageTest {
    
    public static void main(String [] args){
        
        ArrayList<Image> images = new ArrayList<Image>();

        images.add(new GrayImageImpl(25, 30, "gimage01.png"));
        images.add(new GrayImageImpl(40, 60, "gimage02.png"));
        images.add(new GrayImageImpl(50, 70, "gimage03.png"));
        
        images.add(new RGBImageImpl(25, 30, "cimage01.bmp"));
        images.add(new RGBImageImpl(40, 60, "cimage02.bmp"));
        images.add(new RGBImageImpl(50, 70, "cimage03.bmp"));
        
        Collections.sort(images);
        
        int grayImageCount=0;
        int rgbImageCount=0;
        
        for (Image image : images){
            image.randomize();
            if (image instanceof GrayImageImpl){
                grayImageCount++;
            }else if (image instanceof RGBImageImpl){
                rgbImageCount++;
            }
        }
        
        System.out.println("rgbImageCount " + rgbImageCount);
        System.out.println("grayImageCount " + grayImageCount);
        
    }
    
}
