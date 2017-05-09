package core;

import interfaces.*;
import java.util.ArrayList;
import java.util.Map;

public class ImageTest {
    
    public static void main(String [] args){
        
        ArrayList<Image> images = new ArrayList<Image>();

        images.add(new GrayImageImpl(25, 30, "gimage01.pgm"));
        images.add(new GrayImageImpl(40, 60, "gimage02.pgm"));
        images.add(new GrayImageImpl(50, 70, "gimage03.pgm"));
        
        images.add(new RGBImageImpl(25, 30, "cimage01.pgm"));
        images.add(new RGBImageImpl(40, 60, "cimage02.pgm"));
        images.add(new RGBImageImpl(50, 70, "cimage03.pgm"));
        
        for (Image image : images){
            image.randomize();
        }
        
        ImageFactory imf = ImageFactoryImpl.getInstance();
        ImageProcessing imp = imf.getImageProcessing();
        
        for (int i = 0; i < images.get(0).getHeight(); i++) {
            for (int j = 0; j < images.get(0).getWidth(); j++) {
                System.out.print(((GrayColor)(images.get(0).getImg()[i][j].getColor())).getColor()+ "\t");
            }
            System.out.println("");
        }
        
        /*
        for (int i = 0; i < images.get(3).getHeight(); i++) {
            for (int j = 0; j < images.get(3).getWidth(); j++) {
                System.out.print(((RGBColor)(images.get(3).getImg()[i][j].getColor())).getRed() + " "
                               + ((RGBColor)(images.get(3).getImg()[i][j].getColor())).getGreen() + " "
                               + ((RGBColor)(images.get(3).getImg()[i][j].getColor())).getBlue() + " \t");
            }
            System.out.println("");
        }
        System.out.println("\n\n");
        */
        imp.thresholding(images.get(0), 110);
        
        System.out.println("\n\n");
        
        for (int i = 0; i < images.get(0).getHeight(); i++) {
            for (int j = 0; j < images.get(0).getWidth(); j++) {
                System.out.print(((GrayColor)(images.get(0).getImg()[i][j].getColor())).getColor()+ "\t");
            }
            System.out.println("");
        }
        /*
        for (int i = 0; i < images.get(3).getHeight(); i++) {
            for (int j = 0; j < images.get(3).getWidth(); j++) {
                System.out.print(((RGBColor)(images.get(3).getImg()[i][j].getColor())).getRed() + " "
                               + ((RGBColor)(images.get(3).getImg()[i][j].getColor())).getGreen() + " "
                               + ((RGBColor)(images.get(3).getImg()[i][j].getColor())).getBlue() + " \t");
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
