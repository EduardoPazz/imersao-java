package imersao_java;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class StickerGenerator {
    public static void gen(InputStream imageSource, String fileName)
            throws IOException {
        BufferedImage originalImage = ImageIO.read(imageSource);
        BufferedImage newImage = new BufferedImage(originalImage.getWidth(),
                originalImage.getHeight() + 200, BufferedImage.TRANSLUCENT);

        Graphics2D newImageGraphics = newImage.createGraphics();

        newImageGraphics.drawImage(originalImage, 0, 0, null);
        newImageGraphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));
        newImageGraphics.setColor(Color.CYAN);
        newImageGraphics.drawString("TOPZERA", newImage.getWidth() / 2,
                newImage.getHeight() - 100);

        ImageIO.write(newImage, "png", new File("public/" + fileName + ".png"));
    }
}
