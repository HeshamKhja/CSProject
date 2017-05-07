package core;

import interfaces.*;
import java.util.Map;
import java.util.TreeMap;

public class ImageProcessingImpl implements ImageProcessing{
    
    private static ImageProcessing instance = null;
    
    private ImageProcessingImpl(){
        
    }
    
    public static ImageProcessing getInstance(){
        if (instance == null){
             instance = new ImageProcessingImpl();
        }
        return instance;
    }

    @Override
    public Image thresholding(Image image, int thresholdValue) {
        if(image instanceof GrayImage){
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    if( (int) (((GrayColor)(image.getImg()[i][j].getColor())).getColor()) <= thresholdValue){
                        //((GrayColor)(image.getImg()[i][j].getColor())).setColor((int)0);
                        image.getImg()[i][j].setColor(new GrayColorImpl(0));
                    } else if( (int) (((GrayColor)(image.getImg()[i][j].getColor())).getColor()) > thresholdValue){
                        //((GrayColor)(image.getImg()[i][j].getColor())).setColor((int)255);
                        image.getImg()[i][j].setColor(new GrayColorImpl(255));
                    }
                }
            }
            return image;
        }
        else 
            return null;
    }

    @Override
    public Image toDouble(Image image) {
        if(image instanceof GrayImage){
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    double d = ((int)(((GrayColor)(image.getImg()[i][j].getColor())).getColor()))/255.0;
                    //((GrayColor)(image.getImg()[i][j].getColor())).setColor(d);
                    image.getImg()[i][j] = new GrayPixelImpl(new GrayColorImpl(d));
                    //double d = (double)(((GrayColor)(image.getImg()[i][j].getColor())).getColor())/255.0;
                    //System.out.println("d" +d);
                    //((GrayColor)(image.getImg()[i][j].getColor())).setColor(d);
                    //((GrayColorImpl)(image.getImg()[i][j].getColor())).setColor(((GrayColorImpl)(image.getImg()[i][j].getColor())).getColor()/255.0);
                }
            }
        }
        else if(image instanceof RGBImage){
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    double dr = ((int)(((RGBColor)(image.getImg()[i][j].getColor())).getRed()))/255.0;
                    double dg = ((int)(((RGBColor)(image.getImg()[i][j].getColor())).getGreen()))/255.0;
                    double db = ((int)(((RGBColor)(image.getImg()[i][j].getColor())).getBlue()))/255.0;
                    ((RGBColor)(image.getImg()[i][j].getColor())).setRed(dr);
                    ((RGBColor)(image.getImg()[i][j].getColor())).setGreen(dg);
                    ((RGBColor)(image.getImg()[i][j].getColor())).setBlue(db);
                }
            }
        }
        return image;
    }

    @Override
    public Map<Integer, Integer> Histogram(Image image) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        if(image instanceof GrayImage){
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    int tmp = (int)(((GrayColorImpl)(image.getImg()[i][j].getColor())).getColor());
                    if (map.containsKey(tmp))
                        map.put(tmp, map.get(tmp)+1);
                    else
                        map.put(tmp, 1);
                }
            }
        }
        else if(image instanceof RGBImage){
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    int[] tmp = {(int)(((RGBColorImpl)(image.getImg()[i][j].getColor())).getRed()),
                                 (int)(((RGBColorImpl)(image.getImg()[i][j].getColor())).getGreen()),
                                 (int)(((RGBColorImpl)(image.getImg()[i][j].getColor())).getBlue())};
                    for (int k = 0; k < tmp.length; k++) {
                        if (map.containsKey(tmp[k]))
                        map.put(tmp[k], map.get(tmp[k])+1);
                    else
                        map.put(tmp[k], 1);
                    }
                    
                }
            }
        }
        return map;
    }
    
    @Override
    public int MatchPattern(Image subimage, Image image) {
        int count = 0;
        String img = "";
        String subImg = "";
        if (image instanceof GrayImage){
            for (int i = 0; i < image.getHeight() - subimage.getHeight() +1; i++) {
                for (int j = 0; j < image.getWidth() - subimage.getWidth() +1; j++) {
                    for (int k = i; k < subimage.getHeight() + i; k++) {
                        for (int l = j; l < subimage.getWidth() + j; l++) {
                            img = img + ((GrayColor)(image.getImg()[k][l].getColor())).getColor();
                        }
                    }
                    img = img + " ";
                }
            }
            for (int i = 0; i < subimage.getHeight(); i++) {
                for (int j = 0; j < subimage.getWidth(); j++) {
                    subImg = subImg + ((GrayColor)(subimage.getImg()[i][j].getColor())).getColor();
                }
            }

            String[] arr = img.split(" ");
            for (String st : arr) {
                if (st.equals(subImg))
                    count++;
            }
        } else if(image instanceof RGBImage){
            for (int i = 0; i < image.getHeight() - subimage.getHeight() +1; i++) {
                for (int j = 0; j < image.getWidth() - subimage.getWidth() +1; j++) {
                    for (int k = i; k < subimage.getHeight() + i; k++) {
                        for (int l = j; l < subimage.getWidth() + j; l++) {
                            img = img + ((RGBColor)(image.getImg()[k][l].getColor())).getRed()
                                      + ((RGBColor)(image.getImg()[k][l].getColor())).getGreen()
                                      + ((RGBColor)(image.getImg()[k][l].getColor())).getBlue();
                        }
                    }
                    img = img + " ";
                }
            }
            for (int i = 0; i < subimage.getHeight(); i++) {
                for (int j = 0; j < subimage.getWidth(); j++) {
                    subImg = subImg + ((RGBColor)(subimage.getImg()[i][j].getColor())).getRed()
                                    + ((RGBColor)(subimage.getImg()[i][j].getColor())).getGreen()
                                    + ((RGBColor)(subimage.getImg()[i][j].getColor())).getBlue();
                }
            }
            
            String[] arr = img.split(" ");
            for (String st : arr) {
                if (st.equals(subImg))
                    count++;
            }
        }
        return count;
    }
}
