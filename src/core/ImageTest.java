package core;


import interfaces.*;
import java.util.ArrayList;


public class ImageTest {
    
    public static void main(String [] args){
        
        ArrayList<Image> images = new ArrayList<Image>();

        images.add(new GrayImageImpl(25, 30, "gimage01.png"));
        images.add(new GrayImageImpl(5, 5, "gimage02.png"));
        images.add(new GrayImageImpl(50, 70, "gimage03.png"));
        
        images.add(new RGBImageImpl(25, 30, "cimage01.bmp"));
        images.add(new RGBImageImpl(40, 60, "cimage02.bmp"));
        images.add(new RGBImageImpl(50, 70, "cimage03.bmp"));
        
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
        
        ImageProcessing imp = ImageProcessingImpl.getInstance();
        
        for (int i = 0; i < images.get(0).getHeight(); i++) {
            for (int j = 0; j < images.get(0).getWidth(); j++) {
                System.out.print(((GrayColor)(images.get(0).getImg()[i][j].getColor())).getColor() + " ");
            }
            System.out.println("");
        }
        System.out.println("\n\n");
        
        int count = imp.MatchPattern(images.get(1), images.get(0));
        System.out.println("count: " + count);
        
        for (int i = 0; i < images.get(1).getHeight(); i++) {
            for (int j = 0; j < images.get(1).getWidth(); j++) {
                System.out.print(((GrayColor)(images.get(1).getImg()[i][j].getColor())).getColor() + " ");
            }
            System.out.println("");
        }
        
        //int test = imp.MatchPattern(images.get(1), images.get(0));
        
        //System.out.println("count: " + test);
        
        /*
        for (int i = 0; i < images.get(0).getHeight(); i++) {
            for (int j = 0; j < images.get(0).getWidth(); j++) {
                System.out.print(((GrayColor)(images.get(0).getImg()[i][j].getColor())).getColor()+ "\t");
            }
            System.out.println("");
        }
        
        System.out.println("\n\n");
        
        for (int i = 0; i < test.getHeight(); i++) {
            for (int j = 0; j < test.getWidth(); j++) {
                System.out.print(((GrayColor)(images.get(0).getImg()[i][j].getColor())).getColor() + " ");
            }
            System.out.println("");
        }
        */
    }
}
