package main.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;

/**
 * Created by Tony on 2017/6/28.
 */
public class ImageProcess {
    private static final double REDUCE_RATE=0.2;
    public static String ICON_PATH="C:\\Users\\Tony\\Documents\\315douban\\_315douban\\src\\main\\webapp\\";
    private static BufferedImage reduceImage(File srcFile,double rate) throws IOException {
        Image src= ImageIO.read(srcFile);
        int srcWidth = src.getWidth(null);
        int srcHeight=src.getHeight(null);
        int dstWidth= (int) (srcWidth*rate);
        int dstHeight= (int) (srcHeight*rate);
        BufferedImage dstImage=new BufferedImage(dstWidth,dstHeight,BufferedImage.TYPE_INT_RGB);
        dstImage.getGraphics().drawImage(src.getScaledInstance(dstWidth,dstHeight,Image.SCALE_SMOOTH),0,0,null);
        return dstImage;
    }
    public static void saveUserIcon(String path,File srcFile,String userName) throws IOException {
        ICON_PATH=path;
        String fileSuffix=srcFile.getName().substring(srcFile.getName().lastIndexOf(".")+1);
        String fileName=new StringBuffer().append(userName).append(".").append(fileSuffix).toString();
        BufferedImage dstImage=reduceImage(srcFile,REDUCE_RATE);
        File dstFile=new File(ICON_PATH+"userIcons",fileName);
        ImageIO.write(dstImage,fileSuffix,dstFile);
    }
}
