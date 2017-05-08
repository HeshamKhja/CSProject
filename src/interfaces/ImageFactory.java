package interfaces;

public interface ImageFactory {
    
    public Image getImage(String type, int width, int height, String name );
    public ImageProcessing getImageProcessing();
    
}
