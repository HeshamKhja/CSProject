package core;

import interfaces.GrayImage;
import interfaces.Pixel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GrayImageImpl extends ImageImpl implements GrayImage {

    private Pixel[][] img;

    private final int maxColor = 256;

    public GrayImageImpl(int width, int height, String name) {
        super(width, height, name);
        img = new GrayPixelImpl[height][width];
    }

    public GrayImageImpl(GrayImageImpl im) {
        super(im.getWidth(), im.getHeight(), im.getName());
        img = new GrayPixelImpl[im.getHeight()][im.getWidth()];
        img = im.getImg();
    }

    public Pixel[][] getImg() {
        return img;
    }

    public void setImg(GrayPixelImpl[][] img) {
        this.img = img;
    }

    @Override
    public void randomize() {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                img[i][j] = new GrayPixelImpl(new GrayColorImpl((int) (Math.random() * maxColor)));
            }
        }
    }

    public String toString() {
        return String.format("Gray %s", super.toString());
    }

}


/*
    public boolean imread(String filename){
        try {
            Scanner reader = new Scanner(new File(filename));
            String type = reader.nextLine();
            reader.nextLine();
            String size = reader.nextLine();
            setWidth(Integer.parseInt(size.split(" ")[0]));
            setHeight(Integer.parseInt(size.split(" ")[0]));
            reader.nextLine();
            setName(filename);
            int i=0;
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                String [] colors = line.split(" ");
                for (int j=0;j<getWidth();j++){
                    img[i][j].setColor(Byte.parseByte(colors[i]));
                }
                i++;
            }
            return true;
            
        } catch (FileNotFoundException ex) {
            System.out.println("Image file not found");
            return false;
        }        
    }
    
    public boolean imwrite(String filename) {
        try {
            FileWriter fw = new FileWriter(new File(filename));
            fw.write("P2\n");
            fw.write("#Converted from MAP format\n");
            fw.write(String.format("%d %d\n", getWidth(), getHeight()));
            fw.write(maxColor+"\n");
            
            for (int i=0;i<getHeight();i++){
               for (int j=0;j<getWidth();j++){
                   fw.write(img[i][j].getColor()+" ");
               }
               fw.write("\n");
            }
            fw.close();
            return true;
        } catch (IOException ex) {
            System.out.println("Image IO Exception");
            return false;
        }        
    }
 */
