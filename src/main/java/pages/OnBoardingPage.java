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
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import supportFile.ExtentManager;
import wrapper.GenericWrappers;



public class OnBoardingPage extends ExtentManager{
	
		
	RemoteWebDriver driver;
	
	public String onboardingPageTitle="Indiaproperty.com";
	public By onboardingUserEmail=By.id("username");
	public By onboardingUserPasswd=By.id("pass");
	
	public By clickLoginBtn=By.id("send");
	
	
	public OnBoardingPage(RemoteWebDriver driver){
		
		this.driver=driver;
	}
	
	
	

	public OnBoardingPage onboardingLanding(String a, int wincount) throws InterruptedException, IOException {
		test=extent.startTest("Onboarding Interface Navigation for Posted Enquiry Validation");
		
			((JavascriptExecutor) driver).executeScript(a);

			String windowHandle = driver.getWindowHandle();
			
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			
	    	System.out.println(tabs2.size());
			
			driver.switchTo().window(tabs2.get(wincount));
			
			
			Thread.sleep(4000);
			String onboardingLoginPage =driver.getCurrentUrl();
			
			
			System.out.println(onboardingLoginPage);
			
			
			if(onboardingLoginPage.equalsIgnoreCase("http://onboarding.indiaproperty.com/")&&driver.getTitle().equalsIgnoreCase(onboardingPageTitle))
			
			
			  {
				
				
				System.out.println("User Sucessfully Land to onboarding Login  Page");
				
				
		        test.log(LogStatus.PASS, "Check whether user land to the Onboarding Interface", "User Sucessfully Land to onboarding Login  Page");
		        
		       
		         screenShotPath=ExtentManager.capture(driver, "Pass");
				
				test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));	
				
				
		      }
								
			
			
			else
			{
			
			
				System.out.println("User unable to  onboarding Login  Page");
				
				test.log(LogStatus.FAIL, "Check whether user land to the Onboarding Interface", "User unable to  onboarding Login  Page");
		        
			       
		         screenShotPath=ExtentManager.capture(driver, "Fail");
				
				test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));	
				
			}
			return this;
			
			
						
			
			
		} 
	

	
	
	public OnBoardingPage onboardingLogin(String userEmail,String userPwd) throws IOException{
		
		driver.findElement(onboardingUserEmail).sendKeys(userEmail);
		
		driver.findElement(onboardingUserPasswd).sendKeys(userPwd);
		
		
		screenShotPath=ExtentManager.capture(driver, "Pass");
		
		test.log(LogStatus.PASS, "Onboarding Login Credentils Entries " + test.addScreenCapture(screenShotPath));	
		
		driver.findElement(clickLoginBtn).click();
		
		return this;
		
		
		
		
	}
	
	
	
	public OnBoardingPage customerLeadPage(String a, int wincount) throws InterruptedException, IOException {

		test=extent.startTest("Onboarding Leads Page Navigation");
			
			((JavascriptExecutor) driver).executeScript(a);
			Thread.sleep(4000);
			String windowHandle = driver.getWindowHandle();
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			System.out.println(tabs2.size());
			
			driver.switchTo().window(tabs2.get(wincount));
			
			
			String onboardingCustomerPage2 =driver.getCurrentUrl();
			Thread.sleep(4000);
			
			onboardingCustomerPage2.trim();
			
			System.out.println(onboardingCustomerPage2);
			
			if(onboardingCustomerPage2.equalsIgnoreCase("http://onboarding.indiaproperty.com/customervalidation/1675845")){
				
				
				System.out.println("User sucessfully land on Customer Lead Page");
				
				test.log(LogStatus.PASS, "Check whether user land to the respective Customer Lead Page", "User sucessfully land on Customer Lead Page");
		        
			       
		         screenShotPath=ExtentManager.capture(driver, "Pass");
				
				test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));	
					
			
				
			}
			
			else  {
		
				System.out.println("User unable to land on Customer Lead Page");
				
				test.log(LogStatus.FAIL, "Check whether user land to the respective Customer Lead Page", "User unable land on Customer Lead Page");
		        
			       
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
