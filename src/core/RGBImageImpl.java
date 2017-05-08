package core;

import interfaces.Pixel;
import interfaces.RGBImage;

public class RGBImageImpl extends ImageImpl implements RGBImage {

    private Pixel[][] img;

    private final int maxColor = 256;

    public RGBImageImpl(int width, int height, String name) {
        super(width, height, name);
        img = new RGBPixelImpl[height][width];
    }

    public RGBImageImpl(RGBImageImpl im) {
        super(im.getWidth(), im.getHeight(), im.getName());
        img = new RGBPixelImpl[im.getHeight()][im.getWidth()];
        img = im.getImg();
    }

    @Override
    public Pixel[][] getImg() {
        return img;
    }

    public void setImg(RGBPixelImpl[][] img) {
        this.img = img;
    }

    @Override
    public void randomize() {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                img[i][j] = new RGBPixelImpl(new RGBColorImpl(
                        (int) (Math.random() * maxColor),
                        (int) (Math.random() * maxColor),
                        (int) (Math.random() * maxColor)));
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Color %s", super.toString());
    }
    
}
