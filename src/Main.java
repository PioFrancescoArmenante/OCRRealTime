/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pioar
 */
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.*;
 
public class Main {
public static void main(String[] args) {
    long millis = 1000;//CHANGE THIS TO REPEAT OCR EVERY MILLISECONDS
    String nameFile = "output.txt";//CHANGE THIS TO CHANGE OCR OUTPUT RESULT
    ScreenShot sc = new ScreenShot();
    
    
    while(true){try {
        //4EVER
        sc.doScreenShot();//DO THE SCREENSHOT
        } catch (Exception ex) {
            //THIS IS A PROBLEM XD
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    
File imageFile = new File("."+"/screenshot.jpg");//TAKE IMAGE FILE
Tesseract instance = Tesseract.getInstance(); //CREATE TESSERACT INSTANCE
try {
String result = instance.doOCR(imageFile);//TRY TO DO OCR WITH THE IMAGE
System.out.println(result);//PRINT THE TEXT RECOGNIZED
sc.write(result,nameFile);

} catch (TesseractException e) {
    //THIS IS ANOTHER PROBLEM XD
System.err.println(e.getMessage());
}

        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }



    }
    
    
    
    
    
    
}

  
}


