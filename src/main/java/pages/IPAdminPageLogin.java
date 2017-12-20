package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import supportFile.ExtentManager;
import wrapper.GenericWrappers;



public class IPAdminPageLogin extends ExtentManager{
	
		
	RemoteWebDriver driver;
	
	 	
	public By adminUserNameInfo=By.name("username");
	
	public  By adminUserPwdinfo=By.name("password");
	
	public By submitLoginBtn=By.name("submitbutton");
	
	public By logoutText=By.linkText("Logout");
	
	public By memberLink=By.linkText("Member");
		
	public By autoLogin=By.linkText("Auto Login");
	
	public By listingIdInfo=By.id("ListingId");
	
	public By listingidTextBox=By.id("value");
	
	public By autoLoginSubmitbtn=By.name("loginval");
	
	public By accountLinkText=By.xpath("//table[@id='autoLoginBox']/a");
	
public IPAdminPageLogin(RemoteWebDriver driver){
		
		this.driver=driver;
			
	}
	
	


	public IPAdminPageLogin openNewTabForAdminPage(String a, int wincount)throws InterruptedException, IOException{
		Thread.sleep(3000);
		test=extent.startTest("Naviation Of IP Admin Page");
		 ((JavascriptExecutor) driver).executeScript(a);
		
							
						
		String windowHandle = driver.getWindowHandle();	
						ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles());
						System.out.println(tabs3.size());
						
						driver.switchTo().window(tabs3.get(3));
						
						Thread.sleep(4000);
						
						
						String adminPageTitle=driver.getTitle();
						
				String adminPageActualTitle="Property, India Property, Real Estate, Dealers";		
						
			  
					
					
					System.out.println(adminPageTitle);
					
					
					if(adminPageActualTitle.equalsIgnoreCase(adminPageTitle)){
						
						
						System.out.println("User sucessfully land to IP-Admin Page");
						
						test.log(LogStatus.PASS, "Check whether user navigated to the IP Admin Page ", "User sucessfully land to the IP Admin Page");
				        
					       
				         screenShotPath=ExtentManager.capture(driver, "Pass");
						
						test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));		
						
						
					}
					
					else{
						
						System.out.println("User not  land to IP-Admin Page");
						
						test.log(LogStatus.FAIL, "Check whether user navigated to the IP Admin Page ", "User unable to land to the IP Admin Page");
				        
					       
				         screenShotPath=ExtentManager.capture(driver, "Fail");
						
						test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));						
						
						
					}
					return this;
					
	}
						
	public IPAdminPageLogin IPADminLogin(String adminUserName,String adminUserPwd) throws IOException{
		
		
		driver.findElement(adminUserNameInfo).sendKeys(adminUserName);
		driver.findElement(adminUserPwdinfo).sendKeys(adminUserPwd);
		
      screenShotPath=ExtentManager.capture(driver, "Pass");
		
		test.log(LogStatus.PASS, "IP Admin credentials Entries " + test.addScreenCapture(screenShotPath));
		
		driver.findElement(submitLoginBtn).click();
		return this;
		
		
		
	}
	
	
public IPAdminPageLogin verifyloggedAdmin() throws IOException{
		
		
	   WebElement sourceText=driver.findElement(logoutText);
	
	String expectedlinkname=sourceText.getText();
	
	System.out.println("expLogout"+expectedlinkname);
	
	expectedlinkname.trim();
	
	String actualLinkName="Logout";
	
	
if(actualLinkName.equalsIgnoreCase(expectedlinkname)){
		
		System.out.println("User sucessfully logged in IP-Admin Page");
		
		
		test.log(LogStatus.PASS, "Check whether user logged in  to the IP Admin Page ", "User sucessfully login to  IP Admin Page");
        
	       
        screenShotPath=ExtentManager.capture(driver, "Pass");
		
		test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));
		
	}

else {

System.out.println("User unable to logged in IP-Admin Page");
	
test.log(LogStatus.FAIL, "Check whether user logged in  to the IP Admin Page ", "User unable login to  IP Admin Page");


screenShotPath=ExtentManager.capture(driver, "Fail");

test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));		
		
	}
return this;

					
					
}			
			
public IPAdminPageLogin autoLogin() throws InterruptedException, IOException{
	
	
	
	
	//*************************
	
	
	WebElement member= driver.findElement(By.linkText("Member"));
	
	 		    
	   Actions action =new Actions(driver);
	  	   
	  action.moveToElement(member).build().perform();
	  Thread.sleep(3000);
	  

	  driver.findElement(autoLogin).click();
	  
	   driver.findElement(listingIdInfo).click();
	  
	   if(SearchPage.listingid1 != null){

	  driver.findElement(listingidTextBox).sendKeys(SearchPage.listingid1);
	   }
	   
	   
	  
		   
		   else if(SearchPage.melchilistingid1 != null){
			   
			   driver.findElement(listingidTextBox).sendKeys(SearchPage.melchilistingid1);
			   
		   
		   
	   }
	driver.findElement(autoLoginSubmitbtn).click();
	  
		 
	  
	 
	  
	  Thread.sleep(3000);
	  
	 String accoutLink= driver.findElement(accountLinkText).getText();
	  
	  
	  
	  if(accoutLink.contains("User Account")){
		  
	
		  test.log(LogStatus.PASS, "Check whether user auto-Login to the user account Page ", "User sucessfully auto logged to user account Page");
	        
	       
	        screenShotPath=ExtentManager.capture(driver, "Pass");
			
			test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));
		 
	  
	  driver.findElement(By.xpath("//table[@id='autoLoginBox']/a/b[1]")).click();
	  
	  
	  
	  }
	  
	  
	  else{
		  
		  System.out.println("Admin unable to  Login to User-Account ");
		  
		  test.log(LogStatus.FAIL, "Check whether user auto-Login to the user account Page ", "User unable to auto logged to user account Page");
	        
	       
	        screenShotPath=ExtentManager.capture(driver, "Fail");
			
			test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
		  
	  }
	  
	  
	   
	
	
	
	
	return this;
	
	
	
	
}
					
				




	

     
}

/**
 * WebDriver driver = new FirefoxDriver();
driver.get("http://somedomain/url_that_delays_loading");
WebElement myDynamicElement = (new WebDriverWait(driver, 10))
  .until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));
 
 * 
 */
