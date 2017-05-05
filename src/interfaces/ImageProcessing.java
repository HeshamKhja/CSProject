package interfaces;

import java.util.*;


public interface ImageProcessing {
    public abstract Image thresholding (Image image, byte thresholdValue);
    public abstract Image toDouble (Image image);
    public abstract Map<Byte, Integer> Histogram (Image image);
    public abstract int MatchPattern (Image subimage, Image image);
    
}