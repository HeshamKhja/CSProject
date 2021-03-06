package core;

import interfaces.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ImageProcessingImpl implements ImageProcessing {

    private static ImageProcessing instance = null;

    private ImageProcessingImpl() {

    }

    public static ImageProcessing getInstance() {
        if (instance == null) {
            instance = new ImageProcessingImpl();
        }
        return instance;
    }

    @Override
    public Image thresholding(Image image, int thresholdValue) {
        if (image instanceof GrayImage) {
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    if ((int) (((GrayColor) (image.getImg()[i][j].getColor())).getColor()) <= thresholdValue) {
                        //((GrayColor)(image.getImg()[i][j].getColor())).setColor((int)0);
                        image.getImg()[i][j].setColor(new GrayColorImpl(0));
                    } else if ((int) (((GrayColor) (image.getImg()[i][j].getColor())).getColor()) > thresholdValue) {
                        //((GrayColor)(image.getImg()[i][j].getColor())).setColor((int)255);
                        image.getImg()[i][j].setColor(new GrayColorImpl(255));
                    }
                }
            }
            return image;
        } else {
            return null;
        }
    }

    @Override
    public Image toDouble(Image image) {
        if (image instanceof GrayImage) {
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    double d = ((int) (((GrayColor) (image.getImg()[i][j].getColor())).getColor())) / 255.0;
                    //((GrayColor)(image.getImg()[i][j].getColor())).setColor(d);
                    image.getImg()[i][j] = new GrayPixelImpl(new GrayColorImpl(d));
                }
            }
        } else if (image instanceof RGBImage) {
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    double dr = ((int) (((RGBColor) (image.getImg()[i][j].getColor())).getRed())) / 255.0;
                    double dg = ((int) (((RGBColor) (image.getImg()[i][j].getColor())).getGreen())) / 255.0;
                    double db = ((int) (((RGBColor) (image.getImg()[i][j].getColor())).getBlue())) / 255.0;
                    ((RGBColor) (image.getImg()[i][j].getColor())).setRed(dr);
                    ((RGBColor) (image.getImg()[i][j].getColor())).setGreen(dg);
                    ((RGBColor) (image.getImg()[i][j].getColor())).setBlue(db);
                }
            }
        }
        return image;
    }

    @Override
    public Map<Integer, Integer> Histogram(Image image) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        if (image instanceof GrayImage) {
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    int tmp = (int) (((GrayColorImpl) (image.getImg()[i][j].getColor())).getColor());
                    if (map.containsKey(tmp)) {
                        map.put(tmp, map.get(tmp) + 1);
                    } else {
                        map.put(tmp, 1);
                    }
                }
            }
        } else if (image instanceof RGBImage) {
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    int[] tmp = {(int) (((RGBColorImpl) (image.getImg()[i][j].getColor())).getRed()),
                        (int) (((RGBColorImpl) (image.getImg()[i][j].getColor())).getGreen()),
                        (int) (((RGBColorImpl) (image.getImg()[i][j].getColor())).getBlue())};
                    for (int k = 0; k < tmp.length; k++) {
                        if (map.containsKey(tmp[k])) {
                            map.put(tmp[k], map.get(tmp[k]) + 1);
                        } else {
                            map.put(tmp[k], 1);
                        }
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
        if (image instanceof GrayImage) {
            for (int i = 0; i <= image.getHeight() - subimage.getHeight(); i++) {
                for (int j = 0; j <= image.getWidth() - subimage.getWidth(); j++) {
                    if (subimage.getImg()[0][0].getColor().compareTo(image.getImg()[i][j].getColor()) != 0)
                        continue;
                    for (int k = i; k < subimage.getHeight() + i; k++) {
                        for (int l = j; l < subimage.getWidth() + j; l++) {
                            img = img + ((GrayColor) (image.getImg()[k][l].getColor())).getColor();
                        }
                    }
                    img = img + " ";
                }
            }
            for (int i = 0; i < subimage.getHeight(); i++) {
                for (int j = 0; j < subimage.getWidth(); j++) {
                    subImg = subImg + ((GrayColor) (subimage.getImg()[i][j].getColor())).getColor();
                }
            }
            System.out.println("\n" + img + "\n" + subImg);
            String[] arr = img.split(" ");
            for (String st : arr) {
                if (st.equals(subImg)) {
                    count++;
                }
            }
        } else if (image instanceof RGBImage) {
            for (int i = 0; i <= image.getHeight() - subimage.getHeight(); i++) {
                for (int j = 0; j <= image.getWidth() - subimage.getWidth(); j++) {
                    if (subimage.getImg()[0][0].getColor().compareTo(image.getImg()[i][j].getColor()) != 0)
                        continue;
                    for (int k = i; k < subimage.getHeight() + i; k++) {
                        for (int l = j; l < subimage.getWidth() + j; l++) {
                            img = img + ((RGBColor) (image.getImg()[k][l].getColor())).getRed()
                                    + ((RGBColor) (image.getImg()[k][l].getColor())).getGreen()
                                    + ((RGBColor) (image.getImg()[k][l].getColor())).getBlue();
                        }
                    }
                    img = img + " ";
                }
            }
            for (int i = 0; i < subimage.getHeight(); i++) {
                for (int j = 0; j < subimage.getWidth(); j++) {
                    subImg = subImg + ((RGBColor) (subimage.getImg()[i][j].getColor())).getRed()
                            + ((RGBColor) (subimage.getImg()[i][j].getColor())).getGreen()
                            + ((RGBColor) (subimage.getImg()[i][j].getColor())).getBlue();
                }
            }

            String[] arr = img.split(" ");
            for (String st : arr) {
                if (st.equals(subImg)) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public boolean imwrite(Image image, String filename) {
        if (image instanceof GrayImage) {
            try {
                FileWriter fw = new FileWriter(new File(filename));
                fw.write("P2\n");
                fw.write("#Converted from MAP format\n");
                fw.write(String.format("%d %d\n", image.getWidth(), image.getHeight()));

                for (int i = 0; i < image.getHeight(); i++) {
                    for (int j = 0; j < image.getWidth(); j++) {
                        fw.write(((GrayColorImpl) image.getImg()[i][j].getColor()).getColor() + " ");
                    }
                    fw.write("\n");
                }
                fw.close();
                return true;
            } catch (IOException ex) {
                System.out.println("GrayImage IO Exception");
                return false;
            }
        } else if (image instanceof RGBImage) {
            try {
                FileWriter fw = new FileWriter(new File(filename));
                fw.write("Color Image\n");
                fw.write(String.format("%d %d\n", image.getWidth(), image.getHeight()));

                for (int i = 0; i < image.getHeight(); i++) {
                    for (int j = 0; j < image.getWidth(); j++) {
                        Number r = ((RGBColorImpl) image.getImg()[i][j].getColor()).getRed();
                        Number g = ((RGBColorImpl) image.getImg()[i][j].getColor()).getGreen();
                        Number b = ((RGBColorImpl)  image.getImg()[i][j].getColor()).getBlue();
                        //fw.write(r + " " + g + " " + b + " ");
                        fw.write(String.format("%d %d %d\n", r, g, b));
                    }
                    fw.write("\n");
                }
                fw.close();
                return true;
            } catch (IOException ex) {
                System.out.println("Image IO Exception");
                return false;
            }
        } else {
            return false;
        }
    }
    
    @Override
    public Image imread(String filename) {
        Image image = null;
        try {
            Scanner reader = new Scanner(new File(filename));
            String type = reader.nextLine();
            if (type.equalsIgnoreCase("gray")) {
                reader.nextLine();
                String size = reader.nextLine();
                int width = Integer.parseInt(size.split(" ")[0]);
                int height = Integer.parseInt(size.split(" ")[1]);
                reader.nextLine();
                image = new GrayImageImpl(width, height, filename);
                int i = 0;
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    String[] colors = line.split(" ");
                    for (int j = 0; j < image.getWidth(); j++) {
                        ((GrayColor) (image.getImg()[i][j].getColor())).setColor(Integer.getInteger(colors[j]));
                    }
                    i++;
                }
            } else if (type.equalsIgnoreCase("rgb")) {
                reader.nextLine();
                String size = reader.nextLine();
                int width = Integer.parseInt(size.split(" ")[0]);
                int height = Integer.parseInt(size.split(" ")[1]);
                reader.nextLine();
                image = new RGBImageImpl(width, height, filename);
                int i = 0;
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    String[] colors = line.split(" ");
                    for (int j = 0; j < image.getWidth(); j++) {
                        ((RGBColor) (image.getImg()[i][j].getColor())).setRed(Integer.getInteger(colors[0]));
                        ((RGBColor) (image.getImg()[i][j].getColor())).setGreen(Integer.getInteger(colors[1]));
                        ((RGBColor) (image.getImg()[i][j].getColor())).setBlue(Integer.getInteger(colors[2]));
                    }
                    i++;
                    reader.nextLine();
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Image file not found");
        }
        return image;
    }

}
