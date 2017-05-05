package core;


import interfaces.*;
import java.util.Map;
import java.util.TreeMap;


public class ImageProcessingImpl implements ImageProcessing{

    @Override
    public Image thresholding(Image image, byte thresholdValue) {
        if(image instanceof GrayImageImpl){
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    if( ((GrayColorImpl)(image.getImg()[i][j].getColor())).getColor() <= thresholdValue){
                        ((GrayColorImpl)(image.getImg()[i][j].getColor())).setColor((byte)0);
                    } else if( ((GrayColorImpl)(image.getImg()[i][j].getColor())).getColor() > thresholdValue){
                        image.getImg()[i][j].setColor(new GrayColorImpl((byte)(255)));
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
        if(image instanceof GrayImageImpl){
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    ((GrayColorImpl)(image.getImg()[i][j].getColor())).setColor(((GrayColorImpl)(image.getImg()[i][j].getColor())).getColor()/255.0);
                }
            }
        }
        else if(image instanceof RGBImageImpl){
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    ((RGBColorImpl)(image.getImg()[i][j].getColor())).setBlue(((RGBColorImpl)(image.getImg()[i][j].getColor())).getBlue()/255.0);
                    ((RGBColorImpl)(image.getImg()[i][j].getColor())).setGreen(((RGBColorImpl)(image.getImg()[i][j].getColor())).getGreen()/255.0);
                    ((RGBColorImpl)(image.getImg()[i][j].getColor())).setRed(((RGBColorImpl)(image.getImg()[i][j].getColor())).getRed()/255.0);
                }
            }
        }
        return image;
    }

    @Override
    public Map<Byte, Integer> Histogram(Image image) {
        Map<Byte, Integer> map = new TreeMap<Byte, Integer>();
        if(image instanceof GrayImage){
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    byte tmp = ((GrayColorImpl)(image.getImg()[i][j].getColor())).getColor();
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
                    byte[] tmp = {((RGBColorImpl)(image.getImg()[i][j].getColor())).getRed(),
                                  ((RGBColorImpl)(image.getImg()[i][j].getColor())).getGreen(),
                                  ((RGBColorImpl)(image.getImg()[i][j].getColor())).getBlue()};
                    for (int k = 0; k < tmp.length; k++) {
                        if (map.containsKey(tmp[i]))
                        map.put(tmp[i], map.get(tmp[i])+1);
                    else
                        map.put(tmp[i], 1);
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
        if(image instanceof GrayImage){
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
            System.out.println(img);
            System.out.println(subImg);

            String[] arr = img.split(" ");
            for (String st : arr) {
                if (st.equals(subImg))
                    count++;
            }
            System.out.println(count);
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
                    subImg = subImg + ((RGBColor)(image.getImg()[i][j].getColor())).getRed()
                                    + ((RGBColor)(image.getImg()[i][j].getColor())).getGreen()
                                    + ((RGBColor)(image.getImg()[i][j].getColor())).getBlue();
                }
            }
            System.out.println(img);
            System.out.println(subImg);

            String[] arr = img.split(" ");
            for (String st : arr) {
                if (st.equals(subImg))
                    count++;
            }
            System.out.println(count);
        }
        return count;
    }
}
