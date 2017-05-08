package core;

import interfaces.GrayImage;
import interfaces.Pixel;

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

    @Override
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

    @Override
    public String toString() {
        return String.format("Gray %s", super.toString());
    }
    
}