package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;



public class Capturescreeshots extends Capturescreeshotsfull{
	
	//WebDriver driver;
	
//public static long number1 = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 

//public static String strLong;
	
 // public static long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
  
	 public static String capture(WebDriver driver,String screenShotName) throws IOException
	 
	 
	    {
		 
	long number1 = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
         
	        strLong = Long.toString(number1);
	        screenShotName=strLong;
	        
	        /*String reportvalue = new SimpleDateFormat("yyyyMMddhh").format(new Date());
	   
	        System.out.println(reportvalue);*/
	        
	        String reportvalue = new SimpleDateFormat("yyyyMMddHH").format(new Date());
			   
	        System.out.println(reportvalue);
			//Scanner reader = new Scanner(System.in); 
			/*boolean success = false; 
			//System.out.println("Enter path of directory to create"); 
			
			String dir="C:/Users/Temp/workspace/"+reportvalue;
			//String dir = reader.nextLine(); 
			// Creating new directory in Java, if it doesn't exists 
			File directory = new File(dir); 
			if (directory.exists()) { 
			System.out.println("Directory already exists ..."); 
			} 
			else { System.out.println("Directory not exists, creating now"); 
			success = directory.mkdir();
			if (success) 
			{ System.out.printf("Successfully created new directory : %s%n", dir); 
			} 
			else { System.out.printf("Failed to create new directory: %s%n", dir); } 
			} 
	        */
	        
	        
	        
	        
	        
	        
	        
	        
	        
	       TakesScreenshot ts = (TakesScreenshot)driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	      
	        /*File f = null;
	        boolean reportvalue;
	        f = new File("C:/Users/Temp/workspace");
	        bool=f.mkdir();
	        
	        System.out.println(bool);*/
	        //Scanner scanner = new Scanner(System.in);
			//System.out.println("Enter the path of directory to rename.");
			
			/*String dirPath = "C:Users/Temp/workspace/bool";
		//	String dirPath = scanner.nextLine();
			File dir = new File(dirPath);
			if (!dir.isDirectory()) {
				System.err.println("There is no directory @ given path");
				System.exit(0);
			}
	 
			System.out
					.println("Enter new name of directory(Only Name and Not Path).");
			String newDirName = reportvalue;
	 
			File newDir = new File(dir.getParent() +newDirName);
			dir.renameTo(newDir);
	 
			System.out.println("Done");*/
	        
	        
	     /*   File dir = new File("C:/Users/Temp/workspace/bool");
            File newName = new File(reportvalue);
            if ( dir.isDirectory() ) {
                    dir.renameTo(newName);
            } else {
                    dir.mkdir();
                    dir.renameTo(newName);
            }*/
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	               // bool=reportvalue;
	        String dest = "./../"+reportvalue+"/images/"+screenShotName+".png";
	        
	        File destination = new File(dest);
	        //destination.getAbsolutePath();
	        FileUtils.copyFile(source, destination);     
	        
	        //long number1 = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
	                  
	      //  strLong = Long.toString(number1);
	        
	        //System.out.println(strLong);
	        
	        
	       // dest=strLong;
	     // strLong=dest;
	        
	      //  System.out.println(dest);
	        //strLong=dest;
	       
	        return dest;
	        
	    }
	 
	 
	/* public static String screen(WebDriver driver,String screenshotout) throws IOException{
		 
		 Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000)).takeScreenshot(driver);
		 ImageIO.write(screenshot.getImage(), "PNG", new File(("user.dir")+"\\Screenshots\\"+screenshotout+".png"));
		return screenshotout;
		
		
		 
		 
	 }*/
	 
	 
	 
	 
	 
}
	        
	       
	     /********************************************
	      * 
	      *    
	      *    
	      */
		 
		/* long number1 = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		 
		 strLong = Long.toString(number1);
	        screenShotName=strLong;
	        
	      //take the screenshot of the entire home page and save it to a png file
	        Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000)).takeScreenshot(driver);
	        
	        File source = screenshot.getImage().
	        String dest=ImageIO.write(screenshot.getImage(), "PNG", new File("./reports/images/"+screenShotName+".jpg"));
			
			// new File("./reports/images/"+number+".jpg"));
*/			
			
			
			
			
	       /* String dest = System.getProperty("user.dir") +"\\Screenshots\\"+screenShotName+".png";
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination);*/
	        
	        
	        
	       
	        
	   


	/* public long takeSnap5(WebDriver driver,String screenShotName){
			long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
			
				
				FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
			
			return number;
		}
*/










