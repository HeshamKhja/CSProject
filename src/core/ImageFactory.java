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
        if(type.equalsIgnoreCase("gray"))
            return new GrayImageImpl(width, height, name);
        else if(type.equalsIgnoreCase("rgb"))
            return new RGBImageImpl(width, height, name);
        return null;
    }
}
