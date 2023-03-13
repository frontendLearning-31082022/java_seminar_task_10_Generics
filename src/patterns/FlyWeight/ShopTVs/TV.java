package patterns.FlyWeight.ShopTVs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class TV {
    protected String model;
    public String pathIMG;

    private boolean bonusChannels = false;

    BufferedImage image;

    public TV(String model, String pathIMG) {
        this.model = model;
        this.pathIMG = pathIMG;
        loadImage();
    }

    void loadImage() {
        try {
            image = ImageIO.read(new File(pathIMG + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getModel() {
        return model;
    }

    Image getImage() {
        return image;
    }

    public void setBonusChannelPacket() {
        bonusChannels = true;
    }

    public boolean isBonusChannels() {
        return bonusChannels;
    }

}

class SamsungTV extends TV {
    public SamsungTV(String model, String pathIMG) {
        super(model,pathIMG);
    }
}

class SonyTV extends TV {
    public SonyTV(String model, String pathIMG) {
        super(model,pathIMG);
    }
}

class DigmaTV extends TV {
    public DigmaTV(String model, String pathIMG) {
        super(model,pathIMG);
    }
}