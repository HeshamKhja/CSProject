package core;

import interfaces.*;
import java.util.ArrayList;
import java.util.Map;

public class ImageTest {
    
    public static void print(Image image){
        if (image instanceof GrayImage) {
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    System.out.print(((GrayColor)(image.getImg()[i][j].getColor())).getColor()+ "\t");
                }
            System.out.println("");
            }
        } else if (image instanceof RGBImage) {
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    System.out.print(((RGBColor)(image.getImg()[i][j].getColor())).getRed() + " "
                                   + ((RGBColor)(image.getImg()[i][j].getColor())).getGreen() + " "
                                   + ((RGBColor)(image.getImg()[i][j].getColor())).getBlue() + "\t");
                }
            System.out.println("");
            }
        }
        System.out.println("\n\n");
    }
    
    public static void main(String [] args){
        
        ImageFactory imf = ImageFactoryImpl.getInstance();
        ImageProcessing imp = imf.getImageProcessing();
        
        ArrayList<Image> images = new ArrayList<Image>();
        
        images.add(imf.getImage("gray", 20, 20, "gimage01.pgm"));
        images.add(imf.getImage("gray", 20, 20, "gimage02.pgm"));
        images.add(imf.getImage("gray", 20, 20, "gimage03.pgm"));
        images.add(imf.getImage("rgb", 20, 20, "cimage01.pgm"));
        images.add(imf.getImage("rgb", 20, 20, "cimage02.pgm"));
        
        for (Image image : images){
            image.randomize();
        }
        
        //1- Test thresholding:
        print(images.get(0));
        imp.thresholding(images.get(0), 128);
        print(images.get(0));
        
        //2- Test toDouble:
            // Gray:
        print(images.get(1));
        imp.toDouble(images.get(1));
        print(images.get(1));
            // RGB:
        print(images.get(3));
        imp.toDouble(images.get(3));
        print(images.get(3));
        
        //3- Test Histogram:
            // Gray:
        print(images.get(2));
        System.out.println(imp.Histogram(images.get(2)) + "\n\n");
            // RGB:
        print(images.get(4));
        System.out.println(imp.Histogram(images.get(4)) + "\n\n");
        
        //4- Test MatchPattern:
            // Gray:
        Image mainImage = imf.getImage("gray", 4, 5, "testMPG1.pgm");
        Image subImage = imf.getImage("gray", 2, 2, "testMPG2.pgm");
        GrayPixelImpl[][] mainPiIm = {{new GrayPixelImpl(new GrayColorImpl(4)), new GrayPixelImpl(new GrayColorImpl(2)),new GrayPixelImpl(new GrayColorImpl(0)),new GrayPixelImpl(new GrayColorImpl(8))}, 
                                 {new GrayPixelImpl(new GrayColorImpl(3)), new GrayPixelImpl(new GrayColorImpl(1)),new GrayPixelImpl(new GrayColorImpl(4)),new GrayPixelImpl(new GrayColorImpl(2))},
                                 {new GrayPixelImpl(new GrayColorImpl(6)), new GrayPixelImpl(new GrayColorImpl(4)),new GrayPixelImpl(new GrayColorImpl(3)),new GrayPixelImpl(new GrayColorImpl(1))},
                                 {new GrayPixelImpl(new GrayColorImpl(9)), new GrayPixelImpl(new GrayColorImpl(4)),new GrayPixelImpl(new GrayColorImpl(2)),new GrayPixelImpl(new GrayColorImpl(7))},
                                 {new GrayPixelImpl(new GrayColorImpl(3)), new GrayPixelImpl(new GrayColorImpl(3)),new GrayPixelImpl(new GrayColorImpl(1)),new GrayPixelImpl(new GrayColorImpl(5))}};
        ((GrayImageImpl)(mainImage)).setImg(mainPiIm);
        
        GrayPixelImpl[][] subPiIm = {{new GrayPixelImpl(new GrayColorImpl(4)), new GrayPixelImpl(new GrayColorImpl(2))},
                                     {new GrayPixelImpl(new GrayColorImpl(3)), new GrayPixelImpl(new GrayColorImpl(1))}};
        ((GrayImageImpl)(subImage)).setImg(subPiIm);
        //count should be 3
        System.out.println("count: " + imp.MatchPattern(subImage, mainImage));
            // RGB:
        //It works too, but it will take 2 days to finish a code to test it
        
        //5- imwrite:
            // Gray:
        imp.imwrite(images.get(2), images.get(2).getName());
            // RGB:
        imp.imwrite(images.get(4), images.get(4).getName());
        //imread exists, but no image to test(format unknown)
    }
}
