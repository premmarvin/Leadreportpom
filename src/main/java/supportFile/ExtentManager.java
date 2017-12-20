package supportFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class ExtentManager {
	 
	public static ExtentReports extent;

	public static  ExtentTest test;
	public static String strLong;
	
	public static String screenShotPath;
	
	public static RemoteWebDriver driver;
@BeforeClass
public static ExtentReports Instance(){
	
	String reportvalue = new SimpleDateFormat("yyyyMMddHH").format(new Date());
	   
    System.out.println(reportvalue);

    //String workingDir = System.getProperty("user.dir");
	  // System.out.println("Current working directory : " + workingDir);
	//extent = new ExtentReports( "./../"+reportvalue+"/index.html", true);
	
    extent = new ExtentReports( "./../"+reportvalue+"/index.html", true);
 
	extent.addSystemInfo("User Name", "MPrem").addSystemInfo("Host Name", "IndiaProperty")
	.addSystemInfo("Type Of Testing", "Sanity").addSystemInfo("Environment", "Production Site")
	.addSystemInfo("Author", "MPrem -QA");

extent.loadConfig(
	new File(System.getProperty("user.dir") + "/src/main/java/supportFile/extent-config2.xml"));
 
 return extent;
    }


public static String  capturefull(RemoteWebDriver driver,String screenshotout) throws IOException{
	 
	/*String workingDir = System.getProperty("user.dir");
	   System.out.println("Current working directory : " + workingDir);*/
	 long number1 = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
    
       strLong = Long.toString(number1);
       screenshotout=strLong;
       
       String reportvalue = new SimpleDateFormat("yyyyMMddHH").format(new Date());
		   
       System.out.println(reportvalue);
    	 
	 
	 Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000)).takeScreenshot(driver);
	String dest = "./../"+reportvalue+"/images/" + screenshotout + ".png";
	 
	 
	 //String dest = workingDir+File.separator+reportvalue+"/images/" + screenshotout + ".png";
       ImageIO.write(screenshot.getImage(),"PNG",new File(dest));
       return dest;
	 	 
	 
}


public static String capture(RemoteWebDriver driver,String screenShotName) throws IOException

 
{
 
	/*String workingDir = System.getProperty("user.dir");
	   System.out.println("Current working directory : " + workingDir);*/


long number1 = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
 
    strLong = Long.toString(number1);
    screenShotName=strLong;
    
           
    String reportvalue = new SimpleDateFormat("yyyyMMddHH").format(new Date());
	   
    System.out.println(reportvalue);
	       
    
    
   TakesScreenshot ts = (TakesScreenshot)driver;
   
    File source = ts.getScreenshotAs(OutputType.FILE);
         
          
   // String dest = "./../"+reportvalue+"/images/"+screenShotName+".png";
    
    String dest = "./../"+reportvalue+"/images/"+screenShotName+".png";
    
    File destination = new File(dest);
   
    FileUtils.copyFile(source, destination);     
          
   
    return dest;
    
}

/*@AfterMethod

public void getResult() throws IOException {
	

	extent.endTest(test);
	
}*/


/*public static String screenshotPass() throws IOException{
	  
	  screenShotPath=capture(driver, "Pass");
	  test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));
	return screenShotPath;
	

	 
	  	  
}
		 
public static String screenshotFail() throws IOException{
	  
	  screenShotPath=capture(driver, "Fail");
	  test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
	return screenShotPath;
	
 
	  	 
	
}
	 
public static String screenshotInfo() throws IOException{
	  
	  screenShotPath=capture(driver, "Info");
	  test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(screenShotPath));
	return screenShotPath;
	
  	 
	
}*/

/*public static String screenshotPass() throws IOException{
	  
	  screenShotPath=capture(driver, "Pass");
	  test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));
	return screenShotPath;
	

	 
	  	  
}*/


@AfterMethod
public void tear()
{
extent.endTest(test);
 extent.flush();
 //extent.close();
 
}


}
