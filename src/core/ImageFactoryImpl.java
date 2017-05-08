package core;

import interfaces.Image;
import interfaces.ImageFactory;
import interfaces.ImageProcessing;

public class ImageFactoryImpl implements ImageFactory{
    
    private static ImageFactoryImpl instance = null;
    
    private ImageFactoryImpl(){
        
    }
    
    public static ImageFactoryImpl getInstance(){
        if (instance == null){
             instance = new ImageFactoryImpl();
        }
        return instance;
    }
    
    @Override
    public Image getImage(String type, int width, int height, String name ){
        if(type.equalsIgnoreCase("gray"))
            return new GrayImageImpl(width, height, name);
        else if(type.equalsIgnoreCase("rgb"))
            return new RGBImageImpl(width, height, name);
        return null;
    }
    
    @Override
    public ImageProcessing getImageProcessing() {
        return ImageProcessingImpl.getInstance();
    }
}
