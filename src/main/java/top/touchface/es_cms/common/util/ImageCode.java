package top.touchface.es_cms.common.util;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Random;

/**
 * @author Jason
 * 图片验证码工具类
 */
public class ImageCode {

    private static final Encoder encoder= Base64.getEncoder();
    // 图片的宽度。
    private int width;
    // 图片的高度。
    private int height;
    // 验证码字符个数
    private int codeCount;
    // 验证码干扰线数
    private int lineCount;
    // 验证码
    private String code = null;
    // 字符
    private char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private BufferedImage image=null;

    private static final Random random = new Random();

    public ImageCode(int width, int height, int codeCount, int lineCount) {
        this.width = width;
        this.height = height;
        this.codeCount = codeCount;
        this.lineCount = lineCount;
        this.randomCodeImage();
    }

    private void randomCodeImage() {
        //字符所在x坐标
        int x;
        //字体高度
        int fontHeight;
        //字符所在y坐标
        int codeY;
        int red;
        int green;
        int blue;
        x = width / (codeCount + 2);
        fontHeight = height - 2;
        codeY = height - 4;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics2D graphics2D = image.createGraphics();

        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, width,height);
        Font font = new Font("Fixedays",Font.PLAIN,fontHeight);
        graphics2D.setFont(font);

        for (int i = 0; i < lineCount; i++) {
            //x轴第一个点的位置
            int x1 = random.nextInt(width);
            //y轴第一个点的位置
            int y1 = random.nextInt(height);
            //x轴第二个点的位置
            int x2 = x1 + random.nextInt(width >> 2);
            //y轴第二个点的位置
            int y2 = y1 + random.nextInt(height >> 2);

            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);

            graphics2D.setColor(new Color(red, green, blue));
            graphics2D.drawLine(x1, y1, x2, y2);
        }

        StringBuilder randomCode = new StringBuilder(codeCount);
        for (int i = 0; i < codeCount; i++) {
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            graphics2D.setColor(new Color(red, green, blue));
            graphics2D.drawString(strRand, (i +1) * x, codeY);
            randomCode.append(strRand);
        }
        code = randomCode.toString();
    }
    public String getCode(){
        return this.code;
    }
    public BufferedImage getImage(){
        return this.image;
    }
    public String getImageBase64()throws IOException{
        ByteArrayOutputStream bs=new ByteArrayOutputStream();
        ImageIO.write(this.image,"png",bs);
        return encoder.encodeToString(bs.toByteArray());
    }
    public void write(OutputStream outputStream) throws IOException {
        ImageIO.write(image, "png", outputStream);
    }
    public void write(String path) throws IOException {
        OutputStream outputStream = new FileOutputStream(path);
        this.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
