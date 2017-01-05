
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pioar
 */
public class ScreenShot {
     
    
    public ScreenShot(){
        
    }

    public void doScreenShot() throws Exception
    {
       // SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");
        Calendar now = Calendar.getInstance();
        Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
      //  ImageIO.write(screenShot, "JPG", new File("."+formatter.format(now.getTime())+".jpg"));
      ImageIO.write(screenShot, "JPG", new File("screenshot.jpg"));
        //System.out.println(formatter.format(now.getTime()));
    }
    
      void write(String result,String nameFile){
    File f = new File(nameFile);
    FileWriter fw = null;
      if (!f.exists()){//IF FILE DOESN'T EXISTS
	try {
            f.createNewFile();//CREATE THE FILE
    } catch (IOException ex) {
        Logger.getLogger(ScreenShot.class.getName()).log(Level.SEVERE, null, ex);
    }
      }
      
        try {
            //WRITE STRING INTO FILE
            fw = new FileWriter(f,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(result);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(ScreenShot.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
      
      
      }
      
      
    
}
