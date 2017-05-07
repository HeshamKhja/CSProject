package core;

import interfaces.Image;

public class ImageFactory {
    
    private static ImageFactory instance = null;
    
    private ImageFactory(){
        
    }
    
    public static ImageFactory getInstance(){
        if (instance == null){
             instance = new ImageFactory();
        }
        return instance;
    }
    
    public Image getImage(String type, int width, int height, String name ){
        if(type.compareToIgnoreCase("gray") == 0)
            return new GrayImageImpl(width, height, name);
        else if(type.compareToIgnoreCase("rgb") == 0)
            return new RGBImageImpl(width, height, name);
        return null;
    }
}
